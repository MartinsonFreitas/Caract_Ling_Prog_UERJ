package contas;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta c) {
        this.contas.add(c);
    }

    public int getQuantidadeContas() {
        return this.contas.size();
    }

    public void imprimirTodasContas() {
        System.out.println("--- Contas no Banco ---");
        for (Conta c : contas) {
            System.out.println(c);
        }
        System.out.println("------------------------");
    }

    public Conta getContaPorNumero(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null; // Conta não encontrada
    }
}
