package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {

	@FXML
	private TableView<Department> tVDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tCId;
	
	@FXML
	private TableColumn<Department, String> tCName;
	
	@FXML
	private Button btNew;
	
	@FXML
	public void OnBtNwAction() {
		System.out.println("Button press");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		intializeNodes();
	}

	private void intializeNodes() {
		tCId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tCName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tVDepartment.prefHeightProperty().bind(stage.heightProperty());		
	}

}
