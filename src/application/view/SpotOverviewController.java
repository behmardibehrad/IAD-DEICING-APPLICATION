package application.view;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import application.MainApp;
import application.model.AllGraphData;
import application.model.DashboardApi;
import application.model.Flight;
import application.model.FlightInfo;
import application.model.FxUtilTest;
import application.model.SavedExcelData;
import application.model.Spot;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import jxl.write.WriteException;

public class SpotOverviewController {

	@FXML
	private TableView<Spot> storedFlightTable;
	@FXML
	private TableView<Spot> spotsTable;
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
	@FXML
	private TableColumn<Spot, String> storedFlightTableColumn;
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

	@FXML
	private ComboBox<String> fluidTypeComboBox;
	@FXML
	private ComboBox<Flight> flightComboBox1;
	@FXML
	private ComboBox<Flight> flightComboBox;
	@FXML
	private ComboBox<Spot> sendToComboBox = new ComboBox<Spot>();
	@FXML
	private ComboBox<Flight>  searchSSD = new ComboBox<Flight>();
	@FXML
	private Button start;
	@FXML
	private Button stop;
	@FXML
	private Button setting;
	@FXML
	private Button release;
	@FXML
	private Button resetWeb;

	@FXML
	private TextArea commentArea;
	// Reference to the main application.
	private MainApp mainApp;
	private ObservableList<Spot> releaseTableData = FXCollections.observableArrayList();
	private Image imageType1 = new Image("application/image/orangeall.png");
	private Image imageType4 = new Image("application/image/greenfull.png");;
	private Image imageType1Blink = new Image("application/image/Type1.gif");;
	private Image imageType4Blink = new Image("application/image/Type4.gif");;
	private Image imageBlack = new Image("application/image/blackback.png");

    @FXML
    private BarChart<String, Integer> planePerSpot;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    
	//private AllGraphData graphData = new AllGraphData();
	
	
	
	public SpotOverviewController() {
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		spotsTable.setItems(mainApp.getSpotData());
		sendToComboBox.getItems().addAll(spotsTable.getItems());
	}

