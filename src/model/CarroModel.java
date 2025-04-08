/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vinis
 */
public class CarroModel {
    
    private int id;
    private int chassi;
    private String nome;
   
    public CarroModel(int chassi, int id, String nome){
        this.chassi = chassi;
        this.id = id;
        this.nome = nome; 
    }
    
    public CarroModel(){
        
    }
    
    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
