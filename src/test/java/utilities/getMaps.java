package utilities;

import java.io.IOException;
import java.time.DayOfWeek;
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

	public HashMap<String, Float> getIndividualCost(String publication, LocalDate startDate, LocalDate endDate)
			throws IOException {
		HashMap<String, Float> map = getPrice(publication);
//		System.out.println(map);
		HashMap<String, Float> individualCost = new HashMap<>();
		DayOfWeek dayOfWeek;
		calendarUtilities cal = new calendarUtilities();
		long n;

		for (String pub : map.keySet()) {
			switch (pub.substring(3, 6)) {
			case "Mon":
				dayOfWeek = DayOfWeek.MONDAY;
				n = cal.noOfDays(startDate, endDate, dayOfWeek);
//				System.out.println("$$$ No. of mondays: "+n);
				individualCost.put("Mon", n * map.get(pub));
				break;

			case "Tue":
				dayOfWeek = DayOfWeek.TUESDAY;
				n = cal.noOfDays(startDate, endDate, dayOfWeek);
//				System.out.println("$$$ No. of tuesdays: "+n);
				individualCost.put("Tue", n * map.get(pub));
				break;
			case "Wed":
				dayOfWeek = DayOfWeek.WEDNESDAY;
				n = cal.noOfDays(startDate, endDate, dayOfWeek);
//				System.out.println("$$$ No. of wednesdays: "+n);
				individualCost.put("Wed", n * map.get(pub));
				break;
			case "Thu":
				dayOfWeek = DayOfWeek.THURSDAY;
				n = cal.noOfDays(startDate, endDate, dayOfWeek);
//				System.out.println("$$$ No. of thursdays: "+n);
				individualCost.put("Thu", n * map.get(pub));
				break;
			case "Fri":
				dayOfWeek = DayOfWeek.FRIDAY;
				n = cal.noOfDays(startDate, endDate, dayOfWeek);
//				System.out.println("$$$ No. of fridays: "+n);
				individualCost.put("Fri", n * map.get(pub));
				break;
			case "Sat":
				dayOfWeek = DayOfWeek.SATURDAY;
				n = cal.noOfDays(startDate, endDate, dayOfWeek);
//				System.out.println("$$$ No. of saturdays: "+(n+1));
				individualCost.put("Sat", (n + 1) * map.get(pub));
				break;
			case "Sun":
				dayOfWeek = DayOfWeek.SUNDAY;
				n = cal.noOfDays(startDate, endDate, dayOfWeek);
//				System.out.println("$$$ No. of sundays: "+n);
				individualCost.put("Sun", n * map.get(pub));
				break;
			}
		}
		return individualCost;
	}

	public HashMap<String, HashMap<String, Float>> getAllCost(LocalDate startDate, LocalDate endDate, String ...publication) throws IOException{
		HashMap<String,HashMap<String,Float>> allCost = new HashMap<>();
		List<String> allPublications = Arrays.asList(publication);
		for (String pubName : allPublications) {
			HashMap<String, Float> individualCost = getIndividualCost(pubName, startDate, endDate);
			allCost.put(pubName, individualCost);
		}
		return allCost;		
	}
}
