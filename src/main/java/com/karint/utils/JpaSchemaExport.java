package com.karint.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.persistence.Persistence;

import org.hibernate.cfg.AvailableSettings;

public class JpaSchemaExport {
	private static final String PERSISTENCE_UNIT_NAME = "karint";
 	private JpaSchemaExport(){
 	}

	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		props.put(AvailableSettings.FORMAT_SQL, "true");
		props.put(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS, false);
		props.put(AvailableSettings.HBM2DDL_SCRIPTS_ACTION, "create");
//		props.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, "com.xlgames.support.utils.jpa.SpringPhysicalNamingStrategy");
		props.put(AvailableSettings.HBM2DDL_DELIMITER, ";");

		/* console */
		props.put(AvailableSettings.HBM2DDL_SCRIPTS_CREATE_TARGET, new PrintWriter(System.out));
		/* create file */
//		props.put(AvailableSettings.HBM2DDL_SCRIPTS_CREATE_TARGET, "create.sql");
		Persistence.generateSchema(PERSISTENCE_UNIT_NAME, props);
	}

}
