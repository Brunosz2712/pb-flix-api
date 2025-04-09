package br.com.fiap.pb_flix_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.pb_flix_api.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

    //List<Transaction> findByDescriptionContainingIgnoringCase(String description); // Query Methods

    //List<Transaction> findByDescriptionContainingIgnoringCaseAndDate(String description, LocalDate date);

   // List<Transaction> findByDate(LocalDate date);
    
}    
