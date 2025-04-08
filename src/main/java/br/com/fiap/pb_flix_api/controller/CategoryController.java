package br.com.fiap.pb_flix_api.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.pb_flix_api.model.Category;
import br.com.fiap.pb_flix_api.repository.CategoryRepository;

@RestController // component
@RequestMapping({"/categories"})
public class CategoryController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private CategoryRepository repository;

    public CategoryController(){}

    @GetMapping("/categories")
    public List<Category> index() { 
        log.info("Buscando todas as categorias");
        return this.repository.findAll();
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) {
        log.info("Cadastrando categoria " + category.getNameMovie());
        return (Category)this.repository.save(category);
    }

    @GetMapping({"/{id}"})
   public Category get(@PathVariable Long id) {
      this.log.info("Buscando categoria " + String.valueOf(id));
      return this.getCategory(id);
   }

   @DeleteMapping({"/{id}"})
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void destroy(@PathVariable Long id) {
      this.log.info("Apagando categoria " + String.valueOf(id));
      this.repository.delete(this.getCategory(id));
   }

   @PutMapping({"/{id}"})
   public Category update(@PathVariable Long id, @RequestBody Category category) {
      Logger var10000 = this.log;
      String var10001 = String.valueOf(id);
      var10000.info("Atualizando categoria " + var10001 + " " + String.valueOf(category));
      this.getCategory(id);
      category.setId(id);
      return (Category)this.repository.save(category);
   }

   private Category getCategory(Long id) {
    return (Category)this.repository.findById(id).orElseThrow(() -> {
       return new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada");
    });
 }
}
