package exceptions;

/**
 * Exceção lançada quando um usuário não é encontrado no sistema.
 */
public class UsuarioNaoEncontrado extends Exception {
    /**
     * Construtor que recebe uma mensagem de erro.
     *
     * @param mensagem Mensagem de erro explicando a razão da exceção.
     */
    public UsuarioNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}

