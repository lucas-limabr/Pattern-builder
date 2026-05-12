package com.designPattern.builder.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderKitnetTest {

    BuilderKitnet builderKitnet;
    Kitnet kitnet;

    @BeforeEach
    void setUp() {
        builderKitnet = new BuilderKitnet();
    }

    @Test
    void deveRetornarKitnetValida() {
        kitnet = builderKitnet.setQuantidadeComodos(1)
                .areaTotal(80.0)
                .disponivelAluguel(true)
                .estaMobiliada(true)
                .temGaragem(false)
                .setPreco(800.0)
                .build();

        assertNotNull(kitnet);
    }

    @Test
    void deveLancarExcecaoQuantidadeComodosAcimaDoMaximo() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            builderKitnet.setQuantidadeComodos(3)
                    .temSuite(false)
                    .areaTotal(150.0)
                    .disponivelAluguel(true)
                    .estaMobiliada(true)
                    .temGaragem(true)
                    .setPreco(700.0)
                    .temAreaExterna(false)
                    .build();
        });

        assertEquals("Incoerente. Uma kitnet não tem mais de 2 cômodos", e.getMessage());
    }

    @Test
    void deveLancarExcecaoPrecoNuloQuandoEstaDisponivelParaAluguel() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            builderKitnet.setQuantidadeComodos(1)
                    .areaTotal(120.0)
                    .disponivelAluguel(true)
                    .estaMobiliada(true)
                    .temGaragem(false)
                    .temAreaExterna(false)
                    .build();
        });

        assertEquals("Inconsistência. Preço de aluguel ou venda não foi definido.", e.getMessage());
    }

    @Test
    void deveLancarExcecaoPrecoNuloQuandoEstaDisponivelParaVenda() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            builderKitnet.setQuantidadeComodos(1)
                    .temSuite(false)
                    .areaTotal(110.0)
                    .disponivelVenda(true)
                    .estaMobiliada(true)
                    .build();
        });

        assertEquals("Inconsistência. Preço de aluguel ou venda não foi definido.", e.getMessage());
    }

}