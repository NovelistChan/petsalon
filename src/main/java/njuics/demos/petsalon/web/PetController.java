package njuics.demos.petsalon.web;
import com.fasterxml.jackson.annotation.JsonBackReference;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.repository.*;
//import org.springframework.hateoas.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
//import njuics.demos.petsalon.service.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/api")
public class PetController {
    @Autowired
    private final PetRepository repository;
  //  private final PetResourceAssembler assembler;
  /*  PetController(PetRepository repository,
                  PetResourceAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }*/
    PetController(PetRepository repository){
      this.repository = repository;
    }

    //@JsonBackReference
    @GetMapping("/pets")
/*    public Resources<Resource<Pet>> all(){
      List<Resource<Pet>> pets = repository.findAll().stream()
        .map(assembler::toResource)
        .collect(Collectors.toList());
      return new Resources<>(pets,
        linkTo(methodOn(PetController.class).all()).withSelfRel());
    }*/
    public @ResponseBody Iterable<Pet> all(){
        return repository.findAll();
    }

    @PostMapping(value = "/pets")
 /*   public ResponseEntity<?> newPet(@RequestBody Pet newPet) throws URISyntaxException {
      Resource<Pet> resource = assembler.toResource(repository.save(newPet));
      return ResponseEntity
        .created(new URI(resource.getId().expand().getHref()))
        .body(resource);
    }*/
    public Pet newPet(@RequestBody Pet newPet){
        return repository.save(newPet);
    }

    //@JsonBackReference
    @GetMapping("/pets/{id}")
 /*   public Resource<Pet> one(@PathVariable Integer id) {
      Pet pet = repository.findById(id)
        .orElseThrow(() -> new RuntimeException());
      return assembler.toResource(pet);
    }*/
    public Pet one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping(value = "/pets/{id}")
 /*   public ResponseEntity<?> replacePet(@RequestBody Pet newPet, @PathVariable Integer id) throws URISyntaxException {

      Pet updatedPet = repository.findById(id)
        .map(Pet -> {
          Pet.setName(newPet.getName());
          Pet.setType(newPet.getType());
          return repository.save(Pet);
        })
        .orElseGet(() -> {
          newPet.setId(id);
          return repository.save(newPet);
        });

      Resource<Pet> resource = assembler.toResource(updatedPet);

      return ResponseEntity
        .created(new URI(resource.getId().expand().getHref()))
        .body(resource);
    }*/
    public Pet replacePet(@RequestBody Pet newPet, @PathVariable Integer id){
        return repository.findById(id)
                .map(pet -> {
                    pet.setName(newPet.getName());
                    pet.setType(newPet.getType());
               //     pet.setOwner(newPet.getOwner());
                    return repository.save(pet);
                })
                .orElseGet(() -> {
                    newPet.setId(id);
                    return repository.save(newPet);
                });
    }

    @DeleteMapping("/pets/{id}")
 /*   public ResponseEntity<?> deletePet(@PathVariable Integer id) {
      repository.deleteById(id);
      return ResponseEntity.noContent().build();
    }*/
    public void deletePet(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
