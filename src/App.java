import interfaces.Interface;
import sistema.ISistema;
import sistema.Sistema;
import interfaces.Interface;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import excecoes.AluguelNaoEncontradoException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.InformacoesInsuficientesException;
import excecoes.UsuarioNaoEncontrado;
import excecoes.VeiculoNaoDisponivelException;
import excecoes.VeiculoNaoEncontradoException; 

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
    

// correções 
    // Aluguel - verificar se veículo, funcionário e cliente existem antes de criar um aluguel 

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
        Boolean login = false;
        
        ISistema sistema = new Sistema(); 

        
        
        // cadastrar cliente 
        
        // fazer sistema de log out 
        
        try {
            Interface.limparTela();
            
            // login no sistema 
            while (!login) {
                try {
                    Interface.limparTela();
                    Interface.cabecalhoLogin(); 

                    Interface.mensagemInput("Digite seu usuário: ");
                    String usuario = scannerString.nextLine().trim();

                    Interface.limparTela();
                    Interface.cabecalhoLogin();

                    Interface.mensagemInput("Digite sua senha: ");
                    String senha = scannerString.nextLine().trim(); 

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
                    
                    case '1':
                        Interface.limparTela();
                        Interface.cabecalhoDoSistema();
                        Interface.mensagem("Lista de clientes: ");

                        try {
                            List<String> infoClientes = sistema.listarClientes(); 
                            for (String info: infoClientes) {
                                Interface.mensagem("\t# "+info);
                            } 
                            Interface.pararSistema(scannerPause);
                            break; 
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }

                    case '2':
                        try {
                            Interface.limparTela();
                            Interface.cabecalhoDoSistema();
                            
                            Interface.mensagem("Lista de alugueis ativos: ");
                            List<String> alugueis = sistema.listarAlugueisAtivos();

                            if (alugueis.size() == 0) {
                                Interface.mensagem("Não há alugueis ativos no momento.");
                                Interface.pararSistema(scannerPause);
                                break; 
                            }
                            for (String aluguel : alugueis) {
                                Interface.mensagem("\t#"+aluguel);
                            }

                            Interface.pararSistema(scannerPause);

                        } 
                        catch (RuntimeException ex) {
                            Interface.mensagemDeErro("Um erro inesperado ocorreu! Contate o suporte técnico : " + ex.getMessage());
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                        break; 

                    case '3':
                        Interface.limparTela();
                        Interface.cabecalhoDoSistema();

                        Interface.mensagem("Veiculos: ");
                        try {
                            List<String> informacoes = sistema.listarVeiculos(); 

                            for (String informacao : informacoes) {
                                Interface.mensagem("\t# "+informacao);
                            }

                            Interface.pararSistema(scannerPause);
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                        break; 

                    case '4':
                        boolean aluguel = true;
                        while (aluguel) {
                            try {
                                Interface.limparTela();
                                Interface.cabecalhoDoSistema();
    
                                Interface.mensagem("Aluguel de veículo: [0 - sair]");
                                Interface.mensagem("Cpf do cliente: ");
                                String cpfCliente = scannerString.nextLine();
                                if (cpfCliente.equals("0")) {
                                    aluguel = false;
                                    continue;
                                } 

                                Interface.mensagem("Id do veículo: [-1 - cancelar]");
                                String idVeiculo = scannerString.nextLine();

                                Interface.mensagem("Aluguel válido por quantos dias: [-1 - cancelar]");
                                int dias = scannerInt.nextInt(); 

                                sistema.alugarVeiculo(cpfCliente, idVeiculo, dias);
                                aluguel = false; 
                            } 
                            catch (RuntimeException ex) {
                                Interface.mensagemDeErro("Um erro inesperado ocorreu! Contate o suporte técnico : " + ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                            catch(ClienteNaoEncontradoException ex) {
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                            catch(FuncionarioNaoEncontradoException ex) {
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                            catch(VeiculoNaoDisponivelException ex) {
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                            catch(VeiculoNaoEncontradoException ex) {
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                        }
                        
                        break;

                    case '5':
                        try {
                            Interface.mensagem("Cpf do cliente: ");
                            String idCliente = scannerString.nextLine();

                            Interface.mensagem("Id do veículo: ");
                            String idVeiculo = scannerString.nextLine(); 
                            
                            sistema.finalizarAluguel(idCliente, idVeiculo);
                            Interface.mensagem("Aluguel finalizado!");
                            Interface.pausarSistema();
                        } 

                        catch(AluguelNaoEncontradoException ex) {
                            Interface.mensagemDeErro(ex.getMessage());
                            Interface.pausarSistema();
                        }
                        catch(ClienteNaoEncontradoException ex) {
                            Interface.mensagemDeErro(ex.getMessage());
                            Interface.pausarSistema();
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                        
                        break;  

                    case '6':
                        Interface.limparTela();
                        Interface.cabecalhoDoSistema();
                        Interface.mensagem("Lista de Funcionarios: ");

                        try {
                            List<String> infoFuncionarios = sistema.listarFuncionarios();  

                            for (String info: infoFuncionarios) {
                                Interface.mensagem("\t# "+info);
                            }
                            Interface.pararSistema(scannerPause);
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                        break; 

                    case '7':
                        boolean cadastro = true; 
                        while (cadastro) {
                            try {
                                Interface.limparTela();
                                Interface.cabecalhoDoSistema();
                                Interface.mensagem("Cadastro de cliente: ");
                                
                                Interface.mensagem("Nome: ");
                                String nome = scannerString.nextLine();
                                
                                Interface.mensagem("CPF: ");
                                String cpf = scannerString.nextLine();
                                
                                
                                Interface.mensagem("Data de nascimento: ");
                                String dataNascimento = scannerString.nextLine();
                                
                                
                                Interface.mensagem("endereço: ");
                                String endereco = scannerString.nextLine();
                                
                                
                                Interface.mensagem("Telefone");
                                String telefone = scannerString.nextLine();
                                
                                
                                Interface.mensagem("Email");
                                String email = scannerString.nextLine();
                                
                                
                                Interface.mensagem("CNH");
                                String cnh = scannerString.nextLine();
                                
                                sistema.cadastrarCliente(nome, cpf, dataNascimento, endereco, telefone, email, cnh);

                                cadastro = false; 

                            } catch (RuntimeException ex) {
                                Interface.mensagemDeErro("Operação inválida! Tente novamente.");
                            }
                            catch(FuncionarioNaoEncontradoException ex) {
                                Interface.mensagemDeErro("Faça login no sistema para continuar");
                                login = false; 
                                Interface.pausarSistema();
                            }
                            catch(InformacoesInsuficientesException ex) {
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                        }

                        break; 

                    default:
                        Interface.mensagemDeErro("Opção inválida!");
                        break;
                }
            }
        } 
        
        finally {
            // finalizar sistema 
            Interface.mensagemSucesso("Sistema finalizado!");
            scannerInt.close();
            scannerString.close();
            scannerChar.close();
            scannerPause.close();
        }

    }
}


