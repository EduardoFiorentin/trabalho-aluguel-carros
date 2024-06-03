package exceptions;

/**
 * Exceção lançada quando um item não é encontrado.
 */
public class ItemNaoEncontradoException extends Exception {

 /**
 * Construtor que cria uma nova instância de ItemNaoEncontradoException com a mensagem especificada.
 * @param message A mensagem que descreve a exceção.
 */
    public ItemNaoEncontradoException(String message) {
        super(message); 
    }
}