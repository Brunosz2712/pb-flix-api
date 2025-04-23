package br.com.fiap.pb_flix_api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pb_flix_api.model.Movie;
import br.com.fiap.pb_flix_api.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("movies")
@Slf4j
public class MovieController {
    public record MovieFilter(String name, String description, LocalDate realiseDate) {}

    @Autowired
    private MovieRepository repository;

    @GetMapping
    public List<Movie> index(MovieFilter filter){
        log.info("Buscando Filmes com descrição {} e data {}", filter.description(), filter.realiseDate());

        var probe = Movie.builder()
        .description(filter.description())
        .realiseDate(filter.realiseDate())
        .build();

        var matcher = ExampleMatcher
                    .matchingAll()
                    .withIgnoreCase()
                    .withStringMatcher(StringMatcher.CONTAINING);

        var example = Example.of(probe, matcher);
        return repository.findAll(example);
}
}
