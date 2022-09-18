/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import revisaobd.Principal;
import revisaobd.Venda;

/**
 *
 * @author usuario
 */
public class VendaController implements Initializable {
     @FXML
    private TableView<Produto> tableViewProduto;

    @FXML
    private TableColumn<Produto, Double> columnValor;
    
    @FXML
    private TableColumn<Produto, Integer> columnCod;
    @FXML
    private TableColumn<Produto, String> columnTipo;
    
    @FXML
    private TableColumn<Produto, String> columnMarca;
    
    @FXML
    private Button buttonVoltar;
     
    @FXML
    private TextField textValorProdutos;

    @FXML
    private Button buttonVenderProdutos;
   
    @FXML
    private Button buttonBuscar;

    @FXML
    private TextField textValorCliente;

    @FXML
    private TextField textCodigo;

    @FXML
    private Button buttonTroco;
    @FXML
    private TextField textQuantidade;
    @FXML
    private TextField textTroco;
    @FXML
    private Button buttonRemover;
    private List<Produto> listaProduto = new ArrayList<>();
    private ObservableList<Produto> observableProduto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      textValorProdutos.setText("R$ "+String.valueOf(0));

        buttonVoltar.setOnMouseClicked((MouseEvent e)->{
          
            Principal principal = new Principal();
            principal.start(new Stage());
            Principal.getPrimaryStage().show();
            Venda.getPrimaryStage().close();
        });
        
        buttonBuscar.setOnMouseClicked((MouseEvent e)->{
           
          Produto produto =  DAO.findByProdutoCod(Integer.parseInt(textCodigo.getText()));
          int quant=Integer.parseInt(textQuantidade.getText());
          double valor = Double.valueOf(textValorProdutos.getText().replace("R$", ""));
            for (Produto produto1 : listaProduto) {
                if(produto1.getCodigo() == produto.getCodigo()){
                    quant = quant + 1; 
                }
            }
 
           
          if(quant <= produto.getQuantidade() && quant !=0 ){
            int i =0;
              while(i< Integer.parseInt(textQuantidade.getText())){
                  System.out.println(produto.toString());
                  listaProduto.add( new Produto(produto.getCodigo(), produto.getMarca(), produto.getValor(),produto.getTipo(),produto.getQuantidade()));
                  
                  i++;
                  valor = valor+produto.getValor();
                  textValorProdutos.setText("R$ "+String.valueOf(valor));
              }

          }else{
          
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro!");
                alert.setTitle("Erro");
                alert.setContentText("Não há produto no estoque!");
                alert.show();
          }
            initTableView();
      

        });
        buttonRemover.setOnMouseClicked((MouseEvent e)->{
        
            remover();
        
        });
        
        buttonTroco.setOnMouseClicked((MouseEvent e)->{
          double valorCliente = Double.parseDouble(textValorCliente.getText());
          double valorProduto = Double.parseDouble(textValorProdutos.getText().replace("R$", ""));
          textTroco.setText("R$ "+String.valueOf(valorCliente-valorProduto));
        });
        
       buttonVenderProdutos.setOnMouseClicked((MouseEvent e)->{
          if(!listaProduto.isEmpty()){ 
           int quant =0;
          
           for (Produto produto : listaProduto) {
               for (int j = 0; j < listaProduto.size(); j++) {
                   Produto get = listaProduto.get(j);
                   if(produto.getCodigo() == get.getCodigo()){
                       quant++;
                  }
                   
               }
              
               produto.setQuantidade(produto.getQuantidade()-quant);
               DAO.update(produto);
               quant = 0;
           }
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Venda realizada");
           alert.setHeaderText("A venda foi realizada!");
           alert.show();
           listaProduto.clear();
           initTableView();
          
          }else{
              Alert erro = new Alert(Alert.AlertType.ERROR);
              erro.setTitle("Aviso");
              erro.setHeaderText("A lista de compras está vazia!");
              erro.show();
          }
       });
       

        initTableView();
       
    }
    
    private void initTableView(){
        
               
        columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        observableProduto = FXCollections.observableArrayList(listaProduto);
        tableViewProduto.setItems(observableProduto);

    }
    private void remover(){
      Produto produto = tableViewProduto.getSelectionModel().getSelectedItem();
      
      double itemValor = Double.parseDouble( textValorProdutos.getText().replace("R$", ""));
       itemValor = itemValor- produto.getValor();
       textValorProdutos.setText("R$ "+String.valueOf(itemValor));
      listaProduto.remove(produto);
      observableProduto.remove(produto);
      tableViewProduto.setItems(observableProduto);
    }
}
