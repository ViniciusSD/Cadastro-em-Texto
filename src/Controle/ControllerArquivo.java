package Controle;

import java.io.File;
import javax.swing.JFileChooser;


public abstract class ControllerArquivo {
    protected File arquivo = null;

    public abstract boolean ler();
    public abstract boolean escrever(boolean append);

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(String TextoBotao) {
        arquivo = null;
        String pastainicial = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(pastainicial);
        try {
            if (chooser.showDialog(null, TextoBotao) == JFileChooser.APPROVE_OPTION) {
                arquivo = chooser.getSelectedFile();
            }
        } catch (Exception e) {
            System.err.println("Erro ao selecionar o arquivo: " + e.getMessage());
        }
    }
}

