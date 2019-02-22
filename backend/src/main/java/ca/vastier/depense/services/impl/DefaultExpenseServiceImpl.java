package ca.vastier.depense.services.impl;

import ca.vastier.depense.services.ExpenseService;
import ca.vastier.depense.web.dto.ExpenseDto;
import org.springframework.stereotype.Component;


@Component
public class DefaultExpenseServiceImpl extends AbstractGenericEntityService<ExpenseDto> implements ExpenseService
{
}
