package application.view.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.entity.tblklient;
import application.entity.controller.tblklientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.input.KeyEvent;

public class fxmlKlientController implements Initializable {
	
	private ObservableList<tblklient> data;
	private tblklientController klientController = new tblklientController();
	private tblklient klient;
	private FilteredList<tblklient> filterData;
	
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
	private Button btnRuaj;

	@FXML
	private Button btnNdrysho;

	@FXML
	private Button btnFshij;
	
    @FXML
    private TextField txtKerko;

    @FXML
    private Button btnKerko;
    
    @FXML
    private Button btnPastro;

	@FXML
	private TableView<tblklient> tableview;

	@FXML
	private TableColumn<tblklient, Long> colId;

	@FXML
	private TableColumn<tblklient, String> colEmer;

	@FXML
	private TableColumn<tblklient, String> colMbiemer;

	@FXML
	private TableColumn<tblklient, String> colKompania;

	@FXML
	private TableColumn<tblklient, String> colNrCelulari;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initColumns();
		refreshTable();
		filterData = new FilteredList<>(data,e->true);
		
	}
	
	@FXML
	void onTableItemSelect() {
		klient = tableview.getSelectionModel().getSelectedItem();
		if(klient !=null) {
			txtId.setText(Long.toString(klient.getId()));
			txtEmri.setText(klient.getEmri());
			txtMbiemri.setText(klient.getMbiemri());
			txtKompania.setText(klient.getKompania());
			txtNrCelularit.setText(klient.getNrcelulari());
		}
	}
	
    @FXML
    void onFilterData(KeyEvent event) {
    	txtKerko.textProperty().addListener((o ,ov, nv)->{
    		filterData.setPredicate((tblklient kli)->{
    			
    			String newVal = nv.toLowerCase();
    			
    			return kli.getEmri().toLowerCase().contains(newVal)
    				 || kli.getMbiemri().toLowerCase().contains(newVal)
    				 || kli.getKompania().toLowerCase().contains(newVal)
    				 || kli.getNrcelulari().toLowerCase().contains(newVal);
    		});
    	});
    	SortedList sort = new SortedList(filterData);
    	sort.comparatorProperty().bind(tableview.comparatorProperty());
    	tableview.setItems(sort);
    }
	
    @FXML
    void onUpdate(ActionEvent event) {
    	
    	klient.setEmri(txtEmri.getText());
    	klient.setMbiemri(txtMbiemri.getText());
    	klient.setKompania(txtKompania.getText());
    	klient.setNrcelulari(txtNrCelularit.getText());
    	
		if(klientController.updateKlient(klient,klient.getId())) {
			new Alert(Alert.AlertType.CONFIRMATION, "Te dhenat e klientit u ndryshuan me sukses !", ButtonType.CLOSE).show();
			clearFields();
			data.set(tableview.getSelectionModel().getFocusedIndex(), klient);
//			refreshTable();
		}else {
			new Alert(Alert.AlertType.ERROR, "Ndryshimi i te dhenave te klientit deshtoji !", ButtonType.CLOSE).show();
		}
    	
    }

	@FXML
	void onSave(ActionEvent event) {
		
		tblklient klient = new tblklient();
		
		klient.setEmri(txtEmri.getText());
		klient.setMbiemri(txtMbiemri.getText());
		klient.setKompania(txtKompania.getText());
		klient.setNrcelulari(txtNrCelularit.getText());
		
		if(klientController.addKlient(klient)) {
			new Alert(Alert.AlertType.CONFIRMATION, "Klienti i ri u shtua me sukses !", ButtonType.CLOSE).show();
			clearFields();
			refreshTable();
		}else {
			new Alert(Alert.AlertType.ERROR, "Krijimi i klientit te ri deshtoji !", ButtonType.CLOSE).show();
		}
	}
	
    @FXML
    void onDelete(ActionEvent event) {
    	
    	Alert alert = new Alert(Alert.AlertType.ERROR, "A jeni i sigurt te fshini kete klient me emer "+klient.getEmri(), ButtonType.YES,ButtonType.NO);
    	
    	Optional<ButtonType> btnType = alert.showAndWait();
    	
    	if(btnType.get() == ButtonType.YES) {
    		if(klientController.deleteKlient(klient.getId())) {
    			new Alert(Alert.AlertType.CONFIRMATION, "Klienti me emer"+klient.getEmri()+" u fshi me sukses !", ButtonType.CLOSE).show();
    			clearFields();
    			data.set(tableview.getSelectionModel().getFocusedIndex(), klient);
    		}else {
    			new Alert(Alert.AlertType.ERROR, "Fshirja e te dhenave te klientit deshtoji !", ButtonType.CLOSE).show();
    		}
    	}else if(btnType.get() == ButtonType.NO) {
    		new Alert(Alert.AlertType.WARNING, "Fshirja e klientit me emer "+klient.getEmri()+" u anullua !", ButtonType.CLOSE).show();
    		
    	}
    }
    
    @FXML
    void onClear(ActionEvent event) {
    	clearFields();
    }

	private void initColumns() {
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colEmer.setCellValueFactory(new PropertyValueFactory<>("emri"));
		colMbiemer.setCellValueFactory(new PropertyValueFactory<>("mbiemri"));
		colKompania.setCellValueFactory(new PropertyValueFactory<>("kompania"));
		colNrCelulari.setCellValueFactory(new PropertyValueFactory<>("nrcelulari"));
	}
	
	public void clearFields() {
		txtId.setText("");
		txtEmri.setText("");
		txtMbiemri.setText("");
		txtKompania.setText("");
		txtNrCelularit.setText("");
	}
	
	public void refreshTable() {
		tableview.setItems(getKlients());
	}

	public ObservableList<tblklient> getKlients() {
		data = FXCollections.observableArrayList(klientController.getKlients());
		if (data == null) {
			return data = FXCollections.observableArrayList();
		} else {
			return data;
		}
	}
}
