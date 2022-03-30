/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaTv.model;

import java.util.ArrayList;
import vendaTv.DAO.ExceptionDAO;
import vendaTv.DAO.FuncionarioDAO;

/**
 *
 * @author felipe
 */
public class Funcionario {
    private Integer incricao;
    private String nome;
    private float salario;
    
    public Funcionario(){
    }
    
    public Integer getIncricao() {        
        return incricao;
    }

    public String getNome() {
        return nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setIncricao(Integer incricao) {
        this.incricao = incricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public ArrayList<Funcionario> listarFuncionarios(String sqlX) throws ExceptionDAO{
        return new FuncionarioDAO().listarFuncionarios(sqlX);
    }
    
}
