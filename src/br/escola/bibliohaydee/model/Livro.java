package br.escola.bibliohaydee.model;

public class Livro {

    private String titulo;
    private String isbn;
    private Autor autor;
    private int anoDePublicacao;
    private String genero;
    private boolean disponibilidade;

    public Livro(String titulo, String isbn, Autor autor,
                 int anoDePublicacao, String genero) {

        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.genero = genero;
        this.disponibilidade = true;
    }
    public Livro(String titulo, String isbn, Autor autor,
                 int anoDePublicacao) {

        this(titulo, isbn, autor, anoDePublicacao, "Não informado");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                " | ISBN: " + isbn +
                "\nAutor: " + autor +
                "\nAno de publicação: " + anoDePublicacao +
                " | Gênero: " + genero +
                " | Disponibilidade: " +
                (disponibilidade ? "disponível" : "emprestado");
    }
}