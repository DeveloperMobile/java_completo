package gui;


import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {
	
	@FXML
	private TextField txtNumberOne;
	
	@FXML
	private TextField txtNumberTwo;
	
	@FXML
	private Label lbResult;
	
	
	@FXML
	private Button btnSum;
	
	@FXML
	public void onBtnSumAction() {
		try {
			Locale.setDefault(Locale.US);  
			double number1 = Double.parseDouble(txtNumberOne.getText());
			double number2 = Double.parseDouble(txtNumberTwo.getText());
			double sum = number1 + number2;
			lbResult.setText(String.format("%.2f", sum));  
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}
}
