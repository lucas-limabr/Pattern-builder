package com.designPattern.builder.core;

public class BuilderKitnet implements BuilderHome {

    Kitnet kitnet;

    public BuilderKitnet() {
        kitnet = new Kitnet();
    }

    public Kitnet build() {
        this.realizaValidacoes();

        return kitnet;
    }

    private void realizaValidacoes() {
        if (kitnet.getQuantidadeComodos() > 2) {
            throw new IllegalArgumentException("Incoerente. Uma kitnet não tem mais de 2 cômodos");
        }

        this.kitnet.validacaoPrecoNulo();
    }

    @Override
    public BuilderKitnet areaTotal(double areaTotal) {
        kitnet.setAreaTotal(areaTotal);
        return this;
    }


    @Override
    public BuilderKitnet setQuantidadeComodos(int quantidadeComodos) {
        kitnet.setQuantidadeComodos(quantidadeComodos);
        return this;
    }

    @Override
    public BuilderKitnet temSuite(boolean temSuite) {
        kitnet.setTemSuite(temSuite);
        return this;
    }

    @Override
    public BuilderKitnet temAreaExterna(boolean temAreaExterna) {
        kitnet.setTemAreaLazer(temAreaExterna);
        return this;
    }

    @Override
    public BuilderKitnet temGaragem(boolean temGaragem) {
        kitnet.setTemGaragem(temGaragem);
        return this;
    }

    @Override
    public BuilderKitnet estaMobiliada(boolean estaMobiliada) {
        kitnet.setEstaMobiliada(estaMobiliada);
        return this;
    }

    @Override
    public BuilderKitnet disponivelAluguel(boolean disponivelAluguel) {
        kitnet.setDisponivelAluguel(disponivelAluguel);
        return this;
    }

    @Override
    public BuilderKitnet disponivelVenda(boolean disponivelVenda) {
        kitnet.setDisponivelVenda(disponivelVenda);
        return this;
    }

    @Override
    public BuilderKitnet setPreco(double preco) {
        kitnet.setPreco(preco);
        return this;
    }
}
