package q7Persistencia;

import q7Negocio.Contato;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContatoDAO implements IContatoDAO {
    private static final String ARQUIVO_CONTATOS = "contatos.txt";

    private List<Contato> carregarContatosDoArquivo() {
        List<Contato> contatos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_CONTATOS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                try {

                	// Separador ","
                    String[] parts = linha.split(",");
                    if (parts.length == 6) {
                        int id = Integer.parseInt(parts[0].trim());
                        String nome = parts[1].trim().replaceAll("^\"|\"$", "");
                        String sobrenome = parts[2].trim().replaceAll("^\"|\"$", "");
                        String email = parts[3].trim().replaceAll("^\"|\"$", "");
                        String celular = parts[4].trim().replaceAll("^\"|\"$", "");
                        String tipo = parts[5].trim().replaceAll("^\"|\"$", "");
                        contatos.add(new Contato(id, nome, sobrenome, email, celular, tipo));
                    } else {
                        System.err.println("Erro: Linha com formato inválido: " + linha);
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao parsear linha do arquivo: " + linha + " - " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de contatos não encontrado. Será criado um novo.");
        } catch (IOException e) {
            System.err.println("Erro de leitura do arquivo de contatos: " + e.getMessage());
        }
        return contatos;
    }

    private void salvarContatosNoArquivo(List<Contato> contatos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_CONTATOS))) {
            for (Contato c : contatos) {
                bw.write(c.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro de escrita no arquivo de contatos: " + e.getMessage());
        }
    }

    @Override
    public void salvar(Contato c) {
        List<Contato> contatos = carregarContatosDoArquivo();
        // Verifica se já existe um contato com o mesmo ID para evitar duplicidade ou sobrescrever
        boolean idExiste = contatos.stream().anyMatch(contato -> contato.getId() == c.getId());
        if (idExiste) {
            System.out.println("Erro: Já existe um contato com o ID " + c.getId() + ". Não foi possível salvar.");
            return;
        }
        contatos.add(c);
        salvarContatosNoArquivo(contatos);
        System.out.println("Contato salvo: " + c.getNome());
    }

    @Override
    public void atualizar(Contato c) {
        List<Contato> contatos = carregarContatosDoArquivo();
        boolean encontrado = false;
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getId() == c.getId()) {
                contatos.set(i, c);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            salvarContatosNoArquivo(contatos);
            System.out.println("Contato atualizado: " + c.getNome());
        } else {
            System.out.println("Erro: Contato com ID " + c.getId() + " não encontrado para atualização.");
        }
    }

    @Override
    public void deletar(int id) {
        List<Contato> contatos = carregarContatosDoArquivo();
        List<Contato> contatosFiltrados = contatos.stream()
                                                .filter(c -> c.getId() != id)
                                                .collect(Collectors.toList());
        if (contatosFiltrados.size() < contatos.size()) {
            salvarContatosNoArquivo(contatosFiltrados);
            System.out.println("Contato com ID " + id + " deletado.");
        } else {
            System.out.println("Erro: Contato com ID " + id + " não encontrado para exclusão.");
        }
    }

    @Override
    public Contato getById(int id) {
        List<Contato> contatos = carregarContatosDoArquivo();
        return contatos.stream()
                       .filter(c -> c.getId() == id)
                       .findFirst()
                       .orElse(null);
    }

    @Override
    public List<Contato> getAll() {
        return carregarContatosDoArquivo();
    }
}