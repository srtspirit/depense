package ca.vastier.depense.web.controllers;

import java.util.Collection;
import java.util.stream.Collectors;

import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.web.dto.AbstractEntity;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PathVariable;


abstract public class AbstractController
{
	private ModelMapper modelMapper;

	protected <T extends AbstractEntity> T createEntity(final Object wsEntity, final Class<T> clazz)
	{
		final AbstractEntity abstractEntity = getModelMapper().map(wsEntity, clazz);
		final AbstractEntity result = getEntityService().createEntity(abstractEntity);

		return (T) result;
	}

	protected <T> T getEntityById(final String id, final Class<T> clazz)
	{
		final AbstractEntity entity = getEntityService().findEntityById(Integer.valueOf(id));

		return getModelMapper().map(entity, clazz);
	}

	protected <T extends AbstractEntity> void updateEntity(final Object wsEntity, Class<T> clazz)
	{
		final AbstractEntity abstractEntity = getModelMapper().map(wsEntity, clazz);
		getEntityService().updateEntity(abstractEntity);
	}

	protected void deleteEntity(@PathVariable("id") final String id)
	{
		getEntityService().deleteEntityById(Integer.valueOf(id));
	}

	protected <T> Collection<T> findAllEntities(final Class<T> clazz)
	{
		final Collection<AbstractEntity> entities = getEntityService().findAllEntities();
		return entities.stream().map(entity -> getModelMapper().map(entity, clazz)).collect(Collectors.toList());
	}

	abstract protected GenericEntityService getEntityService();

	protected ModelMapper createMapper()
	{
		return new ModelMapper();
	}

	final protected ModelMapper getModelMapper()
	{
		if (modelMapper == null)
		{
			modelMapper = createMapper();
		}

		return modelMapper;
	}
}
