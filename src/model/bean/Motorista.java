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
public class Motorista {
    private String numeroHabilitacao;
    private String RG;
    private String Nome;
    private String Vencimento;
    private String Cliente_idCliente;

    public Motorista(String numeroHabilitacao, String RG, String Nome, String Vencimento, String Cliente_idCliente) {
        this.numeroHabilitacao = numeroHabilitacao;
        this.RG = RG;
        this.Nome = Nome;
        this.Vencimento = Vencimento;
        this.Cliente_idCliente = Cliente_idCliente;
    }
    public Motorista (){};

    public String getNumeroHabilitacao() {
        return numeroHabilitacao;
    }

    public void setNumeroHabilitacao(String numeroHabilitacao) {
        this.numeroHabilitacao = numeroHabilitacao;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getVencimento() {
        return Vencimento;
    }

    public void setVencimento(String Vencimento) {
        this.Vencimento = Vencimento;
    }

    public String getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setCliente_idCliente(String Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }


}
