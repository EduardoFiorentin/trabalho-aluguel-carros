package pessoas;

/**
 * Representa um funcionário no sistema.
 */
public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private String senha; 
     /**
     * Construtor da classe Funcionario.
     * @param nome Nome do funcionário.
     * @param cpf CPF do funcionário.
     * @param endereco Endereço do funcionário.
     * @param telefone Telefone do funcionário.
     * @param cargo Cargo do funcionário.
     * @param salario Salário do funcionário.
     * @param senha Senha de acesso do funcionário.
     */
    public Funcionario(String nome, String cpf, String endereco, String telefone, String cargo, double salario, String senha) {
        super(cpf.replace(".", "").replace("-", ""), nome, cpf, endereco, telefone);
        setCargo(cargo);
        setSalario(salario);
        setSenha(senha);
    }

    
    // Getters e setters
     /**
     * Obtém o cargo do funcionário.
     * @return O cargo do funcionário.
     */
    public String getCargo() { return cargo; }
    /**
     * Obtém o salário do funcionário.
     * @return O salário do funcionário.
     */
    public double getSalario() { return salario; }

    /*Metodo privativo para obter a senha do funcionário */
    private String getSenha() { return senha; }

     /**
     * Define o cargo do funcionário.
     * @param cargo O cargo do funcionário.
     */
    public void setCargo(String cargo) { this.cargo = cargo; }
    /**
     * Define o salário do funcionário.
     * @param salario O salário do funcionário.
     */
    public void setSalario(double salario) { this.salario = salario; }

   /*Método privado para definir a senha do funcionário */

    private void setSenha(String senha) { this.senha = senha; }

    /**
     * Verifica se a senha fornecida corresponde à senha do funcionário.
     * @param senha A senha a ser verificada.
     * @return True se a senha fornecida for correta, False caso contrário.
     */
    public boolean verificarSenha(String senha) {
        return getSenha().equals(senha); 
    }

    /**
     * Retorna uma representação textual das informações do funcionário.
     * @return Uma string com as informações do funcionário.
     */
    @Override
    public String getInfo() {
        return String.format("Informações de funcionário: \n\tId: %s\n\tNome: %s\n\tCargo: %s", getId(), getNome(), getCargo());
    }
}