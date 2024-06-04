package sistema;
import aluguel.*;
import excecoes.*;

import java.util.ArrayList;
import java.util.List;


import pessoas.*;
import utilitarios.Armazenamento;
import utilitarios.UniqueIDGenerator;
import veiculo.*;

// funções de adição de aluguel 
/**
 * Implementação da interface ISistema que define as operações disponíveis no sistema de aluguel 
 * de veículos.
 */
public class Sistema implements ISistema{
    private Armazenamento<Pessoa> cadastrados = new Armazenamento<>(); 
    private Armazenamento<Veiculo> veiculos = new Armazenamento<>();
    private Armazenamento<Aluguel> alugueisAtivos = new Armazenamento<>();
    private Pessoa funcionario = null; 

    /**
     * Construtor padrão da classe Sistema.
     */
    public Sistema() {

        // adicionar funcionarios  
        /**
         * São criados métodos que possibilita o cadastro de funcionários, clientes e alugueis ativos.
         * Esse servirá para que quando necessário acessar o Sistema para processar uma transação 
         * de aluguél o funcionário necessite apenas das informações do seu login e sua senha.
        */            
        cadastrados.adicionar(
            new Funcionario( "Eduardo", "000.000.000-00", "Rua S, 22", "00 90000-0000", "Vendedor", 10500.0, "12345")
        ); 

        cadastrados.adicionar(
            new Funcionario("Mario", "000.000.000-01", "Rua D, 12", "00 60000-0000", "Vendedor", 500.0, "mario123")
        ); 

        cadastrados.adicionar(
            new Cliente("Marcelo", "000.000.002-01", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", null)
        );

        veiculos.adicionar(new Veiculo("1", "UN-43", "azn0023", 30.0, 1, 2, "Uno", "GMB", "2000", "Laranja", 15000));
        veiculos.adicionar(new Veiculo("2", "", "atx0283", 30.0, 1, 2, "Celta", "PPL", "2010", "Preto", 30000));
        veiculos.adicionar(new Veiculo("3", "", "azd0350", 30.0, 1, 2, "Marea", "PPL", "1990", "Preto", 150000));
        
        alugueisAtivos.adicionar(new Aluguel("10", veiculos.pesquisar("1"), (Cliente)cadastrados.pesquisar("00000000201"), (Funcionario)cadastrados.pesquisar("00000000000"), 10)); 

    }

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
    
    /**
     * Obtém o funcionário atual no sistema.
     * @return O funcionário atual no sistema.
     */
    public Pessoa getFuncionario() { return funcionario; }
    
    /**
     * Atualiza o funcionário atual no sistema.
     */
    public void setFuncionario(Pessoa funcionario) { this.funcionario = funcionario; }
    
    
    /* Métodos de listagem de informações*/
    /**
     * Lista todos os funcionários cadastrados no sistema.
     */
    public List<String> listarFuncionarios() throws FuncionarioNaoEncontradoException {
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 

        List<Pessoa> pessoas = cadastrados.pesquisar(); 
        Funcionario funcionario; 
        List<String> infoFuncionarios = new ArrayList(); 

        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario)pessoa; 
                infoFuncionarios.add(funcionario.getInfo());   
            }
        }
        return infoFuncionarios; 
    }
        
    /**
     * Lista todos os clientes cadastrados no sistema.
     */
    public List<String> listarClientes() throws FuncionarioNaoEncontradoException{
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 

        List<Pessoa> pessoas = cadastrados.pesquisar(); 
        Cliente cliente; 
        List<String> infoClientes = new ArrayList(); 

        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Cliente) {
                cliente = (Cliente) pessoa; 
                infoClientes.add(cliente.getInfo());
            }
        }
        return infoClientes; 
    }
        
    /**
     * Lista todos os vaículos cadastrados no sistema.
     */
    public List<String> listarVeiculos() throws FuncionarioNaoEncontradoException {
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 
        
        List<String> infoVeiculos = new ArrayList<>();

        for (Veiculo veiculo : veiculos.pesquisar()) {
            infoVeiculos.add(veiculo.getInfo()); 
        }

        return infoVeiculos; 
    }

    // CRUD Aluguel 
    
    // Método para finalizar um aluguel


    
    // metodos gerenciamento de pessoas  

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
    public void cadastrarCliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh) throws FuncionarioNaoEncontradoException, InformacoesInsuficientesException{
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 
        
        if (nome.equals(null) || dataNascimento.equals(null) || endereco.equals(null) || telefone.equals(null) || email.equals(null) || cnh.equals(null) || cpf.equals(null)) {
            throw new InformacoesInsuficientesException("Todas as informações são obrigatórias");
        }

        Cliente novoCliente = new Cliente(nome, cpf, dataNascimento, endereco, telefone, email, cnh);
        cadastrados.adicionar(novoCliente);
    } 

    /**
     * Remove um cliente do sistema com base no ID fornecido.
     * @param id ID do cliente a ser removido.
     * @return True se a remoção for bem-sucedida, False caso contrário.
     * 
     * Remove o cliente com o ID fornecido do armazenamento de pessoas cadastrada.
     */
    public boolean removerCliente(String id) throws FuncionarioNaoEncontradoException{
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 

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
     * @param senha Senha de acesso do funcionário ao sistema.
     * @return True se o cadastro for bem-sucedido, False caso contrário.
     * 
     * Cria um novo funcionário com as informações fornecidas.@interface.
     * Adiciona o funcionário ao armazenamento de pessoas cadastradas.
     */
    public boolean cadastrarFuncionario(String nome, String cpf, String endereco, String telefone, String cargo, double salario, String senha) throws FuncionarioNaoEncontradoException{
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 
        
        Funcionario novoFuncionario = new Funcionario(nome, cpf, endereco, telefone, cargo, salario, senha); 
        cadastrados.adicionar(novoFuncionario);
        return true; 
    }

    /**
     * Lista todos os aluguéis ativos no sistema, exibindo suas informações.
     * Obtém a lista de todos os aluguéis ativos no sistema
     * Exibe as informações do aluguel
     */
    public List<String> listarAlugueisAtivos() throws FuncionarioNaoEncontradoException{
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 

        ArrayList<String> alugueis = new ArrayList<>();

        for (Aluguel aluguel : getAlugueisAtivos()) {
            if (aluguel.getAtivo()) alugueis.add(aluguel.getInfo());
        }; 
        return alugueis; 
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
    public void finalizarAluguel(String idCliente, String idVeiculo) throws AluguelNaoEncontradoException, ClienteNaoEncontradoException, FuncionarioNaoEncontradoException {
        
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 

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
    public boolean alugarVeiculo(String idCliente, String idVeiculo, int dias) throws ClienteNaoEncontradoException, VeiculoNaoDisponivelException, VeiculoNaoEncontradoException, FuncionarioNaoEncontradoException {
        
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 

        Cliente cliente = (Cliente) cadastrados.pesquisar(idCliente); 
        if ( cliente == null ) throw new ClienteNaoEncontradoException("Cliente com ID: " + idCliente + " não encontrado!");

        Veiculo veiculo = veiculos.pesquisar(idVeiculo); 
        if ( veiculo == null ) throw new VeiculoNaoEncontradoException("Veiculo com ID: " + idVeiculo + " não encontrado!");
        if ( !veiculo.isDisponivel() ) throw new VeiculoNaoDisponivelException("Veículo com ID: "+idVeiculo+" não está disponível no momento!"); 
        
        Aluguel aluguel = new Aluguel(UniqueIDGenerator.generateUniqueID(), veiculo, cliente, (Funcionario) getFuncionario(), dias);
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
    public List<Aluguel> pesquisarAlugadosPorCliente(String idCLiente) throws ClienteNaoEncontradoException, FuncionarioNaoEncontradoException {
        
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 
        
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

    /**
     * Realiza a autenticação do usuário no sistema.
     * @param usuario Nome de usuário.
     * @param senha Senha de acesso.
     */
    public void entrar(String id, String senha) throws UsuarioNaoEncontrado {
        Pessoa logUsuario = cadastrados.pesquisar(id);

        if (logUsuario == null || !(logUsuario instanceof Funcionario)) throw new UsuarioNaoEncontrado("Usuário não existe!"); 
        if (!((Funcionario)logUsuario).verificarSenha(senha)) throw new UsuarioNaoEncontrado("Senha incorreta!");

        setFuncionario(logUsuario);
    }

    /**
     * Realiza a saída do usuário do sistema.
     */
    public void sair() {
        setFuncionario(null);
    }

}
