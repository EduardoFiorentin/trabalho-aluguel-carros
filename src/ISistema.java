package sistema;

import aluguel.Aluguel;
import pessoas.Cliente;
import veiculo.Veiculo;

public interface ISistema {
    public Aluguel alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias);
    public void finalizarAluguel(Aluguel aluguel);
}
