package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Deicing {

	//private Spot spot;
	//private Flight flight;
	private StringProperty startTime;
	private StringProperty endTime;
	private StringProperty fluidType;
	private StringProperty aircraftCheck;

	public Deicing() {

		this.startTime = new SimpleStringProperty("");
		this.endTime = new SimpleStringProperty("");
		this.fluidType = new SimpleStringProperty("");
		this.aircraftCheck = new SimpleStringProperty("");

	}

	public String getStartTime() {
		return startTime.get();
	}

	public StringProperty startTimeProperty() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime.set(startTime);
	}

	public String getEndTime() {
		return endTime.get();
	}

	public StringProperty endTimeProperty() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime.set(endTime);
	}

	public String getFluidType() {
		return fluidType.get();
	}

	public StringProperty fluidTypeProperty() {
		return fluidType;
	}

	public void setFluidType(String fluidType) {
		this.fluidType.set(fluidType);
	}

	public String getAircraftCheck() {
		return aircraftCheck.get();
	}

	public StringProperty aircraftCheckProperty() {
		return aircraftCheck;
	}

	public void setAircraftCheck(String aircraftCheck) {
		this.aircraftCheck.set(aircraftCheck);
	}

	public String toString() {
		return "startTime: " + getStartTime() + "\nendTime: " + getEndTime() + "\nfluidType: " + getFluidType()
				+ "\naircraftCheck: " + getAircraftCheck();
	}

}