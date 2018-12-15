package ca.vastier.depense.daos;

import ca.vastier.depense.web.dto.ReceiptDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReceiptDao extends CrudRepository<ReceiptDto, Integer>
{
}
