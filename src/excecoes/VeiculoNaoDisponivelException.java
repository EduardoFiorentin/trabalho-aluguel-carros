package excecoes;

/**
 * Exceção lançada quando um veículo não está disponível.
 */
public class VeiculoNaoDisponivelException extends Exception {
     /**
     * Construtor que cria uma nova instância de VeiculoNaoDisponivelException com a mensagem especificada.
     * @param mensagem A mensagem que descreve a exceção.
    */
    public VeiculoNaoDisponivelException(String mensagem) {
        super(mensagem);
    }
}