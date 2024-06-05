package interfaces;

import java.io.IOException;
import java.util.Scanner;

public class Interface {
    /**
     * Limpa a tela do terminal. Utiliza código de escape ANSI para funcionar em diferentes sistemas operacionais.
     */
    public static void limparTela() {
        System.out.println("\033[H\033[2J"); // limpar terminal antes de começar
        // try {
        // if (System.getProperty("os.name").contains("Windows")) {
        // new ProcessBuilder("cmd", "/c", "clear").inheritIO().start().waitFor();
        // }
        // } catch (IOException | InterruptedException ex) {
        // ex.printStackTrace();
        // }
    }
     /**
     * Exibe o cabeçalho do sistema de aluguel de veículos.
     */
    public static void cabecalhoDoSistema() {
        System.out.println("------------------------------------");
        System.out.println("-- Sistema de aluguel de veículos --");
        System.out.println("------------------------------------\n");
    }
    /**
     * Exibe o cabeçalho de login do sistema.
     */
    public static void cabecalhoLogin() {
        System.out.println("------------------------------------");
        System.out.println("--------- Login no sistema ---------");
        System.out.println("------------------------------------\n");
    }
     /**
     * Exibe a lista de opções disponíveis para interação com o sistema, exibida somente ao funcionário.
     */
    public static void listarOpcoesSistema() {
        System.out.println("Opções do sistema: ");
        System.out.println("[0] - Sair");
        System.out.println("[1] - Listar Clientes");
        System.out.println("[2] - Listar Alugueis");
        System.out.println("[3] - Listar veiculos");
        System.out.println("[4] - Novo Aluguel");
        System.out.println("[5] - Finalizar Aluguel");
        System.out.println("[6] - Listar Funcionários");
        System.out.println("[7] - Cadastrar Cliente");
    }
    /**
     * Pausa a execução do sistema por 1 segundo.
     * @throws InterruptedException Exceção lançada caso a thread seja interrompida durante a espera.
     */
    public static void pausarSistema() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exe) {
            Interface.mensagemDeErro(exe.getMessage());
        }
    }
    /**
     * Exibe uma mensagem e solicita que o usuário pressione ENTER para continuar.
     * @param scanner Scanner utilizado para capturar a entrada do usuário.
     */
    public static void pararSistema(Scanner scannerPause) {
        Interface.mensagem("\nPressione ENTER para continuar...");
        scannerPause.nextLine();
    }
    /**
     * Exibe uma mensagem na saída padrão.
     * @param mensagem Texto da mensagem a ser exibida.
     */
    public static void mensagem(String mensagem) {
        System.out.println(mensagem);
    }
    /**
     * Exibe uma mensagem solicitando uma entrada do usuário.
     * @param mensagem Texto da mensagem a ser exibida.
     */
    public static void mensagemInput(String mensagem) {
        System.out.println(mensagem);
    }
    /**
     * Exibe uma mensagem de sucesso.
     * @param mensagem Texto da mensagem de sucesso.
     */
    public static void mensagemSucesso(String mensagem) {
        System.out.println(mensagem);
    }
    /**
     * Exibe uma mensagem de erro.
     * @param mensagem Texto da mensagem de erro.
     */
    public static void mensagemDeErro(String mensagem) {
        System.out.println(mensagem);
    }

}

// listar clientes

// listar funcionários

// listar veículos

// alugar veículo

// finalizar aluguel de veículo

// sair do sistema
