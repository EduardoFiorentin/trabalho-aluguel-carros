/*Define o pacote e importa as classes e exceções necessárias. */
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
/**
 * Define a classe principal App e o método main para iniciar o aplicativo.
 * Classe principal do aplicativo de gerenciamento de veículos.
 * Esta classe contém o método principal para iniciar e executar o sistema.
 */
public class App {
    /**
     * Método principal para iniciar o aplicativo.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {/*Inicializa variáveis e instâncias necessárias para o funcionamento do sistema. */
        /*Flag para controlar se o sistema está rodando */
        boolean rodando = true; 
        /*Scanners para diferentes tipos de entrada */
        Scanner scannerInt = new Scanner(System.in); 
        Scanner scannerString = new Scanner(System.in); 
        Scanner scannerChar = new Scanner(System.in); 
        Scanner scannerPause = new Scanner(System.in); 
        /*Variável para armazenar a opção escolhida pelo usuário */
        char opcaoUsuario = '\0'; 
        /*Flag para controlar o estado de login */
        Boolean login = false;
        /*Instância do sistema */
        ISistema sistema = new Sistema(); 

        
        
        // cadastrar cliente 
        
        // fazer sistema de log out 
        /**
         * Realiza o processo de login no sistema, repetindo até que o login 
         * seja bem-sucedido ou o usuário escolha sair. */
        try {
            /*Loop principal do aplicativo */
            while (rodando) {
                /*Limpa a tela. */
                Interface.limparTela();
                
                /* Loop de login no sistema */
                while (!login) {
                    try {
                        /*Limpa a tela e exibe o cabeçalho de login */
                        Interface.limparTela();
                        Interface.cabecalhoLogin(); 
                        /*Solicita para o funcionário o login. */
                        Interface.mensagemInput("Digite seu usuário [0 - sair] ");
                        String usuario = scannerString.nextLine().trim();
                        /*Verifica se o usário do sistema deseja sair. */
                        if (usuario.equals("0")) {
                            rodando = false;
                            break; 
                        }
                        /*Solicta a senha para o funcionário acessar o sistema */
                        Interface.limparTela();
                        Interface.cabecalhoLogin();
    
                        Interface.mensagemInput("Digite sua senha: ");
                        String senha = scannerString.nextLine().trim(); 
                        /*Tenta entra no istema. */
                        sistema.entrar(usuario, senha);
                        login = true; // Login bem sucedido

                        /**Exibe o menu principal e processa a opção escolhida pelo usuário.
                        * Acesso ao sistema após o Login para*/
                        Interface.limparTela();
                        Interface.cabecalhoDoSistema();
                        Interface.mensagemSucesso("Login efetuado com sucesso!");
                        Interface.pausarSistema();


                        break; 
    
                    }
                    /*Captura exceções de runtime e exibe mensagem de erro */
                    catch(RuntimeException ex) {
                        Interface.mensagemDeErro("Um erro inesperado ocorreu ao efetuar o login. Contate o suporte técnico!");
                        Interface.mensagemDeErro(ex.getMessage());
                        
                    }
                    /*Captura exceção de usuário não encontrado e exibe mensagem de erro */
                    catch(UsuarioNaoEncontrado ex) {
                        Interface.mensagemDeErro(ex.getMessage());
                        Interface.pausarSistema();
                    }
                }
                /*Verifica se o usuário deseja sair */
                if (!rodando) continue; 

                Interface.limparTela();
                Interface.cabecalhoDoSistema();
                Interface.listarOpcoesSistema();
                Interface.mensagemInput("Opção: ");
                opcaoUsuario = scannerChar.nextLine().charAt(0); 
                /*Processa a opção do usuário */
                switch (opcaoUsuario) {
                    case '0':
                        login = false;
                        break;
                    /*Lista todos os clientes cadastrados no sistema. */
                    case '1':
                        Interface.limparTela();
                        Interface.cabecalhoDoSistema();
                        Interface.mensagem("Lista de clientes: ");

                        try {
                            /*Lista clientes cadastrados no sistema */
                            List<String> infoClientes = sistema.listarClientes(); 
                            for (String info: infoClientes) {
                                Interface.mensagem("\t# "+info);
                            } 
                            Interface.pararSistema(scannerPause);
                            break; 
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                        /*Captura exceção de funcionário não encontrado e exibe mensagem de erro */
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                    /*Lista todos os aluguéis ativos no sistema. */
                    case '2':
                        try {
                            Interface.limparTela();
                            Interface.cabecalhoDoSistema();
                            
                            Interface.mensagem("Lista de alugueis ativos: ");
                            /*Lista aluguéis ativos no sistema */
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
                            /*Captura exceções de runtime e exibe mensagem de erro */
                            Interface.mensagemDeErro("Um erro inesperado ocorreu! Contate o suporte técnico : " + ex.getMessage());
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            /*Captura exceção de funcionário não encontrado e exibe mensagem de erro */
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                        break; 

                    case '3':/*Lista todos os veículos cadastrados no sistema. */
                        Interface.limparTela();
                        Interface.cabecalhoDoSistema();

                        Interface.mensagem("Veiculos: ");
                        try {
                            /*Lista veículos cadastrados no sistema */
                            List<String> informacoes = sistema.listarVeiculos(); 

                            for (String informacao : informacoes) {
                                Interface.mensagem("\t# "+informacao);
                            }

                            Interface.pararSistema(scannerPause);
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            /*Captura exceção de funcionário não encontrado e exibe mensagem de erro */
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                        break; 

                    case '4':/*Permite alugar um veículo para um cliente. */
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
                                /*Aluga veículo para o cliente */
                                sistema.alugarVeiculo(cpfCliente, idVeiculo, dias);
                                aluguel = false; 
                            } 
                            catch (RuntimeException ex) {
                                /*Captura exceções de runtime e exibe mensagem de erro */
                                Interface.mensagemDeErro("Um erro inesperado ocorreu! Contate o suporte técnico : " + ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                            catch(ClienteNaoEncontradoException ex) {
                                /*Captura exceção de cliente não encontrado e exibe mensagem de erro */
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                            catch(FuncionarioNaoEncontradoException ex) {
                                /*Captura exceção de funcionário não encontrado e exibe mensagem de erro*/
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                            catch(VeiculoNaoDisponivelException ex) {
                                /*Captura exceção de veículo não disponível e exibe mensagem de erro */
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                            catch(VeiculoNaoEncontradoException ex) {
                                /*Captura exceção de veículo não encontrado e exibe mensagem de erro */
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                        }
                        
                        break;

                    case '5':
                        try {/*Solicita dados para finalizar aluguel */
                            Interface.mensagem("Cpf do cliente: ");
                            String idCliente = scannerString.nextLine();

                            Interface.mensagem("Id do veículo: ");
                            String idVeiculo = scannerString.nextLine(); 
                            /*Finaliza aluguel do veículo */
                            sistema.finalizarAluguel(idCliente, idVeiculo);
                            Interface.mensagem("Aluguel finalizado!");
                            Interface.pausarSistema();
                        } 

                        catch(AluguelNaoEncontradoException ex) {
                            /*Captura exceção de aluguel não encontrado e exibe mensagem de erro */
                            Interface.mensagemDeErro(ex.getMessage());
                            Interface.pausarSistema();
                        }
                        catch(ClienteNaoEncontradoException ex) {
                            /*Captura exceção de cliente não encontrado e exibe mensagem de erro */
                            Interface.mensagemDeErro(ex.getMessage());
                            Interface.pausarSistema();
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            /*Captura exceção de funcionário não encontrado e exibe mensagem de erro */
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                        
                        break;  

                    case '6':
                        Interface.limparTela();
                        Interface.cabecalhoDoSistema();
                        Interface.mensagem("Lista de Funcionarios: ");

                        try {/*Lista funcionários cadastrados no sistema */
                            List<String> infoFuncionarios = sistema.listarFuncionarios();  

                            for (String info: infoFuncionarios) {
                                Interface.mensagem("\t# "+info);
                            }
                            Interface.pararSistema(scannerPause);
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            /*Captura exceção de funcionário não encontrado e exibe mensagem de erro */
                            Interface.mensagemDeErro("Faça login no sistema para continuar");
                            login = false; 
                            Interface.pausarSistema();
                        }
                        break; 

                    case '7':/*Permite cadastrar um novo cliente no sistema. */
                        boolean cadastro = true; 
                        while (cadastro) {
                            try {
                                Interface.limparTela();
                                Interface.cabecalhoDoSistema();
                                Interface.mensagem("Cadastro de cliente: ");
                                /*Solicita informações do cliente */
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
                                /*Cadastra o cliente no sistema */
                                sistema.cadastrarCliente(nome, cpf, dataNascimento, endereco, telefone, email, cnh);

                                cadastro = false; 

                            } 
                            catch (RuntimeException ex) {/*Captura exceções de runtime e exibe mensagem de erro */
                                Interface.mensagemDeErro("Operação inválida! Tente novamente.");
                            }
                            catch(FuncionarioNaoEncontradoException ex) {
                                /*Captura exceção de funcionário não encontrado e exibe mensagem de erro */
                                Interface.mensagemDeErro("Faça login no sistema para continuar");
                                login = false; 
                                Interface.pausarSistema();
                            }
                            catch(InformacoesInsuficientesException ex) {
                                /*Captura exceção de informações insuficientes e exibe mensagem de erro */
                                Interface.mensagemDeErro(ex.getMessage());
                                Interface.pararSistema(scannerPause);
                            }
                        }

                        break; 

                    default:/**
                             * Caso o Funcionário digite um número que não consta no painel.@interface
                             * Será exibido uma mensagem para opção inválida */
                        Interface.mensagemDeErro("Opção inválida!");
                        break;
                }
            }
        } 
        
        finally {
           /*Finaliza sistema e fecha scanners */
            Interface.mensagemSucesso("Sistema finalizado!");
            scannerInt.close();
            scannerString.close();
            scannerChar.close();
            scannerPause.close();
        }

    }
}


