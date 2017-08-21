package application.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.MainApp;
import application.model.FileChooserTest;
import application.model.Spot;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class SettingEditController {

	private Stage dialogStage;
	private Stage dialogStage1;
	private Spot spot;
	private boolean okClicked = false;
	private FileChooserTest e1 = new FileChooserTest();
	 private Desktop desktop = Desktop.getDesktop();
	
	private JTextField filename = new JTextField(), dir = new JTextField();
    private JButton open = new JButton("Open"), save = new JButton("Save");
    


	@FXML
	private void initialize() {
	}
	

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	


	public boolean isOkClicked() {
		return okClicked;
	}


	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	


	



}

	


