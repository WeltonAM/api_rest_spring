package dev.formacao.backend.exceptions;

public class ProdutoNaoEncontrado extends RuntimeException {
    public ProdutoNaoEncontrado() {
        super("Produto não encontrado");
    }
}
