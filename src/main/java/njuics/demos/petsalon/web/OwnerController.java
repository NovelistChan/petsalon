package njuics.demos.petsalon.web;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.repository.*;

import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
public class OwnerController {
    private final OwnerRepository repository;
    OwnerController(OwnerRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/allowners", method = RequestMethod.GET)
    List<Owner> all(){
        return repository.findAll();
    }

    @RequestMapping(value = "/newowner", method = RequestMethod.POST)
    Owner newOwner(@RequestBody Owner newOwner){
        return repository.save(newOwner);
    }

    @RequestMapping(value = "/fdowners/{name}", method = RequestMethod.GET)
    Owner one(@PathVariable String name){
        return repository.findByName(name);
    }

    @RequestMapping(value = "/dlowners/{name}", method = RequestMethod.DELETE)
    void deleteOwner(@PathVariable String name){
        repository.deleteByName(name);
    }
}
