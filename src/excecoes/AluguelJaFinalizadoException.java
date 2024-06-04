package excecoes;
/**
 * Explicação sobre as Exceptions utilizadas no projeto:
 * As exceções documentadas seguem um padrão simples, onde cada exceção tem um propósito claro.
    * O construtor aceita uma mensagem que detalha o motivo da exceção, e esta mensagem pode ser recuperada
    * posteriormente usando o método getMessage() herdado da classe Exception.
 * O construtor recebe um parâmetro String chamado message, que é a mensagem associada à exceção. 
    * Quando uma instância desta exceção é lançada,  a mensagem passada para o construtor será 
    * exibida para ajudar a identificar a causa da exceção.
 * As exceções são usadas para garantir que operações inválidas (como tentar finalizar um aluguel 
    * inexistente ou já finalizado) sejam tratadas de forma adequada, fornecendo feedback claro sobre o 
    * problema encontrado.
*/
/**
 * Exceção lançada quando uma operação é realizada em um aluguel que já foi finalizado.
 */
public class AluguelJaFinalizadoException extends Exception {
    /**
     * Construtor para criar uma nova AluguelJaFinalizadoException com uma mensagem detalhada.
     * @param message a mensagem detalhada da exceção
    */   
    public AluguelJaFinalizadoException(String message) {
        super(message); 
    }
}