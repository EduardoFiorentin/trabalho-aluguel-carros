package utilitarios;
import java.util.ArrayList;/*Importa a classe ArrayList para usar listas dinâmicas. */
import java.util.List;/*Importa a interface List para definir listas de objetos. */

import pessoas.Identificavel;/*Importa a interface Identificavel, que deve ser implementada 
                                pelos objetos armazenados. */

 /**
 * Classe de utilitário para armazenar objetos que implementam a interface Identificavel.
 * @param <T> Tipo de objeto que implementa a interface Identificavel.
 */
public class Armazenamento<T extends Identificavel>{
    /* Declara uma lista para armazenar os objetos do tipo T. */
    private List<T> armazenamento = new ArrayList<>(); ;
    /**
     * Retorna a lista de armazenamento.
     * @return Lista de armazenamento.
     */
    private List<T> getArmazenamento() {
        /*Retorna a lista de objetos armazenados. */
        return armazenamento;
    }
    /**
     * Pesquisa e retorna todos os itens armazenados.
     * @return Lista de todos os itens armazenados.
     */
    public List<T> pesquisar() {
        /*Cria uma nova lista e retorna uma cópia da lista de armazenamento.*/
        return new ArrayList<>(getArmazenamento());
    }
    
    /**
     * Pesquisa um item pelo seu ID.
     * @param id O ID do item a ser pesquisado.
     * @return O item com o ID especificado, ou null se não encontrado.
     */
    public T pesquisar(String id) {
        /*Itera sobre todos os itens armazenados. */
        for (T item: getArmazenamento()) {
            /*Verifica se o ID do item atual é igual ao ID fornecido. */
            if (item.getId().equals(id)) return item; 
        }
        /*Retorna null se nenhum item com o ID fornecido for encontrado. */
        return null; 
    }
    /**
     * Adiciona um item ao armazenamento.
     * @param item O item a ser adicionado.
     * @return true se o item foi adicionado com sucesso, false caso contrário.
     */
    public boolean adicionar(T item) {
        /*Verifica se o item é nulo ou se já está presente no armazenamento. */
        if (item == null || getArmazenamento().contains(item)) {
            /*Retorna false se o item for nulo ou já estiver na lista. */
            return false;
        }
        /*Adiciona o item ao armazenamento. */
        getArmazenamento().add(item); 
        /*Retorna true indicando que o item foi adicionado com sucesso. */
        return true; 
    }

     /**
     * Remove um item pelo seu ID.
     * @param id O ID do item a ser removido.
     * @return true se o item foi removido com sucesso, false caso contrário.
     */
    public boolean remover(String id) {
        /*Itera sobre todos os itens armazenados. */
        for (T item: armazenamento) {
            /*Verifica se o ID do item atual é igual ao ID fornecido. */
            if (item.getId().equals(id)) {
                /* Remove o item do armazenamento.*/
                armazenamento.remove(item);
                /* Imprime uma mensagem indicando que o item foi removido.*/
                System.out.println("Removeu");
                /*Retorna true indicando que o item foi removido com sucesso.*/
                return true;
            } 
        }/*Retorna false se nenhum item com o ID fornecido for encontrado. */
        return false; 
    }

}
