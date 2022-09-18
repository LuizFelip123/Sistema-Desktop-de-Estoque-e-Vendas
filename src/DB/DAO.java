/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import model.Produto;

/**
 *
 * @author usuario
 */
public abstract class DAO {
    public static void save(Produto produto){
        Connection conexao =null;
        ResultSet resposta;
        PreparedStatement statement = null;
        try{
                    System.out.println(produto.toString());
    
        conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.password);
        String sql = "INSERT INTO produto (`cod`, `tipo`, `marca`, `quant`,  `valor`) VALUES (?,?,?,?,?);";
         statement = conexao.prepareStatement(sql);
         statement.setInt(1, produto.getCodigo());
         statement.setString(2, produto.getTipo());
         statement.setString(3, produto.getMarca());
         statement.setInt(4, produto.getQuantidade());
         statement.setDouble(5, produto.getValor());
         statement.execute();
        }catch(SQLException exececaoSQL){
                      exececaoSQL.getMessage();
          Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, exececaoSQL);
          exececaoSQL.printStackTrace();

        }finally{
        
            try {
                statement.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public static void delete(int cod){
        Connection conexao;
        PreparedStatement statement;
        try {
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.password);
            String sql = "DELETE FROM produto WHERE cod= ?;";
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, cod);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void update(Produto produto){
        Connection conexao;
        PreparedStatement statement;
        
        try {
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.password);
            String sql ="UPDATE produto SET tipo=  ?, marca= ?, valor=?, quant= ? WHERE cod= ?;";
            statement = conexao.prepareStatement(sql);
            
            statement.setString(1, produto.getTipo());
            statement.setString(2, produto.getMarca());
            statement.setDouble(3, produto.getValor());
            statement.setInt(4, produto.getQuantidade());
            statement.setInt(5, produto.getCodigo());
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
   public static Produto findByProdutoCod(int cod){
       Connection conexao;
       PreparedStatement statement;
       ResultSet result;
       Produto produto = new Produto();

        try {
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.password);
            String sql = "select * from produto WHERE cod = ?;";
            statement = conexao.prepareStatement(sql);
           statement.setInt(1, cod);
           result = statement.executeQuery();
            if(result.next()) {
               
                  produto.setCodigo(result.getInt("cod"));
                  produto.setMarca(result.getString("marca"));
                  produto.setQuantidade(result.getInt("quant"));
                  produto.setTipo(result.getString("tipo"));
                  produto.setValor(result.getDouble("valor")); 
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Cod inválido");
            }
  
                            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       return produto;
   
   }  
   public static List<Produto> selectAll(){
       List<Produto> produtos = new ArrayList<>();
       Connection conexao =null;
        ResultSet resposta;
        PreparedStatement statement = null;
        try{
    
        conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.password);
         String  sql ="SELECT * FROM produto Order by cod asc;";

         statement = conexao.prepareStatement(sql);
         resposta = statement.executeQuery();


         while(resposta.next()){
                Produto produto = new Produto();
                produto.setCodigo(resposta.getInt("cod"));
                produto.setMarca(resposta.getString("marca"));
                produto.setQuantidade(resposta.getInt("quant"));
                produto.setTipo(resposta.getString("tipo"));
                produto.setValor(resposta.getDouble("valor"));
                
                produtos.add(produto);
                
            }
        }catch(SQLException exececaoSQL){
                      exececaoSQL.getMessage();
          Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, exececaoSQL);

        }finally{
        
            try {
                statement.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       return produtos;
   }
   }

public static List<Produto> findByProdutoTipo(String tipo){
    Connection conexao = null;
    ResultSet result = null;
    PreparedStatement statement = null;
    List produtos = new ArrayList<Produto>();
    
        try {
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.password);
            String sql = "SELECT * FROM produto WHERE tipo = ?";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, tipo);
            result = statement.executeQuery();
            while (result.next()) {
                Produto produto = new Produto();
                produto.setCodigo(result.getInt("cod"));
                produto.setMarca(result.getString("marca"));
                produto.setQuantidade(result.getInt("quant"));
                produto.setTipo(result.getString("tipo"));
                produto.setValor(result.getDouble("valor"));
                produtos.add(produto);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                 statement.close();

                  conexao.close();
            
              } catch (SQLException ex) {
                     Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
              }
        
        }
            
       return produtos;

}       
    
}
