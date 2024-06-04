package veiculo;

import java.util.List;

import pessoas.Identificavel;

public class Veiculo implements Identificavel{
    private String id;
    private String tipoVeiculo;           // carro ou moto 
    private String placa;
    private String modelo;
    private String marca;
    private String categoria;
    private String ano;
    private String cor;
    private int kmRodados;
    private boolean disponivel;
    private double precoDiaria;
    private String tipoCombustivel;

    // Construtor
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
    public String getInfo() {
        return String.format("ID: %s\t%s\t%s - %s %s\tDiaria: %f", getId(), isDisponivel() ? "Disponivel" : "Indisponível", getModelo(), getMarca(), getCategoria(), getPrecoDiaria()); 
    }

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

   
    
    private void setTipoVeiculo(int tipo) { 
        if (tipo > VeiculoSingleton.getInstance().getTipoVeiculo().size() - 1) {
            throw new IllegalArgumentException("Tipo de veículo inválido!"); 
        }

        this.tipoVeiculo = VeiculoSingleton.getInstance().getTipoVeiculo().get(tipo); 
    }
    
    private void setTipoCombustivel(int tipo) {
        if (tipo > VeiculoSingleton.getInstance().getTipoCombustivel().size() - 1) {
            throw new IllegalArgumentException("Tipo de combustivel inválido!"); 
        }
    
        this.tipoCombustivel = VeiculoSingleton.getInstance().getTipoCombustivel().get(tipo); 
    }
}



