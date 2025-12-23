package dev.formacao.backend.produtos.dto;

import dev.formacao.backend.produtos.ProdutoCategoria;
import dev.formacao.backend.produtos.ProdutoModel;
import dev.formacao.backend.usuarios.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Optional<Integer> id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private Double preco;

    @NotNull(message = "Categoria é obrigatória")
    private ProdutoCategoria categoria;

    private Optional<Date> inseridoEm;
    private Optional<Integer> idUsuario;

    public ProdutoModel toModel() {
        ProdutoModel p = new ProdutoModel();

        if(this.id != null && this.id.isPresent()) {
            p.setId((this.id.get()));
        }

        if(this.idUsuario != null && this.idUsuario.isPresent()) {
            UsuarioModel usuarioModel = new UsuarioModel();
            usuarioModel.setId(this.idUsuario.get());
            p.setUsuarioModel(usuarioModel);
        } else {
            p.setUsuarioModel(null);
        }

        boolean temInseridoEm = this.inseridoEm != null && this.inseridoEm.isPresent();

        p.setNome(this.getNome());
        p.setDescricao(this.getDescricao());
        p.setPreco(this.getPreco());
        p.setCategoria(this.getCategoria());
        p.setInseridoEm(temInseridoEm ? this.inseridoEm.get() : new Date());

        return p;
    }

    public static ProdutoDTO fromModel(ProdutoModel produtoModel) {
        return new ProdutoDTO(
                Optional.ofNullable(produtoModel.getId()),
                produtoModel.getNome(),
                produtoModel.getDescricao(),
                produtoModel.getPreco(),
                produtoModel.getCategoria(),
                Optional.ofNullable(produtoModel.getInseridoEm()),
                Optional.ofNullable(produtoModel.getUsuarioModel().getId())
        );
    }
}
