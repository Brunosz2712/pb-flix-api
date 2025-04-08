package br.com.fiap.pb_flix_api.config;

import br.com.fiap.pb_flix_api.model.Category;
import br.com.fiap.pb_flix_api.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {
   @Autowired
   private CategoryRepository categoryRepository;

   public DatabaseSeeder() {
   }

   @PostConstruct
   public void categorySeed() {
      this.categoryRepository.saveAll(List.of(Category.builder().name("Ação").icon("Movie").build(), Category.builder().name("Drama").icon("Movie").build(), Category.builder().name("Terror").icon("Movie"), Category.builder().name("Suspense").icon("Movie").build()));
   }
}
