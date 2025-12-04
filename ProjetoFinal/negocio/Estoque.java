/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.Calendar;

/**
 *
 * @author USUARIO
 */
public class Estoque {
    // atributos
    private int idEstoque;
    private int idProduto;// chave estrangeira
    private int idFornecedor;// chave estrangeira
    private int idFuncionario;// chave estrangeira
    private Calendar data;
    private int quantidade;
    private float custo_total;

    public Estoque(int idEstoque, int idProduto, int idFornecedor, int idFuncionario, Calendar data, int quantidade, float custo_total) {
        this.idEstoque = idEstoque;
        this.idProduto = idProduto;
        this.idFornecedor = idFornecedor;
        this.idFuncionario = idFuncionario;
        this.data = data;
        this.quantidade = quantidade;
        this.custo_total = custo_total;
    }

    public Estoque() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getCusto_total() {
        return custo_total;
    }

    public void setCusto_total(float custo_total) {
        this.custo_total = custo_total;
    }
       
}
