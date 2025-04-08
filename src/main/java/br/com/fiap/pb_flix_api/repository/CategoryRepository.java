package br.com.fiap.pb_flix_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.pb_flix_api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
