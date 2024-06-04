package excecoes;
/**
 * Exceção lançada quando um cliente não é encontrado no sistema.
 */
public class ClienteNaoEncontradoException extends Exception {
    /**
     * Construtor para criar uma nova ClienteNaoEncontradoException com uma mensagem detalhada.
     * @param mensagem a mensagem detalhada da exceção
     */
    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}