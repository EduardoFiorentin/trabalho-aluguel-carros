package sistema;
import aluguel.*;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import pessoas.*;
import utils.Armazenamento;
import utils.UniqueIDGenerator;
import veiculo.*;
import exceptions.*;

// funções de adição de aluguel 

    /**
     * Implementação da interface ISistema que define as operações disponíveis no sistema de aluguel 
     * de veículos.
     */
public class Sistema implements ISistema{
    private Armazenamento<Pessoa> cadastrados = new Armazenamento<>(); 
    private Armazenamento<Veiculo> veiculos = new Armazenamento<>();
    private Armazenamento<Aluguel> alugueisAtivos = new Armazenamento<>();
    /**
     * Construtor padrão da classe Sistema.
     */
    public Sistema() {

    /**
     * São criados métodos que possibilita o cadastro de funcionários, clientes e alugueis ativos.
     * Esse servirá para que quando necessário acessar o Sistema para processar uma transação 
     * de aluguél o funcionário necessite apenas das informações do seu login e sua senha.
    */       
        cadastrados.adicionar(
            new Funcionario("0", "Eduardo", "000.000.000-00", "Rua S, 22", "00 90000-0000", "Supervisor", 10500.0)
        ); 

        cadastrados.adicionar(
            new Funcionario("1", "Mario", "000.000.000-01", "Rua D, 12", "00 60000-0000", "Estagiario", 500.0)
        ); 
    
    /**
     * Cadastrar um cliente no sistema.
     */
        cadastrarCliente("Marcelo", "000.000.002-01", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", null);
    /**
     * Possibilita a adição de um veículo no sistema.
     */
        veiculos.adicionar(new Veiculo("1", "UN-43", "azn0023", 30.0, 0, 2, "Uno", "GMB", "2000", "Laranja", 15000));
    /**
     * Adciona um aluguél ativo no sistema.
     */
        alugueisAtivos.adicionar(new Aluguel("10", veiculos.pesquisar("1"), (Cliente)cadastrados.pesquisar("00000000201"), (Funcionario)cadastrados.pesquisar("1"), (10))); 

        // cadastrados.pesquisar("00000000201").get(0).nome = "Genesio";
    }

    // public List<Veiculo> getVeiculos() { return this.veiculos; }
    /* Métodos de acesso ao armazenamento. */
    /**
     * Obtém o armazenamento de aluguéis ativos.
     * @return O armazenamento de aluguéis ativos.
     */
    public List<Aluguel> getAlugueisAtivos() { return alugueisAtivos.pesquisar(); }
     /**
     * Obtém o armazenamento de aluguéis.
     * @return O armazenamento de aluguéis.
     */
    public Armazenamento<Aluguel> getArmazenamentoAlugueis() { return alugueisAtivos; }
     /**
     * Obtém o armazenamento de pessoas cadastradas.
     * @return O armazenamento de pessoas cadastradas.
     */
    public Armazenamento<Pessoa> getArmazenamentoCadastrados() {return cadastrados; }
    
    /* Métodos de listagem de informações*/
    /**
     * Lista todos os funcionários cadastrados no sistema.
     */
    public void listarFuncionarios() {
        System.out.println("Lista de Funcionários:");
        /* Obtém a lista de todas as pessoas cadastradas no sistema */
        List<Pessoa> pessoas = cadastrados.pesquisar(); 
        Funcionario funcionario; 
        /* Itera sobre cada pessoa na lista */
        for (Pessoa pessoa : pessoas) {
            /* Verifica se a pessoa é um funcionário */
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario)pessoa; 
                /* Exibe as informações do funcionário */
                System.out.printf("\t# %s - %s - %s\n", funcionario.getId(), funcionario.getNome(), funcionario.getCargo());   
            }
        }
    }
     /**
     * Lista todos os clientes cadastrados no sistema.
     */
    public void listarClientes() {
        System.out.println("Lista de Clientes:");
        /* Obtém a lista de todas as pessoas cadastradas no sistema */
        List<Pessoa> pessoas = cadastrados.pesquisar(); 
        Cliente cliente; 
        /* Itera sobre cada pessoa na lista */
        for (Pessoa pessoa : pessoas) {
            /* Verifica se a pessoa é um cliente */
            if (pessoa instanceof Cliente) {
                cliente = (Cliente) pessoa; 
                /*Exibe as informações do cliente */
                System.out.printf("\t# %s - %s - %s\n", cliente.getId(), cliente.getNome(), cliente.getCpf());   
            }
        }
        
    }
        
    // CRUD Aluguel 
    
    // Método para finalizar um aluguel


    
    /* metodos gerenciamento de pessoas*/
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
 * 
 * Cria um cliente novo com as informações fornecidas
 * Após isso, adiciona o cliente ao armazenamento de pessoas cadastradas.
 */ 
    public boolean cadastrarCliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh) {
        Cliente novoCliente = new Cliente(nome, cpf, dataNascimento, endereco, telefone, email, cnh);
        cadastrados.adicionar(novoCliente);
        return true; 
    } 

/**
 * Remove um cliente do sistema com base no ID fornecido.
 * @param id ID do cliente a ser removido.
 * @return True se a remoção for bem-sucedida, False caso contrário.
 * 
 * Remove o cliente com o ID fornecido do armazenamento de pessoas cadastrada.
 */
    public boolean removerCliente(String id) {
        return cadastrados.remover(id); 
    }
