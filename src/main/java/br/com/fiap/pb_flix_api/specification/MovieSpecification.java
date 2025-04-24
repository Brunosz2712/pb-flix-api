package br.com.fiap.pb_flix_api.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.pb_flix_api.controller.MovieController.MovieFilter;
import br.com.fiap.pb_flix_api.model.Movie;
import jakarta.persistence.criteria.Predicate;

public class MovieSpecification {
    public static Specification<Movie> withFilters(MovieFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.description() != null && !filter.description().isBlank()) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("description")), "%" + filter.description().toLowerCase() + "%"));
            }

            if (filter.realiseDate() != null && filter.realiseDate() != null) {
                predicates.add(
                        cb.between(root.get("date"), filter.realiseDate(), filter.realiseDate()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
