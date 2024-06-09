package pessoas;

/**
 * A classe Cliente (que surge como herança da classe "Pai!" abstrata Pessoas) representa um cliente com 
 * atributos adicionais como email, CNH e data de nascimento.
 */

public class Cliente extends Pessoa {
    private String email;
    private String cnh;
    private String dataNascimento;

/**
 * Construtor para criar um novo cliente.
 *
 * @param nome o nome do cliente
 * @param cpf o CPF do cliente
 * @param dataNascimento a data de nascimento do cliente
 * @param endereco o endereço do cliente
 * @param telefone o telefone do cliente
 * @param email o email do cliente
 * @param cnh a CNH do cliente
 */

    public Cliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh) {
        super(cpf.replace(".", "").replace("-", ""), nome, cpf, endereco, telefone);
        setEmail(email);
        setCnh(cnh);
        setDataNascimento(dataNascimento);
    }

    /**
     * Obtém o email do cliente.
     * @return o email do cliente
     */
    public String getEmail() { return this.email; }

    /**
     * Obtém a CNH do cliente.
     * @return a CNH do cliente
     */
    public String getCnh() { return this.cnh; }

    /**
     * Obtém a data de nascimento do cliente.
     * @return dataNascimento a data de nascimento do cliente 
     */
    public String getDataNascimento() { return this.dataNascimento; }

    /**
     * Define o email do cliente.
     * @param email o email do cliente
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Define a CNH do cliente.
     * @param cnh do cliente
     */
    public void setCnh(String cnh) { this.cnh = cnh; }

    /**
     * Define a data de nascimento do cliente.
     * @param dataNascimento Data de nascimento do cliente
     */
    public void setDataNascimento (String dataNascimento) {this.dataNascimento = dataNascimento; }


    @Override
    public String getInfo() {
        return String.format("ID: %s\tNome: %s\tCPF: %s\tCNH: %s\tEndereço: %s\tTelefone: %s", getId(), getNome(), getCpf(), getCnh(), getEndereco(), getTelefone());
    }
}
