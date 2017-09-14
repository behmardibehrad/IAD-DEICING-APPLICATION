package application.model;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.collections.ObservableList;

// This class contains all the names and Nnumber of Deicers.
//All the operational Deicing Trucks,  and the Aircrafts that SPX currently operates on.

public class FlightInfo {
	// This is the the name and Nnumbers of All the Deicers!
	
	//public static ArrayList<Flight> getFlights() {
//ReadFlights f = new ReadFlights();
////return f.readFlightsFromExcel2();
	//}

	
	
	
	
	//working
	
	public static ObservableList<Flight> getFlights() {
ReadFlights f = new ReadFlights();
return f.readFlightsFromExcel3();
	}
	
	
	
	
	
	
	

}