package Controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import Modelo.Compra;


/**
 *
 * @author Vinicius
 */
public class ControllerArquivoTextoCompra extends ControllerArquivoTexto {

    private static final List<Compra> compras = new ArrayList<>();
    protected Compra compra = new Compra();

    public void lerCompras() {
        try {
            setArquivo("Abrir");
            if (ler()) {
                String aux = getTexto();
                StringTokenizer tokens = new StringTokenizer(aux, ";");
                compras.clear();
                while (tokens.hasMoreTokens()) {
                    Compra i = new Compra();
                    i.setId(Integer.parseInt(tokens.nextToken()));
                    i.setProduto(tokens.nextToken());
                    i.setPreco(Double.parseDouble(tokens.nextToken()));
                    i.setCliente(tokens.nextToken());
                    compras.add(i);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro de formatação dos dados da compra: " + e.getMessage());
        }
    }

    public int countId() {
        return compras.size();
    }

    public Compra buscarCompra(int id) {
        return compras.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void gravarCompra() {
        try {
            int id = countId();
            String aux = id + ";" + compra.getProduto() + ";" + compra.getPreco() + ";" + compra.getCliente() + ";";
            setTexto(aux);
            if (getArquivo() == null) {
                setArquivo("Salvar");
            }
            if (escrever(true)) {
                compras.add(compra);
            }
        } catch (Exception e) {
            System.err.println("Erro ao gravar compra: " + e.getMessage());
        }
    }

    public void editarCompra(int id) {
        Compra i = buscarCompra(id);
        if (i != null) {
            try {
                if (!compra.getProduto().isEmpty()) {
                    i.setProduto(compra.getProduto());
                }
                if (compra.getPreco() != 0) {
                    i.setPreco(compra.getPreco());
                }
                if (!compra.getCliente().isEmpty()) {
                    i.setCliente(compra.getCliente());
                }
                clear();
                for (Compra in : compras) {
                    String aux = in.getId() + ";" + in.getProduto() + ";" + in.getPreco() + ";" + in.getCliente() + ";";
                    setTexto(aux);
                    escrever(true);
                }
            } catch (Exception e) {
                System.err.println("Erro ao editar compra: " + e.getMessage());
            }
        }
    }

    public void removeCompra(int id) {
        try {
            Compra i = buscarCompra(id);
            if (i != null) {
                compras.remove(i);
                clear();
                for (Compra in : compras) {
                    String aux = in.getId() + ";" + in.getProduto() + ";" + in.getPreco() + ";" + in.getCliente() + ";";
                    setTexto(aux);
                    escrever(true);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao remover compra: " + e.getMessage());
        }
    }

    public Compra getCompra() {
        return compra;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    /**
     * @param compra the cliente to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * @param produto
     * @param preco
     * @param cliente
     */
    public void setCompra(String produto, double preco, String cliente) {
        this.compra.setProduto(produto);
        this.compra.setPreco(preco);
        this.compra.setCliente(cliente);
    }
}
