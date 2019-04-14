package njuics.demos.petsalon.repository;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.web.*;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.*;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.name LIKE :name%")
    Owner findByName(@Param("name") String name);
    Owner deleteByName(@Param("name") String name);
    Owner save(Owner entity);
}
