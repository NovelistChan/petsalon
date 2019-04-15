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

    @GetMapping("/owners")
    List<Owner> all() {
        return repository.findAll();
    }

    @PostMapping("/owners")
    Owner newOwner(@RequestBody Owner newOwner){
        return repository.save(newOwner);
    }

    @GetMapping("/owners/{id}")
    Owner one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/owners/{id}")
    Owner replaceOwner(@RequestBody Owner newOwner, @PathVariable Integer id){
        return repository.findById(id)
                .map(owner -> {
                    owner.setName(newOwner.getName());
                    owner.setAddress(newOwner.getAddress());
                    return repository.save(owner);
                })
                .orElseGet(() -> {
                    newOwner.setId(id);
                    return repository.save(newOwner);
                });
    }

    @DeleteMapping("/owners/{id}")
    void deleteOwner(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
