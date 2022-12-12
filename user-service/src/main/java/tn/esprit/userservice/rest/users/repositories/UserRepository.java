package tn.esprit.userservice.rest.users.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
import tn.esprit.userservice.rest.users.entities.*;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    User findByUsername(String username);

}
