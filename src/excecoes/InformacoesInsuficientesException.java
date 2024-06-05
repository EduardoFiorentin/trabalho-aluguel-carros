package excecoes;

/**
 * Exceção lançada quando não há informações suficientes para completar uma operação.
 * @author [Seu nome]
 * @version 1.0
 */
public class InformacoesInsuficientesException extends Exception {

    /**
     * Construtor que recebe uma mensagem descrevendo a informação insuficiente.
     * @param message Mensagem detalhando a informação insuficiente.
     */
    public InformacoesInsuficientesException(String message) {
        super(message);
    }
}
