package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Autor> autores = new ArrayList<>();
    static List<Livro> livros = new ArrayList<>();

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
                "O Pequeno Príncipe", "ISBN-001",
                antoine, 1943, "Fábula");

        cadastrarLivro(
                "Dom Casmurro", "ISBN-002",
                machado, 1899, "Romance");

        cadastrarLivro(
                "O Hobbit", "ISBN-003",
                tolkien, 1937, "Fantasia");

        cadastrarLivro(
                "Harry Potter e a Pedra Filosofal", "ISBN-004",
                rowling, 1997, "Fantasia");

        cadastrarLivro(
                "1984", "ISBN-008",
                orwell, 1949, "Ficção distópica");

        cadastrarLivro(
                "O Sítio do Picapau Amarelo", "ISBN-009",
                lobato, 1920, "Infantojuvenil");

        cadastrarLivro(
                "O Pequeno Príncipe - Edição escolar", "ISBN-010",
                antoine, 1943, "Fábula");

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