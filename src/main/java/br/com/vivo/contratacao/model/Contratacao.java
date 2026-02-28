package br.com.vivo.contratacao.model;

public class Contratacao {

    // Todo registro no banco precisa de um ID único
    private Long id;
    private String nome;
    private String cpf;
    private String plano;

    public Contratacao(Long id, String nome, String cpf, String plano) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.plano = plano;
    }

    // Adicione o Getter e Setter para o ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getPlano() { return plano; }
    public void setPlano(String plano) { this.plano = plano; }
} // A ÚLTIMA CHAVE TERMINA AQUI!