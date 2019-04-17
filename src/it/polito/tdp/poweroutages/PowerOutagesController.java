package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;
import it.polito.tdp.poweroutages.model.Blackout;
import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PowerOutagesController {
	
	private Model modello;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Nerc> finestranerc;

    @FXML
    private TextField spazioanni;

    @FXML
    private TextField spazioore;

    @FXML
    private Button bottoneworst;

    @FXML
    private TextArea testoresult;

    @FXML
    void analizzaworst(ActionEvent event) {
   int maxanni=Integer.parseInt(spazioanni.getText());
  try{int year= Integer.parseInt(spazioanni.getText());
  if(year<1 || year>15) {testoresult.setText("Errore,inserire un numero tra 1 e 15");}
  }catch(NumberFormatException e) {testoresult.setText("Errore, inserire un numero compreso tra 1 e 15");}
  int maxore=Integer.parseInt(spazioore.getText());
List<Blackout> lista= modello.getWorst(finestranerc.getValue().getId(), maxore, maxanni);
 for(Blackout b:lista) {
	 testoresult.appendText(b.toString());
 }
    }

    @FXML
    void initialize() {
        assert finestranerc != null : "fx:id=\"finestranerc\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert spazioanni != null : "fx:id=\"spazioanni\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert spazioore != null : "fx:id=\"spazioore\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert bottoneworst != null : "fx:id=\"bottoneworst\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert testoresult != null : "fx:id=\"testoresult\" was not injected: check your FXML file 'PowerOutages.fxml'.";

    }
    public void setModel(Model m) {
    	modello=m;
    	finestranerc.getItems().addAll(modello.getNercList());
    	
    }
}
