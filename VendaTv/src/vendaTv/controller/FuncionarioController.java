/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaTv.controller;

import java.util.ArrayList;
import vendaTv.DAO.ExceptionDAO;
import vendaTv.model.Funcionario;

/**
 *
 * @author felipe
 */
public class FuncionarioController {
    public ArrayList<Funcionario> listarFuncionarios(String sqlX) throws ExceptionDAO{
        return new Funcionario().listarFuncionarios(sqlX);
    }
}
