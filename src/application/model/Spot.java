package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Spot {

	private StringProperty spotNumber;
	private StringProperty truck1;
	private StringProperty truck2;
	private StringProperty sprayer1;
	private StringProperty sprayer2;
	private StringProperty driver1;
	private StringProperty driver2;
	private StringProperty freezepoint1;
	private StringProperty freezepoint2;
	private Image spotImage;

	Flight flight;
	Deicing deicing;

	public Spot() {
		this(null);
	}

	public Spot(String spotNumber) {

		this.spotNumber = new SimpleStringProperty(spotNumber);
		this.truck1 = new SimpleStringProperty("");
		this.freezepoint1 = new SimpleStringProperty("");
		this.driver1 = new SimpleStringProperty("");
		this.sprayer1 = new SimpleStringProperty("");
		this.truck2 = new SimpleStringProperty("");
		this.freezepoint2 = new SimpleStringProperty("");
		this.driver2 = new SimpleStringProperty("");
		this.sprayer2 = new SimpleStringProperty("");
		this.flight = new Flight();
		this.deicing = new Deicing();
	}

	public String getSpotNumber() {
		return spotNumber.get();
	}

	public StringProperty spotNumberProperty() {
		return spotNumber;
	}

	public void setSpotNumber(String spotNumber) {
		this.spotNumber.set(spotNumber);
	}

	public String getTruck1() {
		return truck1.get();
	}

	public StringProperty truck1Property() {
		return truck1;
	}

	public void setTruck1(String truck1) {
		this.truck1.set(truck1);
	}

	public String getTruck2() {
		return truck2.get();
	}

	public StringProperty truck2Property() {
		return truck2;
	}

	public void setTruck2(String truck2) {
		this.truck2.set(truck2);
	}

	public String getFreezepoint1() {
		return freezepoint1.get();
	}

	public StringProperty freezepoint1Property() {
		return freezepoint1;
	}

	public void setFreezepoint1(String freezepoint1) {
		this.freezepoint1.set(freezepoint1);
	}

	public String getFreezepoint2() {
		return freezepoint2.get();
	}

	public StringProperty freezepoint2Property() {
		return freezepoint2;
	}

	public void setFreezepoint2(String freezepoint2) {
		this.freezepoint2.set(freezepoint2);
	}

	public String getSprayer2() {
		return sprayer2.get();
	}

	public StringProperty sprayer2Property() {
		return sprayer2;
	}

	public void setSprayer2(String sprayer2) {
		this.sprayer2.set(sprayer2);
	}

	public String getSprayer1() {
		return sprayer1.get();
	}

	public StringProperty sprayer1Property() {
		return sprayer1;
	}

	public void setSprayer1(String sprayer1) {
		this.sprayer1.set(sprayer1);
	}

	public String getDriver1() {
		return driver1.get();
	}

	public StringProperty driver1Property() {
		return driver1;
	}

	public void setDriver1(String driver1) {
		this.driver1.set(driver1);
	}

	public String getDriver2() {
		return driver2.get();
	}

	public StringProperty driver2Property() {
		return driver2;
	}

	public void setDriver2(String driver2) {
		this.driver2.set(driver2);
	}

	public Image getSpotImage() {
		return spotImage;
	}

	public void setSpotImage(Image spotImage) {
		this.spotImage = spotImage;
	}

	public Deicing getDeicing() {
		return deicing;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight.setAircraftType(flight.getAircraftType());
		this.flight.setCarrier(flight.getCarrier());
		this.flight.setFlightNumber(flight.getFlightNumber());
		this.flight.setTailNumber(flight.getTailNumber());
	}

	public void setDeicing(Deicing deicing) {
		this.deicing.setFluidType(deicing.getFluidType());
		this.deicing.setStartTime(deicing.getStartTime());
		this.deicing.setAircraftCheck(deicing.getAircraftCheck());
		this.deicing.setEndTime(deicing.getEndTime());
	}

	public String toString() {
		return getSpotNumber();
	}

	public String toStringFullData() {
		return "\nSpot: " + getSpotNumber();
	}

}
