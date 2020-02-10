package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesInitializer {
	private Properties prop;
	private InputStream inputStream;
	private String propFileName;

	public propertiesInitializer(String file) {
		this.propFileName = file;
	}

	public Properties getPropValues() throws IOException {

		try {
			prop = new Properties();
			String propFileName = ".\\priceSource\\masterPriceList.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}
}