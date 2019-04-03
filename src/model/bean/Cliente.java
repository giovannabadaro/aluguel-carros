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
public class Cliente {
    private String id_Cliente;
    private String Endereco;
    private String Nome;

    public Cliente(String id_Cliente, String Endereco, String Nome) {
        this.id_Cliente = id_Cliente;
        this.Endereco = Endereco;
        this.Nome = Nome;
    }
    
public Cliente(){};
    public String getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    





}
