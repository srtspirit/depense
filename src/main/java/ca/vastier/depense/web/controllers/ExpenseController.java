package ca.vastier.depense.web.controllers;

import java.util.Collection;

import ca.vastier.depense.services.ExpenseService;
import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.web.dto.ArticleDto;
import ca.vastier.depense.web.dto.ExpenseDto;
import ca.vastier.depense.web.dto.ReceiptDto;
import ca.vastier.depense.web.wsdto.ArticleWsDto;
import ca.vastier.depense.web.wsdto.ExpenseWsDto;
import ca.vastier.depense.web.wsdto.ReceiptWsDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("expense")
public class ExpenseController extends AbstractController
{
	@Getter
	@Setter
	@Autowired
	private ExpenseService expenseService;

	@RequestMapping(method = RequestMethod.POST)
	public int createExpense(@RequestBody final ExpenseWsDto expenseWsDto)
	{
		return createEntity(expenseWsDto, ExpenseDto.class).getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ExpenseWsDto getExpenseById(@PathVariable("id") final String id)
	{

		return getEntityById(id, ExpenseWsDto.class);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateExpense(@RequestBody final ExpenseWsDto expenseWsDto)
	{
		updateEntity(expenseWsDto, ExpenseDto.class);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteExpenseById(@PathVariable("id") final String id)
	{
		deleteEntity(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<ExpenseWsDto> getAllArticles()
	{
		return findAllEntities(ExpenseWsDto.class);
	}


	@Override
	protected GenericEntityService getEntityService()
	{
		return expenseService;
	}

	@Override
	protected ModelMapper createMapper()
	{
		final ModelMapper modelMapper = new ModelMapper();

		modelMapper.addMappings(new PropertyMap<ReceiptDto, ReceiptWsDto>()
		{
			@Override
			protected void configure()
			{
				skip().setExpenses(null);
			}
		});

		modelMapper.addMappings(new PropertyMap<ArticleDto, ArticleWsDto>()
		{
			@Override
			protected void configure()
			{
				skip().setParentArticleId(null);
				skip().setChildArticles(null);
			}
		});

		modelMapper.addMappings(new PropertyMap<ReceiptWsDto, ReceiptDto>()
		{
			@Override
			protected void configure()
			{
				skip().setDate(null);
				skip().setExpenses(null);
				skip().setAmount(null);
			}
		});

		return modelMapper;
	}
}
