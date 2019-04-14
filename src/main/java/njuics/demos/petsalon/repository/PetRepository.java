package njuics.demos.petsalon.repository;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.web.*;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    List<PetType> findPetTypes() throws DataAccessException;
    Pet findByName(@Param("name") String name);
    Pet deleteByName(@Param("name") String name);
    Pet save(Pet entity);
}
