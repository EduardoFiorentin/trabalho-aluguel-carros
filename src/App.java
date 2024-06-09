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
        char opcaoUsuario = '\0'; 
        Boolean login = false;

        /*Instância do sistema */
        ISistema sistema = new Sistema(); 


        /**
         * Realiza o processo de login no sistema, repetindo até que o login 
         * seja bem-sucedido ou o usuário escolha sair. */
        try {
            /*Loop principal do aplicativo */
            while (rodando) {

                Interface.limparTela();
                
                /* Loop de login no sistema */
                while (!login) {
                    try {
                        /*Limpa a tela e exibe o cabeçalho de login */
                        Interface.limparTela();
                        Interface.cabecalhoLogin(); 
                        /*Solicita para o funcionário o login. */
                        Interface.mensagem("Digite seu usuário [0 - sair] ");
                        String usuario = scannerString.nextLine().trim();
                        /*Verifica se o usário do sistema deseja sair. */
                        if (usuario.equals("0")) {
                            rodando = false;
                            break; 
                        }
                        /*Solicta a senha para o funcionário acessar o sistema */
                        Interface.limparTela();
                        Interface.cabecalhoLogin();
    
                        Interface.mensagem("Digite sua senha: ");
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
                    catch(RuntimeException ex) {
                        Interface.mensagemDeErro("Um erro inesperado ocorreu ao efetuar o login. Contate o suporte técnico!");
                        Interface.mensagemDeErro(ex.getMessage());
                        
                    }
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
                 Interface.mensagem("Opção: ");
                 opcaoUsuario = scannerChar.nextLine().charAt(0); 
                 /*Processa a opção do usuário */
                 switch (opcaoUsuario) {
                     case '0':
                         login = false;
                         break;
                     case '1':/*Lista todos os veículos cadastrados no sistema. */
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
                        
                     case '2':/*Permite cadastrar um novo cliente no sistema. */
                         boolean cadastro = true; 
                         while (cadastro) {
                             try {
                                 Interface.limparTela();
                                 Interface.cabecalhoDoSistema();
                                 Interface.mensagem("Cadastro de cliente: ");
                                 /*Solicita informações do cliente */
                                 Interface.mensagem("Nome: [0 - cancelar]");
                                 String nome = scannerString.nextLine();

                                 if (nome.equals("0")) {
                                    cadastro = false;
                                    continue; 
                                 };
                                 
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
 
                                 Interface.mensagemSucesso("Cliente cadastrado com sucesso!");
                                 Interface.pararSistema(scannerPause);

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

                     case '3':/*Permite alugar um veículo para um cliente. */
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

                                 Interface.mensagemSucesso("Aluguel realizado com sucesso!");
                                 Interface.pausarSistema();
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
 
                    /*Solicita dados para finalizar aluguel */
                     case '4':
                         try {
                             Interface.limparTela();
                             Interface.cabecalhoDoSistema();
                             Interface.mensagem("Cpf do cliente: [0 - cancelar]");
                             String idCliente = scannerString.nextLine();

                             if (idCliente.equals("0")) break; 
 
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
 
                     /*Lista todos os clientes cadastrados no sistema. */
                     case '5':
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
                     case '6':
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
                             for (String infoAluguel : alugueis) {
                                 Interface.mensagem("\t#"+infoAluguel);
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
 
                     case '7':
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
 
                             /*Opção para remover um cliente*/
                    case '8': 
                        Interface.limparTela();
                        Interface.cabecalhoDoSistema();
                        Interface.mensagem("Lista de Funcionarios: ");

                         try {
                             Interface.mensagem("CPF do cliente: [0 - cancelar]");
                             String cliente = scannerString.nextLine(); 

                             if (cliente.equals("0")) break; 
                             
                             sistema.removerCliente(cliente);

                             Interface.mensagemSucesso("Cliente "+ cliente + " removido com sucesso!");
                             Interface.pararSistema(scannerPause);

                             break; 
                        }
                        catch(ClienteNaoEncontradoException ex) {
                            Interface.mensagemDeErro(ex.getMessage());
                            Interface.pausarSistema();
                        }
                        catch(FuncionarioNaoEncontradoException ex) {
                            Interface.mensagemDeErro(ex.getMessage());
                            Interface.pausarSistema();
                        }

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


