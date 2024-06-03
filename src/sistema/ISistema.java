package sistema;
import java.util.List;

import aluguel.Aluguel;
import exceptions.AluguelNaoEncontradoException;
import exceptions.ClienteNaoEncontradoException;
import exceptions.FuncionarioNaoEncontradoException;
import exceptions.UsuarioNaoEncontrado;
import exceptions.VeiculoNaoDisponivelException;
import exceptions.VeiculoNaoEncontradoException;
import pessoas.Cliente;
import pessoas.Funcionario;
import pessoas.Pessoa;
import utils.Armazenamento;
import veiculo.Veiculo;
//Só tem o nome da função para ser escrita depopis (Contrato)

public interface ISistema {
    public void listarFuncionarios();
    public void listarClientes();
    public List<String> listarAlugueisAtivos(); 
    public List<String> listarVeiculos(); 
    public Armazenamento<Pessoa> getArmazenamentoCadastrados();

    // metodos de gestão de cadastros
    public boolean cadastrarCliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh);
    public boolean removerCliente(String id);
    public boolean cadastrarFuncionario(String nome, String cpf, String endereco, String telefone, String cargo, double salario, String senha);


    // metodos de gestao de alugueis 
    public boolean alugarVeiculo(String idCliente, String idVeiculo, int dias) throws ClienteNaoEncontradoException, VeiculoNaoDisponivelException, VeiculoNaoEncontradoException, FuncionarioNaoEncontradoException;
    public void finalizarAluguel(String idCliente, String idVeiculo) throws AluguelNaoEncontradoException, ClienteNaoEncontradoException;
    public List<Aluguel> pesquisarAlugadosPorCliente(String idCLiente) throws ClienteNaoEncontradoException; 

    public void entrar(String id, String senha) throws UsuarioNaoEncontrado;
    public void sair();
}
