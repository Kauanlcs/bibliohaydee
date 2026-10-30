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

        cadastrarLivro(
                "Livro sem gênero (teste)", "ISBN-TESTE-SEM-GENERO",
                antoine, 2020);


        Scanner entrada = scanner;
        lerUsuario();

        System.out.print("\nDeseja atualizar um usuário? (S/N): ");
        String respostaAtualizacao = entrada.nextLine();

        if (respostaAtualizacao.equalsIgnoreCase("S")) {
            atualizarUsuario(entrada);
        }

        listarLivros();
        menu();
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

        return autor;
    }

    static void cadastrarLivro(
            String titulo, String isbn, Autor autor,
            int ano, String genero) {

        if (autor == null || !autores.contains(autor)) {
            return;
        }

        Livro livro = new Livro(titulo, isbn, autor, ano, genero);

        livros.add(livro);

        System.out.println("Livro cadastrado: " + livro);
    }

    static void cadastrarLivro(
            String titulo, String isbn, Autor autor, int ano) {

        if (autor == null || !autores.contains(autor)) {
            return;
        }

        Livro livro = new Livro(titulo, isbn, autor, ano);

        livros.add(livro);

        System.out.println("Livro cadastrado: " + livro);
    }

    static void menu() {

        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA BIBLIOHAYDEE =====");
            System.out.println("1 - Ver todos os livros");
            System.out.println("2 - Pesquisar um livro");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    listarLivros();
                    break;

                case 2:
                    pesquisarLivro();
                    break;

                case 3:
                    lerUsuario();
                    break;

                case 4:
                    System.out.println(
                            "Obrigado por visitar a BiblioHaydee!");
                    break;

                default:
                    System.out.println(
                            "Opção inválida. Tente novamente.");
            }

        } while (opcao != 4);
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
                System.out.println("Nome inválido. Digite novamente.\n");
                continue;
            }

            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine().trim();

            if (matricula.isBlank()) {
                System.out.println("Matrícula inválida. Digite novamente.\n");
                continue;
            }

            if (buscarUsuario(matricula) != null) {
                System.out.println("Essa matrícula já está cadastrada.\n");
                continue;
            }

            System.out.print("Tipo (ALUNO ou PROFESSOR): ");
            String tipo = scanner.nextLine().trim().toUpperCase();

            if (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR")) {
                System.out.println("Tipo inválido. Digite ALUNO ou PROFESSOR.\n");
                continue;
            }

            System.out.print("Deseja definir um limite personalizado? (S/N): ");
            String definirLimite = scanner.nextLine();

            Usuario usuario;

            if (definirLimite.equalsIgnoreCase("S")) {
                System.out.print("Limite de emprestimos: ");
                String limiteTexto = scanner.nextLine();

                try {
                    int limite = Integer.parseInt(limiteTexto);

                    if (limite < 1) {
                        System.out.println("O limite deve ser maior que zero.");
                        System.out.println("Digite os dados novamente.\n");
                        continue;
                    }

                    usuario = new Usuario(nome, matricula, tipo, limite);

                } catch (NumberFormatException erro) {
                    System.out.println("Limite inválido: digite um número inteiro.");
                    System.out.println("Digite os dados novamente.\n");
                    continue;
                }

            } else if (definirLimite.equalsIgnoreCase("N")) {
                usuario = new Usuario(nome, matricula, tipo);

            } else {
                System.out.println("Resposta inválida. Digite S ou N.");
                System.out.println("Digite os dados novamente.\n");
                continue;
            }

            usuarios.add(usuario);

            System.out.println("Usuário cadastrado: "
                    + usuario.getNome());

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

    static void atualizarUsuario(Scanner entrada) {

        System.out.print("Matrícula do usuário: ");
        String matricula = entrada.nextLine();

        Usuario usuario = buscarUsuario(matricula);

        if (usuario == null) {
            System.out.println("Usuário não localizado. Nenhuma alteração feita.");
            return;
        }

        System.out.println("\nUsuário encontrado:");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite de empréstimos: " + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: " + usuario.getEmprestimosAtivos());

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
                System.out.println("Nome inválido. Nenhuma alteração feita.");
            }

        } else if (opcao.equals("2")) {

            while (true) {
                System.out.print("Novo limite de empréstimos: ");
                String limiteTexto = entrada.nextLine();

                try {
                    int novoLimite = Integer.parseInt(limiteTexto);

                    if (usuario.setLimiteEmprestimos(novoLimite)) {
                        System.out.println("Limite atualizado com sucesso.");
                    } else {
                        System.out.println("Limite inválido. Nenhuma alteração feita.");
                    }

                    break;

                } catch (NumberFormatException erro) {
                    System.out.println("Digite um número inteiro. Tente novamente.");
                }
            }

        } else {
            System.out.println("Opção inválida. Nenhuma alteração feita.");
        }
    }
}