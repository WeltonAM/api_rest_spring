package dev.formacao.backend.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    public UsuarioModel findByEmail(String email);
}
