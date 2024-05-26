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

public class Sistema implements ISistema{
    private Armazenamento<Pessoa> cadastrados = new Armazenamento<>(); 
    private Armazenamento<Veiculo> veiculos = new Armazenamento<>();
    private Armazenamento<Aluguel> alugueisAtivos = new Armazenamento<>();

    public Sistema() {

        // adicionar funcionarios         
        cadastrados.adicionar(
            new Funcionario("0", "Eduardo", "000.000.000-00", "Rua S, 22", "00 90000-0000", "Supervisor", 10500.0)
        ); 

        cadastrados.adicionar(
            new Funcionario("1", "Mario", "000.000.000-01", "Rua D, 12", "00 60000-0000", "Estagiario", 500.0)
        ); 

        cadastrarCliente("Marcelo", "000.000.002-01", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", null);

        veiculos.adicionar(new Veiculo("1", "UN-43", "azn0023", 30.0, 0, 2, "Uno", "GMB", "2000", "Laranja", 15000));
        alugueisAtivos.adicionar(new Aluguel("10", veiculos.pesquisar("1"), (Cliente)cadastrados.pesquisar("00000000201"), (Funcionario)cadastrados.pesquisar("1"), (10))); 

        // cadastrados.pesquisar("00000000201").get(0).nome = "Genesio";
    }

    // public List<Veiculo> getVeiculos() { return this.veiculos; }
    public List<Aluguel> getAlugueisAtivos() { return alugueisAtivos.pesquisar(); }

    public Armazenamento<Aluguel> getArmazenamentoAlugueis() { return alugueisAtivos; }
    public Armazenamento<Pessoa> getArmazenamentoCadastrados() {return cadastrados; }

    
    public static void main (String[] args) {
        try {
        System.out.println("\033[H\033[2J"); // limpar terminal antes de começar
        Sistema sistema = new Sistema(); 
        // sistema.listarFuncionarios();
        // sistema.listarClientes();
        // sistema.listarAlugueisAtivos();
        // sistema.listarFuncionarios();

        sistema.listarAlugueisAtivos();
        // sistema.removerCliente("2");
        // sistema.listarAlugueisAtivos();
        sistema.finalizarAluguel("00000000201", "1");
        System.out.println(sistema.getArmazenamentoCadastrados().pesquisar("00000000201").getInfo());
        
        sistema.listarAlugueisAtivos();
        
        // sistema.listarClientes();
    } 
    catch(RuntimeException ex) {
        System.out.println(ex.getMessage());
    }
    }
    
    public void listarFuncionarios() {
        System.out.println("Lista de Funcionários:");
        List<Pessoa> pessoas = cadastrados.pesquisar(); 
        Funcionario funcionario; 

        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Funcionario) {
                funcionario = (Funcionario)pessoa; 
                System.out.printf("\t# %s - %s - %s\n", funcionario.getId(), funcionario.getNome(), funcionario.getCargo());   
            }
        }
    }
        
    public void listarClientes() {
        System.out.println("Lista de Clientes:");
        List<Pessoa> pessoas = cadastrados.pesquisar(); 
        Cliente cliente; 

        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Cliente) {
                cliente = (Cliente) pessoa; 
                System.out.printf("\t# %s - %s - %s\n", cliente.getId(), cliente.getNome(), cliente.getCpf());   
            }
        }
        
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

    public boolean cadastrarFuncionario(String id, String nome, String cpf, String endereco, String telefone, String cargo, double salario) {
        Funcionario novoFuncionario = new Funcionario(id, nome, cpf, endereco, telefone, cargo, salario); 
        cadastrados.adicionar(novoFuncionario);
        return true; 
    }


    public void listarAlugueisAtivos() {
        System.out.println("Alugueis:");
        for (Aluguel aluguel : getAlugueisAtivos()) {
            System.out.println(aluguel.getInfo());
        }; 
    }; 

    // metodos gerenciamento de aluguel 
    public void finalizarAluguel(String idCliente, String idVeiculo) {

        List<Aluguel> alugueisDoCliente = pesquisarAlugadosPorCliente(idCliente);

        if (alugueisDoCliente.size() == 0) {
            throw new RuntimeException("O cliente ID: "+idCliente+" não possui alugueis ativos");
        }

        for (Aluguel aluguel: alugueisDoCliente) {
            if (aluguel.getVeiculo().getId().equals(idVeiculo)) {
                aluguel.finalizar();
                return; 
            }
        }

        // testar se a mudança será salva no armazenamento após chamar o finalizar 
        throw new Error("Aluguel não encontrado!"); 
    }

    public boolean alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias, Funcionario funcionarioResponsavel) {
        Aluguel aluguel = new Aluguel(UniqueIDGenerator.generateUniqueID(), veiculo, cliente, funcionarioResponsavel, dias);
        alugueisAtivos.adicionar(aluguel);

        return true;
    }

    public List<Aluguel> pesquisarAlugadosPorCliente(String idCLiente) {
        List<Aluguel> alugueisAtivos = new ArrayList<>();


        for (Aluguel aluguel : getArmazenamentoAlugueis().pesquisar()) {
            if (aluguel.getCliente().getId().equals(idCLiente) && aluguel.getAtivo()) {
                alugueisAtivos.add(aluguel);
            }
        }

        return alugueisAtivos; 
    }

}
