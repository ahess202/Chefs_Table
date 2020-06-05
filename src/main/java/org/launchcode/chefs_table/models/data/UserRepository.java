package org.launchcode.chefs_table.models.data;


import org.launchcode.chefs_table.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
