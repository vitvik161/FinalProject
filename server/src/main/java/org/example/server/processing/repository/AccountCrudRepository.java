package org.example.server.processing.repository;

import org.example.server.processing.entity.Account;
import org.example.server.processing.entity.Cust;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountCrudRepository extends CrudRepository<Account, Long> {
}
