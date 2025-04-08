package Controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Vinicius
 */
public class ControllerArquivoTexto extends ControllerArquivo {

    private String texto = null;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean ler() {
        StringBuilder line = new StringBuilder();
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            while (leitor.ready()) {
                line.append(leitor.readLine()).append("\n");
            }
            setTexto(line.toString());
            return true;
        } catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado: " + erro.getMessage());
        } catch (IOException erro) {
            System.err.println("Erro ao ler arquivo: " + erro.getMessage());
        }
        return false;
    }

    @Override
    public boolean escrever(boolean append) {
        if (arquivo == null) {
            System.err.println("Arquivo não definido.");
            return false;
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, append))) {
            escritor.write(getTexto());
            return true;
        } catch (IOException erro) {
            System.err.println("Erro ao escrever no arquivo: " + erro.getMessage());
        }
        return false;
    }

    public boolean clear() {
        if (arquivo == null) {
            System.err.println("Arquivo não definido.");
            return false;
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))) {
            return true;
        } catch (IOException erro) {
            System.err.println("Erro ao limpar o arquivo: " + erro.getMessage());
        }
        return false;
    }
}
