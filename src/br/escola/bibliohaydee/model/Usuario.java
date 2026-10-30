package br.escola.bibliohaydee.model;

public class Usuario {

    public static final int LIMITE_PADRAO = 3;

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;

    public Usuario(String nomeRecebido, String matriculaRecebida,
                   String tipoRecebido, Integer limiteRecebido) {

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

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public boolean setNome(String novoNome) {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        nome = novoNome;
        return true;
    }


    public void setTipo(String novoTipo) {
        if (novoTipo == null
                || (!novoTipo.equals("ALUNO") && !novoTipo.equals("PROFESSOR"))) {
            throw new IllegalArgumentException("O tipo deve ser ALUNO ou PROFESSOR.");
        }
        tipo = novoTipo;
    }


    public boolean setLimiteEmprestimos(int novoLimite) {

        if (novoLimite < 1) {
            return false;
        }

        this.limiteEmprestimos = novoLimite;
        return true;
    }
}