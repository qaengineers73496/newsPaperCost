package utilities;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class calendarUtilities {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public int getNoOfDays() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public HashMap<String, Integer> getCount(LocalDate start, LocalDate end) {
		if (end.isBefore(start)) {
			throw new IllegalArgumentException("Start dat " + start + " cannot be greater than last data " + end);
		}

		HashMap<String, Integer> m = new HashMap<>();
		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {

		}
		return m;
	}

	long noOfDays(LocalDate startDate, LocalDate endDate, DayOfWeek dayOfWeek) {
		if (endDate.isBefore(startDate)) {
			throw new IllegalArgumentException("Start date " + startDate + " can't be greate than last date " + endDate);
		}

		LocalDate firstDOW = startDate.with(TemporalAdjusters.next(dayOfWeek));
		LocalDate lastDOW = endDate.with(TemporalAdjusters.previous(dayOfWeek));

		long number = ChronoUnit.WEEKS.between(firstDOW, lastDOW);
		return number + 1;
	}

}
