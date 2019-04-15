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

    @GetMapping("/pets")
    List<Pet> all(){
        return repository.findAll();
    }

    @PostMapping("/pets")
    Pet newPet(@RequestBody Pet newPet){
        return repository.save(newPet);
    }

    @GetMapping("/pets/{id}")
    Pet one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/pets/{id}")
    Pet replacePet(@RequestBody Pet newPet, @PathVariable Integer id){
        return repository.findById(id)
                .map(pet -> {
                    pet.setName(newPet.getName());
                    pet.setBirthDate(newPet.getBirthDate());
                    pet.setType(newPet.getType());
                    return repository.save(pet);
                })
                .orElseGet(() -> {
                    newPet.setId(id);
                    return repository.save(newPet);
                });
    }

    @DeleteMapping("/pets/{id}")
    void deletePet(@PathVariable Integer id){
        repository.deleteById(id);
    }
}