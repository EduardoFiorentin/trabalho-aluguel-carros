import exceptions.AluguelNaoEncontradoException;
import exceptions.ClienteNaoEncontradoException;
import exceptions.UsuarioNaoEncontrado;
import interfaces.Interface;
import sistema.ISistema;
import sistema.Sistema;
import interfaces.Interface;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner; 

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
    

// Excessões 
    // faltam informações (cadastros)
    // cliente não encontrado
    // funcionário não encontrado 
    // veículo não encontrado 
    // item não encontrado (metodos de pesquisa)
    // veículo não disponível
    // aluguel já finalizado 
    


// sistema de login 
// seleção automatica do funcionário na criação de Aluguel 

public class App {
    public static void main(String[] args) {
        // flags
        boolean rodando = true; 
        Scanner scannerInt = new Scanner(System.in); 
        Scanner scannerString = new Scanner(System.in); 
        Scanner scannerChar = new Scanner(System.in); 
        Scanner scannerPause = new Scanner(System.in); 

        char opcaoUsuario = '\0'; 

        try {
            Interface.limparTela();
            ISistema sistema = new Sistema(); 
            
            
            Boolean login = false;
            
            String usuario; 
            String senha; 
            
            // login no sistema 
            while (!login) {
                try {
                    Interface.limparTela();
                    Interface.cabecalhoLogin(); 

                    Interface.mensagemInput("Digite seu usuário: ");
                    usuario = scannerString.nextLine().trim();

                    Interface.limparTela();
                    Interface.cabecalhoLogin();

                    Interface.mensagemInput("Digite sua senha: ");
                    senha = scannerString.nextLine().trim(); 

                    sistema.entrar(usuario, senha);
                    break; 

                }
                catch(RuntimeException ex) {
                    Interface.mensagemDeErro("Um erro inesperado ocorreu ao efetuar o login. Contate o suporte técnico!");
                    Interface.mensagemDeErro(ex.getMessage());
                    
                }
                catch(UsuarioNaoEncontrado ex) {
                    Interface.mensagemDeErro(ex.getMessage());
                    Interface.pausarSistema();
                }
            }

            Interface.limparTela();
            Interface.cabecalhoDoSistema();
            Interface.mensagemSucesso("Login efetuado com sucesso!");
            Interface.pausarSistema();


            // cadastrar cliente 

            while (rodando) {

                Interface.limparTela();
                Interface.cabecalhoDoSistema();
                Interface.listarOpcoesSistema();
                Interface.mensagemInput("Opção: ");
                opcaoUsuario = scannerChar.nextLine().charAt(0); 

                switch (opcaoUsuario) {
                    case '0':
                        rodando = false;
                        break;
                    
                    default:
                        Interface.mensagemDeErro("Opção inválida!");
                        break;
                }
                // apagar cliente 
                    // coletar id 

                    
                // listar clientes

        
                // listar funcionários 
        
        
                // listar veículos 
        
        
                // alugar veículo 
        
        
                // finalizar aluguel de veículo 
    
        
                // sair do sistema 

            }


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
            Interface.mensagemDeErro("Ocorreu um erro inesperado!");
            // os.getDir("c:/").remove()
        }
        catch (AluguelNaoEncontradoException ex) {
            System.out.println(ex.getMessage());
            Interface.mensagemDeErro("Ocorreu um erro inesperado!");
        }
        catch (ClienteNaoEncontradoException ex) {
            System.out.println(ex.getMessage());
            Interface.mensagemDeErro("Ocorreu um erro inesperado!");
        }
        
        finally {
            // finalizar sistema 
            Interface.mensagemSucesso("Sistema finalizado!");
            scannerInt.close();
            scannerString.close();
            scannerChar.close();
        }

    }
}



