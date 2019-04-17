package njuics.demos.petsalon.web;
import com.fasterxml.jackson.annotation.JsonBackReference;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.repository.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resource;
//import njuics.demos.petsalon.service.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class ServiceController {
    @Autowired
    private final ServiceRepository repository;
//    private final ServiceResourceAssembler assembler;
/*    ServiceController(ServiceRepository repository,
                      ServiceResourceAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }*/
    ServiceController(ServiceRepository repository){
      this.repository = repository;
    }

    //@JsonBackReference
    @GetMapping("/services")
 /*   public Resources<Resource<Service>> all(){
      List<Resource<Service>> services = repository.findAll().stream()
        .map(assembler::toResource)
        .collect(Collectors.toList());
      return new Resources<>(services,
        linkTo(methodOn(ServiceController.class).all()).withSelfRel());
    }*/
    public @ResponseBody Iterable<Service> all(){
        return repository.findAll();
    }

    @PostMapping(value = "/services")
/*    public ResponseEntity<?> newService(@RequestBody Service newService) throws URISyntaxException {
      Resource<Service> resource = assembler.toResource(repository.save(newService));
      return ResponseEntity
        .created(new URI(resource.getId().expand().getHref()))
        .body(resource);
    }*/
    public Service newService(@RequestBody Service newService){
        return repository.save(newService);
    }

    //@JsonBackReference
    @GetMapping("/services/{id}")
/*    public Resource<Service> one(@PathVariable Integer id) {
      Service service = repository.findById(id)
        .orElseThrow(() -> new RuntimeException());
      return assembler.toResource(service);
    }*/
    public Service one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping(value = "/services/{id}")
/*    public ResponseEntity<?> replaceService(@RequestBody Service newService, @PathVariable Integer id) throws URISyntaxException {

      Service updatedService = repository.findById(id)
        .map(Service -> {
          Service.setFee(newService.getFee());
          Service.setServiceCategory(newService.getServiceCategory());
          Service.setDate(newService.getDate());
          return repository.save(Service);
        })
        .orElseGet(() -> {
          newService.setId(id);
          return repository.save(newService);
        });

      Resource<Service> resource = assembler.toResource(updatedService);

      return ResponseEntity
        .created(new URI(resource.getId().expand().getHref()))
        .body(resource);
    }*/
    public Service replaceService(@RequestBody Service newService, @PathVariable Integer id){
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
 /*   public ResponseEntity<?> deleteService(@PathVariable Integer id) {
      repository.deleteById(id);
      return ResponseEntity.noContent().build();
    }*/
    void deleteService(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
