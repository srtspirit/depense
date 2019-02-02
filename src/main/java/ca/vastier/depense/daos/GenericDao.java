package ca.vastier.depense.daos;

import ca.vastier.depense.web.dto.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenericDao<T extends AbstractEntity> extends CrudRepository<T, Integer>
{
}
