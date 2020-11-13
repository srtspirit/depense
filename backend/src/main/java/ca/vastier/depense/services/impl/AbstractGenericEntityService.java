package ca.vastier.depense.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.vastier.depense.persistence.daos.GenericDao;
import ca.vastier.depense.exceptions.EntityNotFoundException;
import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.web.dto.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;


abstract public class AbstractGenericEntityService<T extends AbstractEntity> implements GenericEntityService<T>
{
	@Autowired
	private GenericDao<T> genericDao;

	@Override
	public T createEntity(final T entity)
	{
		return getGenericDao().save(entity);
	}

	@Override
	public T findEntityById(final int id)
	{
		return getGenericDao().findById(id).orElseThrow(
				() -> new EntityNotFoundException(getClass().getSimpleName() + ": entity " + " with id " + id + " not found"));
	}

	@Override
	public void updateEntity(final T entity)
	{
		if (!getGenericDao().existsById(entity.getId()))
		{
			throw new IllegalStateException(
					getClass().getSimpleName() + " :entity " + " with id " + entity.getId() + " doesn't exist");
		}

		getGenericDao().save(entity);
	}

	@Override
	public void deleteEntityById(final int id)
	{
		getGenericDao().deleteById(id);
	}

	@Override
	public Collection<T> findAllEntities()
	{
		final List<T> result = new ArrayList<>();
		getGenericDao().findAll().forEach(result::add);

		return result;
	}

	protected GenericDao<T> getGenericDao()
	{
		return genericDao;
	}

	public void setGenericDao(final GenericDao<T> genericDao)
	{
		this.genericDao = genericDao;
	}
}
