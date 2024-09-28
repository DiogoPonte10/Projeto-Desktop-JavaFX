package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService service;
	
	@FXML
	private TableView<Department> tVDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tCId;
	
	@FXML
	private TableColumn<Department, String> tCName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

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
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list =  service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tVDepartment.setItems(obsList);
	}

}
