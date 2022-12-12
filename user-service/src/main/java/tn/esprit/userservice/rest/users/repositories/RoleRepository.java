package tn.esprit.userservice.rest.users.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import tn.esprit.userservice.rest.users.entities.*;

import java.util.*;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByRole(String role);

    @Query(value = "select count(*) from users_roles where role_id = ?1", nativeQuery = true)
    Long countRoleUsage(Long roleId);

}
