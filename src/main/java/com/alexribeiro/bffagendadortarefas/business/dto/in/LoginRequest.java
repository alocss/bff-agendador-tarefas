package com.alexribeiro.bffagendadortarefas.business.dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginRequest {

    private String email;
    private String senha;
}
