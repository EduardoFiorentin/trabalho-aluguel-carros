package veiculo;/*Declara o pacote veiculo onde a classe VeiculoSingleton está localizada. */

import java.util.Arrays;/*Importa a classe Arrays para manipulação de arrays. */
import java.util.Collections;/* Importa a classe Collections para trabalhar com coleções imutáveis.*/
import java.util.List;/* Importa a interface List para trabalhar com listas de objetos.*/

/**
 * Singleton para gerenciamento dos tipos de veículos e combustíveis.
 * Esta classe fornece listas imutáveis dos tipos de veículos e combustíveis como um Singleton.
 */
public class VeiculoSingleton {
    /*Listas imutáveis de tipos de veículos e combustíveis*/
    private final List<String> tipoVeiculo;
    private final List<String> tipoCombustivel;

    /**
     * Construtor privado para evitar instanciamento externo.
     * Inicializa as listas imutáveis de tipos de veículos e combustíveis.
     * Declara um construtor privado para evitar que a classe seja instanciada diretamente.
     */
    private VeiculoSingleton() {
        /*Inicializa a lista de tipos de veículos como uma lista imutável. */
        tipoVeiculo = Collections.unmodifiableList(Arrays.asList("Carro", "Moto", "Patinete"));
        /*Inicializa a lista de tipos de combustíveis como uma lista imutável. */
        tipoCombustivel = Collections.unmodifiableList(Arrays.asList("Gasolina", "Diesel", "Hibrido", "Eletrico"));
    }

     /**
     * Classe interna estática que contém a instância do Singleton.
     * O SingletonHolder é carregado na memória somente quando necessário.
     */
    private static class SingletonHolder {
        /* Instância única do VeiculoSingleton. */
        private static final VeiculoSingleton INSTANCE = new VeiculoSingleton();
    }

    /**
     * public static VeiculoSingleton getInstance(): Método público estático que retorna a instância 
     * única do VeiculoSingleton. 
     * return SingletonHolder.INSTANCE;: Retorna a instância única do VeiculoSingleton criada pela SingletonHolder.

     * @return A instância única do VeiculoSingleton.
     */
    public static VeiculoSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
     /**
     * Obtém a lista imutável de tipos de veículos.
     * @return A lista imutável de tipos de veículos.
     */
    public List<String> getTipoVeiculo() {
        return tipoVeiculo;
    }
   
     /**
     * Obtém a lista imutável de tipos de combustíveis.
     * @return A lista imutável de tipos de combustíveis.
     */
    public List<String> getTipoCombustivel() {
        return tipoCombustivel;
    }
}
