package utilities;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Properties;

public class testClass4Utilities {

	public static void main(String[] args) throws IOException {
		calendarUtilities obj = new calendarUtilities();
		DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;
//		System.out.println(obj.noOfDays(LocalDate.of(2019, Month.FEBRUARY, 01), LocalDate.of(2020, Month.FEBRUARY, 29), dayOfWeek));

		getMaps obj1 = new getMaps();
		HashMap<String, Float> map = obj1.getPrice("TI");
//		System.out.println(map);

		HashMap<String, HashMap<String, Float>> map1 = obj1.getPriceAll("HT", "HI", "ET");
//		System.out.println(map1);

		for (String s : map1.keySet()) {
			HashMap<String, Float> pub = obj1.getPrice(s);
			HashMap<String, Float> cost = new HashMap<>();
			for (String p : pub.keySet()) {
				if (s.contains(p.substring(0, 2))) {
					for (int i = 1; i < 8; i++) {
						Float val = pub.get(p);
						switch (p.substring(3, 6)) {
						case "Mon":
							cost = obj1.getPrice(p.substring(0,2));
							System.out.println("$$$$$$$$$$  "+cost);
							System.out.println("Found Monday for " + p.subSequence(0, 2));
							break;
						case "Tue":
							System.out.println("Found Tuesday for " + p.subSequence(0, 2));
							break;
						case "Wed":
							System.out.println("Found Wednesday for " + p.subSequence(0, 2));
							break;
						case "Thu":
							System.out.println("Found Thursday for " + p.subSequence(0, 2));
							break;
						case "Fri":
							System.out.println("Found Friday for " + p.subSequence(0, 2));
							break;
						case "Sat":
							System.out.println("Found Saturday for " + p.subSequence(0, 2));
							break;
						case "Sun":
							System.out.println("Found Sunday for " + p.subSequence(0, 2));
							break;
						}
						if (p.substring(3, 6).contains("Mon")) {

						}

					}
				}

			}
		}

	}

}
