package com.example.E_commerce.E_commerce.Service;


import com.example.E_commerce.E_commerce.Entity.Produtos;
import com.example.E_commerce.E_commerce.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {


    @Autowired
    ProdutoRepository repository;


    public Produtos salvarProdutos() {
        var produtos = new Produtos();
        return repository.save(produtos);
    }

    public List<Produtos> listarProduto(){
        return repository.findAll();
    }

    public Optional<Produtos> produto(UUID id){
        return repository.findById(id);
    }

    public Produtos atualizarProdutos(Produtos produtos) {
        return repository.save(produtos);
    }

    public Optional<Produtos> deletarProduto(UUID id) {
        repository.deleteById(id);
        return null;
    }
}
