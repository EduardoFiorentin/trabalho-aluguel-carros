package sistema;
import aluguel.*;
import java.util.ArrayList;
import java.util.List;


import pessoas.*;
import utils.Armazenamento;
import utils.UniqueIDGenerator;
import veiculo.*;
import exceptions.*;

// funções de adição de aluguel 

public class Sistema implements ISistema{
    private Armazenamento<Pessoa> cadastrados = new Armazenamento<>(); 
    private Armazenamento<Veiculo> veiculos = new Armazenamento<>();
    private Armazenamento<Aluguel> alugueisAtivos = new Armazenamento<>();
    private Pessoa funcionario = null; 

    public Sistema() {

        // adicionar funcionarios         
        cadastrados.adicionar(
            new Funcionario( "Eduardo", "000.000.000-00", "Rua S, 22", "00 90000-0000", "Vendedor", 10500.0, "12345")
        ); 

        cadastrados.adicionar(
            new Funcionario("Mario", "000.000.000-01", "Rua D, 12", "00 60000-0000", "Vendedor", 500.0, "mario123")
        ); 

        cadastrarCliente("Marcelo", "000.000.002-01", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", null);

        veiculos.adicionar(new Veiculo("1", "UN-43", "azn0023", 30.0, 1, 2, "Uno", "GMB", "2000", "Laranja", 15000));
        veiculos.adicionar(new Veiculo("2", "", "atx0283", 30.0, 1, 2, "Celta", "PPL", "2010", "Preto", 30000));
        veiculos.adicionar(new Veiculo("3", "", "azd0350", 30.0, 1, 2, "Marea", "PPL", "1990", "Preto", 150000));
        alugueisAtivos.adicionar(new Aluguel("10", veiculos.pesquisar("1"), (Cliente)cadastrados.pesquisar("00000000201"), (Funcionario)cadastrados.pesquisar("00000000000"), 10)); 

        // cadastrados.pesquisar("00000000201").get(0).nome = "Genesio";
    }

    // public List<Veiculo> getVeiculos() { return this.veiculos; }
    public List<Aluguel> getAlugueisAtivos() { return alugueisAtivos.pesquisar(); }
    public Armazenamento<Aluguel> getArmazenamentoAlugueis() { return alugueisAtivos; }
    public Armazenamento<Pessoa> getArmazenamentoCadastrados() {return cadastrados; }

    public Pessoa getFuncionario() { return funcionario; }
    public void setFuncionario(Pessoa funcionario) { this.funcionario = funcionario; }
    

    public List<String> listarFuncionarios() {
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
        
    public List<String> listarClientes() {
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
        
    public List<String> listarVeiculos()  {
        List<String> infoVeiculos = new ArrayList<>();

        for (Veiculo veiculo : veiculos.pesquisar()) {
            infoVeiculos.add(veiculo.getInfo()); 
        }

        return infoVeiculos; 
    }

    // CRUD Aluguel 
    
    // Método para finalizar um aluguel


    
    // metodos gerenciamento de pessoas  
    public boolean cadastrarCliente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email, String cnh) {
        Cliente novoCliente = new Cliente(nome, cpf, dataNascimento, endereco, telefone, email, cnh);
        cadastrados.adicionar(novoCliente);
        return true; 
    } 

    public boolean removerCliente(String id) {
        return cadastrados.remover(id); 
    }

    public boolean cadastrarFuncionario(String nome, String cpf, String endereco, String telefone, String cargo, double salario, String senha) {
        Funcionario novoFuncionario = new Funcionario(nome, cpf, endereco, telefone, cargo, salario, senha); 
        cadastrados.adicionar(novoFuncionario);
        return true; 
    }


    public List<String> listarAlugueisAtivos() {
        ArrayList<String> alugueis = new ArrayList<>();

        for (Aluguel aluguel : getAlugueisAtivos()) {
            if (aluguel.getAtivo()) alugueis.add(aluguel.getInfo());
        }; 
        return alugueis; 
    }; 

    // metodos gerenciamento de aluguel 
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

        // testar se a mudança será salva no armazenamento após chamar o finalizar 
        throw new AluguelNaoEncontradoException("Aluguel não encontrado!");
    }

    public boolean alugarVeiculo(String idCliente, String idVeiculo, int dias) throws ClienteNaoEncontradoException, VeiculoNaoDisponivelException, VeiculoNaoEncontradoException, FuncionarioNaoEncontradoException {
        
        Cliente cliente = (Cliente) cadastrados.pesquisar(idCliente); 
        if ( cliente == null ) throw new ClienteNaoEncontradoException("Cliente com ID: " + idCliente + " não encontrado!");

        Veiculo veiculo = veiculos.pesquisar(idVeiculo); 
        if ( veiculo == null ) throw new VeiculoNaoEncontradoException("Veiculo com ID: " + idVeiculo + " não encontrado!");
        if ( !veiculo.isDisponivel() ) throw new VeiculoNaoDisponivelException("Veículo com ID: "+idVeiculo+" não está disponível no momento!"); 
        
        Aluguel aluguel = new Aluguel(UniqueIDGenerator.generateUniqueID(), veiculo, cliente, (Funcionario) getFuncionario(), dias);
        alugueisAtivos.adicionar(aluguel);

        return true;
    }

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

    public void entrar(String id, String senha) throws UsuarioNaoEncontrado {
        Pessoa logUsuario = cadastrados.pesquisar(id);
        // System.out.println("Log: "+logUsuario.getNome());

        if (logUsuario == null || !(logUsuario instanceof Funcionario)) throw new UsuarioNaoEncontrado("Usuário não existe!"); 
        // if ((Funcionario)logUsuario)
        if (!((Funcionario)logUsuario).verificarSenha(senha)) throw new UsuarioNaoEncontrado("Senha incorreta!");

        setFuncionario(logUsuario);
    }

    
    public void sair() {
        setFuncionario(null);
    }

}
