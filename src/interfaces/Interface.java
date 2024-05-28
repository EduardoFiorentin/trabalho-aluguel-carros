package interfaces;

public class Interface {
    public static void cabecalhoDoSistema() {
        System.out.println("------------------------------------");
        System.out.println("-- Sistema de aluguel de veículos --");
        System.out.println("------------------------------------");
    }

    public static void mensagemLogin() {
        System.out.println("Login no sistema: \n");
    }

    public static void mensagem(String mensagem) {
        System.out.println(mensagem+"\n");
    }

    public static void mensagemDeErro(String mensagem) {
        System.out.println(mensagem + "\n");
    }
}
