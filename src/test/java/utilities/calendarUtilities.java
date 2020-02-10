package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calendarUtilities {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public int getNoOfDays() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

}
