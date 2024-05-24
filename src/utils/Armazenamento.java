package utils;
import java.util.ArrayList;
import java.util.List;

import pessoas.Identificavel;

public class Armazenamento<T extends Identificavel>{
    private List<T> armazenamento = new ArrayList<>(); ;

    private List<T> getArmazenamento() {
        return armazenamento;
    }

    public List<T> pesquisar() {
        return new ArrayList<>(getArmazenamento());
    }
    
    // pesquisar por id 
    public List<T> pesquisar(String id) {
        List<T> itens = new ArrayList<>(); 

        for (T item: getArmazenamento()) {
            if (item.getId().equals(id)) itens.add(item); 
        }
        return itens; 
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
    public boolean remover(String id) {
        
        for (T item: armazenamento) {
            if (item.getId().equals(id)) {
                armazenamento.remove(item);
                System.out.println("Removeu");
                return true;
            } 
        }
        return false; 
    }

}
