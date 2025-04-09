package br.com.fiap.pb_flix_api.config;

import br.com.fiap.pb_flix_api.model.Category;
import br.com.fiap.pb_flix_api.model.Movie;
import br.com.fiap.pb_flix_api.model.MovieType;
import br.com.fiap.pb_flix_api.repository.CategoryRepository;
import br.com.fiap.pb_flix_api.repository.MovieRepository;
import jakarta.annotation.PostConstruct;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

   @Autowired
   private CategoryRepository categoryRepository;

   @Autowired
    private MovieRepository movieRepository;

    @PostConstruct
    public void init(){
      var categories = List.of(
         Category.builder().name("Ação").icon("Movie").build(),
         Category.builder().name("Drama").icon("Movie").build(),
         Category.builder().name("Terror").icon("Movie").build(),
         Category.builder().name("Suspense").icon("Movie").build()
      );

      categoryRepository.saveAll(categories);

      var descriptions = List.of(
         "Ação",
         "Comédia",
         "Terror",
         "Suspense",
         "Drama",
         "Fixão Ciêntifica"
      );

      var movies = new ArrayList<Movie>();
        for (int i = 0; i < 50; i++) {
            movies.add(Movie.builder()
                    .description(descriptions.get(new Random().nextInt(descriptions.size())))
                    .realiseDate(LocalDate.now().minusDays(new Random().nextInt(30)))
                    .type(MovieType.EXPENSE)
                    .build());
        }
        movieRepository.saveAll(movies);
   }
   
}
