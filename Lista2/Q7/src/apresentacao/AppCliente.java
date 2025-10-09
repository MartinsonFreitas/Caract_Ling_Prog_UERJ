package apresentacao;

import negocio.Contato;
import persistencia.ContatoDAO;
import persistencia.IContatoDAO;
import java.util.List;
import java.util.Scanner;

public class AppCliente {

    public static void main(String[] args) {
        IContatoDAO dao = new ContatoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Menu Agenda de Contatos ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Todos os Contatos");
            System.out.println("3. Buscar Contato por ID");
            System.out.println("4. Atualizar Contato");
            System.out.println("5. Deletar Contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        adicionarContato(dao, scanner);
                        break;
                    case 2:
                        listarContatos(dao);
                        break;
                    case 3:
                        buscarContatoPorId(dao, scanner);
                        break;
                    case 4:
                        atualizarContato(dao, scanner);
                        break;
                    case 5:
                        deletarContato(dao, scanner);
                        break;
                    case 0:
                        System.out.println("Saindo da agenda...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Por favor, digite um número.");
            } catch (Exception e) {
                System.err.println("Ocorreu um erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    private static void adicionarContato(IContatoDAO dao, Scanner scanner) {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Celular: ");
        String celular = scanner.nextLine();
        System.out.print("Tipo (trabalho, família, amigos, etc.): ");
        String tipo = scanner.nextLine();

        Contato novoContato = new Contato(id, nome, sobrenome, email, celular, tipo);
        dao.salvar(novoContato);
    }

    private static void listarContatos(IContatoDAO dao) {
        List<Contato> contatos = dao.getAll();
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.println("\n--- Lista de Contatos ---");
            for (Contato c : contatos) {
                System.out.println(c);
            }
            System.out.println("-------------------------");
        }
    }

    private static void buscarContatoPorId(IContatoDAO dao, Scanner scanner) {
        System.out.print("Digite o ID do contato a buscar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Contato contato = dao.getById(id);
        if (contato != null) {
            System.out.println("Contato encontrado: " + contato);
        } else {
            System.out.println("Contato com ID " + id + " não encontrado.");
        }
    }

    private static void atualizarContato(IContatoDAO dao, Scanner scanner) {
        System.out.print("Digite o ID do contato a atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Contato contatoExistente = dao.getById(id);

        if (contatoExistente != null) {
            System.out.println("Contato atual: " + contatoExistente);
            System.out.print("Novo Nome (deixe em branco para manter: " + contatoExistente.getNome() + "): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) contatoExistente.setNome(nome);

            System.out.print("Novo Sobrenome (deixe em branco para manter: " + contatoExistente.getSobrenome() + "): ");
            String sobrenome = scanner.nextLine();
            if (!sobrenome.isEmpty()) contatoExistente.setSobrenome(sobrenome);

            System.out.print("Novo E-mail (deixe em branco para manter: " + contatoExistente.getEmail() + "): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) contatoExistente.setEmail(email);

            System.out.print("Novo Celular (deixe em branco para manter: " + contatoExistente.getCelular() + "): ");
            String celular = scanner.nextLine();
            if (!celular.isEmpty()) contatoExistente.setCelular(celular);

            System.out.print("Novo Tipo (deixe em branco para manter: " + contatoExistente.getTipo() + "): ");
            String tipo = scanner.nextLine();
            if (!tipo.isEmpty()) contatoExistente.setTipo(tipo);

            dao.atualizar(contatoExistente);
        } else {
            System.out.println("Contato com ID " + id + " não encontrado para atualização.");
        }
    }

    private static void deletarContato(IContatoDAO dao, Scanner scanner) {
        System.out.print("Digite o ID do contato a deletar: ");
        int id = Integer.parseInt(scanner.nextLine());
        dao.deletar(id);
    }
}
