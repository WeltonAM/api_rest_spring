package dev.formacao.backend.usuarios;

import dev.formacao.backend.usuarios.dto.CadastrarUsuarioDTO;
import dev.formacao.backend.usuarios.dto.LogarUsuarioDTO;
import dev.formacao.backend.usuarios.dto.UsuarioCadastradoDTO;
import dev.formacao.backend.usuarios.dto.UsuarioLogadoDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService service) {
        this.usuarioService = service;
    }

    @GetMapping("usuarios")
    public List<UsuarioModel> pegarTodos() {
        return usuarioService.pegarTodos();
    }

    @PostMapping("cadastrar")
    public UsuarioCadastradoDTO cadastrar(@Valid @RequestBody CadastrarUsuarioDTO dto) {
        return usuarioService.cadastrar(dto);
    }

    @PostMapping("login")
    public UsuarioLogadoDTO logar(@Valid @RequestBody LogarUsuarioDTO dto) {
        return usuarioService.logar(dto);
    }
}
