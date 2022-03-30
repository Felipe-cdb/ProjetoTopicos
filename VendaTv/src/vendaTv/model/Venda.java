/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaTv.model;

import java.util.ArrayList;
import vendaTv.DAO.ExceptionDAO;
import vendaTv.DAO.VendaDAO;

/**
 *
 * @author felipe
 */
public class Venda {
    private Integer id_venda;
    private Integer incricaoFunc;
    private String tipoTv;
    private float preco;

    public void setId_venda(Integer id_venda) {
        this.id_venda = id_venda;
    }

    public void setIncricaoFunc(Integer incricaoFunc) {
        this.incricaoFunc = incricaoFunc;
    }

    public void setTipoTv(String tipoTv) {
        this.tipoTv = tipoTv;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }    
    
    public Integer getId_venda() {
        return id_venda;
    }

    public Integer getIncricaoFunc() {
        return incricaoFunc;
    }

    public String getTipoTv() {
        return tipoTv;
    }

    public float getPreco() {
        return preco;
    }
   

    public ArrayList<Venda> listarVendas(String sqlX) throws ExceptionDAO{
        return new VendaDAO().listarVendas(sqlX);
    }
}
