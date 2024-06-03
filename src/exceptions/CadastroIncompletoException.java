package exceptions;

/**
 * Exceção lançada quando o cadastro de um cliente, funcionário ou veículo está incompleto.
 */
public class CadastroIncompletoException extends Exception {

/**
 * Construtor para criar uma nova CadastroIncompletoException com uma mensagem detalhada.
 * @param message a mensagem detalhada da exceção
 */
    public CadastroIncompletoException(String message) {
        super(message); 
    }
}