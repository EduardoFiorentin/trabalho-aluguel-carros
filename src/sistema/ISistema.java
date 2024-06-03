package sistema;
import java.util.List;

import aluguel.Aluguel;
import exceptions.AluguelNaoEncontradoException;
import exceptions.ClienteNaoEncontradoException;
import pessoas.Cliente;
import pessoas.Funcionario;
import pessoas.Pessoa;
import utils.Armazenamento;
import veiculo.Veiculo;
//Só tem o nome da função para ser escrita depopis (Contrato)
/**
 * Interface que define as operações disponíveis no sistema de aluguel de veículos.
 */
public interface ISistema {
     /**
     * Lista todos os funcionários cadastrados no sistema.
     */
    public void listarFuncionarios();
    /**
     * Lista todos os clientes cadastrados no sistema.
     */
    public void listarClientes();
    /**
     * Lista todos os aluguéis ativos no sistema.
     */
    public void listarAlugueisAtivos(); 
     /**
     * Obtém o armazenamento de pessoas cadastradas no sistema.
     * @return O armazenamento de pessoas cadastradas.
     */
    public Armazenamento<Pessoa> getArmazenamentoCadastrados();

    // metodos de gestão de cadastros
    /**
     * Cadastra um novo cliente no sistema.
     * @param nome Nome do cliente.
     * @param cpf CPF do cliente.
     * @param dataNascimento Data de nascimento do cliente.
     * @param endereco Endereço do cliente.
     * @param telefone Telefone do cliente.
     * @param email Email do cliente.
     * @param cnh Número da CNH do cliente.
     * @return True se o cadastro for bem-sucedido, False caso contrário.
     */
    public boolean cadastrarCliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh);
    /**
     * Remove um cliente do sistema.
     *
     * @param id ID do cliente a ser removido.
     * @return True se a remoção for bem-sucedida, False caso contrário.
     */
    public boolean removerCliente(String id);
    /**
     * Cadastra um novo funcionário no sistema.
     * @param id ID do funcionário.
     * @param nome Nome do funcionário.
     * @param cpf CPF do funcionário.
     * @param endereco Endereço do funcionário.
     * @param telefone Telefone do funcionário.
     * @param cargo Cargo do funcionário.
     * @param salario Salário do funcionário.
     * @return True se o cadastro for bem-sucedido, False caso contrário.
     */
    public boolean cadastrarFuncionario(String id, String nome, String cpf, String endereco, String telefone, String cargo, double salario);


    // metodos de gestao de alugueis 
    /**
     * Realiza o aluguel de um veículo para um cliente.
     * @param cliente Cliente que está alugando o veículo.
     * @param veiculo Veículo a ser alugado.
     * @param dias Número de dias do aluguel.
     * @param funcionarioResponsavel Funcionário responsável pelo aluguel.
     * @return True se o aluguel for bem-sucedido, False caso contrário.
     */
    public boolean alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias, Funcionario funciomarioResponsavel);
    /**
     * Finaliza um aluguel.
     * @param idCliente ID do cliente que está finalizando o aluguel.
     * @param idVeiculo ID do veículo que está sendo devolvido.
     * @throws AluguelNaoEncontradoException Exceção lançada se o aluguel não for encontrado.
     * @throws ClienteNaoEncontradoException Exceção lançada se o cliente não for encontrado.
     */
    public void finalizarAluguel(String idCliente, String idVeiculo) throws AluguelNaoEncontradoException, ClienteNaoEncontradoException;
    /**
     * Pesquisa aluguéis realizados por um determinado cliente.
     * @param idCliente ID do cliente.
     * @return Lista de aluguéis realizados pelo cliente.
     * @throws ClienteNaoEncontradoException Exceção lançada se o cliente não for encontrado.
     */
    public List<Aluguel> pesquisarAlugadosPorCliente(String idCLiente) throws ClienteNaoEncontradoException; 
    /**
     * Permite que um usuário entre no sistema.
     * @param usuario Nome de usuário.
     * @param senha Senha de acesso.
     */
    public void entrar(String usuario, String senha);
    /**
     * Permite que um usuário saia do sistema.
     */
    public void sair();
}
