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
import application.model.SavedExcelData;
import application.model.Spot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import jxl.write.WriteException;

public class SpotOverviewController {

	// Spot Table With 3 Columns.
	//@FXML
	//private TextField searchSSD;
	
	@FXML
	private ComboBox<Flight> searchSSD = new ComboBox<>();
	
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
	@FXML
	private Label flightNumberLabel;
	@FXML
	private Label tailNumberLabel;
	@FXML
	private Label aircraftTypeLabel;
	@FXML
	private Label carrierLabel;
	@FXML
	private Label flightNumberLabel1;
	@FXML
	private Label tailNumberLabel1;
	@FXML
	private Label aircraftTypeLabel1;
	@FXML
	private Label carrierLabel1;
	@FXML
	private Label middleHiddenSpotNumber;
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
	@FXML
	private TableColumn<Spot, String> fluidColumn;
	@FXML
	private TableColumn<Spot, String> checkColumn;
	@FXML
	private TableColumn<Spot, String> startColumn;
	@FXML
	private TableColumn<Spot, String> endColumn;
	@FXML
	private TableColumn<Spot, String> employeeInit;
	// Selected Flight Table with 3 Columns
	//@FXML
	//private TableView<Flight> selectedFlightTable;
	@FXML
	private TableColumn<Flight, String> flightSelectedColumn;
	@FXML
	private TableColumn<Flight, String> aircraftSelectedColumn;
	@FXML
	private TableColumn<Flight, String> tailSelectedColumn;

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
		
        
		
		
		flightNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().flightNumberProperty());
		aircraftColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().aircraftTypeProperty());

		// Initialize the releaseSpotTable table with the one columns.
		carrierColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().carrierProperty());
		aircraftTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().aircraftTypeProperty());
		
		//behrad2
		//flightReleasedColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().flightNumberProperty());
		tailNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().tailNumberProperty());
		fluidColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().fluidTypeProperty());
		checkColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().aircraftCheckProperty());
		startColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().startTimeProperty());
		endColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().endTimeProperty());
		employeeInit.setCellValueFactory(cellData -> cellData.getValue().sprayer1Property());

		// Initialize the selectedflight table with the 3 columns.
		
		//behrad2
		//flightSelectedColumn.setCellValueFactory(cellData -> cellData.getValue().flightNumberProperty());
		//aircraftSelectedColumn.setCellValueFactory(cellData -> cellData.getValue().aircraftTypeProperty());
		//tailSelectedColumn.setCellValueFactory(cellData -> cellData.getValue().tailNumberProperty());


		// Listen for selection changes and show the spot details when changed.
		spotsTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showSpotDetails(newValue));
		
		fluidTypeComboBox.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> spotsTable.getSelectionModel().getSelectedItem().getDeicing().setFluidType(newValue)); 

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
		
		//TextFields.bindAutoCompletion(searchSSD, FlightInfo.getFlights());
		searchSSD.setEditable(true);
		searchSSD.getItems().addAll(FlightInfo.getFlights());
		

		

		

	}

	// change the spotmodeling data look at the getter and setters



	
	
	
	private void showSpotDetails(Spot selectedSpot) {

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
			flightNumberLabel.setText(selectedSpot.getFlight().getFlightNumber());
			tailNumberLabel.setText(selectedSpot.getFlight().getTailNumber());
			aircraftTypeLabel.setText(selectedSpot.getFlight().getAircraftType());
			carrierLabel.setText(selectedSpot.getFlight().getCarrier());
			imageView.setImage(selectedSpot.getSpotImage());
			if (selectedSpot.getDeicing().getFluidType().equalsIgnoreCase("")) 
			{
				selectedSpot.getDeicing().setFluidType("Fluid Type");
			}
			else
			{
			fluidTypeComboBox.setValue(selectedSpot.getDeicing().getFluidType());
			}
			UpdateStatusTableImage(selectedSpot);
			/*
			if (selectedSpot.getDeicing().getFluidType().equalsIgnoreCase("")) {
				selectedSpot.getDeicing().setFluidType("Fluid Type");
				selectedSpot.setSpotImage(imageBlack);
				imageView.setImage(imageBlack);
			} 
		//}
			else 
			{
				fluidTypeComboBox.setValue(selectedSpot.getDeicing().getFluidType());

				if (selectedSpot.getDeicing().getFluidType().equals("TYPE I")
						&& selectedSpot.getActive().equals(false)) {
					selectedSpot.setSpotImage(imageType1);
					imageView.setImage(selectedSpot.getSpotImage());
				} else if (selectedSpot.getDeicing().getFluidType().equals("TYPE I")
						&& selectedSpot.getActive().equals(true)) {
					selectedSpot.setSpotImage(imageType1Blink);
					imageView.setImage(selectedSpot.getSpotImage());
				} else if (selectedSpot.getDeicing().getFluidType().equals("TYPE IV")
						&& selectedSpot.getActive().equals(false)) {
					selectedSpot.setSpotImage(imageType4);
					imageView.setImage(selectedSpot.getSpotImage());
				} else if (selectedSpot.getDeicing().getFluidType().equals("TYPE IV")
						&& selectedSpot.getActive().equals(true)) {
					selectedSpot.setSpotImage(imageType4Blink);
					imageView.setImage(selectedSpot.getSpotImage());
				}

			}
*/

		
		//UpdateStatusTableImage(selectedSpot);
	}
	
	

