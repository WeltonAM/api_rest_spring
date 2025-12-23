package dev.formacao.backend.exceptions;

public class UsuarioExistente extends RuntimeException {
    public UsuarioExistente() {
        super("Usuário já existe");
    }
}
