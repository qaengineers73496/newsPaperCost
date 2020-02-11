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
		
		HashMap<String, HashMap<String,Float>> map1 = obj1.getPriceAll("HT", "HI", "ET");
		System.out.println(map1);
	}

}
