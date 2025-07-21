package com.alexribeiro.bffagendadortarefas.business;

import com.alexribeiro.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.alexribeiro.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail ( TarefasDTOResponse dto){
         emailClient.enviarEmail(dto);
    }

}
