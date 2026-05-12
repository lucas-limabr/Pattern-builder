package com.designPattern.builder.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderApartamentoTest {

    BuilderApartamento builderApartamento;
    Apartamento apartamento;

    @BeforeEach
    void setUp() {
        builderApartamento = new BuilderApartamento();
    }

    @Test
    void deveRetornarApartamentoValido() {
        apartamento = builderApartamento.setQuantidadeComodos(5)
                .setQuantidadeBanheiros(2)
                .setQuantidadeQuartos(1)
                .temSuite(true)
                .setQuantidadeSuites(2)
                .areaTotal(200.0)
                .disponivelAluguel(true)
                .estaMobiliada(true)
                .disponivelVenda(false)
                .temGaragem(true)
                .setPreco(2500.0)
                .temAreaExterna(true)
                .build();

        assertNotNull(apartamento);
    }

    @Test
    void deveLancarExcecaoQuantidadeComodosAbaixoDoMinimo() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            builderApartamento.setQuantidadeComodos(2)
                    .setQuantidadeBanheiros(1)
                    .setQuantidadeQuartos(1)
                    .setQuantidadeSuites(0)
                    .areaTotal(150.0)
                    .disponivelAluguel(true)
                    .estaMobiliada(true)
                    .temGaragem(true)
                    .setPreco(2000.0)
                    .build();
        });

        assertEquals("Incoerente. Apartamento deve ter mais pelo menos 3 cômodos (Uma cozinha, uma sala e um quarto)", e.getMessage());
    }

    @Test
    void deveLancarExcecaoTemSuiteComQuantidadeMenorOuIgualAZero() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            builderApartamento.setQuantidadeComodos(3)
                    .setQuantidadeBanheiros(1)
                    .setQuantidadeQuartos(1)
                    .temSuite(true)
                    .areaTotal(150.0)
                    .disponivelAluguel(true)
                    .estaMobiliada(true)
                    .temGaragem(true)
                    .setPreco(2000.0)
                    .build();
        });

        assertEquals("Inconsistência. Foi informado que tem suíte, mas a quantidade de suítes é menor ou igual a zero.", e.getMessage());
    }

    @Test
    void deveLancarExcecaoPrecoNuloQuandoEstaDisponivelParaAluguel() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            builderApartamento.setQuantidadeComodos(3)
                    .setQuantidadeBanheiros(1)
                    .setQuantidadeQuartos(1)
                    .temSuite(true)
                    .setQuantidadeSuites(1)
                    .areaTotal(150.0)
                    .disponivelAluguel(true)
                    .estaMobiliada(true)
                    .temGaragem(true)
                    .build();
        });

        assertEquals("Inconsistência. Preço de aluguel ou venda não foi definido.", e.getMessage());
    }

    @Test
    void deveLancarExcecaoPrecoNuloQuandoEstaDisponivelParaVenda() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            builderApartamento.setQuantidadeComodos(3)
                    .setQuantidadeBanheiros(1)
                    .setQuantidadeQuartos(1)
                    .temSuite(true)
                    .setQuantidadeSuites(1)
                    .areaTotal(150.0)
                    .disponivelVenda(true)
                    .estaMobiliada(true)
                    .temGaragem(true)
                    .build();
        });

        assertEquals("Inconsistência. Preço de aluguel ou venda não foi definido.", e.getMessage());
    }
}