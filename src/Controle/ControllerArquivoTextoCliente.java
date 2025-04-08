package Controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import Modelo.Cliente;

/**
 *
 * @author Vinicius
 */
public class ControllerArquivoTextoCliente extends ControllerArquivoTexto {

    private static final List<Cliente> clientes = new ArrayList<>();
    protected Cliente cliente = new Cliente();

    public void lerClientes() {
        try {
            setArquivo("Abrir");
            if (ler()) {
                String aux = getTexto();
                StringTokenizer tokens = new StringTokenizer(aux, ";");
                clientes.clear();
                while (tokens.hasMoreTokens()) {
                    Cliente i = new Cliente();
                    i.setId(Integer.parseInt(tokens.nextToken()));
                    i.setNome(tokens.nextToken());
                    i.setIdade(Integer.parseInt(tokens.nextToken()));
                    i.setEmail(tokens.nextToken());
                    clientes.add(i);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter dados de cliente: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao ler clientes: " + e.getMessage());
        }
    }

    public int countId() {
        return clientes.size();
    }

    public Cliente buscarCliente(int id) {
        try {
            return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        } catch (Exception e) {
            System.err.println("Erro ao buscar cliente: " + e.getMessage());
            return null;
        }
    }

    public void gravarCliente() {
        try {
            int id = countId();
            String aux = id + ";" + cliente.getNome() + ";" + cliente.getIdade() + ";" + cliente.getEmail() + ";";
            setTexto(aux);
            if (getArquivo() == null) {
                setArquivo("Salvar");
            }
            if (escrever(true)) {
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.err.println("Erro ao gravar cliente: " + e.getMessage());
        }
    }

    public void editarCliente(int id) {
        try {
            Cliente i = buscarCliente(id);
            if (i != null) {
                if (!cliente.getNome().isEmpty()) i.setNome(cliente.getNome());
                if (cliente.getIdade() != 0) i.setIdade(cliente.getIdade());
                if (!cliente.getEmail().isEmpty()) i.setEmail(cliente.getEmail());

                clear();
                for (Cliente in : clientes) {
                    String aux = in.getId() + ";" + in.getNome() + ";" + in.getIdade() + ";" + in.getEmail() + ";";
                    setTexto(aux);
                    escrever(true);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao editar cliente: " + e.getMessage());
        }
    }

    public void removeCliente(int id) {
        try {
            Cliente i = buscarCliente(id);
            if (i != null) {
                clientes.remove(i);
                clear();
                for (Cliente in : clientes) {
                    String aux = in.getId() + ";" + in.getNome() + ";" + in.getIdade() + ";" + in.getEmail() + ";";
                    setTexto(aux);
                    escrever(true);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    /**
     * @return the iten
     */
    public Cliente getCliente(){
        return cliente;
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

/**
     * @param nome
     * @param idade
     * @param email
     */
    public void setCliente(String nome, int idade, String email) {
        this.cliente.setNome(nome);
        this.cliente.setIdade(idade);
        this.cliente.setEmail(email);
    }    
    
}
