/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.DBConnect;

/**
 * FXML Controller class
 *
 * @author Amix
 */
public class TicketViewController implements Initializable {

    @FXML
    private TableView tableview;
    
    Connection conn =DBConnect.connect();

    public void filltable()
    {
    TableColumn IdColumn = new TableColumn("Id");
    IdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn FullnamesColumn = new TableColumn("Fullnames");
        FullnamesColumn.setCellValueFactory(new PropertyValueFactory<>("Fullnames"));
        TableColumn NidColumn = new TableColumn("Nid");
        NidColumn.setCellValueFactory(new PropertyValueFactory<>("Nid"));
        TableColumn MobileColumn = new TableColumn("Mobile");
        MobileColumn.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
         TableColumn OriginColumn = new TableColumn("Origin");
        OriginColumn.setCellValueFactory(new PropertyValueFactory<>("Origin"));
     TableColumn DestinationColumn = new TableColumn("Destination");
   DestinationColumn.setCellValueFactory(new PropertyValueFactory<>("Destination"));
          TableColumn CoachColumn = new TableColumn("Coach");
            CoachColumn.setCellValueFactory(new PropertyValueFactory<>("Coach"));
            TableColumn DateColumn = new TableColumn("Date");
            DateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
            TableColumn TimeColumn = new TableColumn("Time");
            TimeColumn.setCellValueFactory(new PropertyValueFactory<>("Time"));

    tableview.getColumns().addAll(IdColumn,FullnamesColumn, NidColumn,MobileColumn,OriginColumn,DestinationColumn,CoachColumn,DateColumn,TimeColumn);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
