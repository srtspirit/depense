package ca.vastier.depense.config;

import javax.sql.DataSource;

import java.util.Collection;

import lombok.Setter;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FlywayConfig
{
	@Value("${spring.flyway.locations:db/migration}")
	@Setter
	private String [] dbLocations;

	@Bean
	public Flyway flyway(final DataSource dataSource)
	{
		for(final String str: dbLocations)
		System.out.println(str);
		final Flyway flyway = new Flyway();
		flyway.setLocations(dbLocations);
		flyway.setDataSource(dataSource);

		return flyway;
	}

	@Bean
	public FlywayMigrationInitializer flywayMigrationInitializer(final Flyway flyway)
	{
		return new FlywayMigrationInitializer(flyway);
	}
}
