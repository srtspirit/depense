package ca.vastier.depense.daos;

import ca.vastier.depense.web.dto.ExpenseDto;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpenseDao extends GenericDao<ExpenseDto>
{
}
