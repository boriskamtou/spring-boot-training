package com.boris.springbootgraphqldogapi.repository;

import com.boris.springbootgraphqldogapi.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
}
