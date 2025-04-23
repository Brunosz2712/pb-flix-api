package br.com.fiap.pb_flix_api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Campo Obrigatório")
    @Size(min = 5, max = 255, message = "Deve ter pelo menos 5 caracteres")
    private String name;

    @NotBlank(message = "Campo Obrigatório")
    @Size(min = 5, max = 255, message = "Deve ter pelo menos 5 caracteres")
    private String description;

    @PastOrPresent(message = "Não pode ser no futuro")
    private LocalDate realiseDate;

    @NotNull(message = "Campo Obrigatório")
    @Enumerated(EnumType.STRING)
    private MovieType type;

    @NotNull(message = "campo obrigatório")
    @ManyToOne
    private Category category;
}