package dev.formacao.backend.produtos;

import dev.formacao.backend.produtos.dto.ProdutoDTO;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService service) {
        this.produtoService = service;
    }

    @GetMapping
    public List<ProdutoDTO> pegarTodos(@AuthenticationPrincipal UserDetails userDetails) {
        return produtoService.pegarTodos(userDetails.getUsername());
    }

    @GetMapping("/{id}")
    public ProdutoDTO pegarProduto(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        return produtoService.pegarProduto(id, userDetails.getUsername());
    }

    @PostMapping
    public ProdutoDTO criar(@Valid @RequestBody ProdutoDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        return produtoService.criar(dto, userDetails.getUsername());
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizar(@PathVariable Integer id, @Valid @RequestBody ProdutoDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        return produtoService.atualizar(id, dto, userDetails.getUsername());
    }

    @DeleteMapping("/{id}")
    public ProdutoDTO deletar(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        return produtoService.deletar(id, userDetails.getUsername());
    }
}
