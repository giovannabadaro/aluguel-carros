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
public class Modelo {
    private String codigo;
    private String Categoria;
    private String Cambio;
    private String Direcao;
    private String nPassageiros;

    public Modelo(String codigo, String Categoria, String Cambio, String Direcao, String nPassageiros) {
        this.codigo = codigo;
        this.Categoria = Categoria;
        this.Cambio = Cambio;
        this.Direcao = Direcao;
        this.nPassageiros = nPassageiros;
    }
    
    public Modelo(){};

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCambio() {
        return Cambio;
    }

    public void setCambio(String Cambio) {
        this.Cambio = Cambio;
    }

    public String getDirecao() {
        return Direcao;
    }

    public void setDirecao(String Direcao) {
        this.Direcao = Direcao;
    }

    public String getnPassageiros() {
        return nPassageiros;
    }

    public void setnPassageiros(String nPassageiros) {
        this.nPassageiros = nPassageiros;
    }
    
    

            }