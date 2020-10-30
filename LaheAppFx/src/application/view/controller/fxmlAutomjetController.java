package application.view.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

import application.entity.tblautomjet;
import application.entity.tblklient;
import application.entity.controller.tblautomjetController;
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

public class fxmlAutomjetController implements Initializable {
	
	private ObservableList<tblklient> data;
	private ObservableList<tblautomjet> auto;
	private tblklientController klientController = new tblklientController();
	private tblautomjetController automjetController = new tblautomjetController();
	private tblautomjet automjet;
	private tblklient klient;
	private FilteredList<tblklient> filterKlient;
	private FilteredList<tblautomjet> filterAuto;
	
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
    private TextField txtKambio;

    @FXML
    private TextField txtProdhimi;

    @FXML
    private TextField txtShasia;

    @FXML
    private Button btnRuaj;

    @FXML
    private Button btnNdrysho;

    @FXML
    private Button btnFshij;

    @FXML
    private Button btnPastro;
    
    @FXML
    private Button btnKerko;
     
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
    private TextField txtKerkoAutomjet;

    @FXML
    private TableView<tblautomjet> tableAutomjet;
    
    @FXML
    private TableColumn<tblautomjet, String> colKlient;
    
    @FXML
    private TableColumn<tblautomjet, String> colTarga;

    @FXML
    private TableColumn<tblautomjet, String> colShasia;

    @FXML
    private TableColumn<tblautomjet, String> colMarka;

    @FXML
    private TableColumn<tblautomjet, String> colModeli;

    @FXML
    private TableColumn<tblautomjet, String> colCilindrata;

    @FXML
    private TableColumn<tblautomjet, String> colFuqia;

    @FXML
    private TableColumn<tblautomjet, String> colKarburanti;
    
    @FXML
    private TableColumn<tblautomjet, String> colKambio;

