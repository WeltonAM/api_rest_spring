package dev.formacao.backend.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogarUsuarioDTO {
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Size(min = 3, max = 50, message = "O email deve ter entre 3 e 50 caracteres")
    String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 3, max = 50, message = "A senha deve ter entre 3 e 50 caracteres")
    String senha;
}
