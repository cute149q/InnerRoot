package main;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import main.Main;

public class Skip {

	@FXML
	private AnchorPane mainPage;
	
	public void skipToMST() {
		mainPage.getScene().getWindow().hide();
		Main.showMST();
	}
	
	public void skipToSearch() {
		mainPage.getScene().getWindow().hide();
		Main.showSearch();
	}
	
	public void skipToSP() {
		mainPage.getScene().getWindow().hide();
		Main.showSP();
	}
	
	public void skipToTP() {
		mainPage.getScene().getWindow().hide();
		Main.showTP();
	}
}
