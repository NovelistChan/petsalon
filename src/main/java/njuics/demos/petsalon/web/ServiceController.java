package njuics.demos.petsalon.web;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.repository.*;

import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
public class ServiceController {
    private final ServiceRepository repository;
    ServiceController(ServiceRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/allservices", method = RequestMethod.GET)
    List<Service> all(){
        return repository.findAll();
    }

    @RequestMapping(value = "/newservice", method = RequestMethod.POST)
    Service newService(@RequestBody Service newService){
        return repository.save(newService);
    }

    @RequestMapping(value = "/fdservices/{name}", method = RequestMethod.GET)
    Service one(@PathVariable ServiceCategory serviceCategory){
        return repository.findByCategory(serviceCategory);
    }

    @RequestMapping(value = "/dlservices/{name}", method = RequestMethod.DELETE)
    void deleteService(@PathVariable ServiceCategory serviceCategory){
        repository.deleteByCategory(serviceCategory);
    }
}
