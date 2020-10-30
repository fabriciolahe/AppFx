package application.view.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import application.entity.tblautomjet;
import application.entity.tblklient;
import application.entity.controller.tblautomjetController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class fxmlKrijoAutomjetController implements Initializable {
	
	private ObservableList<tblklient> data;
	private tblautomjetController automjetController = new tblautomjetController();
	private tblautomjet automjet;
	private tblklient klient;
	
    @FXML
    private TableView<tblklient> tableKlient;

    @FXML
    private TableColumn<tblklient, String> colEmri;

    @FXML
    private TableColumn<tblklient, String> colMbiemri;

    @FXML
    private TableColumn<tblklient, String> colKompania;

    @FXML
    private TableColumn<tblklient, String> colCelular;

    @FXML
    private TextField txtKerkoKlient;

    @FXML
    private Button btnKerko;

    @FXML
    private TextField txtKlient;

    @FXML
    private TextField txtTarga;

    @FXML
    private TextField txtMarka;

    @FXML
    private TextField txtModeli;

    @FXML
    private TextField txtCilindrata;

    @FXML
    private TextField txtFuqia;

    @FXML
    private TextField txtKarburanti;

    @FXML
    private TextField txtProdhimi;

    @FXML
    private TextField txtShasia;

    @FXML
    private TextField txtKambio;
    
    @FXML
    private Button btnShto;

    @FXML
    private Button btnMbyll;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initKlientColumns();
	}
	
    private void initKlientColumns() {
    	
		colEmri.setCellValueFactory(new PropertyValueFactory<>("emri"));
		colMbiemri.setCellValueFactory(new PropertyValueFactory<>("mbiemri"));
		colKompania.setCellValueFactory(new PropertyValueFactory<>("kompania"));
		colCelular.setCellValueFactory(new PropertyValueFactory<>("nrcelulari"));
		
	}

	@FXML
    void onTableItemSelect(MouseEvent event) {
		klient = tableKlient.getSelectionModel().getSelectedItem();
		if(klient !=null) {
			txtKlient.setText(klient.getEmri());
		}
    }
    
    private ObservableList<tblklient> getKlient() {
		data = FXCollections.observableArrayList(automjetController.kerkoKlient(txtKerkoKlient.getText()));
//		data = FXCollections.observableArrayList(automjetController.getKlient());
		if (data == null) {
			return data = FXCollections.observableArrayList();
		} else {
			return data;
		}
	}

	@FXML
    void kerko(ActionEvent event) {
		tableKlient.setItems(getKlient());
    }
	
    @FXML
    void onSaveAutomjet(ActionEvent event) {
    	automjet = new tblautomjet();
    	
    	Set<tblklient> list = new HashSet<>();
    	klient.getId();
    	list.add(klient);
    	
    	automjet.setTarga(txtTarga.getText());
    	automjet.setNrshasi(txtShasia.getText());
    	automjet.setMarka(txtMarka.getText());
    	automjet.setModel(txtModeli.getText());
    	automjet.setCilindrata(txtCilindrata.getText());
    	automjet.setFuqia(txtFuqia.getText());
    	automjet.setKarburant(txtKarburanti.getText());
		automjet.setKambio(txtKambio.getText());
    	automjet.setViti(txtProdhimi.getText());
    	automjet.setKlient(list);
		
		if(automjetController.addAutomjet(automjet)) {
			new Alert(Alert.AlertType.CONFIRMATION, "Automjeti i ri u shtua me sukses !", ButtonType.CLOSE).show();
			clear();
		}else {
			new Alert(Alert.AlertType.ERROR, "Krijimi i automjetit te ri deshtoji !", ButtonType.CLOSE).show();
		}
    }
    
	private void clear() {
		txtKlient.setText("");
		txtTarga.setText("");
		txtShasia.setText("");
		txtMarka.setText("");
		txtModeli.setText("");
		txtCilindrata.setText("");
		txtFuqia.setText("");
		txtKarburanti.setText("");
		txtKambio.setText("");
		txtProdhimi.setText("");
	}

	@FXML
    void onAnullo(ActionEvent event) {
        Stage stage = (Stage) btnMbyll.getScene().getWindow();
        stage.close();
    }

}
