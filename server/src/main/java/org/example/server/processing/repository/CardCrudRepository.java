package org.example.server.processing.repository;

import org.example.server.processing.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardCrudRepository extends CrudRepository<Card, Long> {
    Card findByPan(String str);
}