/**
 * Cadastra um novo funcionário no sistema.
 *
 * @param id ID do funcionário.
 * @param nome Nome do funcionário.
 * @param cpf CPF do funcionário.
 * @param endereco Endereço do funcionário.
 * @param telefone Telefone do funcionário.
 * @param cargo Cargo do funcionário.
 * @param salario Salário do funcionário.
 * @return True se o cadastro for bem-sucedido, False caso contrário.
 * 
 * Cria um novo funcionário com as informações fornecidas.@interface.
 * Adiciona o funcionário ao armazenamento de pessoas cadastradas.
 */
    public boolean cadastrarFuncionario(String id, String nome, String cpf, String endereco, String telefone, String cargo, double salario) {
        Funcionario novoFuncionario = new Funcionario(id, nome, cpf, endereco, telefone, cargo, salario); 
        cadastrados.adicionar(novoFuncionario);
        return true; 
    }

/**
 * Lista todos os aluguéis ativos no sistema, exibindo suas informações.
 * Obtém a lista de todos os aluguéis ativos no sistema
 * Exibe as informações do aluguel
 */
    public void listarAlugueisAtivos() {
        System.out.println("Alugueis:");
        for (Aluguel aluguel : getAlugueisAtivos()) {
            System.out.println(aluguel.getInfo());
        }; 
    }; 

    /*Metodos gerenciamento de aluguel*/ 
/**
 * Finaliza um aluguel com base nos IDs do cliente e do veículo.
 * @param idCliente ID do cliente que está finalizando o aluguel.
 * @param idVeiculo ID do veículo que está sendo devolvido.
 * @throws AluguelNaoEncontradoException Exceção lançada se o aluguel não for encontrado.
 * @throws ClienteNaoEncontradoException Exceção lançada se o cliente não for encontrado.
 * 
 * Pesquisa os aluguéis ativos do cliente com base no ID do cliente
 * Verifica se o cliente possui aluguéis ativos
 * Procura pelo aluguel associado ao veículo e finaliza-o
 */
    public void finalizarAluguel(String idCliente, String idVeiculo) throws AluguelNaoEncontradoException, ClienteNaoEncontradoException {

        List<Aluguel> alugueisDoCliente = pesquisarAlugadosPorCliente(idCliente);

        if (alugueisDoCliente.size() == 0) {
            throw new AluguelNaoEncontradoException("O cliente ID: "+idCliente+" não possui alugueis ativos");
        }

        for (Aluguel aluguel: alugueisDoCliente) {
            if (aluguel.getVeiculo().getId().equals(idVeiculo)) {
                aluguel.finalizar();
                return; 
            }
        }

        /* Testa se a mudança será salva no armazenamento após chamar o finalizar */
        throw new AluguelNaoEncontradoException("Aluguel não encontrado!");
    }

/**
 * Realiza o aluguel de um veículo para um cliente e adiciona o aluguel à lista de aluguéis ativos.
 * @param cliente Cliente que está alugando o veículo.
 * @param veiculo Veículo a ser alugado.
 * @param dias Número de dias do aluguel.
 * @param funcionarioResponsavel Funcionário responsável pelo aluguel.
 * @return True se o aluguel for bem-sucedido, False caso contrário.
 * 
 * Cria um novo aluguel com informações fornecidas
 * Adiciona o aluguel à lista de aluguéis ativos
 */
    public boolean alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias, Funcionario funcionarioResponsavel) {
        Aluguel aluguel = new Aluguel(UniqueIDGenerator.generateUniqueID(), veiculo, cliente, funcionarioResponsavel, dias);
        alugueisAtivos.adicionar(aluguel);

        return true;
    }
/**
 * Pesquisa aluguéis ativos realizados por um determinado cliente com base no seu ID.
 * @param idCliente ID do cliente.
 * @return Lista de aluguéis ativos realizados pelo cliente.
 * @throws ClienteNaoEncontradoException Exceção lançada se o cliente não for encontrado.
 * 
 * Verifica se o cliente com o ID fornecido existe
 * Verifica se o cliente possui aluguéis ativos e os retorna
 */
    public List<Aluguel> pesquisarAlugadosPorCliente(String idCLiente) throws ClienteNaoEncontradoException {
        
        // verificar se cliente existe 
        Pessoa cliente = getArmazenamentoCadastrados().pesquisar(idCLiente); 
        if (cliente == null) throw new ClienteNaoEncontradoException("CLiente com ID: "+idCLiente+" não existe!");
        
        // verificar se cliente tem alugueis ativos
        List<Aluguel> alugueisAtivos = new ArrayList<>();
        for (Aluguel aluguel : getArmazenamentoAlugueis().pesquisar()) {
            if (aluguel.getCliente().getId().equals(idCLiente) && aluguel.getAtivo()) {
                alugueisAtivos.add(aluguel);
            }
        }

        return alugueisAtivos;
    }

    // controle de login 

    /**
     * Realiza a autenticação do usuário no sistema.
     * @param usuario Nome de usuário.
     * @param senha Senha de acesso.
     */
    public void entrar(String usuario, String senha) {
        // Implementação da lógica de autenticação do usuário no sistema
    }

    /**
     * Realiza a saída do usuário do sistema.
     */
    public void sair() {
        // Implementação da lógica de saída do usuário do sistema
    }
}
