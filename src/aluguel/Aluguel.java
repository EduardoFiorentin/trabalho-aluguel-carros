package aluguel;

import pessoas.*;
import veiculo.*; 

public class Aluguel {
    private Veiculo veiculo;
	private Cliente cliente;
	private Funcionario funcionarioResponsavel;
    private boolean ativo; 

	public Aluguel(Veiculo veiculo, Cliente cliente, Funcionario funcionarioResponsavel) {
        setVeiculo(veiculo);
        setCliente(cliente);
        setFuncionarioResponsavel(funcionarioResponsavel);
        iniciar();
    }

    //Metodos
    public boolean getAtivo() { return ativo; } 
    public Veiculo getVeiculo(){ return veiculo; }
    public Cliente getCliente(){ return cliente; }
    public Funcionario getFuncionarioResponsavel(){ return funcionarioResponsavel; }
    public String getInfo() { return String.format("Cliente: %s - %s | Funcionario: %s - %s | Veículo: %s - %s, %s - placa: %s", cliente.getNome(), cliente.getCpf(), funcionarioResponsavel.getNome(), funcionarioResponsavel.getCargo(), veiculo.getTipoVeiculo(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca());}
    
    public void setAtivo (boolean ativo)        { this.ativo = ativo; }
    public void setVeiculo(Veiculo veiculo)     { this.veiculo = veiculo; }
    public void setCliente(Cliente cliente)     { this.cliente = cliente; }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel)   { this.funcionarioResponsavel = funcionarioResponsavel; }

    public void iniciar() {
        veiculo.setDisponivel(false);
        setAtivo(true);
    }

    public void finalizar() {
        veiculo.setDisponivel(true);
        setAtivo(false);
    }
}
