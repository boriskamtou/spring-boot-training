package com.boris.dogapi.services;

import com.boris.dogapi.entities.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DogService {
    public String retrieveDogBreed(Dog dog);
    public String retrieveDogBreedById(Long id);
    public List<String> retrieveDogNames();
}
