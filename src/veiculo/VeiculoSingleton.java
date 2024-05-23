//package veiculo;/
//Qual das suas abordagens é melhor ficaria como objeto Singleton.
//Singleton é utilizado para atributos estaticos. 
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VeiculoSingleton {
    // Listas imutáveis de tipos de veículos e combustíveis
    private final List<String> tipoVeiculo;
    private final List<String> tipoCombustivel;

    // Construtor privado para evitar instanciamento
    private VeiculoSingleton() {
        tipoVeiculo = Collections.unmodifiableList(Arrays.asList("Carro", "Moto", "Patinete"));
        tipoCombustivel = Collections.unmodifiableList(Arrays.asList("Gasolina", "Diesel", "Hibrido", "Eletrico"));
    }

    // Classe interna estática que contém a instância do Singleton
    private static class SingletonHolder {
        private static final VeiculoSingleton INSTANCE = new VeiculoSingleton();
    }

    // Método público para obter a instância única
    public static VeiculoSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // Métodos para obter as listas imutáveis
    public List<String> getTipoVeiculo() {
        return tipoVeiculo;
    }

    public List<String> getTipoCombustivel() {
        return tipoCombustivel;
    }
}
/*public interface IVeiculo {
    // tipos fixos
    //atributos que vou implementar e depois preencher.
    //IVeiculo deveria ser uma classe abstrata - já  tem os atributos pré preenchidos
    //Boas práticas de codificação.
    //Isso é o ideal Podemos transformar a IVeiculo em object - (Singleton) instancia unica que fica alocado na RAM do pc.
    String tiposVeiculo [] = {"Carro", "Moto", "Patinete"};
    String tiposCombustivel [] = {"Gasolina", "Diesel", "Hibrido", "Eletrico"}; 

}*/