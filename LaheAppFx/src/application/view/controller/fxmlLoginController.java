package application.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.entity.tblperdorues;
import application.entity.controller.tblperdoruesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class fxmlLoginController implements Initializable {
	
	tblperdoruesController perdoruesController = new tblperdoruesController();
	
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnAnullo;

    @FXML
    private PasswordField txtFjalekalim;

    @FXML
    private TextField txtEmriPerdoruesit;

    @FXML
    private Label lblEmriPerdoruesit;

    @FXML
    private Label lblFjalekalimi;

    @FXML
    private Label lblNewPerdorues;
    
    @FXML
    private Label lblPassword;

    @FXML
    private Label lblPerdorues;
	
    private List<tblperdorues> listPerdorues = new ArrayList<>();
    
    private List<tblperdorues> listPerdoruesit = new ArrayList<>();
    
    private List<tblperdorues> listEmrat = new ArrayList<>();
    
    private List<tblperdorues> listFjalekalimet = new ArrayList<>();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listPerdorues = perdoruesController.getListPerdorues();
	}
	
    @FXML
    void onAnullo(ActionEvent event) {
        Stage stage = (Stage) btnAnullo.getScene().getWindow();
        stage.close();
    }
    
    //Metode Testuese
    @FXML
    void onLogin(ActionEvent event) {
    	if(!txtEmriPerdoruesit.getText().isEmpty() && !txtFjalekalim.getText().isEmpty() ) {
	    	for(tblperdorues perdorues:listPerdorues) {
	    		if(txtEmriPerdoruesit.getText().equals(perdorues.getPerdoruesi())) {
	    			if(txtFjalekalim.getText().equals(perdorues.getFjalekalimi())) {
	    				lblPerdorues.setText("");
	    				lblPassword.setText("");
	    	    		Parent root;
						try {
							(((Node)event.getSource()).getScene()).getWindow().hide();
//							root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlDashboard.fxml"));
//	    					tblperdoruesController perdoruesController = loader.getController();
							FXMLLoader load = new FXMLLoader();
							load.setLocation(getClass().getClassLoader().getResource("application/view/fxmlDashboard.fxml"));
							root = load.load();
							fxmlDashboardController controller = load.getController();
							controller.menu(perdorues.isAdmin());
							
		    	    		Stage dashboard = new Stage();
		    	    		dashboard.setScene(new Scene(root));
//		    	    		dashboard.setFullScreen(true);
		    	    		dashboard.setMaximized(true);
		    	    		dashboard.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    				break;
	    			}else {
	    				lblPerdorues.setText("");
	    				lblPassword.setText("Fjalekalimi eshte i pasakte");
	    				break;
	    			}
	    		}else {
	    			
	    		}
	    		lblPerdorues.setText("Emri eshte i pasakte");
	    		lblPassword.setText("");
	    	}
    	}else {
			lblPerdorues.setText("Plotesoni kufizat");
			lblPassword.setText("Plotesoni kufizat");
    	}
    }//Mbarimi i metodes Testuese
    
    @FXML
    void onLoginUser(ActionEvent event) {
    	
		lblPerdorues.setText("");
		lblPassword.setText("");
    	
    	if(!txtEmriPerdoruesit.getText().isEmpty()) {
    	   if(!txtFjalekalim.getText().isEmpty()) {
    		if(perdoruesController.gjejPerdorues(txtEmriPerdoruesit.getText(), txtFjalekalim.getText()) != null) {
    			listPerdoruesit = perdoruesController.gjejPerdorues(txtEmriPerdoruesit.getText(), txtFjalekalim.getText());
    			listEmrat = perdoruesController.kerkoPerdorues(txtEmriPerdoruesit.getText());
    			listFjalekalimet = perdoruesController.kerkoPerdorues(txtEmriPerdoruesit.getText());
    			if(listEmrat.listIterator().hasNext() || !listEmrat.isEmpty()) {
    				if(listFjalekalimet.listIterator().next().getFjalekalimi().equals(txtFjalekalim.getText())) {
        			for(tblperdorues perdorues:listPerdoruesit) {
        	    		Parent root;
        					try {
        						(((Node)event.getSource()).getScene()).getWindow().hide();
//        						root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlDashboard.fxml"));
//        						tblperdoruesController perdoruesController = loader.getController();
        						FXMLLoader load = new FXMLLoader();
        						load.setLocation(getClass().getClassLoader().getResource("application/view/fxmlDashboard.fxml"));
        						root = load.load();
        						fxmlDashboardController controller = load.getController();
        						controller.menu(perdorues.isAdmin());
        						
        	    	    		Stage dashboard = new Stage();
        	    	    		dashboard.setScene(new Scene(root));
//        	    	    		dashboard.setFullScreen(true);
        	    	    		dashboard.setMaximized(true);
        	    	    		dashboard.show();
        					}catch(Exception e) {
        						e.printStackTrace();
        					}
            			}
        			  }else {
        				  lblPerdorues.setText("");
        				  lblPassword.setText("Fjalekalimi eshte i pasakte");
        			  }
	    			}else {
	    				lblPassword.setText("");
	        			lblPerdorues.setText("Emri eshte i pasakte");
	        		}
	    		}
	    	}else {
	    		lblPerdorues.setText("");
				lblPassword.setText("Plotesoni kufizat");
	    	}
    }else {
    	lblPassword.setText("");
    	lblPerdorues.setText("Plotesoni kufizat");
	   }
   }
    
    @FXML
    void onKrijoPerdorues(MouseEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlKrijoPerdorues.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
    		Stage stage = new Stage();
    		stage.setTitle("Krijo Perdorues te Ri");
    		stage.setScene(new Scene(root));
    		stage.setResizable(false);
    		stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
