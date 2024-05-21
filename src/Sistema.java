import java.util.ArrayList;
import java.util.List;

import aluguel.*;
import pessoas.*;
import utils.Armazenamento;
import veiculo.*;

public class Sistema {
    private Armazenamento<Pessoa> cadastrados = new Armazenamento<>(); 

    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Aluguel> alugueisAtivos = new ArrayList<>();

    public Sistema() {

        // adicionar funcionarios 
        cadastrados.adicionar(
            new Funcionario("0", "Eduardo", "000.000.000-00", "Rua S, 22", "00 90000-0000", "Supervisor", 10500.0)
        ); 

        cadastrados.adicionar(
            new Funcionario("1", "Mario", "000.000.000-01", "Rua D, 12", "00 60000-0000", "Estagiario", 500.0)
        ); 

        cadastrados.adicionar(
            new Cliente("2", "Marcelo", "000.000.002-01", "10/03/2005", "Rua N - 45", "(54) 99996-3305", "marcelo@marcelo.marcelo", null)
        ); 

        veiculos.add(new Veiculo("Civic", "azn0023", 30.0, 1, 2));
        alugueisAtivos.add(new Aluguel(veiculos.get(0), (Cliente)cadastrados.pesquisar("2"), (Funcionario)cadastrados.pesquisar("1"))); 
    }

    public List<Veiculo> getVeiculos() { return this.veiculos; }
    public List<Aluguel> getAlugueisAtivos() { return this.alugueisAtivos; }

    
    public static void main (String[] args) {
        System.out.print("\033[H\033[2J"); // limpar terminal antes de começar
        Sistema sistema = new Sistema(); 
        sistema.listarFuncionarios();
        sistema.listarClientes();
        sistema.listarAlugueisAtivos();
        

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
    
    // Método para alugar um veículo
    public boolean alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias) {
        // Verificar disponibilidade do veículo e datas válidas
        // Criar um novo objeto Aluguel
        // Adicionar o Aluguel na lista de alugueis ativos
        // Atualizar a disponibilidade do veículo
        // Retornar o objeto Aluguel
        Aluguel novoAluguel = new Aluguel(null, null, null);
        // armazenar aluguel 
        return true; 
    }

    // Método para finalizar um aluguel
    public void finalizarAluguel(Aluguel aluguel) {
        // Calcular o valor total do aluguel
        // Registrar o pagamento
        // Remover o Aluguel da lista de alugueis ativos
        // Atualizar a disponibilidade do veículo
    }

    public void listarAlugueisAtivos() {
        System.out.println("Alugueis:");
        for (Aluguel aluguel : getAlugueisAtivos()) {
            System.out.println(aluguel.getInfo());
        }; 
    }; 
    
    // CRUD Clientes 
    public boolean cadastrarCliente() {
        return true; 
    } 



}
