import aluguel.*;
import java.util.List;
import pessoas.*;
import utils.Armazenamento;
import utils.UniqueIDGenerator;
import veiculo.*;

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

        veiculos.adicionar(new Veiculo("8", "Civic", "azn0023", 30.0, 1, 2));
        alugueisAtivos.adicionar(new Aluguel("10", veiculos.pesquisar("8"), (Cliente)cadastrados.pesquisar("00000000201"), (Funcionario)cadastrados.pesquisar("1"), (10))); 
    }

    // public List<Veiculo> getVeiculos() { return this.veiculos; }
    public List<Aluguel> getAlugueisAtivos() { return alugueisAtivos.pesquisar(); }

    
    public static void main (String[] args) {
        System.out.print("\033[H\033[2J"); // limpar terminal antes de começar
        Sistema sistema = new Sistema(); 
        // sistema.listarFuncionarios();
        sistema.listarClientes();
        // sistema.listarAlugueisAtivos();
        sistema.listarFuncionarios();

        sistema.listarAlugueisAtivos();
        // sistema.removerCliente("2");
        // sistema.listarAlugueisAtivos();
        sistema.listarClientes();

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

    public void listarAlugueisAtivos() {
        System.out.println("Alugueis:");
        for (Aluguel aluguel : getAlugueisAtivos()) {
            System.out.println(aluguel.getInfo());
        }; 
    }; 
    
    // CRUD Clientes 
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

    @Override
    public void finalizarAluguel(Aluguel aluguel) {
        Aluguel aluguelFinalizado = alugueisAtivos.pesquisar(aluguel.getId());
        aluguelFinalizado.finalizar();
    }

    @Override
    public boolean alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias, Funcionario funcionarioResponsavel) {
        Aluguel aluguel = new Aluguel(UniqueIDGenerator.generateUniqueID(), veiculo, cliente, funcionarioResponsavel, dias);
            alugueisAtivos.adicionar(aluguel);

        return true;
    }

}
