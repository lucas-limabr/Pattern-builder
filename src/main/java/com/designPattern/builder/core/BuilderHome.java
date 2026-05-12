package com.designPattern.builder.core;

interface BuilderHome {

    BuilderHome areaTotal(double areaTotal);

    BuilderHome setQuantidadeComodos(int quantidadeComodos);

    BuilderHome temSuite(boolean temSuite);

    BuilderHome temAreaExterna(boolean temAreaLazer);

    BuilderHome temGaragem(boolean temGaragem);

    BuilderHome estaMobiliada(boolean estaMobiliada);

    BuilderHome disponivelAluguel(boolean dispoivelAaluguel);

    BuilderHome disponivelVenda(boolean disponivelVenda);

    BuilderHome setPreco(double preco);
}