	@FXML
	public void initialize() {
		planePerSpot.setTitle("A/C Fluid requests per SPOT ");
		xAxis.setLabel("SPOTS");
		yAxis.setLabel("A/C De-iced");
		//xAxis.setCategories(graphData.getxAsixSpotS());
		
		//planePerSpot.getData().add(graphData.getGrapg1series());

		
		
		// Initialize the spot table with the one columns.
		spotsNumberColumn.setCellValueFactory(cellData -> cellData.getValue().spotNumberProperty());

		padStatusImageViewSpot1Front.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(0);});
 		padStatusImageViewSpot1Rear.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(1);});
 		padStatusImageViewSpot2Front.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(2);});
 		padStatusImageViewSpot2Rear.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(3);});
 		padStatusImageViewSpot3Front.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(4);});
 		padStatusImageViewSpot3Rear.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(5);});
 		padStatusImageViewSpot4Front.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(6);});
 	    padStatusImageViewSpot4Rear.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(7);});
 		padStatusImageViewSpot5Front.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(8);});
 		padStatusImageViewSpot5Rear.setOnMouseClicked((MouseEvent e) -> {spotsTable.getSelectionModel().select(9);});

		flightNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().flightNumberProperty());
		aircraftColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().aircraftTypeProperty());
		carrierColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().carrierProperty());
		aircraftTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().aircraftTypeProperty());
		tailNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().tailNumberProperty());
		checkColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().aircraftCheckProperty());
		employeeInit.setCellValueFactory(cellData -> cellData.getValue().sprayer1Property());
		type4startColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().type4StarttTime());
		type4stopColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().type4StoptTime());
		type1startColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().type1StarttTime());
		type1stopColumn.setCellValueFactory(cellData -> cellData.getValue().getDeicing().type1StoptTime());
		flightReleasedColumn.setCellValueFactory(cellData -> cellData.getValue().getFlight().flightNumberProperty());
		comment.setCellValueFactory(cellData -> cellData.getValue().commentProperty());

		// Listen for selection changes and show the spot details when changed.
		
		spotsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSpotDetails(newValue));
		spotsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> newValue.setPlaneCalledIn(setTime()));
		spotsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> newValue.setApiTileID(newValue.getSpotNumber()));
		
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

		fluidTypeComboBox.getItems().addAll("TYPE I", "TYPE IV");
		searchSSD.getItems().addAll(FlightInfo.getFlights());
		
        FxUtilTest.autoCompleteComboBoxPlus(searchSSD, 
        		(typedText, itemToCompare) -> 
        itemToCompare.getFlightNumber().toLowerCase().contains(typedText.toLowerCase()) || itemToCompare.getTailNumber().toLowerCase().contains(typedText.toLowerCase()) );

	}

	
	
	
	
	private void showSpotDetails(Spot selectedSpot) {
		
		//if(!selectedSpot.getIsSetup()) {handleEditSpot();}
		
		if(!selectedSpot.getPostPlaneCalledInDataPosted()) {
			try {
				selectedSpot.getDashboardApi().PostPlaneCalledInData();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		


		
		
		
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
				if(!selectedSpot.getPostPlaneFluidSet()) {
					Thread th1 = new Thread(() -> {
						try {
							selectedSpot.getDashboardApi().PostFluidTypeSet();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						});
						th1.setDaemon(true);
						th1.start();
					}
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
		spot.setActive(false);
		spot.setSpotHasFlightData(false);
		spot.setPostPlaneCalledInDataPosted(false);
		spot.setcomment("");
		spot.setSpotImage(imageBlack);
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
		commentArea.setText("");
		imageView.setImage(spot.getSpotImage());
		UpdateStatusTableImage(spot);
		
	}


	@FXML
	private void handleEditSpot() {
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		if (selectedSpot != null) {
			boolean okClicked = mainApp.showSpotEditDialog(selectedSpot);
			if (okClicked) {
				showSpotDetails(selectedSpot);
				selectedSpot.setSpotHasFlightData(true);
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
				
				
	
				try {
					selectedSpot.getDashboardApi().PostPlaneCalledInData();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

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
		showSpotDetails(selectedSpot);
	}
	
	

	
	

	@FXML
	private void handleSetting() {
		mainApp.showSettingDialog();
	}

	@FXML
	private void handleReleaseFlight() {
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		
	
		


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
			Thread th = new Thread(() -> {
			try {
				selectedSpot.getDashboardApi().clearSpotData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			});
			th.setDaemon(true);
			th.start();
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
		System.out.println(spot.getComment());
		copiedSpot.setcomment(spot.getComment());

		return copiedSpot;

	}

	
	@FXML
	public void setSearchSsd() {
		

			Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
			selectedSpot.setFlight(FxUtilTest.getComboBoxValue(searchSSD));
			showSpotDetails(selectedSpot);
			searchSSD.getSelectionModel().clearSelection();
			searchSSD.getItems().addAll(FlightInfo.getFlights());	

		
	}

//		selectedSpot.setFlight(FxUtilTest.getComboBoxValue(searchSSD));
		
		//if (FxUtilTest.getComboBoxValue(searchSSD) instanceof Flight) {
//System.out.print("flight");
//}
		//f=FxUtilTest.getComboBoxValue(searchSSD);
		//System.out.println(FxUtilTest.getComboBoxValue(searchSSD).getFlightNumber());




		//searchSSD.getSelectionModel().clearSelection();
		//selectedSpot.getFlight().setFlightNumber(searchSSD.getSelectionModel().getSelectedItem().getFlightNumber());
		

		

	

	@FXML
	public void setFluidType() {
		
		
		//0=type 1
		//1=type4
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		selectedSpot.getDeicing().setFluidType(fluidTypeComboBox.getSelectionModel().getSelectedItem());
		selectedSpot.getDeicing().setFluidTypeInt(fluidTypeComboBox.getSelectionModel().getSelectedIndex());
		
		switch(selectedSpot.getDeicing().getFluidTypeInt()) {
		   case 0 :
			   selectedSpot.setSpotImage(imageType1);
				break;
		   case 1 :
			   selectedSpot.setSpotImage(imageType4);
				break;	
		}


		imageView.setImage(selectedSpot.getSpotImage());
		UpdateStatusTableImage(selectedSpot);
		showSpotDetails(selectedSpot);
}




	

	@FXML
	public void handleStart() {
		Alert alert = new Alert(AlertType.WARNING);	
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
				selectedSpot.setTypeISprayed(true);
				
				//Thread th = new Thread(() -> {
				try {
					selectedSpot.getDashboardApi().PostActiveData();;
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					selectedSpot.getDashboardApi().PostActivateConf();;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				//});
				//th.setDaemon(true);
				//th.start();
				System.out.println("thread");
				break; // optional
		   case 1 :
				selectedSpot.getDeicing().setType4StartTime(setTime());
				selectedSpot.setActive(true);
				selectedSpot.setActivityLable("De-Icing In Progress!");
				selectedSpot.setSpotImage(imageType4Blink);
				imageView.setImage(selectedSpot.getSpotImage());
				selectedSpot.setTypeIVSprayed(true);
				//Thread th1 = new Thread(() -> {
				try {
					selectedSpot.getDashboardApi().PostActiveData();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					selectedSpot.getDashboardApi().PostActivateConf();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
				//});
				//th1.setDaemon(true);
				//th1.start();

				break; // optional
		}
       UpdateStatusTableImage(selectedSpot);
		showSpotDetails(selectedSpot);

	}
	
	@FXML
	public void handleCommentArea()
	{
		Spot selectedSpot = spotsTable.getSelectionModel().getSelectedItem();
		selectedSpot.setcomment(commentArea.getText());
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
					Thread th1 = new Thread(() -> {
					try {
						selectedSpot.getDashboardApi().PostFluidTypeSet();
					} catch (Exception e) {
						e.printStackTrace();
					}
					});
					th1.setDaemon(true);
					th1.start();
					break; // optional
			   case 1 :
				   selectedSpot.setSpotImage(imageType4);
				   selectedSpot.getDeicing().setType4StopTime(setTime());
				   Thread th2 = new Thread(() -> {
					try {
						selectedSpot.getDashboardApi().PostFluidTypeSet();
					} catch (Exception e) {
						e.printStackTrace();
					}
					});
					th2.setDaemon(true);
					th2.start();

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
