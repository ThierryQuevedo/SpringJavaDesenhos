package com.desenho.cadastro_desenho.infrastrucure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "desenho")
@Entity

public class Desenho {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "ano_lancamento")
    private Integer  ano_lancamento;

    @Column (name = "protagonista")
    private String protagonista;

    @Column (name = "criador")
    private String criador;

}
