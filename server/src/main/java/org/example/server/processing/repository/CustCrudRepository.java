package org.example.server.processing.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.server.processing.entity.Cust;

@Repository
public interface CustCrudRepository extends CrudRepository<Cust, Long> {
}
