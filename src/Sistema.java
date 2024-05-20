

import java.util.ArrayList;
import java.util.List;

import aluguel.*;
import pessoas.*;
import veiculo.*;

public class Sistema implements ISistema {
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    private List<Veiculo> veiculos;
    private List<Aluguel> alugueisAtivos;

    public Sistema() {
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.alugueisAtivos = new ArrayList<>();

        // adicionar alguns funcionários para teste 
        funcionarios.add(new Funcionario("0", "Eduardo", "000.000.000-00", "Rua S, 22", "00 90000-0000", "Supervisor", 10500.0));
        funcionarios.add(new Funcionario("1", "Mario", "000.000.000-01", "Rua D, 12", "00 60000-0000", "Estagiario", 500.0));
    }
    
    // Getters / Setters
    public List<Funcionario> getFuncionarios() { return this.funcionarios; }
    public List<Cliente> getClientes() { return this.clientes; }
    public List<Veiculo> getVeiculos() { return this.veiculos; }
    public List<Aluguel> getAlugueisAtivos() { return this.alugueisAtivos; }
    
    // public void setFuncionarios(List<Funcionario> funcionarios) { this.funcionarios = funcionarios; }
    // public void setClientes(List<Cliente> clientes) { this.clientes = clientes; }
    // public void setVeiculos(List<Veiculo> veiculos) { this.veiculos = veiculos; }
    // public void setAlugueisAtivos(List<Aluguel> alugueisAtivos) { this.alugueisAtivos = alugueisAtivos; }
    
    public static void main (String[] args) {
        System.out.print("\033[H\033[2J"); // limpar terminal antes de começar
        Sistema sistema = new Sistema(); 

        sistema.listarFuncionarios();
    }
    
    public void listarFuncionarios() {
        System.out.println("Lista de Funcionários:");
        Funcionario funcionario; 
        for (int i = 0; i < getFuncionarios().size(); i++) {
            funcionario = getFuncionarios().get(i);
            System.out.printf("\t# %s - %s - %s\n", funcionario.getId(), funcionario.getNome(), funcionario.getCargo());
        }
    }

    
    // CRUD Funcionário
    
    // CRUD Cliente (MSV)
    
    // CRUD Veículos 
    
    // CRUD Aluguel (MSV)

    // Método para alugar um veículo
    public Aluguel alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias) {
        // Verificar disponibilidade do veículo e datas válidas
        // Criar um novo objeto Aluguel
        // Adicionar o Aluguel na lista de alugueis ativos
        // Atualizar a disponibilidade do veículo
        // Retornar o objeto Aluguel
        return new Aluguel(null, null, null);
    }

    // Método para finalizar um aluguel
    public void finalizarAluguel(Aluguel aluguel) {
        // Calcular o valor total do aluguel
        // Registrar o pagamento
        // Remover o Aluguel da lista de alugueis ativos
        // Atualizar a disponibilidade do veículo
    }


}
