package veiculo;

import java.util.List;/* Importa a classe List para trabalhar com listas de objetos.*/

import pessoas.Identificavel;/*Importa a interface Identificavel, que deve ser 
                            implementada pelos objetos que precisam de um identificador. */

/**
 * Classe Veiculo que representa um veículo e implementa a interface Identificavel.
 */
public class Veiculo implements Identificavel{
    private String id;/*Identificador único do veículo. */
    private String tipoVeiculo;/* Tipo de veículo, por exemplo, carro ou moto.*/
    private String placa;/*Placa do veículo. */
    private String modelo;/* Modelo do veículo.*/
    private String marca;/*Marca do veículo */
    private String categoria;/*Categoria do veículo */
    private String ano;/*Ano de fabricação do veículo */
    private String cor;/* Cor do veículo*/
    private int kmRodados;/* Quilometragem rodada pelo veículo*/
    private boolean disponivel;/* Disponibilidade do veículo*/
    private double precoDiaria;/*Preço da diário para lugar o veículo */
    private String tipoCombustivel;/*Tipo de combustível do veículo. */

     /**
     * Construtor para criar um novo veículo.
     *
     * @param id O ID do veículo.
     * @param modelo O modelo do veículo.
     * @param placa A placa do veículo.
     * @param precoDiaria O preço da diária para alugar o veículo.
     * @param tipoVeiculo O tipo de veículo (índice para obter o tipo real).
     * @param tipoCombustivel O tipo de combustível (índice para obter o tipo real).
     * @param marca A marca do veículo.
     * @param categoria A categoria do veículo.
     * @param ano O ano de fabricação do veículo.
     * @param cor A cor do veículo.
     * @param kmRodados A quilometragem rodada pelo veículo.
     */
    public Veiculo(String id, String modelo, String placa, double precoDiaria, int tipoVeiculo, int tipoCombustivel, String marca, String categoria, String ano, String cor, int kmRodados) {
        setId(id);
        setModelo(modelo);
        setPlaca(placa);
        setPrecoDiaria(precoDiaria);
        setTipoVeiculo(tipoVeiculo);
        setTipoCombustivel(tipoCombustivel);
        setCategoria(categoria);
        setMarca(marca);
        setAno(ano);
        setCor(cor);
        setKmRodados(tipoCombustivel);
        setDisponivel(true);
    }

    /**
     * Métodos Getters para obter os valores dos campos que carecteriza o veículo.@interface.
     * Esses métodos obtÊm cada uma das caracteristicas descritas na classe e no construtor e 
     * retornam os seus respectvos valores, Ex: getId retorna o ID do veículo, getPlaca retorna a 
     * placa do veículo, e assim por diante.
    */
    public String getId() { return id; }
    public boolean isDisponivel() { return disponivel; }
    public String getTipoVeiculo() { return tipoVeiculo; }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public String getCategoria() { return categoria; }
    public String getAno() { return ano; }
    public String getCor() { return cor; }
    public int getKmRodados() { return kmRodados; }
    public double getPrecoDiaria() { return precoDiaria; }
    public String getTipoCombustivel() { return tipoCombustivel; }
     /**
     * Obtém as informações completas do veículo.
     * @return Uma string com as informações do veículo.
     */
    public String getInfo() {
        return String.format("ID: %s\t%s\t%s - %s %s\tDiaria: %f", getId(), isDisponivel() ? "Disponivel" : "Indisponível", getModelo(), getMarca(), getCategoria(), getPrecoDiaria()); 
    }
    /**
     * Métodos Setters para definir os valores dos campos que carecteriza o veículo.
     * Esses métodos definem cada uma das caracteristicas descritas na classe e no construtor e 
     * retornam os seus respectvos valores, Ex: setId define o Id do veículo e retorna o valor atribuido como ID do veículo,
     * setPlaca define a placa do veículo e retorna o vlaor da placa do veículo, e assim por diante.
    */
    private void setId(String id) { this.id = id; }
    private void setPlaca(String placa) { this.placa = placa; }
    private void setModelo(String modelo) { this.modelo = modelo; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    private void setPrecoDiaria(double precoDiaria) { this.precoDiaria = precoDiaria; }
    private void setMarca(String marca) { this.marca = marca; }
    private void setCategoria(String categoria) { this.categoria = categoria; }
    private void setAno(String ano) { this.ano = ano; }
    private void setCor(String cor) { this.cor = cor; }
    private void setKmRodados(int kmRodados) { this.kmRodados = kmRodados; }

   
     /**
     * Define o tipo de veículo baseado em um índice.
     * @param tipo O índice do tipo de veículo.
     * @throws IllegalArgumentException se o índice for inválido.
     */
    private void setTipoVeiculo(int tipo) { 
        /*Verifica se o índice é válido. */
        if (tipo > VeiculoSingleton.getInstance().getTipoVeiculo().size() - 1) {
            throw new IllegalArgumentException("Tipo de veículo inválido!"); 
        }
        /*Define o tipo de veículo a partir do índice. */
        this.tipoVeiculo = VeiculoSingleton.getInstance().getTipoVeiculo().get(tipo); 
    }
      /**
     * Define o tipo de combustível baseado em um índice.
     * @param tipo O índice do tipo de combustível.
     * @throws IllegalArgumentException se o índice for inválido.
     */
    private void setTipoCombustivel(int tipo) {
        /*Verifica se o índice é válido. */
        if (tipo > VeiculoSingleton.getInstance().getTipoCombustivel().size() - 1) {
            throw new IllegalArgumentException("Tipo de combustivel inválido!"); 
        }
        /*Define o tipo de combustível a partir do índice. */
        this.tipoCombustivel = VeiculoSingleton.getInstance().getTipoCombustivel().get(tipo); 
    }
}



