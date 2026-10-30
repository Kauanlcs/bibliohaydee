package br.escola.bibliohaydee.model;

public class Usuario {

    public static final int LIMITE_PADRAO = 3;

    private String nome;
    private String matricula;
    private String tipo;
    private int limiteEmprestimos;
    private int emprestimosAtivos;
    
    public Usuario(String nome, String matricula,
                   String tipo, int limiteEmprestimos) {

        this.nome = nome.trim();
        this.matricula = matricula.trim();
        this.tipo = tipo.trim().toUpperCase();
        this.limiteEmprestimos = limiteEmprestimos;
        this.emprestimosAtivos = 0;
    }

    public Usuario(String nome, String matricula, String tipo) {
        this(nome, matricula, tipo, LIMITE_PADRAO);
    }


    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public int getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public boolean setNome(String novoNome) {

        if (novoNome == null || novoNome.isBlank()) {
            return false;
        }

        this.nome = novoNome.trim();
        return true;
    }

    public boolean setLimiteEmprestimos(int novoLimite) {

        if (novoLimite < 1) {
            return false;
        }

        this.limiteEmprestimos = novoLimite;
        return true;
    }
}