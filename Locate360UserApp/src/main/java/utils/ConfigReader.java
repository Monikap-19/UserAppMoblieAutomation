package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static final Properties PROPERTIES = new Properties();
	static {
		try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (input != null)
				PROPERTIES.load(input);
		} catch (Exception e) {
			throw new RuntimeException("Unable to load config.properties", e);
		}
	}

	public static String get(String key) {
		return PROPERTIES.getProperty(key, "");
	}
}
