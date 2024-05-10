import sistema.Sistema;
import pessoas.Funcionario;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.print("\033[H\033[2J"); // limpar terminal antes de começar
        Sistema sistema = new Sistema(); 

        sistema.listarFuncionarios();
    }
}
