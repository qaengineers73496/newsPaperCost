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
		getMaps obj1 = new getMaps();

		HashMap<String, Float> individualPrice = obj1.getPrice("TI");
		System.out.println("Individual price for TI Publication :" + individualPrice);

		HashMap<String, HashMap<String, Float>> allPrice = obj1.getPriceAll("HT", "HI", "ET", "BM", "TI");
		System.out.println("Price for HT, HI and ET and other Publications :" + allPrice);

		DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;
		System.out.println("Number of tuesdays between Feb 01 to feb 29 : " + obj
				.noOfDays(LocalDate.of(2020, Month.FEBRUARY, 01), LocalDate.of(2020, Month.FEBRUARY, 29), dayOfWeek));

		HashMap<String, Float> individualCost = obj1.getIndividualCost("HT", LocalDate.of(2020, Month.FEBRUARY, 01),
				LocalDate.of(2020, Month.FEBRUARY, 29));
		System.out.println("Toal cost of HT Publication subscription between given dates :" + individualCost);

		String[] pubs = { "HT", "HI", "ET", "BM", "TI" };
		HashMap<String, HashMap<String, Float>> allCost = obj1.getAllCost(LocalDate.of(2020, Month.FEBRUARY, 01),
				LocalDate.of(2020, Month.FEBRUARY, 29), pubs);
		System.out.println("Total cost of multiple subscriptions between dates :" + allCost);
	}

//	private long printCost(LocalDate startDate, LocalDate endDate, String[] publication) {
//		
//	}
}
