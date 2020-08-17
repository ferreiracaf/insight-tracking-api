package com.ferreiracaf.insighttrackingapi.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.ferreiracaf.insighttrackingapi.dto.UsuarioDTO;
import com.ferreiracaf.insighttrackingapi.event.RecursoCriadoEvent;
import com.ferreiracaf.insighttrackingapi.model.Usuario;
import com.ferreiracaf.insighttrackingapi.service.UsuarioService;
import com.ferreiracaf.insighttrackingapi.view.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private MessageSource messageSource;

//    @JsonView(Views.UsuarioAtividades.class)
    @GetMapping
//    public ResponseEntity<List<Usuario>> listarTodos() {
//        List<Usuario> usuarios = usuarioService.listarTodos();
//        if (!usuarios.isEmpty()) {
//            return ResponseEntity.ok(usuarios);
//        }
//        return ResponseEntity.noContent().build();
//    }
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        if (!usuarios.isEmpty()) {
            List<UsuarioDTO> retUsers = new ArrayList<>();
            for (Usuario usr : usuarios) {
                retUsers.add(new UsuarioDTO(usr));
            }
            return ResponseEntity.ok(retUsers);
        }
        return ResponseEntity.noContent().build();
    }

//    @JsonView(Views.UsuarioAtividades.class)
    @GetMapping("/{cpf}")
//    public ResponseEntity<Usuario> buscarUsuarioPorCpf(@PathVariable String cpf){
//        Usuario usuario = usuarioService.buscarUsuarioPorCpf(cpf);
//        if (usuario != null)
//            return ResponseEntity.ok(usuario);
//        return ResponseEntity.noContent().build();
//
//    }
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorCpf(@PathVariable String cpf){
        Usuario usuario = usuarioService.buscarUsuarioPorCpf(cpf);
        if (usuario != null)
            return ResponseEntity.ok(new UsuarioDTO(usuario));
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario, HttpServletResponse response){
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getCpf()));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable String cpf, @Valid @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.atualizarUsuario(cpf, usuario));
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerUsuario(@PathVariable String cpf){
        usuarioService.apagarUsuario(cpf);
    }

}
