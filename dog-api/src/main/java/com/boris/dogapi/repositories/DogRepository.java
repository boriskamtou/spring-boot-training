package com.boris.dogapi.repositories;

import com.boris.dogapi.entities.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

}
