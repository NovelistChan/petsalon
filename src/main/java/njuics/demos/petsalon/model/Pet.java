package njuics.demos.petsalon.model;
import lombok.Data;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.web.*;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Pet extends NamedEntity {

    @Column(name = "type")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Service> services;

 /*   public Pet(String name, PetType type, Integer id){
      this.setName(name);
      this.setType(type);
      this.setId(id);
    }
*/
    public PetType getType() {
        return this.type;
    }

    public void setType(PetType type) {
        this.type = type;
    }


}
