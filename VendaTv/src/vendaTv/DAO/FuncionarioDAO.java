/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaTv.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import vendaTv.model.Funcionario;
import java.sql.ResultSet;
/**
 *
 * @author felipe
 */
public class FuncionarioDAO {
    public ArrayList<Funcionario> listarFuncionarios(String sqlX) throws ExceptionDAO{
    //public ArrayList<Funcionario> listarFuncionarios() throws ExceptionDAO{
               
        String sql = sqlX;
        Connection connection = null;
        PreparedStatement pStatement = null;
        ArrayList<Funcionario> funcionarios = null;
        
        try {
            connection = new ConnectionVendaTv().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet resultado = pStatement.executeQuery(sql);
            
            if (resultado!=null){
                funcionarios = new ArrayList<Funcionario>();
                while(resultado.next()){
                    Funcionario funcionario = new Funcionario();
                    funcionario.setIncricao(resultado.getInt("incricao"));
                    funcionario.setNome(resultado.getString("nome"));
                    funcionario.setSalario(resultado.getFloat("salario"));                    
                    funcionarios.add(funcionario);
                }                
            }            
        } catch (SQLException e){
            throw new ExceptionDAO("Erro ao consultar Funcionarios:"+ e);
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
        return funcionarios;        
    }    
}
