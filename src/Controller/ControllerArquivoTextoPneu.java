/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.PneuModel;

/**
 *
 * @author vinis
 */
public class ControllerArquivoTextoPneu extends ControllerArquivoTexto{
    private static final List<PneuModel> pneus = new ArrayList<PneuModel>();
    protected PneuModel pneu = new PneuModel();
    public void lerPneus() {
        setArquivo("Abrir");
        ler();
        String aux = getTexto();

        StringTokenizer tokens = new StringTokenizer(aux, ";");
        pneus.removeAll(pneus);
        for(int t = tokens.countTokens()/4; t > 0; t--){
            PneuModel c = new PneuModel();
            c.setId(Integer.valueOf(tokens.nextToken()));
            c.setAro(Integer.valueOf(tokens.nextToken())) ;
            c.setMarca(tokens.nextToken());
            c.setTamanho(Integer.valueOf(tokens.nextToken()));
            pneus.add(c);
        }
    }
    
    public int countId(){
        int count = 0;
        if(pneus !=null){
           count = pneus.size();
        }
        return count;
    }
    
    public PneuModel buscarPneu(int id) {
        for(PneuModel i: pneus){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }
    
     public void gravarPneu() {
        int id = countId();
        String aux = id + ";" + pneu.getMarca()+ ";" + pneu.getAro() + ";" + pneu.getTamanho()+ ";" ;
        setTexto(aux);
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        escrever(true);
        pneus.add(pneu);
    }
     
      public void editarPneu(int id) {
        PneuModel c = buscarPneu(id);
        if(!"".equals(pneu.getMarca())){
            c.setMarca(pneu.getMarca());
        }
        if(pneu.getAro()!= 0){
            c.setAro(pneu.getAro());
        }
        if(!"".equals(pneu.getTamanho())){
            c.setTamanho(pneu.getTamanho());
        }
        clear();
        for(PneuModel i: pneus){ //duvida
            String aux = i.getId() + ";"+ pneu.getMarca()+ ";" + pneu.getAro() + ";" + pneu.getTamanho()+ ";";
            setTexto(aux);
            escrever(true);
        }
    }
      
       public void removePneu(int id){ 
        PneuModel j = buscarPneu(id);
        pneus.remove(j);
        clear();
        for(int i = 0 ; i < pneus.size(); i++){
            pneu = pneus.get(i);
            String aux = pneu.getId() + ";"+ pneu.getMarca()+ ";" + pneu.getAro() + ";" + pneu.getTamanho()+ ";";
            setTexto(aux);
            escrever(true);
        }
    }
    
       public PneuModel getPneu() {
        return pneu;
    }
    
    public List<PneuModel> getPneus() {
        return pneus;
    }

    /**
     * @param pneu the pneu to set
     */
    public void setPneu(PneuModel pneu) {
        this.pneu = pneu;
    }

/**
     * @param aro
     * @param tamanho
     * @param marca
     */
    public void setPneu(int aro, int tamanho , String marca) {
        this.pneu.setAro(aro);
        this.pneu.setMarca(marca);
        this.pneu.setTamanho(tamanho);
    }    
    
}
