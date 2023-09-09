
package com.produtos.crudProdutos.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import com.produtos.crudProdutos.model.ProdutosModel;
import com.produtos.crudProdutos.repository.ProdutosRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProdutosController {
    
    
    @Autowired
    ProdutosRepository produtosRepository;
    
    
    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutosRepository>> getAllProdutos(@RequestParam(required = false) String nome){ 
    try{
       List<Produtos> produtos = new ArrayList<Produtos>();
       
       if(nome==null)
           produtoRepository.findAll()forEach(produtos::add);
        else
            produtosRepository.findbyNomeContaining(nome).forEach(produtos::add);
        
        if (produtos.isEmpty())
            return new   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        }   catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
  }
}
    
     @GetMapping("/produtos/{codigo}")
       public ResponseEntity<Produtos> getProdutosByCodigo(@PathVariable("codigo") String codigo) {
        Optional<Produtos> produtosData = produtosRepository.findByCodigo(codigo);

    if (produtosData.isPresent()) {
      return new ResponseEntity<>(produtosData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
        
     @PostMapping("/produtos")
         public ResponseEntity<Produtos> createProdutos(@RequestBody Produtos produtos) {
    try {
      Produtos _produtos = produtosRepository.save(new Produtos(produto.getCodigo(), produto.getNome(), false));
      return new ResponseEntity<>(_produtos, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  

     @PutMapping("/produtos/{codigo}")
        public ResponseEntity<Produtos> updateProdutos(@PathVariable("codigo") String codigo, @RequestBody Produtos produtos) {
        Optional<Produtos> produtosData = produtosRepository.findByCodigo(Codigo);

    if (produtosData.isPresent()) {
      Produtos _produtos = produtosData.get();
      _produtos.setNome(produtos.getNome());
      _produtos.setPreco(produtos.getPreco());
      return new ResponseEntity<>(produtosRepository.save(_produtos), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

    @DeleteMapping("/produtos/{codigo}")
      public ResponseEntity<HttpStatus> deleteProdutos(@PathVariable("codigo") String codigo) {
    try {
      tutorialRepository.deleteByCodigo(codigo);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
   
    