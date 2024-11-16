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
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataPrevisaoFim;

    private LocalDate dataFim;

    @Column(length = 5000)
    private String descricao;

    @Column(length = 45)
    private String status;

    private Float orcamento;

    @Column(length = 45)
    private String risco;

    @ManyToOne
    @JoinColumn(name = "idgerente", nullable = false)
    private Pessoa gerente;

    public Projeto(String nome, String gerente, String status) {
        this.nome = nome;
        this.gerente = Pessoa.builder().nome(gerente).build(); // Cria um objeto Pessoa com apenas o nome
        this.status = status;
    }

}