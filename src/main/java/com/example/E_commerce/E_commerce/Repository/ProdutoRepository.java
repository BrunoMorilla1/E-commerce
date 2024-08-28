package com.example.E_commerce.E_commerce.Repository;

import com.example.E_commerce.E_commerce.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, UUID> {

}
