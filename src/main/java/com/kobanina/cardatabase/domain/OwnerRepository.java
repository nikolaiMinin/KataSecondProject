package com.kobanina.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface OwnerRepository extends CrudRepository<Owner, Long> {
//    @Query("select c from Owner c where c.firstname = ?1")
    Optional<Owner> findByFirstname(String firstName);
}

//public class OwnerRepository {
//}
