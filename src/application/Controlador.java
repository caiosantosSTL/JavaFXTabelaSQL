package application;


import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controlador implements Initializable {
	
    @FXML
    private Button butono;
    
    @FXML
    private Button butonFile;

    @FXML
    private Button butonDir;
	
    @FXML
    private TableView<Pessoas> tabelox;
	
    @FXML
    private TableColumn<Pessoas, String> KolumID;
    
    @FXML
    private TableColumn<Pessoas, String> KolumNome;

    @FXML
    private TableColumn<Pessoas, String> KolumColor;
    
    private ObservableList<Pessoas> data;
    private ConectDB db;

    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// abaixo info do que devemos colocar
		db=new ConectDB();

		
		// TODO Auto-generated method stub
//		KolumID.setCellValueFactory(new PropertyValueFactory<>("idx"));
//		KolumNome.setCellValueFactory(new PropertyValueFactory<>("nomex"));
//		KolumColor.setCellValueFactory(new PropertyValueFactory<>("colorx"));
//		
//		tabelox.setItems(listaPerson());
		
		
	}
	
//	private ObservableList<Pessoas> listaPerson(){
//		return FXCollections.observableArrayList(
//				new Pessoas("3","Gosd","Luim"),
//				new Pessoas("3","Gosd","Luim"),
//				new Pessoas("3","Gosd","Luim"),
//				new Pessoas("3","Gosd","Luim")
//				
//				//investigar DAO
//
//				);
//	}
	
	
    @FXML
    void ExecutDB(ActionEvent event) {
    	
    	try {
    		Connection con= db.Conect();
    		data=FXCollections.observableArrayList();
    		ResultSet rs= con.createStatement().executeQuery("SELECT id, nome, color FROM TabelaX");
    		
            while (rs.next()) {

                data.add(new Pessoas(rs.getString("id"), 
                		rs.getString("nome"), 
                		rs.getString("color")));
            }
    		
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("nao foi "+e);
		}
    	
		KolumID.setCellValueFactory(new PropertyValueFactory<>("idx"));//indicando nome da coluna do db
		KolumNome.setCellValueFactory(new PropertyValueFactory<>("nomex"));
		KolumColor.setCellValueFactory(new PropertyValueFactory<>("colorx"));
		
		tabelox.setItems(null);//nao tem pq isso ta aqui
		tabelox.setItems(data);
    	

    }
    
    
    
    @FXML
    void ArkivoBox(ActionEvent event) {
    	
    	FileChooser fc = new FileChooser();
    	//fc.getExtensionFilters().add(new ExtensionFilter("pdf", "*.pdf"));
    	fc.getExtensionFilters();
    	List<File> f = fc.showOpenMultipleDialog(null);
    	for (File file : f) {
			System.out.println(file.getAbsolutePath());//aqui sai o caminho
		}
    	
    	
    	
    	

    }
    
    @FXML
    void ApertarDir(ActionEvent event) {//pegar caminho de pasta
    	
    	DirectoryChooser chose = new DirectoryChooser();
    	File fil = chose.showDialog(null);
    	if (fil != null) {
			System.out.println(fil.getAbsolutePath());
		}
    	

    }
    

}
