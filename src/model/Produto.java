/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Produto implements  Serializable{
    private int codigo;
    private String marca;
    private double valor;
    private String tipo;
    private int quantidade;
    
    public Produto(){
    }
    public Produto(int codigo, String marca, double valor, String tipo, int quantidade){
        this.codigo = codigo;
        this.marca = marca;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.valor = valor;
        
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getCodigo() {
        return codigo;
    }
    

    public void setCodigo(int codigo) {
        this.codigo = codigo; 
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", marca=" + marca + ", valor=" + valor + ", tipo=" + tipo + ", quantidade=" + quantidade + '}';
    }

    
    
    
}
