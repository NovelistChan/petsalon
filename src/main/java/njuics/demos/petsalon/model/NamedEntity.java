package njuics.demos.petsalon.model;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.web.*;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity extends BaseEntity {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
