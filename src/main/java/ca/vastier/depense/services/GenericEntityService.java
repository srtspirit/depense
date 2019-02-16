package ca.vastier.depense.services;

import ca.vastier.depense.web.dto.AbstractEntity;


public interface GenericEntityService<T extends AbstractEntity>
{
	T createEntity(T articleDto);

	T findEntityById(int id);

	void updateEntity(T articleDto);

	void deleteEntityById(int id);
}
