package utils;
import java.util.ArrayList;
import java.util.List;

import pessoas.Identificavel;

public class Armazenamento<T extends Identificavel>{
    private List<T> armazenamento = new ArrayList<>(); ;

    private List<T> getArmazenamento() {
        return armazenamento;
    }

    // pesquisar por id 
    public List<T> pesquisar() {
        return new ArrayList<>(getArmazenamento());
    }

    public T pesquisar(String id) {
        for (T item: getArmazenamento()) {
            if (item.getId().equals(id)) return item; 
        }
        return null; 
    }

    // adicionar 
    public boolean adicionar(T item) {
        if (item == null || getArmazenamento().contains(item)) {
            return false;
        }

        getArmazenamento().add(item); 
        return true; 
    }

    // remover 
    public boolean remover(T item) {
        return getArmazenamento().remove(item); 
    }

}