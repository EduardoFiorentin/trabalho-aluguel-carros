package exceptions;
/**
 * Exceção lançada quando um veículo não é encontrado.
 */
public class VeiculoNaoEncontradoException extends Exception {
    /**
     * Construtor que cria uma nova instância de VeiculoNaoEncontradoException com a mensagem especificada.
     * @param message A mensagem que descreve a exceção.
     */
    public VeiculoNaoEncontradoException(String message) {
        super(message); 
    }
}