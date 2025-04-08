
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.CarroModel;
/**
 *
 * @author Vinicius Santiago
 */
public class ControllerArquivoTextoCarro extends ControllerArquivoTexto {
    private static final List<CarroModel> carros = new ArrayList<CarroModel>();
    protected CarroModel carro = new CarroModel();
   
    public void lerCarro(){
        setArquivo("Abrir");
        ler();
        String aux = getTexto();
        
        StringTokenizer tokens = new StringTokenizer(aux, ";");
        carros.removeAll(carros);
        for(int t = tokens.countTokens()/3; t > 0; t--){
            CarroModel i = new CarroModel();     
            i.setId(Integer.valueOf(tokens.nextToken()));
            i.setNome(tokens.nextToken().trim());
            i.setChassi(Integer.parseInt(tokens.nextToken()));
                                    
            carros.add(i);
        }
    }
    
    public int countId(){
        int count = 0;
        if(carros !=null){
           count = carros.size();
        }
        return count;
    }
    
    
    public CarroModel buscarCarro(int id) {        
        for(CarroModel i: carros){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

    public void gravarCarro() {
        int id = countId();
        String aux =  id + ";" +carro.getNome() + ";" + carro.getChassi();
        setTexto(aux);
        if(getArquivo() == null){
            setArquivo("Salvar");
        }
        escrever(true);
        carros.add(carro);
    }
    
    public void editarCarro(int id) {
        CarroModel c = buscarCarro(id);
        if(!"".equals(carro.getNome())){
            c.setNome(carro.getNome());
        }
        if(carro.getChassi() != 0){
            c.setChassi(carro.getChassi());
        
        }
        clear();
        for(CarroModel car: carros){
            String aux = car.getId() + ";" +car.getNome() + ";" + car.getChassi() + ";" ;
            setTexto(aux);
            escrever(true);
        }
    }
    
    public void removeCarro(int id){ 
        CarroModel c = buscarCarro(id);
        carros.remove(c);
        clear();
        for(CarroModel car: carros){
            String aux = car.getId() + ";" + car.getNome() + ";" + car.getChassi() + ";" ;
            setTexto(aux);
            escrever(true);
        }
    }

    /**
     * @return the instrumento
     */
    public CarroModel getCarro() {
        return carro;
    }
    
    public List<CarroModel> getCarros() {
        return carros;
    }

    /**
     * @param carr the carro to set
     */
    public void setCarro(CarroModel carro) {
        this.carro = carro;
    }

/**
     * @param nome
     * @param chassi
     */
    public void setCarro(String nome, int chassi) {
        this.carro.setNome(nome);
        this.carro.setChassi(chassi);
    }    
}

