/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Cida
 */
public class PessoaFisica extends Cliente {
    private String CPF;
    private String sexo;
    private String DataNascimento;   
    private String Cliente_idCliente;

    public PessoaFisica(String CPF, String sexo, String DataNascimento, String id_Cliente, String Endereco, String Nome) {
        super(id_Cliente, Endereco, Nome);
        this.CPF = CPF;
        this.sexo = sexo;
        this.DataNascimento = DataNascimento;
        this.Cliente_idCliente = super.getId_Cliente();
    }

    public PessoaFisica() {};
       

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setCliente_idCliente(String Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }

  
    
    

    
}
