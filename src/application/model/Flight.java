package application.model;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Flight {

	private StringProperty flightNumber;
	private StringProperty tailNumber;
	private StringProperty aircraftType;
	private StringProperty carrier;
	private StringProperty estDeparture;

	private Spot spot;

	public Flight() {
		this(null);
	}

	public Flight(String flightNumber) {

		this.flightNumber = new SimpleStringProperty(flightNumber);
		this.tailNumber = new SimpleStringProperty("");
		this.aircraftType = new SimpleStringProperty("");
		this.carrier = new SimpleStringProperty("");

	}

	public Flight(String flightNumber, String tailNumber, String planeType, String estDeparture, String carrier) {
		this.flightNumber = new SimpleStringProperty(flightNumber);
		this.tailNumber = new SimpleStringProperty(tailNumber);
		this.aircraftType = new SimpleStringProperty(planeType);
		this.estDeparture = new SimpleStringProperty(estDeparture);
		this.carrier = new SimpleStringProperty(carrier);

	}

	public String getFlightNumber() {
		return flightNumber.get();
	}

	public StringProperty flightNumberProperty() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber.set(flightNumber);
	}

	public String getTailNumber() {
		return tailNumber.get();
	}

	public StringProperty tailNumberProperty() {
		return tailNumber;
	}

	public void setTailNumber(String tailNumber) {
		this.tailNumber.set(tailNumber);
	}

	public String getAircraftType() {
		return aircraftType.get();
	}

	public StringProperty aircraftTypeProperty() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType.set(aircraftType);
	}

	public String getCarrier() {
		return carrier.get();
	}

	public StringProperty carrierProperty() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier.set(carrier);
	}

	public void clear() {

		this.flightNumber = new SimpleStringProperty("");
		this.tailNumber = new SimpleStringProperty("");
		this.aircraftType = new SimpleStringProperty("");
		this.carrier = new SimpleStringProperty("");
	}

	public String toString() {
		return "Flight: " + getFlightNumber() + "\nCarrier: " + getCarrier() + "\nAircraft: " + getAircraftType()
				+ "\nTail#: " + getTailNumber();
	}

}
