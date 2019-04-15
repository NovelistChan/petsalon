package njuics.demos.petsalon.repository;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.web.*;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ServiceRepository extends  JpaRepository<Service, Integer>{
//    List<ServiceCategory> findServiceCategories() throws DataAccessException;
//    Service findByCategory(@Param("Category") ServiceCategory category);
//    Service deleteByCategory(@Param("Category") ServiceCategory category);
//    Service save(Service entity);
}
