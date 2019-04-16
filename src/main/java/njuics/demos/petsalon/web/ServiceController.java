package njuics.demos.petsalon.web;
import com.fasterxml.jackson.annotation.JsonBackReference;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.repository.*;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ServiceController {
    @Autowired
    private final ServiceRepository repository;
    ServiceController(ServiceRepository repository){
        this.repository = repository;
    }

    @JsonBackReference
    @GetMapping("/services")
    public @ResponseBody Iterable<Service> all(){
        return repository.findAll();
    }

    @PostMapping("/services")
    Service newService(@RequestBody Service newService){
        return repository.save(newService);
    }

    @JsonBackReference
    @GetMapping("/services/{id}")
    Service one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/services/{id}")
    Service replaceService(@RequestBody Service newService, @PathVariable Integer id){
        return repository.findById(id)
                .map(Service -> {
                    Service.setDate(newService.getDate());
                    Service.setFee(newService.getFee());
                    Service.setServiceCategory(newService.getServiceCategory());
                    return repository.save(Service);
                })
                .orElseGet(() -> {
                    newService.setId(id);
                    return repository.save(newService);
                });
    }

    @DeleteMapping("/services/{id}")
    void deleteService(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
