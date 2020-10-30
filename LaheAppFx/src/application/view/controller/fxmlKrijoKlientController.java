package application.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.entity.tblklient;
import application.entity.controller.tblklientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class fxmlKrijoKlientController implements Initializable {
	
	private tblklientController klientController = new tblklientController();
	
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtMbiemri;

    @FXML
    private TextField txtKompania;

    @FXML
    private TextField txtNrCelularit;

    @FXML
    private Button btnShto;

    @FXML
    private Button btnMbyll;

    @FXML
    void onAnullo(ActionEvent event) {
        Stage stage = (Stage) btnMbyll.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onSaveKlient(ActionEvent event) {
		
		tblklient klient = new tblklient();
		
		klient.setEmri(txtEmri.getText());
		klient.setMbiemri(txtMbiemri.getText());
		klient.setKompania(txtKompania.getText());
		klient.setNrcelulari(txtNrCelularit.getText());
		
		if(klientController.addKlient(klient)) {
			new Alert(Alert.AlertType.CONFIRMATION, "Klienti i ri u shtua me sukses !", ButtonType.CLOSE).show();
			clearFields();
		}else {
			new Alert(Alert.AlertType.ERROR, "Krijimi i klientit te ri deshtoji !", ButtonType.CLOSE).show();
		}
    }
	
	private void clearFields() {
		txtId.setText("");
		txtEmri.setText("");
		txtMbiemri.setText("");
		txtKompania.setText("");
		txtNrCelularit.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
