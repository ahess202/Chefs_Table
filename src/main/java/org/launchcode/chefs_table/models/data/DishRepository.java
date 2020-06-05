package org.launchcode.chefs_table.models.data;

import org.launchcode.chefs_table.models.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DishRepository extends CrudRepository <Dish, Integer>{
}
