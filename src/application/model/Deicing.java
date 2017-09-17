package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Deicing {

	//private Spot spot;
	//private Flight flight;
	private StringProperty startTime;
	private StringProperty endTime;
	private StringProperty type1StartTime;
	private StringProperty type1StoptTime;
	private StringProperty type4StartTime;
	private StringProperty type4StoptTime;
	private StringProperty fluidType;
	private StringProperty aircraftCheck;
	private int fluidTypeInt;

	public Deicing() {

		this.startTime = new SimpleStringProperty("");
		this.endTime = new SimpleStringProperty("");
		this.fluidType = new SimpleStringProperty("");
		this.aircraftCheck = new SimpleStringProperty("");
		this.fluidTypeInt = 2;
		this.type1StartTime = new SimpleStringProperty("");
		this.type1StoptTime= new SimpleStringProperty("");
		this.type4StartTime= new SimpleStringProperty("");
		this.type4StoptTime= new SimpleStringProperty("");

	}

	public int getFluidTypeInt() {
		return fluidTypeInt;
	}

	public void setFluidTypeInt(int fluidTypeInt) {
		this.fluidTypeInt = fluidTypeInt;
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
	
	public String getType1StoptTime() {
		return type1StoptTime.get();
	}
	
	public StringProperty type1StoptTime() {
		return type1StoptTime;
	}
	public void setType1StopTime(String type1StopTime) {
		this.type1StoptTime.set(type1StopTime);
	}

	public String getType1StarttTime() {
		return type1StartTime.get();
	}
	
	public StringProperty type1StarttTime() {
		return type1StartTime;
	}
	public void setType1StartTime(String type1StartTime) {
		this.type1StartTime.set(type1StartTime);
	}

	public String getType4StoptTime() {
		return type4StoptTime.get();
	}
	
	public StringProperty type4StoptTime() {
		return type4StoptTime;
	}
	public void setType4StopTime(String type4StoptTime) {
		this.type4StoptTime.set(type4StoptTime);
	}
	

	public String getType4Startime() {
		return type4StartTime.get();
	}
	
	public StringProperty type4StarttTime() {
		return type4StoptTime;
	}
	public void setType4StartTime(String type4StartTime) {
		this.type4StartTime.set(type4StartTime);
	}
	
	


	public String toString() {
		return "startTime: " + getStartTime() + "\nendTime: " + getEndTime() + "\nfluidType: " + getFluidType()
				+ "\naircraftCheck: " + getAircraftCheck() + "\nfluid int type: " + getFluidTypeInt() + "\ntype1StartTime:" +getType1StarttTime()
				+ "\ntype4StartTime:" + getType4Startime()+ "\ntype1StopTime:" + getType1StoptTime() +"\ntype4StopTime:" + getType4StoptTime() ;
	}	

}