/*
	@SuppressWarnings("null")
	private void showSpotDetails(Spot selectedSpot) {
		//if (selectedSpot == null) {
		//	selectedSpot.setSpotImage(imageBlack);
		//}

		if (selectedSpot.getSpotHasFlightData()) {
			// Fill the labels with info from the spot object
			middleHiddenSpotNumber.setText(selectedSpot.getSpotNumber().toString());
			spotLabel.setText(selectedSpot.getSpotNumber());
			truck1Label.setText(selectedSpot.getTruck1());
			freezepoint1Label.setText(selectedSpot.getFreezepoint1());
			dirver1Label.setText(selectedSpot.getDriver1());
			sprayer1Label.setText(selectedSpot.getSprayer1());
			truck2Label.setText(selectedSpot.getTruck2());
			freezepoint2Label.setText(selectedSpot.getFreezepoint2());
			dirver2Label.setText(selectedSpot.getDriver2());
			sprayer2Label.setText(selectedSpot.getSprayer2());
			flightNumberLabel.setText(selectedSpot.getFlight().getFlightNumber());
			tailNumberLabel.setText(selectedSpot.getFlight().getTailNumber());
			aircraftTypeLabel.setText(selectedSpot.getFlight().getAircraftType());
			carrierLabel.setText(selectedSpot.getFlight().getCarrier());
			flightNumberLabel1.setVisible(true);
			tailNumberLabel1.setVisible(true);
			aircraftTypeLabel1.setVisible(true);
			carrierLabel1.setVisible(true);
			middleHiddenSpotNumber.setVisible(true);
			flightNumberLabel1.setText("Flight#: ");
			tailNumberLabel1.setText("Tail#: ");
			aircraftTypeLabel1.setText("A/C: ");
			carrierLabel1.setText("Carrier: ");
			if (selectedSpot.getDeicing().getFluidType().equalsIgnoreCase("")) {
				selectedSpot.getDeicing().setFluidType("Fluid Type");
				selectedSpot.setSpotImage(imageBlack);
				imageView.setImage(imageBlack);
			} 
			else 
			{
				fluidTypeComboBox.setValue(selectedSpot.getDeicing().getFluidType());

				if (selectedSpot.getDeicing().getFluidType().equals("TYPE I")
						&& selectedSpot.getActive().equals(false)) {
					selectedSpot.setSpotImage(imageType1);
					imageView.setImage(selectedSpot.getSpotImage());
				} else if (selectedSpot.getDeicing().getFluidType().equals("TYPE I")
						&& selectedSpot.getActive().equals(true)) {
					selectedSpot.setSpotImage(imageType1Blink);
					imageView.setImage(selectedSpot.getSpotImage());
				} else if (selectedSpot.getDeicing().getFluidType().equals("TYPE IV")
						&& selectedSpot.getActive().equals(false)) {
					selectedSpot.setSpotImage(imageType4);
					imageView.setImage(selectedSpot.getSpotImage());
				} else if (selectedSpot.getDeicing().getFluidType().equals("TYPE IV")
						&& selectedSpot.getActive().equals(true)) {
					selectedSpot.setSpotImage(imageType4Blink);
					imageView.setImage(selectedSpot.getSpotImage());
				}

			}
			// imageView.setImage(selectedSpot.getSpotImage());

		} else {
			// spot is null, remove all the text.
			middleHiddenSpotNumber.setText("");
			truck1Label.setText("");
			freezepoint1Label.setText("");
			dirver1Label.setText("");
			sprayer1Label.setText("");
			truck2Label.setText("");
			freezepoint2Label.setText("");
			truck2Label.setText("");
			freezepoint2Label.setText("");
			dirver2Label.setText("");
			sprayer2Label.setText("");
			truck2Label.setText("");
			freezepoint2Label.setText("");
			flightNumberLabel.setText("");
			tailNumberLabel.setText("");
			aircraftTypeLabel.setText("");
			carrierLabel.setText("");
			imageView.setImage(imageBlack);
			fluidTypeComboBox.setValue("Fluid Type");
			flightNumberLabel1.setVisible(false);
			tailNumberLabel1.setVisible(false);
			aircraftTypeLabel1.setVisible(false);
			carrierLabel1.setVisible(false);
			middleHiddenSpotNumber.setVisible(false);
			selectedSpot.setSpotImage(imageBlack);
		}
		
		UpdateStatusTableImage(selectedSpot);
	}
*/
	private void clearSpot(Spot spot) {
		spot.getFlight().setAircraftType("");
		spot.getFlight().setCarrier("");
		spot.getFlight().setFlightNumber("");
		spot.getFlight().setTailNumber("");
		spot.getDeicing().setAircraftCheck("");
		spot.getDeicing().setEndTime("");
		spot.getDeicing().setStartTime("");
		spot.getDeicing().setFluidType("");
		flightNumberLabel.setText("");
		tailNumberLabel.setText("");
		aircraftTypeLabel.setText("");
		carrierLabel.setText("");
		spot.setSpotImage(imageBlack);
		imageView.setImage(imageBlack);
		spot.setActive(false);
		spot.setSpotHasFlightData(false);
		flightNumberLabel1.setVisible(false);
		tailNumberLabel1.setVisible(false);
		aircraftTypeLabel1.setVisible(false);
		carrierLabel1.setVisible(false);
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
			if (okClicked) {
				showSpotDetails(selectedSpot);
				selectedSpot.setSpotImage(imageBlack);
				selectedSpot.setSpotHasFlightData(true);
				flightNumberLabel1.setVisible(true);
				tailNumberLabel1.setVisible(true);
				aircraftTypeLabel1.setVisible(true);
				;
				carrierLabel1.setVisible(true);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Spot Selected");
			alert.setContentText("Please select a Flight in the table.");
			alert.showAndWait();
		}
	}
	
	

	
	

	@FXML
	private void handleSetting() {
		mainApp.showSettingDialog();

	}

	@FXML
	private void handleReleaseFlight() {
		Alert alert = new Alert(AlertType.WARNING);
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
			

		if (!selectedSpot.getSpotHasFlightData()) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("Selected Spot is empty");
			alert.setContentText("Please select a Flight in the table");
			alert.showAndWait();
		}

		else if (fluidTypeComboBox.getValue().equalsIgnoreCase("Clear")) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Fluid Type!");
			alert.setContentText("Please select the Fluid Type!");
			alert.showAndWait();
		}

		else if (selectedSpot.getActive()) {
			// Nothing selected.

			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Active Spot");
			alert.setHeaderText("Timmer Running");
			alert.setContentText("Please Stop the timer before releasing!");
			alert.showAndWait();
		} else if (!selectedSpot.getActive() && selectedSpot.getDeicing().getStartTime().equalsIgnoreCase("")) {
			// Nothing selected.

			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Active Spot");
			alert.setHeaderText("Timmer not started!");
			alert.setContentText("Please start the timer before releasing!");
			alert.showAndWait();
		} else {
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
			selectedSpot.setSpotHasFlightData(false);
			selectedSpot.setActive(false);
			clearSpot(selectedSpot);

			// spotsTable.getSelectionModel().clearSelection();
			// fluidTypeComboBox.setValue("Fluid Type");
		}
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
		return copiedSpot;

	}

	@FXML
	public void setSearchFlight() {

		//Flight selectedFlight = flightComboBox.getSelectionModel().getSelectedItem();
		//flightData.add(selectedFlight);

	}
	
	@FXML
	public void setSearchSsd() {
		
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.WARNING);
		
			//selectedSpot.setFlight(searchSSD.getSelectionModel().selectedItemProperty().get());
		//Flight ss = searchSSD.getValue();
		//selectedSpot.setFlight(searchSSD.getSelectionModel().getSelectedItem());
		//selectedSpot.getFlight().setFlightNumber(searchSSD.getSelectionModel().getSelectedItem().flightNumberProperty().getValue());
		//System.out.print((Flight)searchSSD.getSelectionModel().getSelectedItem());
			
			
	
		//selectedSpot.setFlight(searchSSD.getUserData().equals(Flight));
		

	}

	@FXML
	public void setFluidType() {
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();

		if (selectedSpot.getSpotHasFlightData())

		{
			selectedSpot.getDeicing().setFluidType(fluidTypeComboBox.getSelectionModel().getSelectedItem());
			if (selectedSpot.getDeicing().getFluidType().equalsIgnoreCase("TYPE I")) {
				selectedSpot.setSpotImage(imageType1);
				imageView.setImage(selectedSpot.getSpotImage());
			} else if (selectedSpot.getDeicing().getFluidType().equalsIgnoreCase("TYPE IV")) {
				selectedSpot.setSpotImage(imageType4);
				imageView.setImage(selectedSpot.getSpotImage());
			} else {
				selectedSpot.setSpotImage(imageBlack);
				imageView.setImage(selectedSpot.getSpotImage());
			}
		}
		UpdateStatusTableImage(selectedSpot);

	}

	@FXML
	public void handleSendTo() {
		/*
		Flight selectedFlight = selectedFlightTable.getSelectionModel().getSelectedItem();
		Spot selectedSpot = sendToComboBox.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.WARNING);

		if (selectedFlightTable.getItems().isEmpty()) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("Empty Table");
			alert.setContentText("Table is Empty, Add Flights.");
			alert.showAndWait();
		} else if (selectedFlightTable.getSelectionModel().isEmpty()) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Flight Selected");
			alert.setContentText("Please select a Flight in the table.");
			alert.showAndWait();
		} else {
			selectedSpot.setFlight(selectedFlight);
			selectedFlightTable.getSelectionModel().clearSelection();
			flightData.remove(selectedFlight);
			selectedSpot.setSpotImage(imageBlack);
			*/

		}

	

	@FXML
	public void handleStart() {
		Alert alert = new Alert(AlertType.WARNING);	
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		selectedSpot.setApiTileID(selectedSpot.getSpotNumber());
		
       if (!selectedSpot.getSpotHasFlightData()) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("Selected Spot is empty");
			alert.setContentText("Please select a Flight in the table");
			alert.showAndWait();
		} else if (fluidTypeComboBox.getValue().equals("Fluid Type")) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Fluid Type!");
			alert.setContentText("Please select the Fluid Type!");
			alert.showAndWait();
		}else if (selectedSpot.getActive()) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Active Spot");
			alert.setHeaderText("Timer is already running!!");
			alert.setContentText("Timer is already running!!");
			alert.showAndWait();
		} else if (selectedSpot.getDeicing().getFluidType().equals("TYPE I")) {
			selectedSpot.getDeicing().setStartTime(setTime());
			selectedSpot.setActive(true);
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
			selectedSpot.setSpotImage(imageType1Blink);
			imageView.setImage(selectedSpot.getSpotImage());
		} else if (selectedSpot.getDeicing().getFluidType().equals("TYPE IV")) {
			selectedSpot.getDeicing().setStartTime(setTime());
			selectedSpot.setActive(true);
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
			selectedSpot.setSpotImage(imageType4Blink);
			imageView.setImage(selectedSpot.getSpotImage());

		}
       UpdateStatusTableImage(selectedSpot);
	}

	@FXML
	public void handleStop() {
		Alert alert = new Alert(AlertType.WARNING);
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();

		if (!selectedSpot.getSpotHasFlightData()) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("Selected Spot is empty");
			alert.setContentText("Please select a Flight in the table");
			alert.showAndWait();
		}

		else if (fluidTypeComboBox.getValue().equals(null)) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Fluid Type!");
			alert.setContentText("Please select the Fluid Type!");
			alert.showAndWait();
		} else if (!selectedSpot.getActive()) {
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Not Active");
			alert.setHeaderText("Timer Not Running!");
			alert.setContentText("Timer has not been started!");
			alert.showAndWait();
		}

		else {
			selectedSpot.getDeicing().setEndTime(setTime());
			selectedSpot.setActive(false);
			if (selectedSpot.getDeicing().getFluidType().equalsIgnoreCase("TYPE I")) {
				selectedSpot.setSpotImage(imageType1);
				imageView.setImage(selectedSpot.getSpotImage());
			} else if (selectedSpot.getDeicing().getFluidType().equalsIgnoreCase("TYPE IV")) {
				selectedSpot.setSpotImage(imageType4);
				imageView.setImage(selectedSpot.getSpotImage());
			} else if (selectedSpot.getDeicing().getFluidType().equalsIgnoreCase("")
					|| selectedSpot.getDeicing().getFluidType().equalsIgnoreCase(null)) {
				selectedSpot.setSpotImage(imageBlack);
				imageView.setImage(selectedSpot.getSpotImage());

			}
			

		}
		UpdateStatusTableImage(selectedSpot);

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
