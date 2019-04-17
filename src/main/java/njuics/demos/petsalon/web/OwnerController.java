package njuics.demos.petsalon.web;
import com.fasterxml.jackson.annotation.JsonBackReference;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.repository.*;
import njuics.demos.petsalon.service.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.net.URISyntaxException;
import java.net.URI;
@RestController
@RequestMapping(path="/api")
public class OwnerController {
    @Autowired

    private final OwnerRepository repository;
    private final OwnerResourceAssembler assembler;
    OwnerController(OwnerRepository repository,
                    OwnerResourceAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    //@JsonBackReference
    @GetMapping("/owners")
    public Resources<Resource<Owner>> all(){
      /*List<Resource<Owner>> owners = repository.findAll().stream()
        .map(owner -> new Resource<>(owner,
          linkTo(methodOn(OwnerController.class).one(owner.getId())).withSelfRel(),
          linkTo(methodOn(OwnerController.class).all()).withRel("owners")))
        .collect(Collectors.toList());
      return new Resources<>(owners,
        linkTo(methodOn(OwnerController.class).all()).withSelfRel());*/
      List<Resource<Owner>> owners = repository.findAll().stream()
        .map(assembler::toResource)
        .collect(Collectors.toList());
      return new Resources<>(owners,
        linkTo(methodOn(OwnerController.class).all()).withSelfRel());
    }
  //public @ResponseBody Iterable<Owner> all() {
  //      return repository.findAll();
  //  }

    @PostMapping(value = "/owners")
  //  Owner newOwner(@RequestBody Owner newOwner){
  //      return repository.save(newOwner);
  //  }
    public ResponseEntity<?> newOwner(@RequestBody Owner newOwner) throws URISyntaxException {
      Resource<Owner> resource = assembler.toResource(repository.save(newOwner));
      return ResponseEntity
        .created(new URI(resource.getId().expand().getHref()))
        .body(resource);
    }

    //@JsonBackReference
    @GetMapping("/owners/{id}")
    public Resource<Owner> one(@PathVariable Integer id) {
      /*Owner owner = repository.findById(id)
      .orElseThrow(() -> new RuntimeException());
      return new Resource<>(owner,
        linkTo(methodOn(OwnerController.class).one(id)).withSelfRel(),
        linkTo(methodOn(OwnerController.class).all()).withRel("owners"));*/
      Owner owner = repository.findById(id)
        .orElseThrow(() -> new RuntimeException());
      return assembler.toResource(owner);
   }

    @PutMapping(value = "/owners/{id}")
 /*   Owner replaceOwner(@RequestBody Owner newOwner, @PathVariable Integer id){
        return repository.findById(id)
                .map(owner -> {
                    owner.setName(newOwner.getName());
                    owner.setPets(newOwner.getPets());
                    return repository.save(owner);
                })
                .orElseGet(() -> {
                    newOwner.setId(id);
                    return repository.save(newOwner);
                });
    }*/
    public ResponseEntity<?> replaceOwner(@RequestBody Owner newOwner, @PathVariable Integer id) throws URISyntaxException {

      Owner updatedOwner = repository.findById(id)
        .map(Owner -> {
          Owner.setName(newOwner.getName());
          return repository.save(Owner);
        })
        .orElseGet(() -> {
          newOwner.setId(id);
          return repository.save(newOwner);
        });

      Resource<Owner> resource = assembler.toResource(updatedOwner);

      return ResponseEntity
        .created(new URI(resource.getId().expand().getHref()))
        .body(resource);
    }

    @DeleteMapping("/owners/{id}")
  //  void deleteOwner(@PathVariable Integer id){
  //      repository.deleteById(id);
  //  }
    public ResponseEntity<?> deleteOwner(@PathVariable Integer id) {
      repository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
}
