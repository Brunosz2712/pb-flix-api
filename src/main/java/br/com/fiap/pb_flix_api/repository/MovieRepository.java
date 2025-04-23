package br.com.fiap.pb_flix_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.pb_flix_api.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Nenhum código foi alterado aqui
}
