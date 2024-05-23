

import aluguel.Aluguel;
import pessoas.Cliente;
import pessoas.Funcionario;
import veiculo.Veiculo;
//Só tem o nome da função para ser escrita depopis (Contrato)
public interface ISistema {
    public boolean alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias, Funcionario funciomarioResponsavel);
    public void finalizarAluguel(Aluguel aluguel);
}
