package application.view;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.ss.formula.functions.T;
import org.controlsfx.control.textfield.TextFields;
import application.MainApp;
import application.model.DashboardApi;
import application.model.DeicersInfo;
import application.model.Flight;
import application.model.FlightInfo;
import application.model.FxUtilTest;
import application.model.SavedExcelData;
import application.model.Spot;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import javafx.util.StringConverter;
import jxl.write.WriteException;

public class SpotOverviewController {

	// Spot Table With 3 Columns.
	//@FXML
	//private TextField searchSSD;
	
	//@FXML
	//private ComboBox<Flight>  searchSSD = new ComboBox<>();	
	
	@FXML
	private ComboBox<Flight>  searchSSD = new ComboBox<Flight>();
	@FXML
	private TableView<Spot> storedFlightTable;
	@FXML
	private TableColumn<Spot, String> storedFlightTableColumn;
	
	@FXML
	private TextArea commentArea;
	
	@FXML
	private TableView<Spot> spotsTable;
	@FXML
	private TableColumn<Spot, String> spotsNumberColumn;
	@FXML
	private TableColumn<Spot, String> flightNumberColumn;
	@FXML
	private TableColumn<Spot, String> aircraftColumn;
	@FXML
	private Label spotLabel;
	@FXML
	private Label truck1Label;
	@FXML
	private Label freezepoint1Label;
	@FXML
	private Label dirver1Label;
	@FXML
	private Label sprayer1Label;
	@FXML
	private Label truck2Label;
	@FXML
	private Label freezepoint2Label;
	@FXML
	private Label dirver2Label;
	@FXML
	private Label sprayer2Label;
	
	//Dynamic Lables
	@FXML
	private Label flightNumberLabel;
	@FXML
	private Label tailNumberLabel;
	@FXML
	private Label aircraftTypeLabel;
	@FXML
	private Label carrierLabel;
	@FXML
	private Label type1starttime;
	@FXML
	private Label type1stoptime;
	@FXML
	private Label type4starttime;
	@FXML
	private Label type4stoptime;
	@FXML
	private Label fluidTypeLable;
	
	
	//Static lables
	@FXML
	private Label flightNumberLabel1;
	@FXML
	private Label tailNumberLabel1;
	@FXML
	private Label aircraftTypeLabel1;
	@FXML
	private Label carrierLabel1;
	@FXML
	private Label type1starttime1;
	@FXML
	private Label type1stoptime1;
	@FXML
	private Label type4starttime1;
	@FXML
	private Label type4stoptime1;
	@FXML
	private Label fluidTypeLable1;
	
	
	
	
	


	@FXML
	private Label middleHiddenSpotNumber;
	@FXML
	private Label activityLable;
	// Released Flights Table With 9 Columns.
	@FXML
	private TableView<Spot> releaseTable;
	@FXML
	private TableColumn<Spot, String> carrierColumn;
	@FXML
	private TableColumn<Spot, String> aircraftTypeColumn;
	@FXML
	private TableColumn<Spot, String> flightReleasedColumn;
	@FXML
	private TableColumn<Spot, String> tailNumberColumn;
	//@FXML
	//private TableColumn<Spot, String> fluidColumn;
	
	@FXML
	private TableColumn<Spot, String> type1Column;
	@FXML
	private TableColumn<Spot, String> type4Column;
	@FXML
	private TableColumn<Spot, String> type4startColumn;
	@FXML
	private TableColumn<Spot, String> type4stopColumn;
	@FXML
	private TableColumn<Spot, String> type1startColumn;
	@FXML
	private TableColumn<Spot, String> type1stopColumn;
	
	
	
	@FXML
	private TableColumn<Spot, String> checkColumn;
	@FXML
	private TableColumn<Spot, String> employeeInit;
	@FXML
	private TableColumn<Spot, String> comment;
	// Selected Flight Table with 3 Columns
	//@FXML
	//private TableView<Flight> selectedFlightTable;

	@FXML
	private ImageView imageView;
	@FXML
	private ImageView padStatusImageViewSpot1Front;
	
