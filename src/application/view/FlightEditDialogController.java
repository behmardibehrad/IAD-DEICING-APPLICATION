package application.view;

import org.controlsfx.control.textfield.TextFields;

import application.model.DeicersInfo;
import application.model.Spot;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FlightEditDialogController {

	@FXML
	private TextField flightNumberField;
	@FXML
	private TextField tailNumberField;
	@FXML
	private TextField aircraftTypeField;
	@FXML
	private TextField carrierField;

	private Stage dialogStage;
	private Spot spot;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
	}


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setFlight(Spot spot) {
		this.spot = spot;

		flightNumberField.setText(spot.getFlight().getFlightNumber());
		tailNumberField.setText(spot.getFlight().getTailNumber());
		carrierField.setText(spot.getFlight().getCarrier());
		aircraftTypeField.setText(spot.getFlight().getAircraftType());

	}

	public void clearFlight() {

		flightNumberField.setText("");
		tailNumberField.setText("");
		carrierField.setText("");
		aircraftTypeField.setText("");

	}


	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			spot.getFlight().setFlightNumber(flightNumberField.getText());
			spot.getFlight().setTailNumber(tailNumberField.getText());
			spot.getFlight().setCarrier(carrierField.getText());
			spot.getFlight().setAircraftType(aircraftTypeField.getText());

			okClicked = true;
			dialogStage.close();

		}
	}


	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (flightNumberField.getText() == null || flightNumberField.getText().length() == 0) {
			errorMessage += "No valid flight Number!\n";
		}
		if (tailNumberField.getText() == null || tailNumberField.getText().length() == 0) {
			errorMessage += "No valid tailNumber!\n";
		}
		if (aircraftTypeField.getText() == null || aircraftTypeField.getText().length() == 0) {
			errorMessage += "No valid aircraftType\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}

	}
}