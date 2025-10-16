package view;

import model.*;
import controller.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Gerente gerente = new Gerente("Carlos", "12345678900");
        Bliblioteca biblioteca = new Bliblioteca("Biblioteca Central", "Rua A, 123", new ArrayList<>(), gerente);
        BlibliotecaController bController = new BlibliotecaController(biblioteca);
        EmprestimoController eController = new EmprestimoController();

        int opcao = -1;
        while(opcao != 0) {
            System.out.println("\n=== MENU BIBLIOTECA ===");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuário");
            System.out.println("3 - Listar Livros Disponíveis");
            System.out.println("4 - Realizar Empréstimo");
            System.out.println("5 - Listar Empréstimos");
            System.out.println("6 - Devolver Livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("Título do livro: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    bController.adicionarLivro(titulo, autor);
                    break;
                case 2:
                    System.out.print("Nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Tipo (1-Comum, 2-VIP): ");
                    int tipo = sc.nextInt(); sc.nextLine();
                    Carterinha carteirinha = new Carterinha("CARTEIRA" + (int)(Math.random()*1000), LocalDate.now().plusYears(1));
                    Usuario usuario;
                    if(tipo == 1)
                        usuario = new UsuarioComum(bController.listarUsuarios().size()+1, nome, email, carteirinha);
                    else
                        usuario = new UsuarioVip(bController.listarUsuarios().size()+1, nome, email, carteirinha, 0.2);
                    bController.cadastrarUsuario(usuario);
                    break;
                case 3:
                    List<Livro> livros = bController.listarLivrosDisponiveis();
                    System.out.println("Livros disponíveis:");
                    for(int i=0; i<livros.size(); i++)
                        System.out.println((i+1) + " - " + livros.get(i).getTitulo());
                    break;
                case 4:
                    List<Usuario> usuarios = bController.listarUsuarios();
                    for(int i=0; i<usuarios.size(); i++)
                        System.out.println((i+1) + " - " + usuarios.get(i).getNome());
                    System.out.print("Escolha usuário: ");
                    int uIndex = sc.nextInt() - 1;
                    List<Livro> livrosDisp = bController.listarLivrosDisponiveis();
                    for(int i=0; i<livrosDisp.size(); i++)
                        System.out.println((i+1) + " - " + livrosDisp.get(i).getTitulo());
                    System.out.print("Escolha livro: ");
                    int lIndex = sc.nextInt() - 1;
                    eController.realizarEmprestimo(usuarios.get(uIndex), livrosDisp.get(lIndex));
                    break;
                case 5:
                    List<Emprestimo> emprestimos = eController.listarEmprestimos();
                    System.out.println("Empréstimos:");
                    for(Emprestimo emp : emprestimos)
                        System.out.println(emp.getUsuario().getNome() + " -> " + emp.getLivro().getTitulo());
                    break;
                case 6:
                    List<Emprestimo> emps = eController.listarEmprestimos();
                    for(int i=0; i<emps.size(); i++)
                        System.out.println((i+1) + " - " + emps.get(i).getLivro().getTitulo() +
                                           " (Usuário: " + emps.get(i).getUsuario().getNome() + ")");
                    System.out.print("Escolha empréstimo para devolver: ");
                    int empIndex = sc.nextInt() - 1;
                    eController.devolverLivro(emps.get(empIndex));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}
