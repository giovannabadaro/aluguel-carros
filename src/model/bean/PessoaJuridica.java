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
public class PessoaJuridica extends Cliente {
    private String CNPJ;
    private String Cliente_idCliente;

    public PessoaJuridica(String CNPJ, String Nome, String Cliente_idCliente, String id_Cliente, String Endereco) {
        super(id_Cliente, Endereco, Nome);
        this.CNPJ = CNPJ;
        this.Cliente_idCliente = Cliente_idCliente;
    }
    public PessoaJuridica(){};

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setCliente_idCliente(String Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }

  
    
    
  

   
    
    
}