	@FXML
	private ImageView padStatusImageViewSpot1Rear;
	@FXML
	private ImageView padStatusImageViewSpot2Front;
	@FXML
	private ImageView padStatusImageViewSpot2Rear;
	@FXML
	private ImageView padStatusImageViewSpot3Front;
	@FXML
	private ImageView padStatusImageViewSpot3Rear;
	@FXML
	private ImageView padStatusImageViewSpot4Front;
	@FXML
	private ImageView padStatusImageViewSpot4Rear;
	@FXML
	private ImageView padStatusImageViewSpot5Front;
	@FXML
	private ImageView padStatusImageViewSpot5Rear;
	private Image imageType1 = new Image("application/image/orangeall.png");
	private Image imageType4 = new Image("application/image/greenfull.png");;
	private Image imageType1Blink = new Image("application/image/Type1.gif");;
	private Image imageType4Blink = new Image("application/image/Type4.gif");;
	private Image imageBlack = new Image("application/image/blackback.png");

	@FXML
	private ComboBox<String> fluidTypeComboBox;
	@FXML
	private ComboBox<Flight> flightComboBox1;
	@FXML
	private ComboBox<Flight> flightComboBox;
	@FXML
	private ComboBox<Spot> sendToComboBox = new ComboBox<Spot>();
	@FXML
	private Button start;
	@FXML
	private Button stop;
	@FXML
	private Button setting;
	@FXML
	private Button release;
	// Reference to the main application.
	private MainApp mainApp;
	private ObservableList<Spot> releaseTableData = FXCollections.observableArrayList();
	//private ObservableList<Flight> flightData = FXCollections.observableArrayList();
    

	
	
	
	public SpotOverviewController() {
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		// spotsTable.setItems(mainApp.getSpotData());
		// spotData.addAll(mainApp.getSpotData());
		spotsTable.setItems(mainApp.getSpotData());
		sendToComboBox.getItems().addAll(spotsTable.getItems());

	}

