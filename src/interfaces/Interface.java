package interfaces;

import java.io.IOException;

public class Interface {
    public static void limparTela() {
        // System.out.println("\033[H\033[2J"); // limpar terminal antes de começar
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void cabecalhoDoSistema() {
        System.out.println("------------------------------------");
        System.out.println("-- Sistema de aluguel de veículos --");
        System.out.println("------------------------------------\n");
    }
    public static void cabecalhoLogin() {
        System.out.println("------------------------------------");
        System.out.println("--------- Login no sistema ---------");
        System.out.println("------------------------------------\n");
    }
    public static void listarOpcoesSistema() {
        System.out.println("Opções do sistema: ");
        System.out.println("[0] - Sair");
        System.out.println("[1] - Listar Clientes");
        System.out.println("[2] - Listar Alugueis");
        System.out.println("[3] - Novo Aluguel");
        System.out.println("[4] - Finalizar Aluguel");
        System.out.println("[5] - Listar Funcionários");
        System.out.println("[6] - Cadastrar Cliente");
    }


    public static void pausarSistema() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exe) {
            Interface.mensagemDeErro(exe.getMessage());
        }
    }
    public static void mensagem(String mensagem) {
        System.out.println(mensagem+"\n");
    }

    public static void mensagemInput(String mensagem) {
        System.out.println(mensagem);
    }

    public static void mensagemSucesso(String mensagem) {
        System.out.println(mensagem+"\n");
    }

    public static void mensagemDeErro(String mensagem) {
        System.out.println(mensagem + "\n");
    }


}

// listar clientes
                    
        
                // listar funcionários 
        
        
                // listar veículos 
        
        
                // alugar veículo 
        
        
                // finalizar aluguel de veículo 
    
        
                // sair do sistema 
