package clientClasses;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;

import utilities.calendarUtilities;
import utilities.getMaps;

public class client {

	private String[] publications = { "HT", "HI", "ET", "BM", "TI" }; // hardcoded here (extensible in utilities)
	private calendarUtilities calUtility = new calendarUtilities();
	private getMaps mapUtility = new getMaps();

	public double getCost(LocalDate startDate, LocalDate endDate, String[] publications) throws IOException { // Exception
																												// handling
																												// for
																												// IOException
																												// ignore
																												// (hardcoded
																									// filename)
		double cost = 0.0;
		if ((!(startDate instanceof LocalDate)) || (!(endDate instanceof LocalDate))) {
			System.out.println("Error pls. provide dates in Localdate format");
			throw new RuntimeException("Exception while processing startDate/endDate");
		}
		if (publications.length > 1) {
			HashMap<String, HashMap<String, Float>> tc = mapUtility.getAllCost(startDate, endDate, publications);
			cost = calculateMultiplePublicationsCost(tc);
		} 
		if (publications.length == 1) {
			HashMap<String, Float> ic = mapUtility.getIndividualCost(publications[0], startDate, endDate);
			cost = calculateSinglePublicationCost(ic);
		}

		return cost;
	}

	private double calculateSinglePublicationCost(HashMap<String, Float> map) {
		double sum = 0.0;

		for (String K : map.keySet()) {
			sum = sum + map.get(K);
		}
		return sum;
	}

	private double calculateMultiplePublicationsCost(HashMap<String, HashMap<String, Float>> map) {
		double sum = 0.0;
		for (String K : map.keySet()) {
			HashMap<String, Float> sm = map.get(K);
			for(String Key:sm.keySet()) {
				sum = sum+sm.get(Key);
			}
		}		
		return sum;
	}
}
