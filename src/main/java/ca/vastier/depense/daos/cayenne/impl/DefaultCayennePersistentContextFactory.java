package ca.vastier.depense.daos.cayenne.impl;

import ca.vastier.depense.daos.cayenne.CayennePersistentContextFactory;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DefaultCayennePersistentContextFactory implements CayennePersistentContextFactory
{
	private ServerRuntime serverRuntime;

	@Autowired
	public DefaultCayennePersistentContextFactory(@Value("${db.cayenne.configurationfile}") final String resource)
	{
		serverRuntime = ServerRuntime.builder().addConfig(resource).build();
	}

	@Override
	public ObjectContext getObjectContext()
	{
		return serverRuntime.newContext();
	}
}
