package veiculo;

public interface IVeiculo {
    // tipos fixos
    String tiposVeiculo [] = {"Carro", "Moto", "Patinete"};
    String tiposCombustivel [] = {"Gasolina", "Diesel", "Hibrido", "Eletrico"}; 

    public double calcularPrecoAluguel();
}