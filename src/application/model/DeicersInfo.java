package application.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// This class contains all the names and Nnumber of Deicers.
//All the operational Deicing Trucks,  and the Aircrafts that SPX currently operates on.

public class DeicersInfo {
	// This is the the name and Nnumbers of All the Deicers!
	public static ObservableList<String> getDeicers() {
ReadEmployees e = new ReadEmployees();
return e.readEmployeesFromExcel();
	}

	public static ObservableList<String> getTrucks() {
		// This is the list of the Deicing Trucks that SPX has in IAD.
		ObservableList<String> trucks = FXCollections.observableArrayList();
		String[] s2 = new String[] { "SPX700", "SPX701", "SPX702", "SPX703", "SPX704", "SPX705", "SPX706", "SPX707",
				"SPX708", "SPX709", "SPX710", "SPX711", "SPX697", "SPX698", "SPX699" };
		for (int a = 0; a < s2.length; a++) {
			trucks.add(s2[a]);
		}
		return trucks;
	}

	public static ObservableList<String> getAircrafts() {
		// This is the list of the Aircrafts that SPX operates at IAD.
		ObservableList<String> aircrafts = FXCollections.observableArrayList();
		String[] s3 = new String[] { "CRJ 700", "CRJ 200", "ERJ 145", "Q 200", "Q 300", "Q 400 ", "EMB 175" };
		for (int b = 0; b < s3.length; b++) {
			aircrafts.add(s3[b]);
		}
		
		return aircrafts;
	}

	// public static ObservableList<Flight> getApiFlightsFlightNumber(){

	// API api = new API();
	// ArrayList<Flight> flights = api.getFlights();
	// ObservableList<Flight> flightNumbers =
	// FXCollections.observableArrayList(flights);

	// return flightNumbers;

	// }

}
