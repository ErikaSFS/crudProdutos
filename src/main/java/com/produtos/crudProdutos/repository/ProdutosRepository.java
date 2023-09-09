
package com.produtos.crudProdutos.repository;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.produtos.crudProdutos.model.ProdutosModel;


public interface ProdutosRepository extends MongoRepository<ProdutosModel, String> {
    List<ProdutosModel> findByName(String nome);
    List<ProdutosModel> findByCodigo(String codigo);
}
