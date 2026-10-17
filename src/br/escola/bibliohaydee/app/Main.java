package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Usuario;
import java.util.Scanner;
import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Autor> autores = new ArrayList<>();
    static List<Livro> livros = new ArrayList<>();
    static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {


        listarLivros();


        cadastrarAutor("", "Francesa", 1900);

        Autor antoine = cadastrarAutor(
                "Antoine de Saint-Exupéry", "Francesa", 1900);

        Autor machado = cadastrarAutor(
                "Machado de Assis", "Brasileira", 1839);

        Autor tolkien = cadastrarAutor(
                "J. R. R. Tolkien", "Britânica", 1892);

        Autor rowling = cadastrarAutor(
                "J. K. Rowling", "Britânica", 1965);

        Autor felipeNeto = cadastrarAutor(
                "Felipe Neto",
                "Brasileira",
                1988
        );

        Autor orwell = cadastrarAutor(
                "George Orwell", "Britânica", 1903);

        Autor lobato = cadastrarAutor(
                "Monteiro Lobato", "Brasileira", 1882);

        Autor saintExupery = antoine;

        cadastrarLivro(
                "Livro sem autor", "ISBN-TESTE", null,
                2020, "Teste");
        cadastrarLivro(
                "O Pequeno Príncipe", "978-85-325-3155-1",
                antoine, 1943, "Fábula");

        cadastrarLivro(
                "Dom Casmurro", "978-857-799-171-6 ",
                machado, 1899, "Romance");

        cadastrarLivro(
                "O Hobbit", "9788595086081",
                tolkien, 1937, "Fantasia");

        cadastrarLivro(
                "Harry Potter e a Pedra Filosofal", "9788532530271",
                rowling, 1997, "Fantasia");

        cadastrarLivro(
                "Como enfrentar o ódio",
                "978-85-359-3891-3",
                felipeNeto,
                2024,
                "Autobiografia"
        );
        cadastrarLivro(
                "1984", "9786557390016",
                orwell, 1949, "Ficção distópica");

        cadastrarLivro(
                "O Sítio do Picapau Amarelo", "9788511300055",
                lobato, 1920, "Infantojuvenil");

        Scanner entrada = new Scanner(System.in);
        Usuario novo = lerUsuario(entrada);
        System.out.println("Empréstimos ativos: " + novo.getEmprestimosAtivos());

        try {
            new Usuario(null, "2026004", "PROFESSOR", 5);
        } catch (IllegalArgumentException erro) {
            System.out.println("Nulo recusado: " + erro.getMessage());
        }

        listarLivros();
    }

    static Autor cadastrarAutor(
            String nome, String nacionalidade, int anoNascimento) {

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
            return;
        }

        Livro livro = new Livro(titulo, isbn, autor, ano, genero);

        livros.add(livro);

        System.out.println("Livro cadastrado: " + livro);
    }

    static Usuario lerUsuario(Scanner entrada) {

        while (true) {
            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.print("Matrícula: ");
            String matricula = entrada.nextLine();

            System.out.print("Tipo (ALUNO ou PROFESSOR): ");
            String tipo = entrada.nextLine();

            System.out.print("Limite de empréstimos: ");
            String limiteTexto = entrada.nextLine();

            try {
                int limite = Integer.parseInt(limiteTexto);
                Usuario usuario = new Usuario(nome, matricula, tipo, limite);
                usuarios.add(usuario);
                System.out.println("Usuário cadastrado: " + usuario.getNome());
                return usuario;
            } catch (NumberFormatException erro) {
                System.out.println("Limite inválido: digite um número inteiro.");
            } catch (IllegalArgumentException erro) {
                System.out.println("Cadastro recusado: " + erro.getMessage());
            }

            System.out.println("Digite os dados novamente.\n");
        }
    }

    static void listarLivros() {

        if (livros.isEmpty()) {
            System.out.println("O acervo está vazio.");
            return;
        }

        System.out.println("\n--- Acervo da BiblioHaydee ---");

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}