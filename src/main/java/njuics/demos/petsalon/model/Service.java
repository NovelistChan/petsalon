package njuics.demos.petsalon.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.web.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;


@Entity
//@Table(name = "services")
public class Service extends BaseEntity {
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;

    @Column(name = "fee")
    private Double fee;

    @Column(name = "sv_category")
    private ServiceCategory serviceCategory;

    @JsonBackReference
    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name="pet", referencedColumnName = "id")
    private Pet pet;

/*
    public Service(Integer id, Double fee, ServiceCategory serviceCategory) {
      this.setServiceCategory(serviceCategory);
      this.setFee(fee);
      this.setId(id);
      this.date = new Date();
    }
*/
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getFee() {
        return this.fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) { this.serviceCategory = serviceCategory; }

    public ServiceCategory getServiceCategory() { return this.serviceCategory; }
}
