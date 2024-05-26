package exceptions;


public class VeiculoNaoDisponivelException extends Exception {
    public VeiculoNaoDisponivelException(String mensagem) {
        super(mensagem);
    }
}