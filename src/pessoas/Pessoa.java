package pessoas;

/**
 * A classe abstrata Pessoa representa uma pessoa com atributos básicos 
 * como id, nome, CPF, endereço e telefone.
 */
public abstract class Pessoa implements Identificavel{
    private String id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
/**
 * Construtor para criar uma nova pessoa.
 *
 * @param id o identificador único da pessoa
 * @param nome o nome da pessoa
 * @param cpf o CPF da pessoa
 * @param endereco o endereço da pessoa
 * @param telefone o telefone da pessoa
 */
    public Pessoa(String id, String nome, String cpf, String endereco, String telefone) {
        // id => cpf
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setEndereco(endereco);
        setTelefone(telefone);
    }
/**
* Cada método getter e setter é documentado com uma breve descrição do que 
* ele faz, e, quando aplicável, dos parâmetros e valores de retorno.
* Obtém o identificador único da pessoa.
* @return o identificador único da pessoa

* Define o identificador único da pessoa.
 * @param id o identificador único da pessoa
 * 
 * Obtém o nome da pessoa.
 * @return o nome da pessoa
 * 
 * Define o nome da pessoa.
 * @param nome o nome da pessoa
 * 
 * Obtém o CPF da pessoa.
 * @return o CPF da pessoa
 * 
 * Define o CPF da pessoa.
 * @param cpf o CPF da pessoa
 *
 *Obtém o endereço da pessoa.
 * @return o endereço da pessoa
 * 
 * Define o endereço da pessoa.
 * @param endereco o endereço da pessoa
 * 
 * Obtém o telefone da pessoa.
 * @return o telefone da pessoa
 * 
 * Define o telefone da pessoa.
 * @param telefone o telefone da pessoa
 */


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
    
/**
 * Método abstrato para obter informações da pessoa.
 * As subclasses devem implementar este método para fornecer a 
 * representação específica das informações da pessoa.
 * @return as informações da pessoa
 */
    public abstract String getInfo();
}
