package utilitarios;
import java.util.UUID;/* Importa a classe UUID do pacote java.util */
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
        String uniqueID = generateUniqueID();
        System.out.println("Generated Unique ID: " + uniqueID);
    }
    /**
     * Gera um identificador único.
     *
     * @return Uma string representando um identificador único.
     */
    public static String generateUniqueID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}