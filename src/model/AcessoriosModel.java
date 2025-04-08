/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vinis
 */
public class AcessoriosModel {
    
    private int id;
    private String nome;
    private int preco;
    
    public AcessoriosModel(int id, int preco, String nome){
        this.preco = preco;
        this.id = id;
        this.nome = nome; 
    }
    
    public AcessoriosModel(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
    
    
}
