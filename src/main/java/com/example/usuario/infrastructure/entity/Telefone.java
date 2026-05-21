package com.example.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter // Metodo get
@Setter // Metodo set
@AllArgsConstructor // Metodo com mais de 1 construtor
@NoArgsConstructor // Metodo sem construtor
//Criar uma tabela com entity
@Entity
@Table(name = "telefone") // table para definir o nome da tabela, se nao colocar ele coloca random
@Builder
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero", length = 10)
    private String numero;
    @Column(name = "ddd", length = 3)
    private String ddd;
}
