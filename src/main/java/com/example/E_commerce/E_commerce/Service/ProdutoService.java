package com.example.E_commerce.E_commerce.Service;


import com.example.E_commerce.E_commerce.Dto.ProdutoDto;
import com.example.E_commerce.E_commerce.Entity.Produtos;
import com.example.E_commerce.E_commerce.Repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {


    @Autowired
    ProdutoRepository repository;

    public Produtos salvarProdutos(ProdutoDto produtoDto) {
        var produto = new Produtos();
        produto.setDataCriacao(LocalDateTime.now());
        produto.setAtualizacao(LocalDateTime.now());
        BeanUtils.copyProperties(produtoDto, produto);
        return repository.save(produto);
    }

    public List<Produtos> listarProduto(){
        return repository.findAll();
    }

    public Optional<Produtos> produto(UUID id){
        return repository.findById(id);
    }

    public Produtos atualizarProdutos(Produtos produto) {
        produto.setDataCriacao(LocalDateTime.now());
        produto.setAtualizacao(LocalDateTime.now());
        return repository.save(produto);
    }

    public Optional<Produtos> deletarProduto(UUID id) {
        repository.deleteById(id);
        var produtos1 = new Produtos();
        return null;
    }
}
