/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author vinis
 */
public class PneuModel {

  
    protected int id;
    protected  int aro;
    protected  String marca;
    protected  int tamanho;
    
    public PneuModel(int id, int aro, int tamanho , String marca){
        this.id = id;
        this.aro = aro;
        this.marca = marca;
        this.tamanho = tamanho;
    }
    
    public PneuModel(){
        
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

  
    
}
