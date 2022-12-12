package tn.esprit.userservice.rest.users.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import tn.esprit.userservice.rest.users.entities.*;

import java.util.*;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {

    Optional<Permission> findByPermission(String permission);

    @Query(value = "select count(*) from permissions_roles where permission_id = ?1", nativeQuery = true)
    Long countPermissionUsage(Long permissionId);

    void deleteByPermission(String permission);

}
