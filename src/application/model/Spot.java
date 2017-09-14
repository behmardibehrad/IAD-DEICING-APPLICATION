package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Spot {

	private int spotIntType;
	private Boolean spotHasFlightData;
	private Boolean active;
	private StringProperty spotNumber;
	private StringProperty truck1;
	private StringProperty truck2;
	private StringProperty sprayer1;
	private StringProperty sprayer2;
	private StringProperty driver1;
	private StringProperty driver2;
	private StringProperty freezepoint1;
	private StringProperty freezepoint2;
	private String apiTileID;
	private Image spotImage;

	Flight flight;
	Deicing deicing;
	Spot spot;
	DashboardApi spotApi;

	public Spot() {
		this(null);
	}

	public Spot(String spotNumber) {

		this.spotIntType = 0;
		this.active = false;
		this.spotHasFlightData = false;
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
		this.spotApi = new DashboardApi(flight, deicing, this);

	}


	public Boolean getSpotHasFlightData() {
		return spotHasFlightData;
	}

	public void setSpotHasFlightData(Boolean spotHasFlightData) {
		this.spotHasFlightData = spotHasFlightData;
	}

	public int getSpotIntType() {
		return spotIntType;
	}

	public void setSpotIntType(int spotIntType) {
		this.spotIntType = spotIntType;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public void setDeicing(Deicing deicing) {
		this.deicing.setFluidType(deicing.getFluidType());
		this.deicing.setStartTime(deicing.getStartTime());
		this.deicing.setAircraftCheck(deicing.getAircraftCheck());
		this.deicing.setEndTime(deicing.getEndTime());
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
	

	public String getApiTileID() {
		
		return apiTileID;
	}

	public String setApiTileID(String spotNumber) {
		

    switch(spotNumber) {
       case "SPOT 1 F" :
      	 this.apiTileID = "1";
      	 break;
       case "SPOT 1 R" :
      	 this.apiTileID = "6";
      	 break;	        	 
       case "SPOT 2 F" :
      	 this.apiTileID = "2";
      	 break;
       case "SPOT 2 R" :
      	 this.apiTileID = "7";
      	 break;
       case "SPOT 3 F" :
      	 this.apiTileID = "3";
      	 break;
       case "SPOT 3 R" :
      	 this.apiTileID = "8";
      	 break;
	     case "SPOT 4 F" :
	    	 this.apiTileID = "4";
	    	 break;
	     case "SPOT 4 R" :
	    	 this.apiTileID = "9";
	    	 break;
	     case "SPOT 5 F" :
	    	 this.apiTileID = "5";
	    	 break;
	     case "SPOT 5 R" :
	    	 this.apiTileID = "10";
	    	 break;
    }
	return apiTileID;
}
	
	

	public DashboardApi getDashboardApi() {
		return spotApi;
	}

	public String toString() {
		return "SPOT: " + getSpotNumber();
	}
	


}
