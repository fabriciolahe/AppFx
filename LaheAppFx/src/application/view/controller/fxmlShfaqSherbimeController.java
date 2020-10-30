package application.view.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import application.entity.tblautomjet;
import application.entity.tblklient;
import application.entity.tbllengje;
import application.entity.tblmirembajtje;
import application.entity.tblpjeskembimi;
import application.entity.controller.tblautomjetController;
import application.entity.controller.tblklientController;
import application.entity.controller.tbllengjeController;
import application.entity.controller.tblmirembajtjeController;
import application.entity.controller.tblpjeskembimiController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class fxmlShfaqSherbimeController implements Initializable {
	
	private ObservableList<tblpjeskembimi> pjese;
	private ObservableList<tblmirembajtje> mMbajtje;
	private ObservableList<tbllengje> leng;
	private ObservableList<tblklient> kli;
	private ObservableList<tblautomjet> auto;
	private tblpjeskembimiController pjeseKembimiController = new tblpjeskembimiController();
	private tblmirembajtjeController mirembajtjeController = new tblmirembajtjeController();
	private tblautomjetController automjetController = new tblautomjetController();
	private tblklientController klientController = new tblklientController();
	private tbllengjeController lengjeController = new tbllengjeController();
	private tblpjeskembimi pjeseKembimi;
	private tblmirembajtje mirembajtje;
	private tblautomjet automjet;
	private tblklient klient;
	private tbllengje lengje;
	
    @FXML
    private TextField txtKerkoAutomjet;

    @FXML
    private Button btnKerkoAuto;

    @FXML
    private TableView<tblautomjet> tableAutomjet;

    @FXML
    private TableColumn<tblautomjet, String> colTarga;

    @FXML
    private TableColumn<tblautomjet, String> colMarka;

    @FXML
    private TableColumn<tblautomjet, String> colModeli;

    @FXML
    private TableColumn<tblautomjet, String> colCilindrata;
    
    @FXML
    private TableColumn<tblautomjet, String> colViti;
    
    @FXML
    private TableView<tblautomjet> tableAutomjet1;

    @FXML
    private TableColumn<tblautomjet, String> colTarga1;

    @FXML
    private TableColumn<tblautomjet, String> colMarka1;

    @FXML
    private TableColumn<tblautomjet, String> colModeli1;

    @FXML
    private TableColumn<tblautomjet, String> colCilindrata1;
    
    @FXML
    private TableColumn<tblautomjet, String> colViti1;
    
    @FXML
    private TextField txtKerkoKlient;

    @FXML
    private Button btnKerkoKlient;

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
    private TextField txtEmri;

    @FXML
    private TextField txtMbiemri;

    @FXML
    private TextField txtKompania;

    @FXML
    private TextField txtNrCelulari;

    @FXML
    private TextField txtTarga;

    @FXML
    private TextField txtNrShasie;

    @FXML
    private TextField txtMarka;

    @FXML
    private TextField txtModeli;

    @FXML
    private TextField txtCilindrata;

    @FXML
    private TextField txtFuqia;

    @FXML
    private TextField txtKilometrat;

    @FXML
    private DatePicker txtData;

    @FXML
    private TextField txtKarburanti;

    @FXML
    private TextField txtKambio;

    @FXML
    private TextField txtVitiProdhimit;

    @FXML
    private TextField txtSae;

    @FXML
    private CheckBox filterVaji;

    @FXML
    private CheckBox filterAjri;

    @FXML
    private CheckBox filterKarburanti;

    @FXML
    private CheckBox filterGabine;

    @FXML
    private TextField txtKodiPjeses;

    @FXML
    private TextField txtEmertimiPjeses;

    @FXML
    private Button btnShtoPjese;

    @FXML
    private Button btnFshijPjese;
    
    @FXML
    private Button btnPastroPjese;

    @FXML
    private TextField txtKodiLengjeve;

    @FXML
    private TextField txtTipiLengjeve;

    @FXML
    private TextField txtSasia;

    @FXML
    private Button btnShtoLengje;

    @FXML
    private Button btnFshijLengje;
    
    @FXML
    private Button btnPastroLengje;

    @FXML
    private TableView<tblpjeskembimi> tablePjeseKembimi;

    @FXML
    private TableColumn<tblpjeskembimi, String> colKodiPjeses;

    @FXML
    private TableColumn<tblpjeskembimi, String> colEmertimiPjeses;

    @FXML
    private TableView<tbllengje> tableLengje;

    @FXML
    private TableColumn<tbllengje, String> colKodiLengut;

    @FXML
    private TableColumn<tbllengje, String> colTipiLengut;

    @FXML
    private TableColumn<tbllengje, String> colSasiaLengut;

    @FXML
    private Button btnRuaj;

    @FXML
    private Button btnNdrysho;
    
    @FXML
    private Button btnFshij;
    
    @FXML
    private TableView<tblmirembajtje> tableMirembajtje;

//    @FXML
//    private TableColumn<tblmirembajtje, String> colKilometrat;
    
    @FXML
    private TableColumn<tblmirembajtje, Date> colData;
    
    @FXML
    private TableView<tblmirembajtje> tableMirembajtje1;

//    @FXML
//    private TableColumn<tblmirembajtje, String> colKilometrat;
    
    @FXML
    private TableColumn<tblmirembajtje, Date> colData1;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initPjeseKembimiColumn();
		initLengjeColumn();
		initMirembajtjeColumn();
		initMirembajtjeColumn1();
		initAutomjetColumn();
		initAutomjetColumn1();
		initKlientColumn();
//		refreshTablePjeseKembimi();
//		refreshTableLengje();
//		refreshTableMirembajtje();
	}

	private void initKlientColumn() {
		colEmri.setCellValueFactory(new PropertyValueFactory<>("emri"));
		colMbiemri.setCellValueFactory(new PropertyValueFactory<>("mbiemri"));
		colKompania.setCellValueFactory(new PropertyValueFactory<>("kompania"));
		colCelular.setCellValueFactory(new PropertyValueFactory<>("nrcelulari"));
		
	}

	private void initAutomjetColumn() {
		colTarga.setCellValueFactory(new PropertyValueFactory<>("targa"));
		colMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
		colModeli.setCellValueFactory(new PropertyValueFactory<>("model"));
		colCilindrata.setCellValueFactory(new PropertyValueFactory<>("cilindrata"));
		colViti.setCellValueFactory(new PropertyValueFactory<>("viti"));
	}
	
	private void initAutomjetColumn1() {
		colTarga1.setCellValueFactory(new PropertyValueFactory<>("targa"));
		colMarka1.setCellValueFactory(new PropertyValueFactory<>("marka"));
		colModeli1.setCellValueFactory(new PropertyValueFactory<>("model"));
		colCilindrata1.setCellValueFactory(new PropertyValueFactory<>("cilindrata"));
		colViti1.setCellValueFactory(new PropertyValueFactory<>("viti"));
	}

	private void initMirembajtjeColumn() {
//		colKilometrat.setCellValueFactory(new PropertyValueFactory<>("kilomatrat"));
		colData.setCellValueFactory(new PropertyValueFactory<>("dataKrijimit"));
	}
	
	private void initMirembajtjeColumn1() {
//		colKilometrat.setCellValueFactory(new PropertyValueFactory<>("kilomatrat"));
		colData1.setCellValueFactory(new PropertyValueFactory<>("dataKrijimit"));
	}

	private void initPjeseKembimiColumn(){
		colKodiPjeses.setCellValueFactory(new PropertyValueFactory<>("kodPjese"));
		colEmertimiPjeses.setCellValueFactory(new PropertyValueFactory<>("emerPjese"));
	}
	
	private void initLengjeColumn() {
		colKodiLengut.setCellValueFactory(new PropertyValueFactory<>("kodi"));
		colTipiLengut.setCellValueFactory(new PropertyValueFactory<>("tipi"));
		colSasiaLengut.setCellValueFactory(new PropertyValueFactory<>("sasia"));
	}
	
    @FXML
    void onSavePjese(ActionEvent event) {
    	pjeseKembimi = new tblpjeskembimi();
    	pjeseKembimi.setKodPjese(txtKodiPjeses.getText());
    	pjeseKembimi.setEmerPjese(txtEmertimiPjeses.getText());
    	
    	pjeseKembimi.setTarga(automjet);
    	
		java.util.Date date = java.sql.Date.valueOf(txtData.getValue().toString());
		pjeseKembimi.setDataKrjimit(date);
    	
		pjeseKembimiController.addPjeseKembimi(pjeseKembimi);
		refreshTablePjeseKembimi();
		clearFields();
    }
    
    @FXML
	private void clearFields() {
		txtKodiPjeses.setText("");
		txtEmertimiPjeses.setText("");
	}

	private void refreshTablePjeseKembimi() {
		tablePjeseKembimi.setItems(getPjeseKembimi());
	}

	private ObservableList<tblpjeskembimi> getPjeseKembimi() {
		pjese = FXCollections.observableArrayList(pjeseKembimiController.getPjesetKembimi());
		if(pjese == null) {
			pjese = FXCollections.observableArrayList();
		}
		return pjese;
	}
	
	@FXML
	void onTablePjeseItemSelect() {
		pjeseKembimi = tablePjeseKembimi.getSelectionModel().getSelectedItem();
		if(pjeseKembimi !=null) {
			txtKodiPjeses.setText(pjeseKembimi.getKodPjese());
			txtEmertimiPjeses.setText(pjeseKembimi.getEmerPjese());
		}
	}
	
    @FXML
    void onDeletePjese(ActionEvent event) {
    	pjeseKembimiController.deletePjeseKembimi(pjeseKembimi.getId());
    	pjese.set(tablePjeseKembimi.getSelectionModel().getFocusedIndex(), pjeseKembimi);
    }

    @FXML
    void onDeleteLengje(ActionEvent event) {
    	lengjeController.deleteLengje(lengje.getId());
    	leng.set(tableLengje.getSelectionModel().getFocusedIndex(), lengje);
    }

    @FXML
    void onSaveLengje(ActionEvent event) {
    	lengje = new tbllengje();
    	lengje.setKodi(txtKodiLengjeve.getText());
    	lengje.setTipi(txtTipiLengjeve.getText());
    	lengje.setSasia(txtSasia.getText());
    	
    	lengje.setTarga(automjet);
    	
		java.util.Date date = java.sql.Date.valueOf(txtData.getValue().toString());
		lengje.setDataKrijimit(date);    	
    	
    	lengjeController.addLengje(lengje);
    	refreshTableLengje();
    	clearFieldsLengje();
    }
	
	private void refreshTableLengje() {
		tableLengje.setItems(getLengjet());
	}
	
	@FXML
	void onTableLengjeItemSelect() {
		lengje = tableLengje.getSelectionModel().getSelectedItem();
		if(lengje !=null) {
			txtKodiLengjeve.setText(lengje.getKodi());
			txtTipiLengjeve.setText(lengje.getTipi());
			txtSasia.setText(lengje.getSasia());
		}
	}
    
	private ObservableList<tbllengje> getLengjet() {
		leng = FXCollections.observableArrayList(lengjeController.getlengje());
		if(leng == null) {
			leng = FXCollections.observableArrayList();
		}
		return leng;
	}
	
    @FXML
    void clearFieldsLengje() {
    	txtKodiLengjeve.setText("");
    	txtTipiLengjeve.setText("");
    	txtSasia.setText("");
    }

    @FXML
    void onSaveMirembajtje(ActionEvent event) {
    	mirembajtje = new tblmirembajtje();
	    mirembajtje.setKilomatrat(txtKilometrat.getText());
	    mirembajtje.setSaeVaji(txtSae.getText());
	    mirembajtje.setFilterAjri(filterAjri.isSelected());
	    mirembajtje.setFilterGabine(filterGabine.isSelected());
	    mirembajtje.setFilterKarburanti(filterKarburanti.isSelected());
	    mirembajtje.setFilterVaji(filterVaji.isSelected());
	    
	    mirembajtje.setTarga(automjet);
	    
		java.util.Date date = java.sql.Date.valueOf(txtData.getValue().toString());
		mirembajtje.setDataKrijimit(date);
		
    	mirembajtjeController.addMirembajtje(mirembajtje);
    	clearFieldsMirembajtje();
    	refreshTableMirembajtje();
    	
    }
    
	private void refreshTableMirembajtje() {
		tableMirembajtje.setItems(getMirembajtje());
	}
	
	private ObservableList<tblmirembajtje> getMirembajtje() {
		mMbajtje = FXCollections.observableArrayList(mirembajtjeController.getmirembajtje());
		if(mMbajtje == null) {
			mMbajtje = FXCollections.observableArrayList();
		}
		return mMbajtje;
	}
	
	java.sql.Date data;
	
	@FXML
	void onTableMirembajtjeItemSelect() {
		mirembajtje = tableMirembajtje.getSelectionModel().getSelectedItem();
		if(mirembajtje != null) {
			txtKilometrat.setText(mirembajtje.getKilomatrat());
			txtSae.setText(mirembajtje.getSaeVaji());
			filterAjri.setSelected(mirembajtje.isFilterAjri());
			filterGabine.setSelected(mirembajtje.isFilterGabine());
			filterKarburanti.setSelected(mirembajtje.isFilterKarburanti());
			filterVaji.setSelected(mirembajtje.isFilterVaji());
			
			Instant instant = Instant.ofEpochMilli(mirembajtje.getDataKrijimit().getTime());
			LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
			
			txtData.setValue(LOCAL_DATE (localDateTime.toLocalDate().toString()));
			
			data = java.sql.Date.valueOf(txtData.getValue().toString());
			tablePjeseKembimi.setItems(getListPjeseByDate());
			tableLengje.setItems(getListLengjeByDate());
		}
	}
	
	@FXML
	void onTableMirembajtjeItemSelect1() {
		mirembajtje = tableMirembajtje1.getSelectionModel().getSelectedItem();
		if(mirembajtje != null) {
			txtKilometrat.setText(mirembajtje.getKilomatrat());
			txtSae.setText(mirembajtje.getSaeVaji());
			filterAjri.setSelected(mirembajtje.isFilterAjri());
			filterGabine.setSelected(mirembajtje.isFilterGabine());
			filterKarburanti.setSelected(mirembajtje.isFilterKarburanti());
			filterVaji.setSelected(mirembajtje.isFilterVaji());
			
			Instant instant = Instant.ofEpochMilli(mirembajtje.getDataKrijimit().getTime());
			LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
			
			txtData.setValue(LOCAL_DATE (localDateTime.toLocalDate().toString()));
			
			data = java.sql.Date.valueOf(txtData.getValue().toString());
			tablePjeseKembimi.setItems(getListPjeseByDate());
			tableLengje.setItems(getListLengjeByDate());
		}
	}
	
	public static final LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}
	
	private ObservableList<tblpjeskembimi> getListPjeseByDate(){
		pjese = FXCollections.observableArrayList(pjeseKembimiController.getListPjeseByDate(data));
		if(pjese == null) {
			pjese = FXCollections.observableArrayList();
		}
		return pjese;
	}
	
	private ObservableList<tbllengje> getListLengjeByDate(){
		leng = FXCollections.observableArrayList(lengjeController.getListPjeseByDate(data));
		if(leng == null) {
			leng = FXCollections.observableArrayList();
		}
		return leng;
	}
    
    public void clearFieldsMirembajtje() {
//    	txtEmri.setText("");
//    	txtMbiemri.setText("");
//    	txtKompania.setText("");
//    	txtNrCelulari.setText("");
//    	txtTarga.setText("");
//    	txtNrShasie.setText("");
//    	txtMarka.setText("");
//    	txtModeli.setText("");
//    	txtCilindrata.setText("");
//    	txtFuqia.setText("");
//    	txtKarburanti.setText("");
//    	txtKambio.setText("");
//    	txtVitiProdhimit.setText("");
    	txtKilometrat.setText("");
    	txtSae.setText("");
    	txtData.setValue(null);
    	filterAjri.setSelected(false);
    	filterGabine.setSelected(false);
    	filterKarburanti.setSelected(false);
    	filterVaji.setSelected(false);
    }
    
    @FXML
    void onUpdateMirembajtje(ActionEvent event) {
    	
    	if(
    			!txtKilometrat.getText().isEmpty() &&
    			!txtSae.getText().isEmpty() 
//    			!filterAjri.isSelected() ||
//    			!filterVaji.isSelected() ||
//    			!filterKarburanti.isSelected() ||
//    			!filterGabine.isSelected()
    	  ) { 		
    		mirembajtje.setKilomatrat(txtKilometrat.getText());
    		mirembajtje.setSaeVaji(txtSae.getText());
    		mirembajtje.setFilterAjri(filterAjri.isSelected());
    		mirembajtje.setFilterGabine(filterGabine.isSelected());
    		mirembajtje.setFilterKarburanti(filterKarburanti.isSelected());
    		mirembajtje.setFilterVaji(filterVaji.isSelected());
    		mirembajtjeController.updateMirembajtje(mirembajtje, mirembajtje.getId());
    		clearFieldsMirembajtje();
        	mMbajtje.set(tableMirembajtje.getSelectionModel().getFocusedIndex(), mirembajtje);
    	}
    	
    	if(
    			!txtKodiPjeses.getText().isEmpty() &&
    			!txtEmertimiPjeses.getText().isEmpty()
     	  ) {
        	pjeseKembimi.setKodPjese(txtKodiPjeses.getText());
        	pjeseKembimi.setEmerPjese(txtEmertimiPjeses.getText());
    		pjeseKembimiController.updatePjeseKembimi(pjeseKembimi, pjeseKembimi.getId());
    		clearFields();
    		pjese.set(tablePjeseKembimi.getSelectionModel().getFocusedIndex(), pjeseKembimi);	
    	}
    	
    	if(
    			!txtKodiLengjeve.getText().isEmpty() &&
    			!txtTipiLengjeve.getText().isEmpty() &&
    			!txtSasia.getText().isEmpty()
    	  ) {
    		lengje.setKodi(txtKodiLengjeve.getText());
    		lengje.setTipi(txtTipiLengjeve.getText());
    		lengje.setSasia(txtSasia.getText());
    		lengjeController.updateLengje(lengje, lengje.getId());
    		clearFieldsLengje();
    		leng.set(tableLengje.getSelectionModel().getFocusedIndex(), lengje);
    	}
    }
    
    @FXML
    void onDeleteMirembajtje(ActionEvent event) {
    	mirembajtjeController.deleteMirembajtje(mirembajtje.getId());
    	mMbajtje.set(tableMirembajtje.getSelectionModel().getFocusedIndex(), mirembajtje);
    	refreshTableMirembajtje();
    	
    }
    
    Set<tblmirembajtje> list = new HashSet<>();
    Set<tblpjeskembimi> listPjes = new HashSet<>();
    Set<tbllengje> listLengje = new HashSet<>();
    @FXML
    void onTableAutomjetItemSelect(MouseEvent event) {
    	automjet = tableAutomjet.getSelectionModel().getSelectedItem();
    	if(automjet != null) {	
    		txtTarga.setText(automjet.getTarga());
    		txtNrShasie.setText(automjet.getNrshasi());
    		txtMarka.setText(automjet.getMarka());
    		txtModeli.setText(automjet.getModel());
    		txtCilindrata.setText(automjet.getCilindrata());
    		txtFuqia.setText(automjet.getFuqia());
    		txtKambio.setText(automjet.getKambio());
    		txtKarburanti.setText(automjet.getKarburant());
    		txtVitiProdhimit.setText(automjet.getViti());
    		
    		Set<tblklient> klie = automjet.getKlient();
    		for(tblklient k:klie) {
        		txtEmri.setText(k.getEmri());
        		txtMbiemri.setText(k.getMbiemri());
        		txtKompania.setText(k.getKompania());
        		txtNrCelulari.setText(k.getNrcelulari());
    		}
    		
    		Set<tblmirembajtje> manutazione = automjet.getMirembajtje();
    		for(tblmirembajtje m:manutazione) {list.add(m);}
    		tableMirembajtje.setItems(getListMirembajtje());
    		list.removeAll(manutazione);
    		
    		Set<tblpjeskembimi> pjKembimi = automjet.getPjesekembimi();
    		for(tblpjeskembimi p:pjKembimi) {listPjes.add(p);}
//    		tablePjeseKembimi.setItems(getListPjesKembimi());
    		listPjes.removeAll(pjKembimi);
    		
    		Set<tbllengje> lng = automjet.getLengje();
    		for(tbllengje l : lng) {listLengje.add(l);}
//    		tableLengje.setItems(getListLengjet());
    		listLengje.removeAll(lng);
    	}
    }
    
    @FXML
    void onTableAutomjetItemSelect1(MouseEvent event) {
    	automjet = tableAutomjet1.getSelectionModel().getSelectedItem();
    	if(automjet != null) {	
    		txtTarga.setText(automjet.getTarga());
    		txtNrShasie.setText(automjet.getNrshasi());
    		txtMarka.setText(automjet.getMarka());
    		txtModeli.setText(automjet.getModel());
    		txtCilindrata.setText(automjet.getCilindrata());
    		txtFuqia.setText(automjet.getFuqia());
    		txtKambio.setText(automjet.getKambio());
    		txtKarburanti.setText(automjet.getKarburant());
    		txtVitiProdhimit.setText(automjet.getViti());
    		
    		Set<tblklient> klie = automjet.getKlient();
    		for(tblklient k:klie) {
        		txtEmri.setText(k.getEmri());
        		txtMbiemri.setText(k.getMbiemri());
        		txtKompania.setText(k.getKompania());
        		txtNrCelulari.setText(k.getNrcelulari());
    		}
    		
    		Set<tblmirembajtje> manutazione = automjet.getMirembajtje();
    		for(tblmirembajtje m:manutazione) {list.add(m);}
    		tableMirembajtje1.setItems(getListMirembajtje());
    		list.removeAll(manutazione);
    		
    		Set<tblpjeskembimi> pjKembimi = automjet.getPjesekembimi();
    		for(tblpjeskembimi p:pjKembimi) {listPjes.add(p);}
//    		tablePjeseKembimi.setItems(getListPjesKembimi());
    		listPjes.removeAll(pjKembimi);
    		
    		Set<tbllengje> lng = automjet.getLengje();
    		for(tbllengje l : lng) {listLengje.add(l);}
//    		tableLengje.setItems(getListLengjet());
    		listLengje.removeAll(lng);
    	}
    }
    
    private ObservableList<tblmirembajtje> getListMirembajtje() {
    	mMbajtje = FXCollections.observableArrayList(list);
    	if(mMbajtje == null) {
    		mMbajtje = FXCollections.observableArrayList();
    	}
		return mMbajtje;
	}
    
