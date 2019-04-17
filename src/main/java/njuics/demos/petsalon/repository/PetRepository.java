package njuics.demos.petsalon.repository;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.web.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import java.util.Collection;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
//    List<PetType> findPetTypes() throws DataAccessException;
//    Pet findByName(@Param("name") String name);
//    Pet deleteByName(@Param("name") String name);
//    Pet save(Pet entity);
}
