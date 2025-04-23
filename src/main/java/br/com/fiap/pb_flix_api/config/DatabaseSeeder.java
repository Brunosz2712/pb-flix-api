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
      // Primeiro salvamos as categorias
      var categories = List.of(
         Category.builder().name("Ação").gender("Masculino").icon("Movie").build(),
         Category.builder().name("Drama").gender("Neutro").icon("Movie").build(),
         Category.builder().name("Terror").gender("Masculino").icon("Movie").build(),
         Category.builder().name("Suspense").gender("Masculino").icon("Movie").build()
      );

      // Salvamos as categorias para obter seus IDs
      List<Category> savedCategories = categoryRepository.saveAll(categories);

      var titles = List.of(
         "O Império Contra-Ataca",
         "Matrix",
         "Interestelar",
         "Pulp Fiction",
         "Cidade de Deus",
         "O Senhor dos Anéis",
         "Jurassic Park",
         "Star Wars",
         "Indiana Jones",
         "Batman: O Cavaleiro das Trevas"
      );

      var descriptions = List.of(
         "Ação intensa com muitos efeitos especiais",
         "Comédia divertida para toda a família",
         "Terror psicológico que vai te assustar",
         "Suspense que prende até o final",
         "Drama emocionante baseado em fatos reais",
         "Ficção Científica com efeitos visuais impressionantes"
      );

      var movies = new ArrayList<Movie>();
      Random random = new Random();
      
      for (int i = 0; i < 50; i++) {
         // Escolhe uma categoria aleatória da lista de categorias salvas
         Category randomCategory = savedCategories.get(random.nextInt(savedCategories.size()));
         
         movies.add(Movie.builder()
               .name(titles.get(random.nextInt(titles.size())) + " " + (i + 1))  // Adiciona um nome para cada filme
               .description(descriptions.get(random.nextInt(descriptions.size())))
               .realiseDate(LocalDate.now().minusDays(random.nextInt(30)))
               .type(MovieType.EXPENSE)
               .category(randomCategory)  // Define a categoria do filme
               .build());
      }
      
      movieRepository.saveAll(movies);
   }
}