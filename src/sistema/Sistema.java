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

        // popular dados de inicialização 
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
            new Cliente("Marcelo", "000.000.002-01", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", "12345678901")
        );
        cadastrados.adicionar(
            new Cliente("Lucas", "000.000.000-06", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", "22345678901")
        );
        cadastrados.adicionar(
            new Cliente("Breno", "000.000.000-11", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", "32345678901")
        );
        cadastrados.adicionar(
            new Cliente("Marcio", "000.000.001-21", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", "42345678901")
        );

        // veiculos.adicionar(new Veiculo("1", "UN-43", "azn0023", 30.0, 1, 2, "Uno", "GMB", "2000", "Laranja", 15000));
        // veiculos.adicionar(new Veiculo("2", "", "atx0283", 30.0, 1, 2, "Celta", "PPL", "2010", "Preto", 30000));
        // veiculos.adicionar(new Veiculo("3", "", "azd0350", 30.0, 1, 2, "Marea", "PPL", "1990", "Preto", 150000));
        
        // veículos pré cadastrados 
        veiculos.adicionar(new Veiculo("1", "Modelo X", "ABC1234", 50.0, 0, 1, "Tesla", "Sedan", "2022", "Preto", 5000));
        veiculos.adicionar(new Veiculo("2", "Civic", "DEF5678", 45.0, 0, 1, "Honda", "Sedan", "2021", "Prata", 10000));
        veiculos.adicionar(new Veiculo("3", "Corolla", "GHI9012", 40.0, 0, 1, "Toyota", "Sedan", "2020", "Branco", 20000));
        veiculos.adicionar(new Veiculo("4", "Golf", "JKL3456", 35.0, 0, 1, "Volkswagen", "Hatch", "2019", "Azul", 15000));
        veiculos.adicionar(new Veiculo("5", "Model 3", "MNO7890", 60.0, 0, 1, "Tesla", "Sedan", "2023", "Vermelho", 3000));
        veiculos.adicionar(new Veiculo("6", "Ninja 300", "PQR1234", 25.0, 1, 2, "Kawasaki", "Esportiva", "2020", "Verde", 5000));
        veiculos.adicionar(new Veiculo("7", "CB 500X", "STU5678", 30.0, 1, 2, "Honda", "Trail", "2019", "Preto", 8000));
        veiculos.adicionar(new Veiculo("8", "MT-03", "VWX9012", 28.0, 1, 2, "Yamaha", "Naked", "2021", "Azul", 4000));
        veiculos.adicionar(new Veiculo("9", "R3", "YZA3456", 32.0, 1, 2, "Yamaha", "Esportiva", "2022", "Branco", 3000));
        veiculos.adicionar(new Veiculo("10", "Ducati Monster", "BCD7890", 35.0, 1, 2, "Ducati", "Naked", "2023", "Vermelho", 2000));
        veiculos.adicionar(new Veiculo("11", "Xiaomi M365", "EFG1234", 15.0, 2, 3, "Xiaomi", "Elétrico", "2021", "Preto", 1000));
        veiculos.adicionar(new Veiculo("12", "Segway Ninebot", "HIJ5678", 18.0, 2, 3, "Segway", "Elétrico", "2022", "Branco", 800));
        veiculos.adicionar(new Veiculo("13", "Razor E300", "KLM9012", 12.0, 2, 3, "Razor", "Elétrico", "2020", "Azul", 1200));
        veiculos.adicionar(new Veiculo("14", "Gotrax GXL", "NOP3456", 20.0, 2, 3, "Gotrax", "Elétrico", "2023", "Vermelho", 500));
        veiculos.adicionar(new Veiculo("15", "Glion Dolly", "QRS7890", 17.0, 2, 3, "Glion", "Elétrico", "2021", "Cinza", 700));

        // Funcionários pré cadastrados 
        cadastrados.adicionar(new Funcionario("Eduardo", "000.000.000-00", "Rua S, 22", "00 90000-0000", "Vendedor", 10500.0, "12345"));
        cadastrados.adicionar(new Funcionario("Ana Maria", "111.111.111-11", "Avenida Central, 101", "11 91111-1111", "Gerente", 15000.0, "senha123"));
        cadastrados.adicionar(new Funcionario("Carlos Silva", "222.222.222-22", "Rua das Flores, 45", "22 92222-2222", "Assistente", 8000.0, "abc123"));
        cadastrados.adicionar(new Funcionario("Beatriz Souza", "333.333.333-33", "Rua do Sol, 120", "33 93333-3333", "Vendedor", 9500.0, "beatriz123"));
        cadastrados.adicionar(new Funcionario("Fernando Costa", "444.444.444-44", "Avenida Paulista, 1000", "44 94444-4444", "Analista", 12000.0, "fercosta"));
        cadastrados.adicionar(new Funcionario("Mariana Rocha", "555.555.555-55", "Praça da Liberdade, 55", "55 95555-5555", "Recepcionista", 7000.0, "mariana2023"));
        cadastrados.adicionar(new Funcionario("Rafael Gomes", "666.666.666-66", "Rua das Palmeiras, 300", "66 96666-6666", "Desenvolvedor", 13500.0, "rafaelDev"));
        cadastrados.adicionar(new Funcionario("Juliana Alves", "777.777.777-77", "Rua das Acácias, 78", "77 97777-7777", "Designer", 11000.0, "julidesign"));
        cadastrados.adicionar(new Funcionario("Roberto Lima", "888.888.888-88", "Avenida Brasil, 200", "88 98888-8888", "Vendedor", 9500.0, "roberto88"));
        cadastrados.adicionar(new Funcionario("Patrícia Mendes", "999.999.999-99", "Rua das Hortências, 45", "99 99999-9999", "Analista", 12500.0, "pat1234"));


        alugueisAtivos.adicionar(new Aluguel(veiculos.pesquisar("1"), (Cliente)cadastrados.pesquisar("00000000201"), (Funcionario)cadastrados.pesquisar("00000000000"), 10)); 
        alugueisAtivos.adicionar(new Aluguel(veiculos.pesquisar("2"), (Cliente)cadastrados.pesquisar("00000000006"), (Funcionario)cadastrados.pesquisar("22222222222"), 15)); 
        alugueisAtivos.adicionar(new Aluguel(veiculos.pesquisar("3"), (Cliente)cadastrados.pesquisar("00000000011"), (Funcionario)cadastrados.pesquisar("66666666666"), 45)); 

    }

    // métodos de gerenciamento interno

    /* Métodos de acesso ao armazenamento. */
    /**
     * Obtém o armazenamento de aluguéis ativos.
     * @return O armazenamento de aluguéis ativos.
     */
    private List<Aluguel> getAlugueisAtivos() { return alugueisAtivos.pesquisar(); }

    /**
     * Obtém o armazenamento de aluguéis.
     * @return O armazenamento de aluguéis.
     */
    private Armazenamento<Aluguel> getArmazenamentoAlugueis() { return alugueisAtivos; }

    /**
     * Obtém o armazenamento de pessoas cadastradas.
     * @return O armazenamento de pessoas cadastradas.
     */
    private Armazenamento<Pessoa> getArmazenamentoCadastrados() {return cadastrados; }
    
    /**
     * Obtém o funcionário atual no sistema.
     * @return O funcionário atual no sistema.
     */
    private Pessoa getFuncionario() { return funcionario; }
    
    /**
     * Atualiza o funcionário atual no sistema.
     */
    private void setFuncionario(Pessoa funcionario) { this.funcionario = funcionario; }
    
    /**
     * Atualiza o funcionário atual no sistema.
     */
    private void verificarLogin() throws FuncionarioNaoEncontradoException {
        if (getFuncionario() == null) throw new FuncionarioNaoEncontradoException("É necessário fazer login no sistema para realizar esta operação!"); 
    }
    
    
    // métodos do sistema 
    /* Métodos de listagem de informações*/
    /**
     * Lista todos os funcionários cadastrados no sistema.
     */
    public List<String> listarFuncionarios() throws FuncionarioNaoEncontradoException {
        verificarLogin();

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
        verificarLogin();

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
        verificarLogin();
        
        List<String> infoVeiculos = new ArrayList<>();

        for (Veiculo veiculo : veiculos.pesquisar()) {
            infoVeiculos.add(veiculo.getInfo()); 
        }

        return infoVeiculos; 
    }


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
        verificarLogin();
        
        if (nome.equals("") || dataNascimento.equals("") || endereco.equals("") || telefone.equals("") || email.equals("") || cnh.equals("") || cpf.equals("")) {
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
    public void removerCliente(String id) throws FuncionarioNaoEncontradoException, ClienteNaoEncontradoException{
        verificarLogin();

        boolean remocao = cadastrados.remover(id); 

        if (!remocao) throw new ClienteNaoEncontradoException("Cliente com CPF "+id+" não existe!");
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
        verificarLogin();
        
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
        verificarLogin();

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
        
        verificarLogin();


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
        
        verificarLogin();


        Cliente cliente = (Cliente) cadastrados.pesquisar(idCliente); 
        if ( cliente == null ) throw new ClienteNaoEncontradoException("Cliente com ID: " + idCliente + " não encontrado!");

        Veiculo veiculo = veiculos.pesquisar(idVeiculo); 
        if ( veiculo == null ) throw new VeiculoNaoEncontradoException("Veiculo com ID: " + idVeiculo + " não encontrado!");
        if ( !veiculo.isDisponivel() ) throw new VeiculoNaoDisponivelException("Veículo com ID: "+idVeiculo+" não está disponível no momento!"); 
        
        Aluguel aluguel = new Aluguel(veiculo, cliente, (Funcionario) getFuncionario(), dias);
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
        
        verificarLogin();

        
        // verificar se o cliente existe 
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
