package njuics.demos.petsalon.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    //@JsonManagedReference
    //@JsonIgnore
    @JsonBackReference
    //@JsonIgnoreProperties("pets")
    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name="owner", referencedColumnName = "id")
    //@JoinColumn
    private Owner owner;

    //@JsonManagedReference
    //@JsonIgnoreProperties("pet")
    //@JsonIgnore
    @OneToMany(targetEntity = Service.class, cascade = CascadeType.ALL)
    @JoinColumn(name="pet", referencedColumnName = "id")
    //@JoinColumn
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
