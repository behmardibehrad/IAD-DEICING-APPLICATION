package application;

import java.io.IOException;

import application.model.Spot;
import application.view.FlightEditDialogController;
import application.view.SettingEditController;
import application.view.SpotEditDialogController;
import application.view.SpotOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

	private ObservableList<Spot> spotData = FXCollections.observableArrayList();

	public MainApp() {
		// Add some sample data
		spotData.add(new Spot("SPOT 1"));
		spotData.add(new Spot("SPOT 2"));
		spotData.add(new Spot("SPOT 3"));
		spotData.add(new Spot("SPOT 4"));
		spotData.add(new Spot("SPOT 5"));
		spotData.add(new Spot("SPOT 6"));

	}

	/**
	 * Returns the data as an observable list of Spots.
	 * 
	 * @return
	 */
	public ObservableList<Spot> getSpotData() {
		return spotData;
	}

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ICEMAN");

		initRootLayout();
		showSpotOverview();
		

	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {


			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the Spot overview inside the root layout.
	 */
	public void showSpotOverview() {
		try {
			// Load Spot overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SpotOverview.fxml"));
			AnchorPane spotOverview = (AnchorPane) loader.load();

			// Set Spot overview into the center of root layout.
			rootLayout.setCenter(spotOverview);

			// Give the controller access to the main app.
			SpotOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean showSpotEditDialog(Spot spot) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SpotEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Spot");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the spot into the controller.
			SpotEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSpot(spot);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// private Spot spot;

	public boolean showFlightEditDialog(Spot selectedSpot) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/FlightEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Flight");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the spot into the controller.
			FlightEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setFlight(selectedSpot);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showSettingDialog() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SettingEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Settings");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the spot into the controller.
			SettingEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
