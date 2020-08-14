package com.ferreiracaf.insighttrackingapi.resource;

import com.ferreiracaf.insighttrackingapi.event.RecursoCriadoEvent;
import com.ferreiracaf.insighttrackingapi.model.Categoria;
import com.ferreiracaf.insighttrackingapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodos(){
        List<Categoria> categorias = categoriaService.listarTodos();
        if (!categorias.isEmpty())
            return ResponseEntity.ok(categorias);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriPorId(@PathVariable Long id){
        Categoria categoria = categoriaService.buscarPorCodigo(id);
        if (categoria != null)
            return ResponseEntity.ok(categoria);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaCriada = categoriaService.criarCategoria(categoria);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaCriada.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @Valid @RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.atualizarCategoria(id, categoria));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCategoria(@PathVariable Long id){
        categoriaService.removerCategoria(id);
    }
}
