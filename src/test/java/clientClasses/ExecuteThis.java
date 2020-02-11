package clientClasses;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class ExecuteThis {

	public static void main(String[] args) throws IOException {
		client obj = new client();
		String[] publications = { "HT" };
		System.out.println("Subscription cost for HT "+obj.getCost(LocalDate.of(2020, Month.FEBRUARY, 01), LocalDate.of(2020, Month.FEBRUARY, 29), publications));

		String[] pubs = { "HT", "HI", "ET", "BM", "TI"};
		System.out.println("Subscription cost for HT, HI,ET,BM & TI "+obj.getCost(LocalDate.of(2020, Month.FEBRUARY, 01), LocalDate.of(2020, Month.FEBRUARY, 29), pubs));
	}

}
