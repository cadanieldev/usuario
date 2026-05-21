package com.example.usuario.business.converter;


import com.example.usuario.business.dto.EnderecoDTO;
import com.example.usuario.business.dto.TelefoneDTO;
import com.example.usuario.business.dto.UsuarioDTO;
import com.example.usuario.infrastructure.entity.Endereco;
import com.example.usuario.infrastructure.entity.Telefone;
import com.example.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // Nao é uma service, apenas mais um componente
// O builder ajuda para setar as infos usando return
public class UsuarioConverter {

    //Criamos o converter para converter as dtos para entity
    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        //Transformar a converçao de uma list, vamos usar o java stream
//        return enderecoDTOS.stream().map(this::paraEndereco).toList(); // map transforma cada um em uma lista de endereco
        List<Endereco> enderecos  = new ArrayList<>();
        for(EnderecoDTO enderecoDTO : enderecoDTOS){
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;
    } //forma de usar o for

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList(); // chamando o metodo
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){ // metodo
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }








    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO){
        return UsuarioDTO.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefonesDTO(usuarioDTO.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS){
        //Transformar a converçao de uma list, vamos usar o java stream
//        return enderecoDTOS.stream().map(this::paraEndereco).toList(); // map transforma cada um em uma lista de endereco
        List<EnderecoDTO> enderecos  = new ArrayList<>();
        for(Endereco enderecoDTO : enderecoDTOS){
            enderecos.add(paraEnderecoDTO(enderecoDTO));
        }
        return enderecos;
    } //forma de usar o for

    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO){
        return EnderecoDTO.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList(); // chamando o metodo
    }

    public TelefoneDTO paraTelefoneDTO(Telefone  telefoneDTO){ // metodo
        return TelefoneDTO.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }
}
