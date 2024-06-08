package sistema;
import java.util.List;

import aluguel.Aluguel;
import excecoes.AluguelNaoEncontradoException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.InformacoesInsuficientesException;
import excecoes.UsuarioNaoEncontrado;
import excecoes.VeiculoNaoDisponivelException;
import excecoes.VeiculoNaoEncontradoException;
import pessoas.Cliente;
import pessoas.Funcionario;
import pessoas.Pessoa;
import utilitarios.Armazenamento;
import veiculo.Veiculo;


/**
 * Interface que define as operações disponíveis no sistema de aluguel de veículos.
 */
public interface ISistema {
    /**
     * Lista todos os funcionários cadastrados no sistema.
     */
    public List<String> listarFuncionarios() throws FuncionarioNaoEncontradoException;
    /**
     * Lista todos os clientes cadastrados no sistema.
     */
    public List<String> listarClientes() throws FuncionarioNaoEncontradoException;
    /**
     * Lista todos os aluguéis ativos no sistema.
     */
    public List<String> listarAlugueisAtivos() throws FuncionarioNaoEncontradoException; 
    /**
     * Lista todos os veículos no sistema.
     */
    public List<String> listarVeiculos() throws FuncionarioNaoEncontradoException; 


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
    public void cadastrarCliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh) throws FuncionarioNaoEncontradoException, InformacoesInsuficientesException;
    /**
     * Remove um cliente do sistema.
     *
     * @param id ID do cliente a ser removido.
     * @return True se a remoção for bem-sucedida, False caso contrário.
     */
    public boolean removerCliente(String id) throws FuncionarioNaoEncontradoException;
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
    public boolean cadastrarFuncionario(String nome, String cpf, String endereco, String telefone, String cargo, double salario, String senha) throws FuncionarioNaoEncontradoException;


    // metodos de gestao de alugueis 
    /**
     * Realiza o aluguel de um veículo para um cliente.
     * @param cliente Cliente que está alugando o veículo.
     * @param veiculo Veículo a ser alugado.
     * @param dias Número de dias do aluguel.
     * @param funcionarioResponsavel Funcionário responsável pelo aluguel.
     * @return True se o aluguel for bem-sucedido, False caso contrário.
     */
    public boolean alugarVeiculo(String idCliente, String idVeiculo, int dias) throws ClienteNaoEncontradoException, VeiculoNaoDisponivelException, VeiculoNaoEncontradoException, FuncionarioNaoEncontradoException;
    
     /**
     * Finaliza um aluguel.
     * @param idCliente ID do cliente que está finalizando o aluguel.
     * @param idVeiculo ID do veículo que está sendo devolvido.
     * @throws AluguelNaoEncontradoException Exceção lançada se o aluguel não for encontrado.
     * @throws ClienteNaoEncontradoException Exceção lançada se o cliente não for encontrado.
     */
    public void finalizarAluguel(String idCliente, String idVeiculo) throws AluguelNaoEncontradoException, ClienteNaoEncontradoException, FuncionarioNaoEncontradoException;
    
    /**
     * Pesquisa aluguéis realizados por um determinado cliente.
     * @param idCliente ID do cliente.
     * @return Lista de aluguéis realizados pelo cliente.
     * @throws ClienteNaoEncontradoException Exceção lançada se o cliente não for encontrado.
     */
    public List<Aluguel> pesquisarAlugadosPorCliente(String idCLiente) throws ClienteNaoEncontradoException, FuncionarioNaoEncontradoException; 

     /**
     * Permite que um usuário entre no sistema.
     * @param id Identificador (CPF) de usuário.
     * @param senha Senha de acesso.
     * @throws UsuarioNaoEncontrado Excessão lançada se o usuário passado não existir. 
     */
    public void entrar(String id, String senha) throws UsuarioNaoEncontrado;

    /**
     * Permite que um usuário saia do sistema.
     */
    public void sair();
}
