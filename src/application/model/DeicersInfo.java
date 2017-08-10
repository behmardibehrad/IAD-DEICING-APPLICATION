package application.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// This class contains all the names and Nnumber of Deicers.
//All the operational Deicing Trucks,  and the Aircrafts that SPX currently operates on.

public class DeicersInfo {
	// This is the the name and Nnumbers of All the Deicers!
	public static ObservableList<String> getDeicers() {
		ObservableList<String> deicers = FXCollections.observableArrayList();
		String[] s = new String[] { "Wilber Martinez N053164", "AKUICHOUE ARMAND N055724", "RASHIDANY ARDALAN N055351",
				"ANDRADE JOSE N064933", "ASIF MOHAMMAD N054740", "BAUGH BRYANT N049349", "BETANCOURT MANUEL N048966",
				"CARR KEVIN N050379", "CLARKE AKASHA N049883", "CLAURE HELAR N063377", "FIAVE YAO N055900",
				"GRANADOS ABEL N049676", "GRANT ERLANGGA N049891", "GUEVARA CARLOS N048353", "GUEVARA WILSON N049672",
				"HARRIS JAMAL N054724", "HARRIS JAMES N059248", "HERRERA ALEX N048649", "HICKERSON SARAH N062798",
				"JAGORY MOHAMAD N062815", "JEBEASA TSEGAW N048639", "JOHN VICTOR N048946", "JOHNSON JOE N047920",
				"JOHNSON DAVID N048632", "JONES PATRICIA N048615", "JONES TERRELL N054796", "JORGE DAVID N059239",
				"KHAWRIN MOHAMAD N054779", "KOLURU SRINIVSA N063714", "KUYATEH MUSA N057992", "MACKAY GEORGE N050332",
				"MARIACA JUAN N054789", "MARTINEZ WILBER N053164", "MCKINNEY ARIEL N049858", "MEISKEY MAURICE N049582",
				"MENDOZA MILTON N049807", "MIDDLETON DAMIAN N047927", "MIDDLETON DAVID N047925", "MOSS STEVEN N062812",
				"MUSANZI JOHN N049275", "OCONNOR JOHN N050092", "OLIVA ARNOLD N048609", "OMAR MAGDI N048661",
				"ORTIZ IVAN N057954", "PANCIONE GEORGINA N056982", "PARK KYE N049591", "PEREZ OMAR N054314",
				"PINEDA JUAN N056969", "PINEDA MANUEL N054769", "SALAZAR ALEXIS N049346", "SESAY ABUKAR Nn064932",
				"SLOAN MIGUEL N049749", "SOSA RAFAEL N048656", "SPIRIIOZZI DAVID N049343", "SPIROCH MATTHEW N049792",
				"STOKES ROBERTA N048667", "TALIAFERRO CARROLL N048617", "TESSEMA SAMUEL N055906",
				"THOMAS BARRON N047936", "TORRES ARIEL N048351", "VILLACORTA WILBER N047995",
				"WELLINGTON NYKIA N056996", "WISEMAN DEANGELO N049284", "WOLDGABIEL EYASU N055121" };
		for (int j = 0; j < s.length; j++) {
			deicers.add(s[j]);
		}
		return deicers;
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