    @FXML
    private TableColumn<tblautomjet, String> colProdhimit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//    	tableKlient.setItems(getKlient());    	    	
		initKlientColumns();
		initAutomjetColumns();
		refreshTable();
//    	filterKlient = new FilteredList<>(data,e->true);
		filterAuto = new FilteredList<>(auto,e->true);
	}
    
	private void initKlientColumns() {
		
		colEmri.setCellValueFactory(new PropertyValueFactory<>("emri"));
		colMbiemri.setCellValueFactory(new PropertyValueFactory<>("mbiemri"));
		colKompania.setCellValueFactory(new PropertyValueFactory<>("kompania"));
		colCelular.setCellValueFactory(new PropertyValueFactory<>("nrcelulari"));
		
	}
	
	private void initAutomjetColumns() {
				
		colTarga.setCellValueFactory(new PropertyValueFactory<>("targa"));
		colShasia.setCellValueFactory(new PropertyValueFactory<>("nrshasi"));
		colMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
		colModeli.setCellValueFactory(new PropertyValueFactory<>("model"));
		colCilindrata.setCellValueFactory(new PropertyValueFactory<>("cilindrata"));
		colFuqia.setCellValueFactory(new PropertyValueFactory<>("fuqia"));
		colKarburanti.setCellValueFactory(new PropertyValueFactory<>("karburant"));
		colKambio.setCellValueFactory(new PropertyValueFactory<>("kambio"));
		colProdhimit.setCellValueFactory(new PropertyValueFactory<>("viti"));
		
	}
	
    @FXML
    void kerko(ActionEvent event) {
    	tableKlient.setItems(getKlient());
    }
	
    @FXML
    void onFilterData(KeyEvent event) {
    	txtKerkoKlient.textProperty().addListener((o ,ov, nv)->{
    		filterKlient.setPredicate((tblklient kli)->{
    			
    			String newVal = nv.toLowerCase();
    			
    			return kli.getEmri().toLowerCase().contains(newVal)
    				 || kli.getMbiemri().toLowerCase().contains(newVal)
    				 || kli.getKompania().toLowerCase().contains(newVal)
    				 || kli.getNrcelulari().toLowerCase().contains(newVal);
    		});
    	});
    	SortedList sort = new SortedList(filterKlient);
    	sort.comparatorProperty().bind(tableKlient.comparatorProperty());
    	tableKlient.setItems(sort);
    }
    
    @FXML
    void onFilterAuto(KeyEvent event) {
    	txtKerkoAutomjet.textProperty().addListener((o ,ov, nv)->{
    		filterAuto.setPredicate((tblautomjet auto)->{
    			
    			String newVal = nv.toLowerCase();
    			
    			return auto.getTarga().toLowerCase().contains(newVal)
    				 || auto.getNrshasi().toLowerCase().contains(newVal)
    				 || auto.getMarka().toLowerCase().contains(newVal)
    				 || auto.getModel().toLowerCase().contains(newVal)
    				 || auto.getViti().toLowerCase().contains(newVal);
    		});
    	});
    	SortedList sort = new SortedList(filterAuto);
    	sort.comparatorProperty().bind(tableAutomjet.comparatorProperty());
    	tableAutomjet.setItems(sort);
    }
    
	@FXML
	void onTableAutoItemSelect() {
		automjet = tableAutomjet.getSelectionModel().getSelectedItem();
		if(automjet !=null) {
			
			Set<tblklient> klients = automjet.getKlient();
			String klienti = null;
			for(tblklient k : klients){
				klienti = k.getEmri();
			}
			txtKlient.setText(klienti);
			txtTarga.setText(automjet.getTarga());
			txtMarka.setText(automjet.getMarka());
			txtModeli.setText(automjet.getModel());
			txtCilindrata.setText(automjet.getCilindrata());
			txtFuqia.setText(automjet.getFuqia());
			txtKarburanti.setText(automjet.getKarburant());
			txtKambio.setText(automjet.getKambio());
			txtProdhimi.setText(automjet.getViti());
			txtShasia.setText(automjet.getNrshasi());
		}
	}
    
	@FXML
    void onDeleteAutomjet(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.ERROR, "A jeni i sigurt te fshini kete automjet me targe ", ButtonType.YES,ButtonType.NO);
    	
    	Optional<ButtonType> btnType = alert.showAndWait();
    	
    	if(btnType.get() == ButtonType.YES) {
    		if(automjetController.deleteAutomjet(automjet.getId())) {
    			new Alert(Alert.AlertType.CONFIRMATION, "Automjeti me targe"+ automjet.getTarga() +" u fshi me sukses !", ButtonType.CLOSE).show();
    			clear();
    			auto.set(tableAutomjet.getSelectionModel().getFocusedIndex(), automjet);
    		}else {
    			new Alert(Alert.AlertType.ERROR, "Fshirja e te dhenave te automjetit deshtoji !", ButtonType.CLOSE).show();
    		}
    	}else if(btnType.get() == ButtonType.NO) {
    		new Alert(Alert.AlertType.WARNING, "Fshirja e automjetit me targe "+ automjet.getTarga() +" u anullua !", ButtonType.CLOSE).show();
    		
    	}
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
			refreshTable();
		}else {
			new Alert(Alert.AlertType.ERROR, "Krijimi i automjetit te ri deshtoji !", ButtonType.CLOSE).show();
		}
    }
    
    private void refreshTable() {
    	tableAutomjet.setItems(getAutomjete());
	}
    
    @FXML
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
    void onUpdateAutomjet(ActionEvent event) {
    	
    	Set<tblklient> klient = automjet.getKlient();
    	Set<tblklient> list = new HashSet<>();
    	for(tblklient kli : klient) {
    		list.add(kli);
    	}
		automjet.setKlient(list);
		automjet.setNrshasi(txtShasia.getText());
		automjet.setMarka(txtMarka.getText());
		automjet.setModel(txtModeli.getText());
		automjet.setKarburant(txtKarburanti.getText());
		automjet.setKambio(txtKambio.getText());
		automjet.setCilindrata(txtCilindrata.getText());
		automjet.setFuqia(txtFuqia.getText());
		automjet.setViti(txtProdhimi.getText());    	
    	
		if(automjetController.updateAutomjet(automjet, automjet.getId())){
			new Alert(Alert.AlertType.CONFIRMATION, "Te dhenat e automjetit u ndryshuan me sukses !", ButtonType.CLOSE).show();
			clear();
			auto.set(tableAutomjet.getSelectionModel().getFocusedIndex(), automjet);

		}else {
			new Alert(Alert.AlertType.ERROR, "Ndryshimi i te dhenave te automjetit deshtoji !", ButtonType.CLOSE).show();
		}
    }
	
	@FXML
	void onTableItemSelect() {
		klient = tableKlient.getSelectionModel().getSelectedItem();
		if(klient !=null) {
			txtKlient.setText(klient.getEmri());
		}
	}
	
//	public void refreshTable() {
//		tableKlient.setItems(getKlients());
//	}
//	
//	public ObservableList<tblklient> getKlients() {
//		data = FXCollections.observableArrayList(klientController.getKlients());
//		if (data == null) {
//			return data = FXCollections.observableArrayList();
//		} else {
//			return data;
//		}
//	}
	
	public ObservableList<tblautomjet> getAutomjete(){
		auto = FXCollections.observableArrayList(automjetController.getAutomjete());
		if(auto == null) {
			return auto = FXCollections.observableArrayList();
		}
		return auto;
	}
	
	public ObservableList<tblklient> getKlient() {
		data = FXCollections.observableArrayList(automjetController.kerkoKlient(txtKerkoKlient.getText()));
//		data = FXCollections.observableArrayList(automjetController.getKlient());
		if (data == null) {
			return data = FXCollections.observableArrayList();
		} else {
			return data;
		}
	}
}
