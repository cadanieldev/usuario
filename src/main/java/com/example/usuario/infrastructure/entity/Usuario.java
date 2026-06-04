package com.example.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter // Metodo get
@Setter // Metodo set
@AllArgsConstructor // Metodo com mais de 1 construtor
@NoArgsConstructor // Metodo sem construtor
//Criar uma tabela com entity
@Entity
@Table(name = "usuario") // table para definir o nome da tabela, se nao colocar ele coloca random
@Builder
public class Usuario implements UserDetails { // implements validar usuario como login e senha
    //Criar o identificado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Criar de forma generada automaticamente
    private Long id;
    @Column(name = "nome", length = 100) // Definindo a coluna
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;
    //Criar outra tabela para se comunicar com a usuario com o relacionamento OneToMany/One Many para muitos e One para um endereço
    @OneToMany(cascade = CascadeType.ALL)// cascade ao excluir , ela exclui todos.
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") // Ela traz o nome da nossa coluna/constar no endereço e a referencia como id
    private List<Endereco> enderecos; // Apontar para outra tabela como lista
    //Relacionar telefone
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    //Encapsulamento gerando pelo generate, porem vamos usar o lombok acima com @...
}
