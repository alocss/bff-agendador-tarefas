package com.alexribeiro.bffagendadortarefas.business;


import com.alexribeiro.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.alexribeiro.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.alexribeiro.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.alexribeiro.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.alexribeiro.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.alexribeiro.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.alexribeiro.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.alexribeiro.bffagendadortarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {
    private  final UsuarioClient client;

    public UsuarioDTORequest salvaUsuario(UsuarioDTORequest usuarioDTO){

        return client.salvaUsuario(usuarioDTO);

    }

    public  String loginUsuario(LoginRequestDTO dto){
        return client.login(dto);
    }


    public UsuarioDTORequest buscarUsuarioPorEmail(String email, String token){
        return client.buscaUsuarioPorEmail(email, token);

    }

    public void deletaUsuarioPorEmail(String email, String token){
         client.deletaUsuarioPorEmail(email, token);

    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){
        return client.atualizaDadoUsuario(dto, token);

    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest dto, String token){

        return client.atualizaEndereco(dto, idEndereco, token);

    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){
        return client.atualizaTelefone(dto,idTelefone,token);

    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
        return client.cadastraEndereco(dto, token);

    }

    public TelefoneDTOResponse cadastroTelefone(String token, TelefoneDTORequest dto){
        return client.cadastraTelefone(dto, token);

    }


}
