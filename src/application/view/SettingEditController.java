package application.view;

import application.model.Spot;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class SettingEditController {

	private Stage dialogStage;
	private Spot spot;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

}
