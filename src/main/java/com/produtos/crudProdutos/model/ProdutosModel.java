
package com.produtos.crudProdutos.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection = "ProdutosModel")
public class ProdutosModel {
    @Id
    private String codigo;
    private String nome;
    private double preco;
    
    
    public ProdutosModel(){
        
    }
    
    public ProdutosModel( String codigo, String nome, double preco){
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
    }
    
    public String getCodigo() {
    return codigo;
    }
    
    public String getNome() {
    return nome;
    }
    
     public double getPreco() {
    return preco;
  }
    
}
