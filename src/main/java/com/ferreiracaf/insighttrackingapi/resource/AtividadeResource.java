package com.ferreiracaf.insighttrackingapi.resource;

import com.ferreiracaf.insighttrackingapi.event.RecursoCriadoEvent;
import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.repository.filter.AtividadeFilter;
import com.ferreiracaf.insighttrackingapi.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeResource {

    @Autowired
    private AtividadeService atividadeService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<Page<Atividade>> listarAtividades(AtividadeFilter atividadeFilter, Pageable pageable){
        return ResponseEntity.ok(atividadeService.listarTodos(atividadeFilter, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> buscarAtividadePorId(@PathVariable Long id){
        Atividade atividade = atividadeService.buscarPorCodigo(id);
        return atividade != null ? ResponseEntity.ok(atividade) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Atividade> criarAtividade(@Valid @RequestBody Atividade atividade, HttpServletResponse response){
        Atividade atividadeCriada = atividadeService.criarAtividade(atividade);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, atividadeCriada.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(atividadeCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atividade> atualizarAtividade(@PathVariable Long id, @Valid @RequestBody Atividade atividade){
        return ResponseEntity.ok(atividadeService.atualizarAtividade(id, atividade));
    }

    @DeleteMapping("/{id}")
    void removerAtividade(@PathVariable Long id){
        atividadeService.removerAtividade(id);
    }

}
