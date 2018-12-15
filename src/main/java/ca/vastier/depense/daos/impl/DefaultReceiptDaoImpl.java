package ca.vastier.depense.daos.impl;

import java.util.stream.Collectors;

import ca.vastier.depense.daos.ReceiptDao;
import ca.vastier.depense.daos.cayenne.CayennePersistentContextFactory;
import ca.vastier.depense.generated.model.Article;
import ca.vastier.depense.generated.model.Expense;
import ca.vastier.depense.generated.model.Receipt;
import ca.vastier.depense.web.dto.ArticleDto;
import ca.vastier.depense.web.dto.ExpenseDto;
import ca.vastier.depense.web.dto.ReceiptDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DefaultReceiptDaoImpl implements ReceiptDao
{
	@Getter
	@Setter
	@Autowired
	private CayennePersistentContextFactory cayennePersistentContextFactory;
	@Setter
	@Getter
	@Autowired
	private ModelMapper modelMapper;

	private static void convertReceiptToDomain(final ObjectContext context, final ReceiptDto source, final Receipt target)
	{
		target.setDate(source.getDate());
		source.getExpenses().forEach(expenseDto -> {
			final Expense expense = context.newObject(Expense.class);
			convertExpenseToDomain(context, expenseDto, expense);
			target.addToExpense(expense);
		});
	}

	private static void convertExpenseToDomain(final ObjectContext context, final ExpenseDto source, final Expense target)
	{
		target.setDate(source.getDate());
		target.setPurchase(source.getPurchase());
		target.setAmount(source.getAmount());
		target.setArticle(Cayenne.objectForPK(context, Article.class, source.getArticle().getId()));
	}

	private static void convertReceiptToDto(final Receipt source, final ReceiptDto target)
	{
		target.setId(source.getId());
		target.setDate(source.getDate());

		target.setExpenses(source.getExpense().stream().map(expense -> {
			final ExpenseDto expenseDto = new ExpenseDto();
			convertExpenseToDto(expense, expenseDto);

			return expenseDto;
		}).collect(Collectors.toList()));
	}

	private static void convertExpenseToDto(final Expense source, final ExpenseDto target)
	{
		target.setId(Cayenne.intPKForObject(source));
		target.setDate(source.getDate());
		target.setPurchase(source.getPurchase());
		target.setAmount(source.getAmount());

		final ArticleDto articleDto = new ArticleDto();
		convertArticleToDto(source.getArticle(), articleDto);

		target.setArticle(articleDto);
	}

	private static void convertArticleToDto(final Article source, final ArticleDto target)
	{
		target.setId(source.getId());
		target.setName(source.getName());
	}

	@Override
	public ReceiptDto createReceipt(final ReceiptDto receiptDto)
	{
		final ObjectContext context = getCayennePersistentContextFactory().getObjectContext();

		final Receipt receipt = context.newObject(Receipt.class);
		convertReceiptToDomain(context, receiptDto, receipt);

		context.commitChanges();

		final ReceiptDto result = new ReceiptDto();
		convertReceiptToDto(receipt, result);

		return result;
	}
}
