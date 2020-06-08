package org.launchcode.chefs_table.models.data;

import org.launchcode.chefs_table.models.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface DishRepository extends CrudRepository <Dish, Integer>{
}
