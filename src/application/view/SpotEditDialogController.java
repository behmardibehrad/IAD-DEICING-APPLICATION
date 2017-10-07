package application.view;

import org.controlsfx.control.textfield.TextFields;

import application.model.DeicersInfo;
import application.model.Spot;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SpotEditDialogController {

	@FXML
	private TextField truck1Field;
	@FXML
	private TextField freezepoint1Field;
	@FXML
	private TextField dirver1Field;
	@FXML
	private TextField sprayer1Field;
	@FXML
	private TextField truck2Field;
	@FXML
	private TextField freezepoint2Field;
	@FXML
	private TextField dirver2Field;
	@FXML
	private TextField sprayer2Field;

	private Stage dialogStage;
	private Spot spot;
	private boolean okClicked = false;
	

	@FXML
	private void initialize() {
	}


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}


	public void setSpot(Spot spot) {
		this.spot = spot;
		/*
		 * these were the original code from tutorial;
		 * truck1Field.setText(spot.getTruck1());
		 * dirver1Field.setText(spot.getDriver1());
		 * sprayer1Field.setText(spot.getSprayer1());
		 * truck2Field.setText(spot.getTruck2());
		 * dirver2Field.setText(spot.getDriver2());
		 * sprayer2Field.setText(spot.getSprayer2());
		 */

		TextFields.bindAutoCompletion(truck1Field, DeicersInfo.getTrucks());
		//TextFields.bindAutoCompletion(dirver1Field, DeicersInfo.getDeicers());
		TextFields.bindAutoCompletion(dirver1Field, DeicersInfo.getDeicers());
		TextFields.bindAutoCompletion(sprayer1Field, DeicersInfo.getDeicers());
		TextFields.bindAutoCompletion(truck2Field, DeicersInfo.getTrucks());
		TextFields.bindAutoCompletion(dirver2Field, DeicersInfo.getDeicers());
		TextFields.bindAutoCompletion(sprayer2Field, DeicersInfo.getDeicers());

		freezepoint1Field.setText(spot.getFreezepoint1());
		freezepoint2Field.setText(spot.getFreezepoint2());

	}


	public boolean isOkClicked() {
		return okClicked;
	}


	@FXML
	private void handleOk() {
		if (isInputValid()) {
			spot.setTruck1(truck1Field.getText());
			spot.setFreezepoint1(freezepoint1Field.getText());
			spot.setDriver1(dirver1Field.getText());
			spot.setSprayer1(sprayer1Field.getText());
			spot.setTruck2(truck2Field.getText());
			spot.setFreezepoint2(freezepoint2Field.getText());
			spot.setSprayer2(dirver2Field.getText());
			spot.setDriver2(sprayer2Field.getText());
			spot.setIsSetup(true);

			okClicked = true;
			dialogStage.close();

		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (truck1Field.getText() == null || truck1Field.getText().length() == 0) {
			errorMessage += "No valid Truck Number!\n";
		}
		if (freezepoint1Field.getText() == null || freezepoint1Field.getText().length() == 0) {
			errorMessage += "No valid Freezepoint!\n";
		}
		if (dirver1Field.getText() == null || dirver1Field.getText().length() == 0) {
			errorMessage += "No valid Employee!\n";
		}

		if (sprayer1Field.getText() == null || sprayer1Field.getText().length() == 0) {
			errorMessage += "No valid Employee!\n";
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