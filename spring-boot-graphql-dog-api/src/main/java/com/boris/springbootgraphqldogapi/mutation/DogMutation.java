package com.boris.springbootgraphqldogapi.mutation;

import com.boris.springbootgraphqldogapi.entity.Dog;
import com.boris.springbootgraphqldogapi.exception.DogNotFoundException;
import com.boris.springbootgraphqldogapi.repository.DogRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DogMutation implements GraphQLMutationResolver {
    private final DogRepository repository;

    public DogMutation(DogRepository repository) {
        this.repository = repository;
    }

    public boolean deleteDogBreed(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = repository.findById(id);
        if(optionalDog.isPresent()) {
            Dog updatedDog = optionalDog.get();
            updatedDog.setName(newName);
            return updatedDog;
        } else {
            throw new DogNotFoundException("Dog not found with this id", id);
        }

    }
}
