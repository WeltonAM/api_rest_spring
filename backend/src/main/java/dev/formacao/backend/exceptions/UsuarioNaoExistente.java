package dev.formacao.backend.exceptions;

public class UsuarioNaoExistente extends RuntimeException {
    public UsuarioNaoExistente() {
        super("Usuário não existe");
    }
}
