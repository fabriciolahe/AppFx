package application.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.entity.tblperdorues;
import application.entity.controller.tblperdoruesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class fxmlKrijoPerdoruesController implements Initializable {
	
	tblperdoruesController perdoruesController = new tblperdoruesController();
	
    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtMbiemri;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefon;

    @FXML
    private TextField txtAdresa;

    @FXML
    private TextField txtPerdoruesi;

    @FXML
    private CheckBox chkAdmin;

    @FXML
    private PasswordField txtFjalekalim;

    @FXML
    private Button btnRegjistro;

    @FXML
    private Button btnAnullo;

    @FXML
    void onAnullo(ActionEvent event) {
        Stage stage = (Stage) btnAnullo.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onRegjistro(ActionEvent event) {
    	
    	tblperdorues user = new tblperdorues();
    	user.setEmri(txtEmri.getText());
    	user.setMbiemri(txtMbiemri.getText());
    	user.setEmail(txtEmail.getText());
    	user.setTelefon(txtTelefon.getText());
    	user.setAdresa(txtAdresa.getText());
    	user.setPerdoruesi(txtPerdoruesi.getText());
    	user.setFjalekalimi(txtFjalekalim.getText());
    	user.setAdmin(chkAdmin.isSelected());
    	
    	if(perdoruesController.addPerdorues(user)) {
			new Alert(Alert.AlertType.CONFIRMATION, "Perdoruesi i ri u shtua me sukses !", ButtonType.CLOSE).show();
			clearFields();
    	}
    	
    }
	
	private void clearFields() {
		txtEmri.setText("");
		txtMbiemri.setText("");
		txtEmail.setText("");
		txtTelefon.setText("");
		txtAdresa.setText("");
		txtPerdoruesi.setText("");
		txtFjalekalim.setText("");
		chkAdmin.setSelected(false);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
