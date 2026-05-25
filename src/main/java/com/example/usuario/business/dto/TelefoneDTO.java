package com.example.usuario.business.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTO {

    private Long id; // incluir id no DTO telefone e endereco
    private String numero;
    private String ddd;
}
