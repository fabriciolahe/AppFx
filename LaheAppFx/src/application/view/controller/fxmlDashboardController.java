package application.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class fxmlDashboardController implements Initializable {
	
    @FXML
    private MenuItem menuItemKrijoUser;

    @FXML
    private MenuItem menuItemListoUser;

    @FXML
    private MenuItem menuItemMbyll;
    
    @FXML
    private Menu menuAdmin;

    @FXML
    private Menu menuKlient;
    
    @FXML
    private MenuItem menuItemNewKlient;

    @FXML
    private MenuItem menuItemListoKlient;

    @FXML
    private Menu menuAutomjet;
    
    @FXML
    private MenuItem menuItemNewAuto;

    @FXML
    private MenuItem menuItemListoAuto;

    @FXML
    private Menu menuSherbime;
    
    @FXML
    private MenuItem menuItemNewSherbime;

    @FXML
    private MenuItem menuItemListoSherbime;

    @FXML
    private Button btnKerko;

    @FXML
    private Button btnKlient;

    @FXML
    private Button btnAutomjet;

    @FXML
    private Button btnSherbime;

    @FXML
    private Button btnMbyll;
    
    @FXML
    private TabPane tabPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void menu(boolean isAdmin) {
		menuAdmin.setVisible(isAdmin);
	}
	
    @FXML
    void onAutomjet(ActionEvent event) {
		try {
			Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlAutomjet.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
			Tab tab = new Tab("Automjet",node);
			tabPane.getTabs().add(tab);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
    }

    @FXML
    void onKerko(ActionEvent event) {
		try {
			Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlShfaqSherbime.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
			Tab tab = new Tab("Kerko",node);
			tabPane.getTabs().add(tab);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void onKlient(ActionEvent event) {
		try {
			Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlKlient.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
			Tab tab = new Tab("Klient",node);
			tabPane.getTabs().add(tab);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void onSherbime(ActionEvent event) {
		try {
			Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlSherbime.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
			Tab tab = new Tab("Sherbime",node);
			tabPane.getTabs().add(tab);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void onMenuAutomjet(ActionEvent event) {
//		try {
//			Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlAutomjet.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
//			Tab tab = new Tab("Automjet",node);
//			tabPane.getTabs().add(tab);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }

    @FXML
    void onMenuKlient(ActionEvent event) {
//		try {
//			Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlKlient.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
//			Tab tab = new Tab("Klient",node);
//			tabPane.getTabs().add(tab);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
    
    @FXML
    void onFshijNdryshoAutomjet(ActionEvent event) {
		try {
		Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlAutomjet.fxml"));
//		tblperdoruesController perdoruesController = loader.getController();
		Tab tab = new Tab("Automjet",node);
		tabPane.getTabs().add(tab);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    @FXML
    void onFshijNdryshoKlient(ActionEvent event) {
		try {
		Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlKlient.fxml"));
//		tblperdoruesController perdoruesController = loader.getController();
		Tab tab = new Tab("Klient",node);
		tabPane.getTabs().add(tab);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    @FXML
    void onMenuSherbime(ActionEvent event) {
		try {
			Node node = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlSherbime.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
			Tab tab = new Tab("Sherbime",node);
			tabPane.getTabs().add(tab);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void onItemMbyll(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void onBtnMbyll(ActionEvent event) {
        Stage stage = (Stage) btnMbyll.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void onItemKrijoUser(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlKrijoPerdorues.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void onAddNewAuto(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlKrijoAutomjet.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void onAddNewKlient(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/fxmlKrijoKlient.fxml"));
//			tblperdoruesController perdoruesController = loader.getController();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void onListoUser(ActionEvent event) {
    	
    }
}
