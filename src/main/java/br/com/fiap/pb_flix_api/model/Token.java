package br.com.fiap.pb_flix_api.model;

public record Token(
    String token,
   Long expiration,
    String type,
    String role
) {}
