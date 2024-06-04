package utilitarios;
import java.util.UUID;
//Gerador unico de ID
public class UniqueIDGenerator {
    public static void main(String[] args) {
        String uniqueID = generateUniqueID();
        System.out.println("Generated Unique ID: " + uniqueID);
    }

    public static String generateUniqueID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}