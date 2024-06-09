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

    private List<T> armazenamento = new ArrayList<>(); 
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
        for (T item: getArmazenamento()) {
            if (item.getId().equals(id)) return item; 
        }
        return null; 
    }
    /**
     * Adiciona um item ao armazenamento.
     * @param item O item a ser adicionado.
     * @return true se o item foi adicionado com sucesso, false caso contrário.
     */
    public boolean adicionar(T item) {
        if (item == null || getArmazenamento().contains(item)) {
            return false;
        }
        getArmazenamento().add(item); 
        return true; 
    }

     /**
     * Remove um item pelo seu ID.
     * @param id O ID do item a ser removido.
     * @return true se o item foi removido com sucesso, false caso contrário.
     */
    public boolean remover(String id) {
        for (T item: getArmazenamento()) {
            if (item.getId().equals(id)) {
                getArmazenamento().remove(item);
                return true;
            } 
        }
        return false; 
    }

}
