package ca.vastier.depense.web.controllers;

import ca.vastier.depense.services.ExpenseService;
import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.web.dto.ExpenseDto;
import ca.vastier.depense.web.wsdto.ExpenseWsDto;
import lombok.Getter;
import lombok.Setter;
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

	@Override
	protected GenericEntityService getEntityService()
	{
		return expenseService;
	}
}
