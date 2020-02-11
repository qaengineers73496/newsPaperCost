package utilities;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class getMaps {

	public HashMap<String, Float> getPrice(String publicationName) throws IOException {
		Properties prop = new Properties();
		HashMap<String, Float> map = new HashMap<>();

		propertiesInitializer data = new propertiesInitializer();
		prop = data.getPropValues();

		for (String name : prop.stringPropertyNames()) {
			if (name.substring(0, 2).equals(publicationName)) {
				map.put(name, Float.parseFloat(prop.getProperty(name)));
			}
		}
		return map;
	}

	public HashMap<String, HashMap<String, Float>> getPriceAll(String... pub) throws IOException {
		HashMap<String, HashMap<String, Float>> map = new HashMap<>();
		List<String> publications = Arrays.asList(pub);
		for (String pubName : publications) {
			HashMap<String, Float> individualPriceList = getPrice(pubName);
			map.put(pubName, individualPriceList);
		}
		return map;
	}

}
