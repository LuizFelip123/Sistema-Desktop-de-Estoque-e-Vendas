/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import DB.BancoDeDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author usuario
 */
public class Relatorio {


            

    public void gerar() throws JRException, SQLException{
    //pegar caminho arquivo
    
    //compila o relatório

    //estabelece conexão

          Connection con = DriverManager.getConnection( BancoDeDados.stringDeConexao , BancoDeDados.usuario, BancoDeDados.password ); 
          Statement stm = con.createStatement();
          String query = "select * from produto  order by quant desc";
          ResultSet rs = stm.executeQuery( query );
    //implementação da interface JRDataSource para DataSource ResultSet
         JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

    //executa o relatório
    //caminho da do arquivo jasper
        JasperPrint impressao = JasperFillManager.fillReport( "/home/usuario/NetBeansProjects/TesteRelatorio/build/classes/relatorio/PrimeiroRelatorio.jasper" , null, jrRS );

    //exibe o resultado
         JasperViewer viewer = new JasperViewer( impressao , false );
         viewer.setTitle("Estoque"); 
         viewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
         viewer.setVisible(true);
    }
    
  
}
