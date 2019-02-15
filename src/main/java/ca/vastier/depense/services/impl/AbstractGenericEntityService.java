package ca.vastier.depense.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.vastier.depense.daos.GenericDao;
import ca.vastier.depense.exceptions.EntityNotFoundException;
import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.web.dto.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;


abstract public class AbstractGenericEntityService<T extends AbstractEntity> implements GenericEntityService<T>
{
	@Autowired
	private GenericDao<T> genericDao;

	@Override
	public T createEntity(final T entityDto)
	{
		return getGenericDao().save(entityDto);
	}

	@Override
	public T findEntityById(final int id)
	{
		return getGenericDao().findById(id).orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
	}

	@Override
	public void updateEntity(final T entityDto)
	{
		if (!getGenericDao().existsById(entityDto.getId()))
		{
			throw new IllegalStateException("Entity " + entityDto.getClass() + " with id " + entityDto.getId() + " doesn't exist");
		}

		getGenericDao().save(entityDto);
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
