package com.boris.springbootgraphqldogapi.resolver;

import com.boris.springbootgraphqldogapi.entity.Dog;
import com.boris.springbootgraphqldogapi.exception.DogNotFoundException;
import com.boris.springbootgraphqldogapi.repository.DogRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private final DogRepository repository;

    public Query(DogRepository repository) {
        this.repository = repository;
    }

    public Iterable<Dog> findAllDogs() {
        return  repository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = repository.findById(id);

        if(optionalDog.isPresent()) {
            return  optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog not found with this id", id);
        }

    }
}
