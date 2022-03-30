/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaTv.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vendaTv.controller.VendaController;
import vendaTv.model.Venda;


/**
 *
 * @author felipe
 */
public class VendaDAO {
    
    //Criando logica de negocio da venda
    public ArrayList<Venda> listarVendas(String sqlX) throws ExceptionDAO{
               
        String sql = sqlX;
        Connection connection = null;
        PreparedStatement pStatement = null;
        ArrayList<Venda> vendas = null;
        
        try {
            connection = new ConnectionVendaTv().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet resultado = pStatement.executeQuery(sql);
            
            if (resultado!=null){
                vendas = new ArrayList<Venda>();
                while(resultado.next()){
                    Venda venda = new Venda();
                    venda.setId_venda(resultado.getInt("id_venda"));
                    venda.setIncricaoFunc(resultado.getInt("incricao_func"));
                    venda.setPreco(resultado.getFloat("preco"));
                    venda.setTipoTv(resultado.getString("tipo_tv"));
                    vendas.add(venda);
                }                
            }            
        } catch (SQLException e){
            throw new ExceptionDAO("Erro ao consultar Vendas:"+ e);
        }finally{
            try{
                if(pStatement!=null) {pStatement.close();}
            }catch(SQLException e){
                throw new ExceptionDAO("Erro ao fechar pStatement:"+ e);
            }            
            try{
                if(connection!=null) {connection.close();}
            }catch(SQLException e){
                throw new ExceptionDAO("Erro ao fechar Conexão:"+ e);
            }            
        }
        return vendas;        
    }    
}
