package com.karint.utils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import javax.persistence.Persistence;

import org.hibernate.cfg.AvailableSettings;
import org.junit.Test;

public class JpaSchemaExportTest {
	private static final String PERSISTENCE_UNIT_NAME = "karint";

 	@Test
	public void createJpaSchemaExport() throws IOException {
		Properties props = new Properties();
		props.put(AvailableSettings.FORMAT_SQL, "true");
		props.put(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS, false);
		props.put(AvailableSettings.HBM2DDL_SCRIPTS_ACTION, "create");
		props.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, "com.karint.utils.SpringPhysicalNamingStrategy");
		props.put(AvailableSettings.HBM2DDL_DELIMITER, ";");

//		props.put(AvailableSettings.HBM2DDL_SCRIPTS_CREATE_TARGET, "create.sql");
		/* console */
		props.put(AvailableSettings.HBM2DDL_SCRIPTS_CREATE_TARGET, new OutputStreamWriter( System.out ));
		Persistence.generateSchema(PERSISTENCE_UNIT_NAME, props);
	}

}
