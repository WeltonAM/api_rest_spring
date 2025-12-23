package dev.formacao.backend.usuarios;

import dev.formacao.backend.exceptions.UsuarioExistente;
import dev.formacao.backend.exceptions.UsuarioNaoExistente;
import dev.formacao.backend.jwt.JwtService;
import dev.formacao.backend.usuarios.dto.CadastrarUsuarioDTO;
import dev.formacao.backend.usuarios.dto.LogarUsuarioDTO;
import dev.formacao.backend.usuarios.dto.UsuarioCadastradoDTO;
import dev.formacao.backend.usuarios.dto.UsuarioLogadoDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UsuarioService(
            UsuarioRepository repo,
            PasswordEncoder passwordEncoder,
            @Lazy AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        this.usuarioRepository = repo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public List<UsuarioModel> pegarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioCadastradoDTO cadastrar(CadastrarUsuarioDTO dto) {
       UsuarioModel usuarioExistente = usuarioRepository.findByEmail(dto.getEmail());

       if(usuarioExistente != null) {
           throw new UsuarioExistente();
       }

       UsuarioModel usuario = new UsuarioModel();
       usuario.setNome(dto.getNome());
       usuario.setEmail(dto.getEmail());
       usuario.setSenha(passwordEncoder.encode(dto.getSenha()));

       usuarioRepository.saveAndFlush(usuario);
       return new UsuarioCadastradoDTO(usuario.getNome(), usuario.getEmail());
    }

    public UsuarioLogadoDTO logar(LogarUsuarioDTO dto) {
        UsuarioModel usuarioExiste = usuarioRepository.findByEmail(dto.getEmail());

        if(usuarioExiste == null) {
            throw new UsuarioNaoExistente();
        }

        UsernamePasswordAuthenticationToken emailSenha = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());

        authenticationManager.authenticate(emailSenha);

        String token = jwtService.gerarToken(usuarioExiste.getEmail());

        return new UsuarioLogadoDTO(usuarioExiste.getNome(), usuarioExiste.getEmail(), token);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }
}
