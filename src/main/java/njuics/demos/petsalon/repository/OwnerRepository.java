package njuics.demos.petsalon.repository;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.web.*;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.*;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
//    Owner findByName(@Param("name") String name);
//    Owner deleteByName(@Param("name") String name);
//    Owner save(Owner entity);
}
