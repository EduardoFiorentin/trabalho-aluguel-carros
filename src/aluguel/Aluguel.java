package aluguel;

import pessoas.*;
import utilitarios.UniqueIDGenerator;
import veiculo.*;

/**
 * A classe Aluguel é documentada com uma descrição geral do seu propósito e dos atributos principais.<br/>
 * A classe Aluguel representa o processo de aluguel de um veículo por um cliente. <br/>
 * Inclui informações sobre o veículo alugado, o cliente, o funcionário responsável, 
 * e o estado do aluguel.
 */
public class Aluguel implements Identificavel{
    private String id; 
    private Veiculo veiculo;
	private Cliente cliente;
	private Funcionario funcionarioResponsavel;
    private boolean ativo;
    private int diasDeAluguel;

    /**
     * O construtor da classe Aluguel é documentado com uma descrição dos parâmetros.<br/>
     * Construtor para criar um novo Aluguel.
     *
     * @param id o identificador único do aluguel
     * @param veiculo o veículo que está sendo alugado
     * @param cliente o cliente que está alugando o veículo
     * @param funcionarioResponsavel o funcionário responsável pelo aluguel
     * @param diasDeAluguel o número de dias pelos quais o veículo será alugado
    */
	public Aluguel(Veiculo veiculo, Cliente cliente, Funcionario funcionarioResponsavel, int diasDeAluguel) {
        setId(UniqueIDGenerator.generateUniqueID());
        setVeiculo(veiculo);
        setCliente(cliente);
        setFuncionarioResponsavel(funcionarioResponsavel);
        setDiasDeAluguel(diasDeAluguel);
        iniciar();
    }

    //Metodos
     /**
     * Metodos:
     * Cada método getter e setter, bem como os métodos iniciar e finalizar, são documentados 
     * com uma breve descrição do que fazem, incluindo, quando aplicável, 
     * os parâmetros e valores de retorno.
    */
    
    /**
     * Obtém o identificador único do aluguel.
     * @return o identificador único do aluguel
     */
    public String getId() { return id; }
    
    /**
     * Verifica se o aluguel está ativo.
     * @return true se o aluguel estiver ativo, false caso contrário
     */
    public boolean getAtivo() { return ativo; } 
    
    /**
     * Obtém o veículo que está sendo alugado.
     * @return o veículo que está sendo alugado
     */
    public Veiculo getVeiculo(){ return veiculo; }
    
    /**
     * Obtém o cliente que está alugando o veículo.
     * @return o cliente que está alugando o veículo
     */
    public Cliente getCliente(){ return cliente; }
    
    /**
     * Obtém o funcionário responsável pelo aluguel.
     * @return o funcionário responsável pelo aluguel
     */
    public Funcionario getFuncionarioResponsavel(){ return funcionarioResponsavel; }
    
    /**
     * Obtém uma string formatada com as informações do aluguel.
     * @return as informações do aluguel formatadas
     */
    public String getInfo() { return String.format("Cliente: %s - %s | Funcionario: %s - %s | Veículo: %s - %s, %s - placa: %s | ativo: %s", cliente.getNome(), cliente.getCpf(), funcionarioResponsavel.getNome(), funcionarioResponsavel.getCargo(), veiculo.getTipoVeiculo(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca(), getAtivo() ? "sim": "não");}
    
    /**
     * Obtém o número de dias pelos quais o veículo será alugado.
     * @return o número de dias de aluguel
     */
    public int getDiasDeAluguel() {return diasDeAluguel;}
    
    /**
     * Define o identificador único do aluguel.
     * @param id o novo identificador único do aluguel
     */

    public void setId(String id)                { this.id = id; }
    
    /**
     * Define se o aluguel está ativo.
     * @param ativo o novo estado de atividade do aluguel
     */
    public void setAtivo (boolean ativo)        { this.ativo = ativo; }
    
    /**
     * Define o veículo que está sendo alugado.
     * @param veiculo o novo veículo a ser alugado
     */
    public void setVeiculo(Veiculo veiculo)     { this.veiculo = veiculo; }
    
    /**
     * Define o cliente que está alugando o veículo.
     * @param cliente o novo cliente que está alugando o veículo
     */
    public void setCliente(Cliente cliente)     { this.cliente = cliente; }
    
    /**
     * Define o funcionário responsável pelo aluguel.
     * @param funcionarioResponsavel o novo funcionário responsável pelo aluguel
     */
    public void setDiasDeAluguel(int diasDeAluguel) { this.diasDeAluguel = diasDeAluguel;}
    
    /**
     * Define o número de dias pelos quais o veículo será alugado.
     * @param diasDeAluguel o novo número de dias de aluguel
     */
    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel)   { this.funcionarioResponsavel = funcionarioResponsavel; }
     
    /**
     * Inicia o aluguel, definindo o veículo como não disponível e o aluguel como ativo.
     */

    public void iniciar() {
        veiculo.setDisponivel(false);
        setAtivo(true);
    }

    /**
     * Finaliza o aluguel, definindo o veículo como disponível e o aluguel como inativo.
     */
    public void finalizar() {
        veiculo.setDisponivel(true);
        setAtivo(false);
    }


}
