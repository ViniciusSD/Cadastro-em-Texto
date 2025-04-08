package Controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import Modelo.Itens;

/**
 *
 * @author Vinicius
 */

public class ControllerArquivoTextoItens extends ControllerArquivoTexto {

    private static final List<Itens> itens = new ArrayList<>();
    protected Itens iten = new Itens();

    public void lerItens() {
        try {
            setArquivo("Abrir");
            if (ler()) {
                String aux = getTexto();
                StringTokenizer tokens = new StringTokenizer(aux, ";");
                itens.clear();
                while (tokens.hasMoreTokens()) {
                    Itens i = new Itens();
                    i.setId(Integer.parseInt(tokens.nextToken()));
                    i.setNome(tokens.nextToken());
                    i.setPreco(Double.parseDouble(tokens.nextToken()));
                    i.setDescricao(tokens.nextToken());
                    itens.add(i);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro de formatação dos dados do item: " + e.getMessage());
        }
    }

    public int countId() {
        return itens.size();
    }

    public Itens buscarItens(int id) {
        return itens.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void gravarItens() {
        try {
            int id = countId();
            String aux = id + ";" + iten.getNome() + ";" + iten.getPreco() + ";" + iten.getDescricao() + ";";
            setTexto(aux);
            if (getArquivo() == null) {
                setArquivo("Salvar");
            }
            if (escrever(true)) {
                itens.add(iten);
            }
        } catch (Exception e) {
            System.err.println("Erro ao gravar item: " + e.getMessage());
        }
    }

    public void editarItens(int id) {
        Itens i = buscarItens(id);
        if (i != null) {
            try {
                if (!iten.getNome().isEmpty()) {
                    i.setNome(iten.getNome());
                }
                if (iten.getPreco() != 0) {
                    i.setPreco(iten.getPreco());
                }
                if (!iten.getDescricao().isEmpty()) {
                    i.setDescricao(iten.getDescricao());
                }
                clear();
                for (Itens in : itens) {
                    String aux = in.getId() + ";" + in.getNome() + ";" + in.getPreco() + ";" + in.getDescricao() + ";";
                    setTexto(aux);
                    escrever(true);
                }
            } catch (Exception e) {
                System.err.println("Erro ao editar item: " + e.getMessage());
            }
        }
    }

    public void removeItens(int id) {
        try {
            Itens i = buscarItens(id);
            if (i != null) {
                itens.remove(i);
                clear();
                for (Itens in : itens) {
                    String aux = in.getId() + ";" + in.getNome() + ";" + in.getPreco() + ";" + in.getDescricao() + ";";
                    setTexto(aux);
                    escrever(true);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao remover item: " + e.getMessage());
        }
    }
    
    /**
     * @return the instrumento
     */

    public Itens getIten() {
        return iten;
    }

    public List<Itens> getItens() {
        return itens;
    }

     /**
     * @param instrumento the cliente to set
     */
    public void setItens(Itens iten) {
        this.iten = iten;
    }

    /**
     * @param nome
     * @param preco
     * @param descricao
     */
    public void setItens(String nome, double preco, String descricao) {
        this.iten.setNome(nome);
        this.iten.setPreco(preco);
        this.iten.setDescricao(descricao);
    }
}
