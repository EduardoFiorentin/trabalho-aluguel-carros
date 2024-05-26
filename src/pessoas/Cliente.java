package pessoas;

public class Cliente extends Pessoa {
    private String email;
    private String cnh;
    private String dataNascimento;

    public Cliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh) {
        super(cpf.replace(".", "").replace("-", ""), nome, cpf, endereco, telefone);
        this.email = email;
        this.cnh = cnh;
        this.dataNascimento = dataNascimento;
    }

    // Getters e setters
    public String getEmail() { return this.email; }
    public String getCnh() { return this.cnh; }
    public String getDataNascimento() { return this.dataNascimento; }

    public void setEmail(String email) { this.email = email; }
    public void setCnh(String cnh) { this.cnh = cnh; }
    public void setDataNascimento (String dataNascimento) {this.dataNascimento = dataNascimento; }


    @Override
    public String getInfo() {
        return String.format("Informações de cliente: \n\tId: %s\n\tNome: %s\n\tCPF: %s\n\tCNH: %s\n\tEndereço: %s\n\tTelefone: %s\n", getId(), getNome(), getCpf(), getCnh(), getEndereco(), getTelefone());
    }
}