//    private ObservableList<tblpjeskembimi> getListPjesKembimi(){
//    	pjese = FXCollections.observableArrayList(listPjes);
//    	return pjese;
//    }
//    
//    private ObservableList<tbllengje> getListLengjet(){
//    	leng = FXCollections.observableArrayList(listLengje);
//    	return leng;
//    }
    
    
    String targa = null;
    Set<tblautomjet> listautomjete = new HashSet<>();
    @FXML
    void onTableKlientItemSelect(MouseEvent event) {
    	klient = tableKlient.getSelectionModel().getSelectedItem();
    	if(klient != null) {
    		txtEmri.setText(klient.getEmri());
    		txtMbiemri.setText(klient.getMbiemri());
    		txtKompania.setText(klient.getKompania());
    		txtNrCelulari.setText(klient.getNrcelulari());
    		
    		clearAutomjetFields();
    		
    		Set<tblautomjet> mjete = klient.getAutomjetet();
    		for(tblautomjet aut : mjete) {
    			listautomjete.add(aut);
    		}	
    		tableAutomjet1.setItems(getMjete());
    		listautomjete.removeAll(mjete);
    		tableMirembajtje.getItems().clear();
    		tablePjeseKembimi.getItems().clear();
    		tableLengje.getItems().clear();
    	}
    }
    
    private void clearAutomjetFields() {
    	txtTarga.setText("");
    	txtNrShasie.setText("");
    	txtMarka.setText("");
    	txtModeli.setText("");
    	txtCilindrata.setText("");
    	txtFuqia.setText("");
    	txtKarburanti.setText("");
    	txtKambio.setText("");
    	txtVitiProdhimit.setText("");    	
    }
    
    private ObservableList<tblautomjet> getMjete() {
    	auto = FXCollections.observableArrayList(listautomjete);
    	if(auto == null) {
    		auto = FXCollections.observableArrayList();
    	}
		return auto;
	}

	private void refreshTableKlient(){
		tableKlient.getItems().clear();
    	tableKlient.setItems(getKlients());
    }
    
	private ObservableList<tblklient> getKlients() {
		kli = FXCollections.observableArrayList(automjetController.kerkoKlient(txtKerkoKlient.getText()));
		if(kli == null) {
			kli = FXCollections.observableArrayList();
		}
		return kli;
	}
	
	private void refreshTableAutomjet() {
		tableAutomjet.getItems().clear();
		tableAutomjet.setItems(getAutomjet());
	}
	
	private ObservableList<tblautomjet> getAutomjet(){
		if(!txtKerkoAutomjet.getText().isEmpty()) {
			auto = FXCollections.observableArrayList(automjetController.kerkoAutomjet(txtKerkoAutomjet.getText()));
		}else if(auto == null) {
			auto = FXCollections.observableArrayList();
		}
		return auto;
	}
	
    @FXML
    void kerkoAutomjet(ActionEvent event) {
    	refreshTableAutomjet();
    }

    @FXML
    void kerkoKlient(ActionEvent event) {
    	refreshTableKlient();
    }
}
