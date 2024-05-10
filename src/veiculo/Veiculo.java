package veiculo;

public class Veiculo implements IVeiculo{
    private int id;
    private String tipoVeiculo;           // carro ou moto 
    private String placa;
    private String modelo;
    private String marca;
    private String categoria;
    private int ano;
    private String cor;
    private int kmRodados;
    private boolean disponivel;
    private double precoDiaria;
    private String tipoCombustivel; 

    // Construtor
    public Veiculo(String modelo, String placa, double precoDiaria, int tipoVeiculo, int tipoCombustivel) {
        this.modelo = modelo;
        this.placa = placa;
        this.precoDiaria = precoDiaria;
        setTipoVeiculo(tipoVeiculo);
        setTipoCombustivel(tipoCombustivel);
    }


    public int getId() {return id; }
    public boolean isDisponivel() { return disponivel; }
    public String getTipoVeiculo() { return tipoVeiculo; }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public String getCategoria() { return categoria; }
    public int getAno() { return ano; }
    public String getCor() { return cor; }
    public int getKmRodados() { return kmRodados; }
    public double getPrecoDiaria() { return precoDiaria; }
    public String getTipoCombustivel() { return tipoCombustivel; }

    private void setId(int id) { this.id = id; }
    private void setPlaca(String placa) { this.placa = placa; }
    private void setModelo(String modelo) { this.modelo = modelo; }
    private void setMarca(String marca) { this.marca = marca; }
    private void setCategoria(String categoria) { this.categoria = categoria; }
    private void setAno(int ano) { this.ano = ano; }
    private void setCor(String cor) { this.cor = cor; }
    private void setKmRodados(int kmRodados) { this.kmRodados = kmRodados; }
    private void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    private void setPrecoDiaria(double precoDiaria) { this.precoDiaria = precoDiaria; }
    
    private void setTipoVeiculo(int tipo) { 
        if (tipo > tiposVeiculo.length - 1) {
            throw new Error("Tipo de veículo inválido!"); 
        }

        this.tipoVeiculo = tiposVeiculo[tipo]; 
    }
    
    private void setTipoCombustivel(int tipo) {
        if (tipo > tiposCombustivel.length - 1) {
            throw new Error("Tipo de combustivel inválido!"); 
        }
    
        this.tipoCombustivel = tiposCombustivel[tipo]; 
    }

    
    
    // Método abstrato para calcular o preço do aluguel
    public double calcularPrecoAluguel() {
        return 0.5;
    };
}
