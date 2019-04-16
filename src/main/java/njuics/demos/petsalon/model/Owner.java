package njuics.demos.petsalon.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.web.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

@Data
@Entity
public class Owner extends NamedEntity{
    //@JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets;

/*    public Owner(String name, Integer id){
      this.setName(name);
      this.setId(id);
    }
*/
    public void setPets(Set<Pet> pets) { this.pets = pets; }

    public Set<Pet> getPets() { return this.pets; }

    public void addPet(Pet p) { pets.add(p); }
}
