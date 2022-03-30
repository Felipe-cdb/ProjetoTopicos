/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaTv.controller;

import java.util.ArrayList;
import vendaTv.DAO.ExceptionDAO;
import vendaTv.model.Venda;

/**
 *
 * @author felipe
 */
public class VendaController {
    private float comissao;
    private float somavendas;
    float salarioTotal;
    
    //Calcula a commissão de cada Tv e armazena todas a comissões
    public void comissaoTv(float precoUni, Integer qtdLCD, Integer qtdLED){
        float bonus = 0;
        
        //Comissão das Tvs de LED
        if (qtdLED>=10){
            bonus = precoUni*0.17f;
            comissao = comissao + bonus;
        } else{
            bonus = precoUni*0.12f;
            comissao = comissao + bonus;
        }
        
        //Comissão das Tvs de LCD
        if (qtdLCD>=20){
            bonus = precoUni*0.15f;
            comissao = comissao + bonus;
        } else{
            bonus = precoUni*0.10f;
            comissao = comissao + bonus;
        }
    }

    public float getComissao() {
        return comissao;
    }
            
    public void somaVendas(float precoUni){
        somavendas = somavendas + precoUni;
    }

    public float getSomavendas() {
        return somavendas;
    }
    
    //Função para limpar as comissões e o total das vendas
    public void zeraMemoria(){
        somavendas = 0;
        comissao = 0;
    }    
    
    //Função para efetuar os descontos em cima do salario + comissões
    public float impostos(float salario){
        float inss = 0;
        salarioTotal = 0;
        float descontoFinal = 0;
        float salarioComissao = 0;
        salarioComissao = salario+comissao;
        inss = salarioComissao * 0.08f;
        salarioTotal = salarioComissao - inss;
        if(salarioTotal>3000f){
            descontoFinal = salarioTotal*0.09f;
            salarioTotal = salarioTotal - descontoFinal;
        }
        return salarioTotal;               
    }
            
    public ArrayList<Venda> listarVendas(String sqlX) throws ExceptionDAO{
    return new Venda().listarVendas(sqlX);
    }
}
