package br.com.anderson.portifolio.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    private LocalDate datanascimento;

    @Column(length = 14)
    private String cpf;

    private Boolean funcionario;

    private Boolean gerente;

    // Construtor adicional
    public Pessoa(String nome) {
        this.nome = nome;
    }

}