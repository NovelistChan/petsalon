package njuics.demos.petsalon.web;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.repository.*;

import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
public class PetController {
    private final PetRepository repository;
    PetController(PetRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/allpets", method = RequestMethod.GET)
    List<Pet> all(){
        return repository.findAll();
    }

    @RequestMapping(value = "/newpet", method = RequestMethod.POST)
    Pet newPet(@RequestBody Pet newPet){
        return repository.save(newPet);
    }

    @RequestMapping(value = "/fdpets/{name}", method = RequestMethod.GET)
    Pet one(@PathVariable String name){
        return repository.findByName(name);
    }

    @RequestMapping(value = "/dlpets/{name}", method = RequestMethod.DELETE)
    void deletePet(@PathVariable String name){
        repository.deleteByName(name);
    }
}