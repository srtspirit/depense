package ca.vastier.depense.daos.cayenne;

import org.apache.cayenne.ObjectContext;


public interface CayennePersistentContextFactory
{
	ObjectContext getObjectContext();
}
