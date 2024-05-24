import aluguel.Aluguel;
import pessoas.Cliente;
import pessoas.Funcionario;
import veiculo.Veiculo;
//Só tem o nome da função para ser escrita depopis (Contrato)

public interface ISistema {
    public void listarFuncionarios();
    public void listarClientes();
    public void listarAlugueisAtivos(); 

    // metodos de gestão de cadastros
    public boolean cadastrarCliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh);
    public boolean removerCliente(String id);
    public boolean cadastrarFuncionario(String id, String nome, String cpf, String endereco, String telefone, String cargo, double salario);


    // metodos de gestao de alugueis 
    public boolean alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias, Funcionario funciomarioResponsavel);
    public void finalizarAluguel(String idCliente);
}
