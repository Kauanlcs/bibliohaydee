package br.escola.bibliohaydee.model;

public class Usuario {

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;

    public Usuario(String nomeRecebido, String matriculaRecebida,
                   String tipoRecebido, Integer limiteRecebido) {


        setNome(nomeRecebido);
        setTipo(tipoRecebido);

        matricula = matriculaRecebida;
        limiteEmprestimos = limiteRecebido;
        emprestimosAtivos = 0;
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

    public void setNome(String novoNome) {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        nome = novoNome;
    }

    public void setTipo(String novoTipo) {
        if (novoTipo == null
                || (!novoTipo.equals("ALUNO") && !novoTipo.equals("PROFESSOR"))) {
            throw new IllegalArgumentException("O tipo deve ser ALUNO ou PROFESSOR.");
        }
        tipo = novoTipo;
    }

}