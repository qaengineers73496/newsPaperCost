package utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class testClass4Utilities {

	public static void main(String[] args) {
		calendarUtilities obj = new calendarUtilities();
		DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;
		System.out.println(obj.noOfDays(LocalDate.of(2020, Month.FEBRUARY, 01), LocalDate.of(2020, Month.FEBRUARY, 29), dayOfWeek));

	}

}
