package br.com.fiap.pb_flix_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo Obrigatório")
    private String name;

    @NotBlank(message = "Campo Obrigatório")
    private String gender;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^[A-Z].*", message = "Deve Começar Com Maiúscula")
    private String icon;

}
