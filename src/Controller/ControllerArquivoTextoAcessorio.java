/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.AcessoriosModel;



/**
 *
 * @author Vinicius Sanitago
 */
public class ControllerArquivoTextoAcessorio extends ControllerArquivoTexto{
    private static final List<AcessoriosModel> acessorios = new ArrayList<AcessoriosModel>();
    protected AcessoriosModel acessorio = new AcessoriosModel();
    
    
    public void lerAcessorio(){
        setArquivo("Abrir");
        ler();
        String aux = getTexto();
        
        StringTokenizer tokens = new StringTokenizer(aux, ";");
        acessorios.removeAll(acessorios);
        for(int t = tokens.countTokens()/3; t > 0; t--){
            AcessoriosModel i = new AcessoriosModel();     
            i.setId(Integer.valueOf(tokens.nextToken()));
            i.setPreco(Integer.valueOf(tokens.nextToken()));
            i.setNome(tokens.nextToken());            
            acessorios.add(i);
        }
    }
    
    public int countId(){
        int count = 0;
        if(acessorios !=null){
           count = acessorios.size();
        }
        return count;
    }
    
    
    public AcessoriosModel buscarAcessorio(int id) {        
        for(AcessoriosModel i: acessorios){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public void gravarAcessorio() {
        int id = countId();
        String aux =  id + ";" +acessorio.getNome() + ";" + acessorio.getPreco();
        setTexto(aux);
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        escrever(true);
        acessorios.add(acessorio);
    }
    
    public void editarAcessorio(int id) {
        AcessoriosModel a = buscarAcessorio(id);
        if(!"".equals(acessorio.getNome())){
            a.setNome(acessorio.getNome());
        }
        if(acessorio.getPreco()!= 0){
            a.setPreco(acessorio.getPreco());
        
        }
        clear();
        for(AcessoriosModel ace: acessorios){
            String aux = ace.getId() + ";" +ace.getNome() + ";" + ace.getPreco() + ";" ;
            setTexto(aux);
            escrever(true);
        }
    }
    
    public void removeAcessorio(int id){ 
        AcessoriosModel a = buscarAcessorio(id);
        acessorios.remove(a);
        clear();
        for(AcessoriosModel ac: acessorios){
            String aux = ac.getId() + ";" + ac.getNome() + ";" + ac.getPreco() + ";" ;
            setTexto(aux);
            escrever(true);
        }
    }

    /**
     * @return the instrumento
     */
    public AcessoriosModel getAcessorio() {
        return acessorio;
    }
    
    public List<AcessoriosModel> getAcessorios() {
        return acessorios;
    }

    /**
     * @param acessorio the acessorio to set
     */
    public void setAcessorio(AcessoriosModel acessorio) {
        this.acessorio = acessorio;
    }

/**
     * @param nome
     * @param idade
     */
    public void setAcessorios(String nome, int preco) {
        this.acessorio.setNome(nome);
        this.acessorio.setPreco(preco);
    }    

}
