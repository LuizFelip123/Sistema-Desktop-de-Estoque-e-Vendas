/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Produto;
import revisaobd.Cadastro;
import revisaobd.Consulta;
import revisaobd.Editar;
import revisaobd.Login;
import revisaobd.Principal;
import revisaobd.Venda;

/**
 *
 * @author Luiz Felipe
 */
public class ConsultaController implements Initializable{
   @FXML
    private TextField textTipoPesquisa;
   
   
   
    @FXML
    private Button buttonCadastrar, buttonPrincipal, buttonSair, buttonPesquisa, buttonAtualizar;
    @FXML
    private Button buttonVende;

    @FXML
    private TableColumn<Produto, Integer > columnQuant;

    @FXML
    private TableColumn<Produto, Integer> columnCod;

    @FXML
    private TableView<Produto> tabelaViewProduto;

    @FXML
    private TableColumn<Produto, Double> columnValor;

    @FXML
    private TableColumn<Produto, String> columnTipo;

    @FXML
    private TableColumn<Produto, String> columnMarca;
    
    private List<Produto> listaProduto;
    private ObservableList<Produto> observableProduto;
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarTabela();
        
        buttonPesquisa.setOnMouseClicked((MouseEvent e)->{
           String tipo = textTipoPesquisa.getText();
            if(!tipo.isEmpty()){
                System.out.println("CAIU AQUI");
                 listaProduto = DAO.findByProdutoTipo(tipo);
              
                  carregarTabelaBusca();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Campo de pesquisa vazio!");
                alert.setContentText("O campo de pesquisa está vazio!Preencha.");
                
                alert.show();
            }
                
        
        });
        buttonPrincipal.setOnMouseClicked((MouseEvent  e)->{
           Principal principal = new Principal();
           principal.start(new Stage());
           Principal.getPrimaryStage().show();
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
          
        buttonVende.setOnMouseClicked((MouseEvent e)->{ 
                 Venda venda = new Venda();
                 venda.start(new Stage());
                 Venda.getPrimaryStage().show();
                 fechar();
       });
           
         buttonAtualizar.setOnMouseClicked((MouseEvent e)->{
             carregarTabela();
         
         });
         
        tabelaViewProduto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->selecionarItem(newValue));
    }
    private void carregarTabela(){
        columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnQuant.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        listaProduto = DAO.selectAll();
        
        observableProduto = FXCollections.observableArrayList(listaProduto);
        tabelaViewProduto.setItems(observableProduto);

    }
    private void carregarTabelaBusca(){
      columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnQuant.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        observableProduto = FXCollections.observableArrayList(listaProduto);
        tabelaViewProduto.setItems(observableProduto);
    
    }

    private void selecionarItem(Produto produto) {
          Editar editar = new Editar();
          EditarController.setProduto(produto);
                  
        try {
            editar.start(new Stage());
            Editar.getPrimaryStage().show();
            fechar();
        } catch (Exception ex) {
            Logger.getLogger(ConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

    private void fechar() {
        Consulta.getPrimaryStage().close();
    }
}
