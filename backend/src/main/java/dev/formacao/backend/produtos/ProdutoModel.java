package dev.formacao.backend.produtos;

import dev.formacao.backend.usuarios.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "inserido_em", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inseridoEm;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuarioModel;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private ProdutoCategoria categoria;
}
