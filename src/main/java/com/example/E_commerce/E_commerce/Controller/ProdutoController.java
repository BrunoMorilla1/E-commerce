package com.example.E_commerce.E_commerce.Controller;

import com.example.E_commerce.E_commerce.Dto.ProdutoDto;
import com.example.E_commerce.E_commerce.Entity.Produtos;
import com.example.E_commerce.E_commerce.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produtos> salvarProdutos(@RequestBody @Valid ProdutoDto produtoDto){
        var salvar = produtoService.salvarProdutos(produtoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);

    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listarProdutos(){
        var listar = produtoService.listarProduto();
        return ResponseEntity.status(HttpStatus.OK).body(listar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProduto(@PathVariable(value = "id")UUID idProduto){
        Optional<Produtos> produtos = produtoService.produto(idProduto);
            if(produtos.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
            }
        return ResponseEntity.status(HttpStatus.OK).body(produtos.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id")UUID idProduto,
                                            @RequestBody @Valid ProdutoDto produtoDto){
        Optional<Produtos> produtos = produtoService.produto(idProduto);
        if(produtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        var produtos1 = produtos.get();
        BeanUtils.copyProperties(produtoDto, produtos1);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizarProdutos(produtos1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable(value = "id")UUID idProduto){
        Optional<Produtos> deletar = produtoService.produto(idProduto);
        if(deletar.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        ResponseEntity.ok().body(produtoService.deletarProduto(idProduto));
        System.out.println("Produto deletado: " + idProduto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProduto());

    }

}

