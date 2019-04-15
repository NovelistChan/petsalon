package njuics.demos.petsalon.model;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.web.*;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;

    public PetType getType() {
        return this.type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
