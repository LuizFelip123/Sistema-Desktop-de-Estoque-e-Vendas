/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DAO;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import revisaobd.Cadastro;
import revisaobd.Consulta;
import revisaobd.Login;
import revisaobd.Principal;
import relatorio.Relatorio;
import revisaobd.Venda;
import sun.util.locale.LanguageTag;

/**
 *
 * @author usuario
 */
public class PrincipalController implements Initializable{
    @FXML
    private Button buttonVender, buttonRelatorio, buttonCadastrar, buttonSair; 
    @FXML
    private Button buttonEstoque;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonEstoque.setOnMouseClicked((MouseEvent e)->{
            Consulta consulta = new Consulta();
            consulta.start(new Stage());
            Consulta.getPrimaryStage().show();
            fechar();
        });
        buttonCadastrar.setOnMouseClicked((MouseEvent e)->{
            Cadastro cadastro = new Cadastro();
            cadastro.start(new Stage()); 
            Cadastro.getPrimaryStage().show();
            fechar();
        });
        
       buttonSair.setOnMouseClicked((MouseEvent  e)->{
           Login login = new Login();
           login.start(new Stage());
           Login.getState().show();
           fechar();
       });
       buttonVender.setOnMouseClicked((MouseEvent e)->{ 
           Venda venda = new Venda();
           venda.start(new Stage());
           Venda.getPrimaryStage().show();
           fechar();
       });
       
       buttonRelatorio.setOnMouseClicked( (MouseEvent e)->{
           gerarRelatorio();
       
       
       });
        
    }
    private void fechar(){
        Principal.getPrimaryStage().close();
    }
   private void gerarRelatorio(){
        Relatorio relatorio = new Relatorio();
        try {
            relatorio.gerar();
        } catch (JRException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
