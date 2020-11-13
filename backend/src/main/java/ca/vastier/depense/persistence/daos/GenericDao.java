package ca.vastier.depense.persistence.daos;

import java.util.Optional;

import ca.vastier.depense.web.dto.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenericDao<T extends AbstractEntity> extends CrudRepository<T, Integer>
{
	<S extends T> S save(S s);

	Optional<T> findById(Integer integer);

	boolean existsById(Integer integer);

	void deleteById(Integer integer);

	Iterable<T> findAll();
}
