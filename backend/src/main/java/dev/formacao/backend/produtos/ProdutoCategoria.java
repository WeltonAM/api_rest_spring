package dev.formacao.backend.produtos;

public enum ProdutoCategoria {
    ROUPA("Roupa"),
    ELETRONICO("Eletrônico"),
    ESCRITORIO("Escritório"),
    MOVEIS("Móveis");

    private final String valor;

    ProdutoCategoria(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
}
