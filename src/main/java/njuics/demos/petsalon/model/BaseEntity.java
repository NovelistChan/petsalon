package njuics.demos.petsalon.model;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.web.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public boolean isNew() {
//        return this.id == null;
//    }
}
