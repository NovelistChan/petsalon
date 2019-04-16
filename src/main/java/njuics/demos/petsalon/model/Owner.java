package njuics.demos.petsalon.model;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.web.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "owners")
public class Owner extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String name;

  //  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public void setPets(Set<Pet> pets) { this.pets = pets; }

    public Set<Pet> getPets() { return this.pets; }

    public void addPet(Pet p) { pets.add(p); }
}
