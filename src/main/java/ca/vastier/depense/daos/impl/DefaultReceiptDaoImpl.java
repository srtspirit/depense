package ca.vastier.depense.daos.impl;

import java.math.BigDecimal;

import ca.vastier.depense.daos.ReceiptDao;
import ca.vastier.depense.generated.model.Article;
import ca.vastier.depense.generated.model.Expense;
import ca.vastier.depense.generated.model.Receipt;
import ca.vastier.depense.web.dto.ReceiptDto;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.Query;
import org.apache.cayenne.query.Select;
import org.springframework.stereotype.Component;


@Component
public class DefaultReceiptDaoImpl implements ReceiptDao
{
	@Override
	public int createReceipt(final ReceiptDto receiptDto)
	{
		final ServerRuntime cayenneRuntime = ServerRuntime.builder().addConfig("cayenne-project.xml").build();
		final ObjectContext context = cayenneRuntime.newContext();

		final Receipt receipt = context.newObject(Receipt.class);

		receipt.setAmount(BigDecimal.ZERO);
		receipt.setDate(receiptDto.getDate());

		receiptDto.getExpenses().forEach((expenseDto) -> {
			final Expense expense = context.newObject(Expense.class);
			expense.setDate(expenseDto.getDate());
			expense.setPurchase(expenseDto.getPurchase());

			final Article article = Cayenne.objectForPK(context, Article.class, expenseDto.getArticle().getId());
			expense.setArticle(article);

			receipt.addToExpense(expense);
		});

		context.commitChanges();

		return receipt.getId();
	}
}
