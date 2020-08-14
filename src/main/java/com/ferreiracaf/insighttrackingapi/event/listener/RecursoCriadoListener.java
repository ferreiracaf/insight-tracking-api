package com.ferreiracaf.insighttrackingapi.event.listener;

import com.ferreiracaf.insighttrackingapi.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        if (recursoCriadoEvent.getCodigo() != null){
            Long codigo = recursoCriadoEvent.getCodigo();
            adicionarHeaderLocation(response, codigo);
        }
        else if (recursoCriadoEvent.getCpf() != null){
            String cpf = recursoCriadoEvent.getCpf();
            adicionarHeaderLocation(response, cpf);
        }
//        /*URI uri = */adicionarHeaderLocation(response, codigo);
    }

    private URI adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return uri;
    }

    private URI adicionarHeaderLocation(HttpServletResponse response, String cpf) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(cpf).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return uri;
    }
}
