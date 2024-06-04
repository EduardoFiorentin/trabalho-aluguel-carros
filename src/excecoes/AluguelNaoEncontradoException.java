package excecoes;
/**
 * Exceção lançada quando um aluguel não é encontrado.
 */
public class AluguelNaoEncontradoException extends Exception {
    /**
     * Construtor para criar uma nova AluguelNaoEncontradoException com uma mensagem detalhada.
     * @param message a mensagem detalhada da exceção
     */
    public AluguelNaoEncontradoException(String message) {
        super(message); 
    }
}
