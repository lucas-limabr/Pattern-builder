package com.designPattern.builder.core;

public class BuilderApartamento implements BuilderHome {

    Apartamento apartamento;

    public BuilderApartamento() {
        apartamento = new Apartamento();
    }

    public Apartamento build() {
        this.realizaValidacoes();

        return apartamento;
    }

    private void realizaValidacoes() {
        if (apartamento.getQuantidadeComodos() < 3) {
            throw new IllegalArgumentException("Incoerente. Apartamento deve ter mais pelo menos 3 cômodos (Uma cozinha, uma sala e um quarto)");
        }

        if (apartamento.temSuite() && apartamento.getQuantidadeSuites() <= 0) {
            throw new IllegalArgumentException("Inconsistência. Foi informado que tem suíte, mas a quantidade de suítes é menor ou igual a zero.");
        }

        this.apartamento.validacaoPrecoNulo();
    }

    @Override
    public BuilderApartamento areaTotal(double areaTotal) {
        apartamento.setAreaTotal(areaTotal);
        return this;
    }

    @Override
    public BuilderApartamento setQuantidadeComodos(int quantidadeComodos) {
        apartamento.setQuantidadeComodos(quantidadeComodos);
        return this;
    }

    public BuilderApartamento setQuantidadeBanheiros(int quantidadeBanheiros) {
        apartamento.setQuantidadeBanheiros(quantidadeBanheiros);
        return this;
    }

    public BuilderApartamento setQuantidadeQuartos(int quantidadeQuartos) {
        apartamento.setQuantidadeQuartos(quantidadeQuartos);
        return this;
    }

    @Override
    public BuilderApartamento temSuite(boolean temSuite) {
        apartamento.setTemSuite(temSuite);
        return this;
    }

    public BuilderApartamento setQuantidadeSuites(int quantidadeSuites) {
        apartamento.setQuantidadeSuites(quantidadeSuites);
        return this;
    }

    @Override
    public BuilderApartamento temAreaExterna(boolean temAreaExterna) {
        apartamento.setTemAreaLazer(temAreaExterna);
        return this;
    }

    @Override
    public BuilderApartamento temGaragem(boolean temGaragem) {
        apartamento.setTemGaragem(temGaragem);
        return this;
    }

    @Override
    public BuilderApartamento estaMobiliada(boolean estaMobiliada) {
        apartamento.setEstaMobiliada(estaMobiliada);
        return this;
    }

    @Override
    public BuilderApartamento disponivelAluguel(boolean dispoivelAaluguel) {
        apartamento.setDisponivelAluguel(dispoivelAaluguel);
        return this;
    }

    @Override
    public BuilderApartamento disponivelVenda(boolean disponivelVenda) {
        apartamento.setDisponivelVenda(disponivelVenda);
        return this;
    }

    @Override
    public BuilderApartamento setPreco(double preco) {
        apartamento.setPreco(preco);
        return this;
    }
}
