package aluguel;

import pessoas.*;
import veiculo.*; 

public class Aluguel {
    private Veiculo veiculo;
	private Cliente cliente;
	private Funcionario funcionarioResponsavel;

	public Aluguel(Veiculo veiculo, Cliente cliente, Funcionario funcionarioResponsavel) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    //Metodos
    public Veiculo getVeiculo(){ return veiculo; }
    public Cliente getCliente(){ return cliente; }
    public Funcionario getFuncionarioResponsavel(){ return funcionarioResponsavel; }
    
    public void setVeiculo(Veiculo veiculo){ this.veiculo = veiculo; }
    public void setCliente(Cliente cliente){ this.cliente = cliente; }
    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel){
        this.funcionarioResponsavel = funcionarioResponsavel;
    }
}
