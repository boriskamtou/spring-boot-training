package com.boris.dogapi.services;

import com.boris.dogapi.entities.Dog;
import com.boris.dogapi.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public String retrieveDogBreed(Dog dog) {
        return null;
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        return null;
    }

    @Override
    public List<String> retrieveDogNames() {
        List<String> names = new ArrayList();
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        for (Dog dog : dogs) {
            names.add(dog.getName());
        }
        return names;
//       dogs.forEach( (dog) -> { dog.getName(); } );

    }
}
