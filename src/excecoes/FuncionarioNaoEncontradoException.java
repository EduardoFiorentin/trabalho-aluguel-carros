package excecoes;
/**
 * Exceção lançada quando um funcionário não é encontrado no sistema.
 */
public class FuncionarioNaoEncontradoException extends Exception {
    /**
     * Construtor para criar uma nova FuncionarioNaoEncontradoException com uma mensagem detalhada.
     * @param message a mensagem detalhada da exceção
     */
    public FuncionarioNaoEncontradoException(String message) {
        super(message); 
    }
}