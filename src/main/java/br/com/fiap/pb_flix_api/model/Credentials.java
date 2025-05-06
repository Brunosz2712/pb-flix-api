package br.com.fiap.pb_flix_api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Credentials(
    @Email
    @NotBlank
    String email,

    @NotBlank
    String password
) {}
