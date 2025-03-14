package dev.java10x.marmitaia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.marmitaia.enums.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredientes")
public class Ingredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;
    @JsonIgnore
    @Column(nullable = true)
    private Integer calorias;
    private Integer quantidade;
    @JsonIgnore
    @Column(nullable = true)
    private LocalDate validade;

    @Override
    public String toString() {
        return "Ingredientes{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria=" + categoria +
                ", calorias=" + calorias +
                ", quantidade=" + quantidade +
                ", validade=" + validade +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
