package dev.formacao.backend.produtos;

import dev.formacao.backend.exceptions.ProdutoNaoEncontrado;
import dev.formacao.backend.produtos.dto.ProdutoDTO;
import dev.formacao.backend.usuarios.UsuarioModel;
import dev.formacao.backend.usuarios.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;

    public ProdutoService(ProdutoRepository repo, UsuarioRepository usuarioRepository) {
        this.produtoRepository = repo;
        this.usuarioRepository = usuarioRepository;
    }

    private Integer obterUsuarioId(String email) {
        UsuarioModel usuario = usuarioRepository.findByEmail(email);
        return usuario.getId();
    }

    public List<ProdutoDTO> pegarTodos(String email) {
        Integer idUsuario = obterUsuarioId(email);
        return produtoRepository.findByUsuarioModelId(idUsuario).stream().map(ProdutoDTO::fromModel).toList();
    }

    public ProdutoDTO pegarProduto(Integer produtoId, String email) {
        Integer usuarioId = obterUsuarioId(email);
        ProdutoModel produto = produtoRepository.findByIdAndUsuarioModelId(produtoId, usuarioId).orElseThrow(ProdutoNaoEncontrado::new);
        return ProdutoDTO.fromModel(produto);
    }

    public ProdutoDTO criar(ProdutoDTO dto, String email) {
        Integer usuarioId = obterUsuarioId(email);
        dto.setIdUsuario(Optional.of(usuarioId));
        ProdutoModel novoProduto = produtoRepository.saveAndFlush(dto.toModel());
        return ProdutoDTO.fromModel(novoProduto);
    }

    public ProdutoDTO atualizar(Integer produtoId, ProdutoDTO dto, String email) {
        ProdutoDTO produto = pegarProduto(produtoId, email);
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());

        ProdutoModel produtoAtualizado = produtoRepository.saveAndFlush(produto.toModel());

        return ProdutoDTO.fromModel(produtoAtualizado);
    }

    public ProdutoDTO deletar(Integer produtoId, String email) {
        ProdutoDTO produto = pegarProduto(produtoId, email);
        produtoRepository.deleteById(produtoId);

        return produto;
    }
}
