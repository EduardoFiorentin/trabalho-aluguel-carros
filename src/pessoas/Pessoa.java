package pessoas;


public abstract class Pessoa implements Identificavel{
    private String id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Pessoa(String id, String nome, String cpf, String endereco, String telefone) {
        // id ==> cpf
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters e setters

    public String getId() { return this.id; }
    public String getNome() { return this.nome; }
    public String getCpf() { return this.cpf; }
    public String getEndereco() { return this.endereco; }
    public String getTelefone() { return this.telefone; }

    public void setId(String id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    
    
    public abstract String getInfo();
}
