package com.example.E_commerce.E_commerce.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTOS")
@Getter
@Setter
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduto;
    private String nome;
    private String descricaDoProduto;
    private double valor;
    private int quantidades;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao", updatable = false)
    private LocalDateTime atualizacao;

    @PrePersist
    protected void onCreate() {
        ZonedDateTime dataHoraSaoPaulo = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        this.dataCriacao = dataHoraSaoPaulo.toLocalDateTime().withNano(0);
    }
    @PreUpdate
    protected void onUpdate() {
        // Define a data e hora de atualização como o horário atual em São Paulo, sem frações de segundos
        ZonedDateTime dataHoraSaoPaulo = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        this.atualizacao = dataHoraSaoPaulo.toLocalDateTime().withNano(0);
    }
}



