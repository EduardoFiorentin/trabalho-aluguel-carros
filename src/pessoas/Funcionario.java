package pessoas;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private String senha; 

    public Funcionario(String id, String nome, String cpf, String endereco, String telefone, String cargo, double salario, String senha) {
        super(id, nome, cpf, endereco, telefone);
        setCargo(cargo);
        setSalario(salario);
        setSenha(senha);
    }

    
    // Getters e setters
    public String getCargo() { return cargo; }
    public double getSalario() { return salario; }
    private String getSenha() { return senha; }

    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setSalario(double salario) { this.salario = salario; }
    private void setSenha(String senha) { this.senha = senha; }

    public boolean verificarSenha(String senha) {
        return getSenha().equals(senha); 
    }

    @Override
    public String getInfo() {
        return String.format("Informações de funcionário: \n\tId: %s\n\tNome: %s\n\tCargo: %s", getId(), getNome(), getCargo());
    }
}