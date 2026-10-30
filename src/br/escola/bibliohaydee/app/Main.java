
package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Autor> autores = new ArrayList<>();
    static List<Livro> livros = new ArrayList<>();
    static List<Usuario> usuarios = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        Autor antoine = cadastrarAutor(
                "Antoine de Saint-Exupéry", "Francesa", 1900);

        Autor machado = cadastrarAutor(
                "Machado de Assis", "Brasileira", 1839);

        Autor tolkien = cadastrarAutor(
                "J. R. R. Tolkien", "Britânica", 1892);

        Autor rowling = cadastrarAutor(
                "J. K. Rowling", "Britânica", 1965);

        Autor felipeNeto = cadastrarAutor(
                "Felipe Neto", "Brasileira", 1988);

        Autor orwell = cadastrarAutor(
                "George Orwell", "Britânica", 1903);

        Autor lobato = cadastrarAutor(
                "Monteiro Lobato", "Brasileira", 1882);


        cadastrarLivro(
                "O Pequeno Príncipe", "978-85-325-3155-1",
                antoine, 1943, "Fábula");

        cadastrarLivro(
                "Dom Casmurro", "978-857-799-171-6",
                machado, 1899, "Romance");

        cadastrarLivro(
                "O Hobbit", "9788595086081",
                tolkien, 1937, "Fantasia");

        cadastrarLivro(
                "Harry Potter e a Pedra Filosofal", "9788532530271",
                rowling, 1997, "Fantasia");

        cadastrarLivro(
                "Como enfrentar o ódio", "978-85-359-3891-3",
                felipeNeto, 2024, "Autobiografia");

        cadastrarLivro(
                "1984", "9786557390016",
                orwell, 1949, "Ficção distópica");

        cadastrarLivro(
                "O Sítio do Picapau Amarelo", "9788511300055",
                lobato, 1920, "Infantojuvenil");


        menu();
    }

    static void menu() {

        while (true) {

            System.out.println("\n===== BIBLIOTECA BIBLIOHAYDEE =====");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Pesquisar livros");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Atualizar usuário");
            System.out.println("5 - Listar usuários");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {

                case "1":
                    listarLivros();
                    break;

                case "2":
                    pesquisarLivro();
                    break;

                case "3":
                    lerUsuario();
                    break;

                case "4":
                    atualizarUsuario(scanner);
                    break;

                case "5":
                    listarUsuarios();
                    break;

                case "0":
                    System.out.println("Encerrando a BiblioHaydee...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    static Autor cadastrarAutor(
            String nome, String nacionalidade, int anoNascimento) {

        if (nome == null || nome.isBlank()) {
            System.out.println("Erro: nome do autor não pode ser vazio.");
            return null;
        }

        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);
        autor.setAnoNascimento(anoNascimento);

        autores.add(autor);

        System.out.println("Autor cadastrado: " + autor);

        return autor;
    }

    static void cadastrarLivro(
            String titulo, String isbn, Autor autor,
            int ano, String genero) {

        if (autor == null || !autores.contains(autor)) {
            System.out.println("Erro: autor não cadastrado.");
            return;
        }

        Livro livro = new Livro(titulo, isbn, autor, ano, genero);

        livros.add(livro);

        System.out.println("Livro cadastrado: " + livro);
    }

    static void listarLivros() {

        System.out.println("\n===== ACERVO DA BIBLIOHAYDEE =====");

        if (livros.isEmpty()) {
            System.out.println("O acervo está vazio.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    static void pesquisarLivro() {

        System.out.println("\n===== PESQUISA DE LIVROS =====");
        System.out.println("1 - Pesquisar por título");
        System.out.println("2 - Pesquisar por autor");
        System.out.println("3 - Pesquisar por gênero");

        System.out.print("Escolha uma opção: ");
        String entrada = scanner.nextLine();

        int opcao;

        try {
            opcao = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
            return;
        }

        if (opcao < 1 || opcao > 3) {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.print("Digite o que deseja encontrar: ");
        String pesquisa = scanner.nextLine().trim();

        if (pesquisa.isBlank()) {
            System.out.println("Digite algo para pesquisar.");
            return;
        }

        boolean encontrado = false;

        for (Livro livro : livros) {

            boolean corresponde = false;

            switch (opcao) {

                case 1:
                    corresponde = livro.getTitulo()
                            .toLowerCase()
                            .contains(pesquisa.toLowerCase());
                    break;

                case 2:
                    corresponde = livro.getAutor().getNome()
                            .toLowerCase()
                            .contains(pesquisa.toLowerCase());
                    break;

                case 3:
                    corresponde = livro.getGenero()
                            .toLowerCase()
                            .contains(pesquisa.toLowerCase());
                    break;
            }

            if (corresponde) {
                System.out.println("\nLivro encontrado:");
                System.out.println(livro);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(
                    "Nenhum livro encontrado com essa pesquisa.");
        }
    }


    static Usuario lerUsuario() {

        while (true) {

            System.out.println("\n===== CADASTRO DE USUÁRIO =====");

            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            if (nome.isBlank()) {
                System.out.println("Nome inválido. Digite novamente.");
                continue;
            }

            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine().trim();

            if (matricula.isBlank()) {
                System.out.println("Matrícula inválida. Digite novamente.");
                continue;
            }

            if (buscarUsuario(matricula) != null) {
                System.out.println("Essa matrícula já está cadastrada.");
                continue;
            }

            System.out.print("Tipo (ALUNO ou PROFESSOR): ");
            String tipo = scanner.nextLine().trim().toUpperCase();

            if (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR")) {
                System.out.println("Tipo inválido. Digite ALUNO ou PROFESSOR.");
                continue;
            }

            System.out.print(
                    "Deseja definir um limite personalizado? (S/N): ");

            String definirLimite = scanner.nextLine().trim();

            Usuario usuario;

            if (definirLimite.equalsIgnoreCase("S")) {

                System.out.print("Limite de empréstimos: ");
                String limiteTexto = scanner.nextLine();

                try {
                    int limite = Integer.parseInt(limiteTexto);

                    if (limite < 1) {
                        System.out.println(
                                "O limite deve ser maior que zero.");
                        continue;
                    }

                    usuario = new Usuario(nome, matricula, tipo, limite);

                } catch (NumberFormatException erro) {
                    System.out.println(
                            "Limite inválido. Digite um número inteiro.");
                    continue;
                }

            } else if (definirLimite.equalsIgnoreCase("N")) {

                usuario = new Usuario(nome, matricula, tipo);

            } else {
                System.out.println("Resposta inválida. Digite S ou N.");
                continue;
            }

            usuarios.add(usuario);

            System.out.println("\nUsuário cadastrado com sucesso!");
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Matrícula: " + usuario.getMatricula());
            System.out.println("Tipo: " + usuario.getTipo());
            System.out.println("Limite de empréstimos: "
                    + usuario.getLimiteEmprestimos());
            System.out.println("Empréstimos ativos: "
                    + usuario.getEmprestimosAtivos());

            return usuario;
        }
    }


    static Usuario buscarUsuario(String matricula) {

        for (Usuario usuario : usuarios) {

            if (usuario.getMatricula().equalsIgnoreCase(matricula)) {
                return usuario;
            }
        }

        return null;
    }

    static void listarUsuarios() {

        System.out.println("\n===== USUÁRIOS CADASTRADOS =====");

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario usuario : usuarios) {

            System.out.println("\nNome: " + usuario.getNome());
            System.out.println("Matrícula: " + usuario.getMatricula());
            System.out.println("Tipo: " + usuario.getTipo());
            System.out.println("Limite de empréstimos: "
                    + usuario.getLimiteEmprestimos());
            System.out.println("Empréstimos ativos: "
                    + usuario.getEmprestimosAtivos());

            System.out.println("-------------------------");
        }
    }

    static void atualizarUsuario(Scanner entrada) {

        System.out.println("\n===== ATUALIZAR USUÁRIO =====");

        System.out.print("Matrícula do usuário: ");
        String matricula = entrada.nextLine().trim();

        Usuario usuario = buscarUsuario(matricula);

        if (usuario == null) {
            System.out.println(
                    "Usuário não localizado. Nenhuma alteração feita.");
            return;
        }

        System.out.println("\nUsuário encontrado:");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite de empréstimos: "
                + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: "
                + usuario.getEmprestimosAtivos());

        System.out.println("\n1 - Alterar nome");
        System.out.println("2 - Alterar limite de empréstimos");

        System.out.print("Escolha: ");
        String opcao = entrada.nextLine().trim();

        if (opcao.equals("1")) {

            System.out.print("Novo nome: ");
            String novoNome = entrada.nextLine();

            if (usuario.setNome(novoNome)) {
                System.out.println("Nome atualizado com sucesso.");
            } else {
                System.out.println(
                        "Nome inválido. Nenhuma alteração feita.");
            }
            /*            System.out.print("Novo nome: ");
            String novoNome = entrada.nextLine();

            if (usuario.setNome(novoNome)) {
                System.out.println("Nome atualizado com sucesso.");
            } else {
                System.out.println("Nome inválido. Nenhuma alteração feita.");
            }*/

        } else if (opcao.equals("2")) {

            System.out.print("Novo limite de empréstimos: ");
            String limiteTexto = entrada.nextLine();

            try {
                int novoLimite = Integer.parseInt(limiteTexto);

                if (usuario.setLimiteEmprestimos(novoLimite)) {
                    System.out.println("Limite atualizado com sucesso.");
                } else {
                    System.out.println(
                            "Limite inválido. Nenhuma alteração feita.");
                }

            } catch (NumberFormatException erro) {
                System.out.println(
                        "Digite um número inteiro. Nenhuma alteração feita.");
            }

        } else {
            System.out.println(
                    "Opção inválida. Nenhuma alteração feita.");
        }
    }
}
