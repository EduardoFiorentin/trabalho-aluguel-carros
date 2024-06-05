package utilitarios;
import java.util.UUID;/* Importa a classe UUID do pacote java.util para usar na geração de
                        identificadores únicos. */
/**
 * Classe responsável por gerar identificadores únicos.
 * Esta classe contém métodos para gerar identificadores únicos.
 */
public class UniqueIDGenerator {
    /**
     * Método principal para executar a geração de um ID único.
     * @param args Argumentos de linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        /*Chama o método generateUniqueID para gerar um ID único e armazena o resultado na variável uniqueID. */
        String uniqueID = generateUniqueID();
        /*Imprime o ID único gerado no console. */
        System.out.println("Generated Unique ID: " + uniqueID);
    }
    /*/**
     * Gera um identificador único.
     *
     * @return Uma string representando um identificador único.
     */
    public static String generateUniqueID() {
        /* Cria uma nova instância de UUID utilizando o método randomUUID, que gera um identificador único universal.*/
        UUID uuid = UUID.randomUUID();
        /* Converte o UUID para uma string e retorna.*/
        return uuid.toString();
    }
}