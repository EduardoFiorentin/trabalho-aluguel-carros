package pessoas;
/**
 * A classe Funcionario (que herda da classe abstrata Pessoa) representa um funcionário 
 * com atributos adicionais como cargo e salário.
 */

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
/**
 * Construtor para criar um novo Funcionário.
 *
 * @param id o identificador único do funcionário
 * @param nome o nome do funcionário
 * @param cpf o CPF do funcionário
 * @param endereco o endereço do funcionário
 * @param telefone o telefone do funcionário
 * @param cargo o cargo do funcionário
 * @param salario o salário do funcionário
 */
    public Funcionario(String id, String nome, String cpf, String endereco, String telefone, String cargo, double salario) {
        super(id, nome, cpf, endereco, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

/**
 * Cada método getter e setter é documentado com uma breve descrição do que ele faz, e,
 * quando aplicável, dos parâmetros e valores de retorno.
 * 
 * Obtém o cargo do funcionário.
 * @return o cargo do funcionário
 * 
 * Define o cargo do funcionário.
 * @param cargo o cargo do funcionário
 * 
 * Obtém o salário do funcionário.
 * @return o salário do funcionário
 * 
 * Define o salário do funcionário.
 * @param salario o salário do funcionário
 */
    public String getCargo() { return this.cargo; }
    public double getSalario() { return this.salario; }

    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setSalario(double salario) { this.salario = salario; }

/**
 * Obtém as informações do funcionário formatadas.
 * @return as informações do funcionário
 */
    @Override
    public String getInfo() {
        return String.format("Informações de funcionário: \n\tId: %s\n\tNome: %s\n\tCargo: %s", getId(), getNome(), getCargo());
    }
}