	@FXML
	public void initialize() {
		//selectedFlightTable.setItems(flightData);
		

		
		
		
		// Initialize the spot table with the one columns.
		spotsNumberColumn.setCellValueFactory(cellData -> cellData.getValue().spotNumberProperty());
		
       // spotsNumberColumn.setStyle("-fx-background-color:red");
        //flightNumberColumn.setStyle("-fx-background-color:red");
        //aircraftColumn.setStyle("-fx-background-color:red");
        //spotsTable.getSelectionModel().select(0);
		padStatusImageViewSpot1Front.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(0);
 		});
 		padStatusImageViewSpot1Rear.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(1);
 		});
 		padStatusImageViewSpot2Front.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(2);
 		});
 		padStatusImageViewSpot2Rear.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(3);
 		});
 		padStatusImageViewSpot3Front.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(4);
 		});
 		padStatusImageViewSpot3Rear.setOnMouseClicked((MouseEvent e) -> {
 	    spotsTable.getSelectionModel().select(5);
 		});
 		padStatusImageViewSpot4Front.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(6);
 		});
 	    padStatusImageViewSpot4Rear.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(7);
 		});
 		padStatusImageViewSpot5Front.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(8);
 		});
 		padStatusImageViewSpot5Rear.setOnMouseClicked((MouseEvent e) -> {
 		    spotsTable.getSelectionModel().select(9);
 		});

		
		
		flightNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().flightNumberProperty());
		aircraftColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().aircraftTypeProperty());

		// Initialize the releaseSpotTable table with the one columns.
		carrierColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().carrierProperty());
		aircraftTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().aircraftTypeProperty());
		
		//behrad2
		//flightReleasedColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().flightNumberProperty());
		tailNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().tailNumberProperty());
		//fluidColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().fluidTypeProperty());
		checkColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().aircraftCheckProperty());
		employeeInit.setCellValueFactory(cellData -> cellData.getValue().sprayer1Property());
		type4startColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().type4StarttTime());
		type4stopColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().type4StoptTime());
		type1startColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().type1StarttTime());
		type1stopColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().type1StoptTime());
		flightReleasedColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().flightNumberProperty());
		comment.setCellValueFactory(cellData -> cellData.getValue().commentProperty());

		// Initialize the selectedflight table with the 3 columns.
		
		//behrad2
		//flightSelectedColumn.setCellValueFactory(cellData -> cellData.getValue().flightNumberProperty());
		//aircraftSelectedColumn.setCellValueFactory(cellData -> cellData.getValue().aircraftTypeProperty());
		//tailSelectedColumn.setCellValueFactory(cellData -> cellData.getValue().tailNumberProperty());


		// Listen for selection changes and show the spot details when changed.
		spotsTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showSpotDetails(newValue));
		
		//fluidTypeComboBox.getSelectionModel().selectedItemProperty()
		//.addListener((observable, oldValue, newValue) -> spotsTable.getSelectionModel().getSelectedItem().getDeicing().setFluidType(newValue)); 
		
		

	
		
		

		imageView.setImage(imageBlack);
		
		

		 
		 
		 
		 
		padStatusImageViewSpot1Front.setImage(imageBlack);
		padStatusImageViewSpot1Rear.setImage(imageBlack);
		padStatusImageViewSpot2Front.setImage(imageBlack);
		padStatusImageViewSpot2Rear.setImage(imageBlack);
		padStatusImageViewSpot3Front.setImage(imageBlack);
		padStatusImageViewSpot3Rear.setImage(imageBlack);
		padStatusImageViewSpot4Front.setImage(imageBlack);
		padStatusImageViewSpot4Rear.setImage(imageBlack);
		padStatusImageViewSpot5Front.setImage(imageBlack);
		padStatusImageViewSpot5Rear.setImage(imageBlack);
		

		// showSpotDetails(null);

		// flightComboBox.getItems().addAll(DeicersInfo.getApiFlightsFlightNumber());
		// flightComboBox.setItems(DeicersInfo.getApiFlightsFlightNumber());
		// flightComboBox.getItems().addAll(DeicersInfo.getApiFlightsFlightNumber());

		// flightComboBox.setEditable(true);

		// behrad
		// flightComboBox.getItems().addAll(DeicersInfo.getApiFlightsFlightNumber());
		//TextFields.bindAutoCompletion(flightComboBox.getEditor(), flightComboBox.getItems());

		// TextFields.bindAutoCompletion(flightComboBox,
		// DeicersInfo.getApiFlightsFlightNumber());
		// TextFields.bindAutoCompletion(flightComboBox,
		// DeicersInfo.getApiFlightsFlightNumber());

		// flightComboBox.setItems(selectedFlightTableData);

		fluidTypeComboBox.getItems().addAll("TYPE I", "TYPE IV");
		// fluidTypeComboBox.getSelectionModel().selectFirst();
		// fluidTypeComboBox.setValue("Clear");
		// spotData.addAll(mainApp.getSpotData());
		//searchSSD1.getItems().addAll(FlightInfo.getFlights());
		
		//searchSSD.getEditor();
		//searchSSD.setEditable(true);
		
		searchSSD.getItems().addAll(FlightInfo.getFlights());
		
		
		//TextFields.bindAutoCompletion(searchSSD.getEditor(),FlightInfo.getFlights());
		//searchSSD.setItems(FlightInfo.getFlights().addAll(c));
		//searchSSD.getItems().addAll(FlightInfo.getFlights().toString());
		
        FxUtilTest.autoCompleteComboBoxPlus(searchSSD, 
        		(typedText, itemToCompare) -> 
        itemToCompare.getFlightNumber().toLowerCase().contains(typedText.toLowerCase()) || itemToCompare.getTailNumber().toLowerCase().contains(typedText.toLowerCase()) );

	}

	// change the spotmodeling data look at the getter and setters

	private void showSpotDetails(Spot selectedSpot) {
		if(selectedSpot.getDeicing().getFluidTypeInt()==0)
		{
		fluidTypeComboBox.getSelectionModel().selectFirst();}
		else if(selectedSpot.getDeicing().getFluidTypeInt()==1) {
			fluidTypeComboBox.getSelectionModel().select(1);}
		else {
			fluidTypeComboBox.getSelectionModel().clearSelection();
		fluidTypeComboBox.setPromptText("Fluid Type");
		}
		
		
		
		
		
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), activityLable);
	    fadeTransition.setFromValue(1.0);
	    fadeTransition.setToValue(0.0);
	    fadeTransition.setCycleCount(Animation.INDEFINITE);
	    fadeTransition.play();
		
		//check to see if spot has flight
		if(!selectedSpot.getFlight().getFlightNumber().equals(""))
		{
			selectedSpot.setSpotHasFlightData(true);
			flightNumberLabel.setText(selectedSpot.getFlight().getFlightNumber());
			tailNumberLabel.setText(selectedSpot.getFlight().getTailNumber());
			aircraftTypeLabel.setText(selectedSpot.getFlight().getAircraftType());
			carrierLabel.setText(selectedSpot.getFlight().getCarrier());
			type1starttime.setText(selectedSpot.getDeicing().getType1StarttTime());
			type4starttime.setText(selectedSpot.getDeicing().getType4Startime());
			type1stoptime.setText(selectedSpot.getDeicing().getType1StoptTime());
			type4stoptime.setText(selectedSpot.getDeicing().getType4StoptTime());
			fluidTypeLable.setText(selectedSpot.getDeicing().getFluidType());
			commentArea.setText(selectedSpot.getComment());

			
			if(selectedSpot.getDeicing().getFluidTypeInt()==2 && selectedSpot.getSpotHasFlightData())
			{
				start.setDisable(true);
				stop.setDisable(true);
				release.setDisable(true);
				fluidTypeComboBox.setDisable(false);
			}
			else if(selectedSpot.getDeicing().getFluidTypeInt()!=2 && selectedSpot.getActive() )
			{
				start.setDisable(true);
				stop.setDisable(false);
				release.setDisable(true);
				activityLable.setText(selectedSpot.getActivityLable());
				fluidTypeComboBox.setDisable(true);
				switch(selectedSpot.getDeicing().getFluidTypeInt()) {
				   case 0 :
					   selectedSpot.setSpotImage(imageType1Blink);
						break; // optional
				   case 1 :
					   selectedSpot.setSpotImage(imageType4Blink);
						break; // optional
				}
			}
			else if(selectedSpot.getDeicing().getFluidTypeInt()!=2 && !selectedSpot.getActive())
			{

				fluidTypeComboBox.setDisable(false);
				release.setDisable(false);
				start.setDisable(false);
				stop.setDisable(false);
				activityLable.setText("");
			}
			
		
		}
		else
		{
			fluidTypeComboBox.setDisable(true);
			release.setDisable(true);
			start.setDisable(true);
			stop.setDisable(true);
			flightNumberLabel.setText("");
			tailNumberLabel.setText("");
			aircraftTypeLabel.setText("");
			carrierLabel.setText("");
			type1starttime.setText("");
			type4starttime.setText("");
			type1stoptime.setText("");
			type4stoptime.setText("");
			fluidTypeLable.setText("");
			activityLable.setText("");
			commentArea.setText("");
		}
		
		middleHiddenSpotNumber.setText(selectedSpot.getSpotNumber());
		spotLabel.setText(selectedSpot.getSpotNumber());
		truck1Label.setText(selectedSpot.getTruck1());
		freezepoint1Label.setText(selectedSpot.getFreezepoint1());
		dirver1Label.setText(selectedSpot.getDriver1());
		sprayer1Label.setText(selectedSpot.getSprayer1());
		truck2Label.setText(selectedSpot.getTruck2());
		freezepoint2Label.setText(selectedSpot.getFreezepoint2());
		dirver2Label.setText(selectedSpot.getDriver2());
		sprayer2Label.setText(selectedSpot.getSprayer2());
		imageView.setImage(selectedSpot.getSpotImage());
		commentArea.setText(selectedSpot.getComment());
		UpdateStatusTableImage(selectedSpot);

		

	}

	
	

	private void clearSpot(Spot spot) {
		spot.getFlight().setAircraftType("");
		spot.getFlight().setCarrier("");
		spot.getFlight().setFlightNumber("");
		spot.getFlight().setTailNumber("");
		spot.getDeicing().setAircraftCheck("");
		spot.getDeicing().setType1StartTime("");
		spot.getDeicing().setType1StopTime("");
		spot.getDeicing().setType4StartTime("");
		spot.getDeicing().setType4StopTime("");
		spot.getDeicing().setFluidType("");
		spot.setActivityLable("");
		spot.getDeicing().setFluidTypeInt(2);
		flightNumberLabel.setText("");
		tailNumberLabel.setText("");
		aircraftTypeLabel.setText("");
		carrierLabel.setText("");
		activityLable.setText("");
		type1starttime.setText("");
		type4starttime.setText("");
		type1stoptime.setText("");
		type4stoptime.setText("");
		fluidTypeLable.setText("");
		spot.setComment("");
		spot.setSpotImage(imageBlack);
		imageView.setImage(spot.getSpotImage());
		spot.setActive(false);
		spot.setSpotHasFlightData(false);
		UpdateStatusTableImage(spot);

	}


	@FXML
	private void handleEditSpot() {
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		if (selectedSpot != null) {
			boolean okClicked = mainApp.showSpotEditDialog(selectedSpot);
			if (okClicked) {
				showSpotDetails(selectedSpot);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Spot Selected");
			alert.setContentText("Please select a SPOT in the table.");
			alert.showAndWait();
		}
		
	}

	@FXML
	private void handleEditFlight() {

		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		


		if (selectedSpot != null) {
			boolean okClicked = mainApp.showFlightEditDialog(selectedSpot);
			if (okClicked) 
			{}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Spot Selected");
			alert.setContentText("Please select a Flight in the table.");
			alert.showAndWait();
		}
		showSpotDetails(selectedSpot);
	}
	
	

	
	

	@FXML
	private void handleSetting() {
		mainApp.showSettingDialog();

	}

	@FXML
	private void handleReleaseFlight() {
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
			
			try {
				selectedSpot.getDashboardApi().ClearData();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				selectedSpot.getDashboardApi().ClearConf();
			} catch (Exception e) {
				e.printStackTrace();
			}

			String ac = selectedSpot.getFlight().getAircraftType();
			if (ac.equals("XMJ") || ac.equals("XR4")) {
				selectedSpot.getDeicing().setAircraftCheck("Tactile");
			} else {
				selectedSpot.getDeicing().setAircraftCheck("Post Check");
			}

			releaseTableData.add(copySpot(selectedSpot));
			releaseTable.setItems(releaseTableData);
			//selectedSpot.setSpotHasFlightData(false);
			//selectedSpot.setActive(false);
			clearSpot(selectedSpot);
			showSpotDetails(selectedSpot);
			// spotsTable.getSelectionModel().clearSelection();
			// fluidTypeComboBox.setValue("Fluid Type");
		}
	
	
	@FXML
	private void handleSaveReleaseTable() {
		SavedExcelData excel = new SavedExcelData();
		//excel.write2(existingData, "C:/Users/DarkAngel/Desktop/bbb.xls");
		try {
			excel.write2(releaseTable);
		} catch (WriteException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	
	@FXML
	private void handleSaveReleaseTableOnline() {
	
	}
	

	public Spot copySpot(Spot spot) {
		Spot copiedSpot = new Spot(spot.getSpotNumber());
		copiedSpot.setFlight(spot.getFlight());
		copiedSpot.setDeicing(spot.getDeicing());
		copiedSpot.setSpotNumber(spot.getSpotNumber());
		copiedSpot.setDriver1(spot.getDriver1());
		copiedSpot.setSprayer1(spot.getSprayer1());
		copiedSpot.setDriver2(spot.getDriver2());
		copiedSpot.setSprayer2(spot.getSprayer2());
		copiedSpot.getFlight().setFlightNumber(spot.getFlight().getFlightNumber());
		copiedSpot.setComment(spot.getComment());

		return copiedSpot;

	}

	
	@FXML
	public void setSearchSsd() {
		
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.WARNING);
		
		selectedSpot.setFlight(FxUtilTest.getComboBoxValue(searchSSD));

//		selectedSpot.setFlight(FxUtilTest.getComboBoxValue(searchSSD));
		
		//if (FxUtilTest.getComboBoxValue(searchSSD) instanceof Flight) {
//System.out.print("flight");
//}
		//f=FxUtilTest.getComboBoxValue(searchSSD);
		//System.out.println(FxUtilTest.getComboBoxValue(searchSSD).getFlightNumber());
		showSpotDetails(selectedSpot);
		searchSSD.getSelectionModel().clearSelection();
		searchSSD.getItems().addAll(FlightInfo.getFlights());



		//searchSSD.getSelectionModel().clearSelection();
		//selectedSpot.getFlight().setFlightNumber(searchSSD.getSelectionModel().getSelectedItem().getFlightNumber());
		

		

	}

	@FXML
	public void setFluidType() {
		
		System.out.println("fluid box");

		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();			
		selectedSpot.getDeicing().setFluidType(fluidTypeComboBox.getSelectionModel().getSelectedItem());
		selectedSpot.getDeicing().setFluidTypeInt(fluidTypeComboBox.getSelectionModel().getSelectedIndex());
		
		
		switch(selectedSpot.getDeicing().getFluidTypeInt())
		{
		   case 0 :
			   selectedSpot.setSpotImage(imageType1);
				break; // optional
		   case 1 :
			   selectedSpot.setSpotImage(imageType4);
				break; // optional		
		}
		
		
		imageView.setImage(selectedSpot.getSpotImage());
		UpdateStatusTableImage(selectedSpot);
		showSpotDetails(selectedSpot);
		if(!selectedSpot.getActive()) {
		try {
			selectedSpot.getDashboardApi().PostData();
			selectedSpot.getDashboardApi().PostConf1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
}




	

	@FXML
	public void handleStart() {
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		selectedSpot.setApiTileID(selectedSpot.getSpotNumber());
		
		
		switch(selectedSpot.getDeicing().getFluidTypeInt()) {
		   case 0 :
				selectedSpot.getDeicing().setStartTime(setTime());
				selectedSpot.setActive(true);
				selectedSpot.setActivityLable("De-Icing In Progress!");
				selectedSpot.setSpotImage(imageType1Blink);
				selectedSpot.getDeicing().setType1StartTime(setTime());
				imageView.setImage(selectedSpot.getSpotImage());
				try {
					selectedSpot.getDashboardApi().PostData();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					selectedSpot.getDashboardApi().PostConf();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break; // optional
		   case 1 :
				selectedSpot.getDeicing().setType4StartTime(setTime());
				selectedSpot.setActive(true);
				selectedSpot.setActivityLable("De-Icing In Progress!");
				selectedSpot.setSpotImage(imageType4Blink);
				imageView.setImage(selectedSpot.getSpotImage());
				try {
					selectedSpot.getDashboardApi().PostData();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					selectedSpot.getDashboardApi().PostConf();
				} catch (Exception e3) {
					e3.printStackTrace();
				}

				break; // optional
		}
       UpdateStatusTableImage(selectedSpot);
		showSpotDetails(selectedSpot);

	}

	@FXML
	public void handleStop() {
		Alert alert = new Alert(AlertType.WARNING);
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		
		if (!selectedSpot.getActive()) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Not Active");
			alert.setHeaderText("Timer Not Running!");
			alert.setContentText("Timer has not been started!");
			alert.showAndWait();
		}

		else {
			//selectedSpot.getDeicing().setEndTime(setTime());
			selectedSpot.setActive(false);
			selectedSpot.setActivityLable("");
			switch(selectedSpot.getDeicing().getFluidTypeInt()) {
			   case 0 :
				    selectedSpot.setSpotImage(imageType1);
					selectedSpot.getDeicing().setType1StopTime(setTime());
					try {
						selectedSpot.getDashboardApi().PostData();
						selectedSpot.getDashboardApi().PostConf1();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break; // optional
			   case 1 :
				   selectedSpot.setSpotImage(imageType4);
				   selectedSpot.getDeicing().setType4StopTime(setTime());
					try {
						selectedSpot.getDashboardApi().PostData();
						selectedSpot.getDashboardApi().PostConf1();
					} catch (Exception e) {
						e.printStackTrace();
					}

					break; // optional
			}
		}
		UpdateStatusTableImage(selectedSpot);
		showSpotDetails(selectedSpot);

	}

	@FXML
	private void handleResetWeb() {
		DashboardApi i = new DashboardApi(null, null, null);
		try {
			i.ResetDashboard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String setTime() {
		String time = "";
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		time = dateFormat.format(cal.getTime());
		return time;

	}
	
	
	private void UpdateStatusTableImage(Spot selectedSpot) {
		String spotNumber = selectedSpot.getSpotNumber();
		switch(spotNumber) {
		   case "SPOT 1 F" :
				padStatusImageViewSpot1Front.setImage(selectedSpot.getSpotImage());
				break; // optional
		   
		   case "SPOT 1 R" :
			   padStatusImageViewSpot1Rear.setImage(selectedSpot.getSpotImage());
			   break; // optional
		      
		   case "SPOT 2 F" :
			   padStatusImageViewSpot2Front.setImage(selectedSpot.getSpotImage());
			  break; // optional
			   
		   case "SPOT 2 R" :
			   padStatusImageViewSpot2Rear.setImage(selectedSpot.getSpotImage());
			   break; // optional
			      
		   case "SPOT 3 F" :
			   padStatusImageViewSpot3Front.setImage(selectedSpot.getSpotImage());
			   break; // optional
				   
		   case "SPOT 3 R" :
			   padStatusImageViewSpot3Rear.setImage(selectedSpot.getSpotImage());
			   break; // optional
				      
		   case "SPOT 4 F" :
			   padStatusImageViewSpot4Front.setImage(selectedSpot.getSpotImage());
			   break; // optional
					   
		   case "SPOT 4 R" :
			   padStatusImageViewSpot4Rear.setImage(selectedSpot.getSpotImage());
			   break; // optional
					      
		   case "SPOT 5 F" :
			   padStatusImageViewSpot5Front.setImage(selectedSpot.getSpotImage());
			   break; // optional
						   
		   case "SPOT 5 R" :
			   padStatusImageViewSpot5Rear.setImage(selectedSpot.getSpotImage());
			   break; // optional
		
		}

	}
		
		@FXML
		public void setSpotComment() {
			Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
			selectedSpot.setComment(commentArea.getText());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
