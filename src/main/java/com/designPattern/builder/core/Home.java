package com.designPattern.builder.core;

public abstract class Home {

    private double areaTotal;
    private boolean isKitnet;
    private int quantidadeComodos;
    private int quantidadeBanheiros;
    private int quantidadeQuartos;
    private boolean temSuite;
    private int quantidadeSuites;
    private boolean temSala;
    private boolean temAreaLazer;
    private boolean temGaragem;
    private boolean estaMobiliada;
    private boolean disponivelAluguel;
    private boolean disponivelVenda;
    private double preco;

    public final void validacaoPrecoNulo() {
        if ((this.disponivelAluguel() || this.disponivelVenda()) && this.getPreco() == 0.0) {
            throw new IllegalArgumentException("Inconsistência. Preço de aluguel ou venda não foi definido.");
        }
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public boolean isKitnet() {
        return isKitnet;
    }

    public void setKitnet(boolean kitnet) {
        isKitnet = kitnet;
    }

    public int getQuantidadeComodos() {
        return quantidadeComodos;
    }

    public void setQuantidadeComodos(int quantidadeComodos) {
        this.quantidadeComodos = quantidadeComodos;
    }

    public int getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(int quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public boolean temSuite() {
        return temSuite;
    }

    public void setTemSuite(boolean temSuite) {
        this.temSuite = temSuite;
    }

    public int getQuantidadeSuites() {
        return quantidadeSuites;
    }

    public void setQuantidadeSuites(int quantidadeSuites) {
        this.quantidadeSuites = quantidadeSuites;
    }

    public boolean temSala() {
        return temSala;
    }

    public void setTemSala(boolean temSala) {
        this.temSala = temSala;
    }

    public boolean temAreaLazer() {
        return temAreaLazer;
    }

    public void setTemAreaLazer(boolean temAreaLazer) {
        this.temAreaLazer = temAreaLazer;
    }

    public boolean temGaragem() {
        return temGaragem;
    }

    public void setTemGaragem(boolean temGaragem) {
        this.temGaragem = temGaragem;
    }

    public boolean estaMobiliada() {
        return estaMobiliada;
    }

    public void setEstaMobiliada(boolean estaMobiliada) {
        this.estaMobiliada = estaMobiliada;
    }

    public boolean disponivelAluguel() {
        return disponivelAluguel;
    }

    public void setDisponivelAluguel(boolean disponivelAluguel) {
        this.disponivelAluguel = disponivelAluguel;
    }

    public boolean disponivelVenda() {
        return disponivelVenda;
    }

    public void setDisponivelVenda(boolean disponivelVenda) {
        this.disponivelVenda = disponivelVenda;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
