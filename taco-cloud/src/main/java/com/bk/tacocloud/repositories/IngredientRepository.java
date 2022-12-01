package com.bk.tacocloud.data;

import com.bk.tacocloud.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
