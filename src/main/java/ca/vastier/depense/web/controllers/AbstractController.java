package ca.vastier.depense.web.controllers;

import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.web.dto.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;


abstract public class AbstractController
{
	@Setter
	@Getter
	@Autowired
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

	abstract protected GenericEntityService getEntityService();
}
