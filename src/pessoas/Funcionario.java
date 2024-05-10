package pessoas;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(String id, String nome, String cpf, String endereco, String telefone, String cargo, double salario) {
        super(id, nome, cpf, endereco, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

    
    // Getters e setters
    public String getCargo() { return this.cargo; }
    public double getSalario() { return this.salario; }

    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setSalario(double salario) { this.salario = salario; }


    @Override
    public String getTipoPessoa() {
        return "Funcionário";
    }
}