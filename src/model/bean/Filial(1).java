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
public class Filial {
    private String idFilial;
    private String Endereco;

    public Filial(){};
    
   public Filial(String Endereco) { //contrutor
        this.Endereco = Endereco;
    }
public String getIdFilial() {
        return idFilial;
    }
    public void setIdFilial(String idFilial) {
        this.idFilial = idFilial;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }
    
    

}
