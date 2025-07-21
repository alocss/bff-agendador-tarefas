package com.alexribeiro.bffagendadortarefas.infrastructure.client.config;

import com.alexribeiro.bffagendadortarefas.infrastructure.exceptions.BusinessException;
import com.alexribeiro.bffagendadortarefas.infrastructure.exceptions.ConflictException;
import com.alexribeiro.bffagendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.alexribeiro.bffagendadortarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.net.ConnectException;

public class FeignError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()) {
            case 409:
                return new ConnectException("Erro atributo já existente ");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado ");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado ");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}



