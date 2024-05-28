import exceptions.AluguelNaoEncontradoException;
import exceptions.ClienteNaoEncontradoException;
import sistema.ISistema;
import sistema.Sistema;

// Adição automática
    // funcionários 
    // veículos 
    

// Cadastros
    // clientes 


// Funções do sistema 
    // cadastrar clientes 
    // remover clientes 
    // listar clientes
    // listar funcionários 
    // listar veículos 
    // alugar veículo 
    // finalizar aluguel de veículo 
    



// sistema de login 
// seleção automatica do funcionário na criação de Aluguel 

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("\033[H\033[2J"); // limpar terminal antes de começar
            ISistema sistema = new Sistema(); 
            // sistema.listarFuncionarios();
            // sistema.listarClientes();
            // sistema.listarAlugueisAtivos();
            // sistema.listarFuncionarios();
    
            sistema.listarAlugueisAtivos();
            // sistema.removerCliente("2");
            // sistema.listarAlugueisAtivos();
            sistema.finalizarAluguel("00000000201", "1");
            System.out.println(sistema.getArmazenamentoCadastrados().pesquisar("00000000201").getInfo());
            
            sistema.listarAlugueisAtivos();
            
            // sistema.listarClientes();
        } 

        /** Tratamento de excessões obrigatórias do sistema  */
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            // os.getDir("c:/").remove()
        }

        

        finally {
            // finalizar sistema 
        }

    }
}


