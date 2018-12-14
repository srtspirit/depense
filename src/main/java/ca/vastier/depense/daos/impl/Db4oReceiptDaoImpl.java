package ca.vastier.depense.daos.impl;

import ca.vastier.depense.daos.ReceiptDao;
import ca.vastier.depense.web.dto.ArticleDto;
import ca.vastier.depense.web.dto.ReceiptDto;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("db4o")
public class Db4oReceiptDaoImpl implements ReceiptDao
{
	@Override
	public ReceiptDto createReceipt(final ReceiptDto receipt)
	{
		System.out.println("inside of " + this.getClass().getName());
		final ObjectContainer objectContainer = Db4o.openFile("dbfo.db");

		ObjectSet objectSet = objectContainer.get(ArticleDto.builder().hui(receipt.getExpenses().iterator().next().getArticle().getHui()).build());

		ArticleDto article;
		if (objectSet.hasNext())
		{
			Object hui = objectSet.next();
			article = (ArticleDto) hui;
			System.out.println(objectSet.size() + " artices are found: " + article.toString());
		}
		else
		{
			article = ArticleDto.builder().hui(receipt.getExpenses().iterator().next().getArticle().getHui()).article_name("art").build();
			objectContainer.set(article);
			//objectContainer.commit();
			System.out.println("articel is not found. Creating.... " + article);

			article = (ArticleDto) objectContainer.get(ArticleDto.builder().hui(receipt.getExpenses().iterator().next().getArticle().getHui()).build()).next();
		}

		receipt.getExpenses().iterator().next().setArticle(article);

		for (int i = 0; i < 10; i++)
		{
			objectContainer.set(receipt);
		}

		objectContainer.commit();

		objectSet = objectContainer.get(receipt);

		System.out.println("size: " + objectSet.size());
		final ReceiptDto result;
		result = (ReceiptDto)objectContainer.get(receipt).next();

		return result;
	}
}
