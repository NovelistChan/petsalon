package njuics.demos.petsalon.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import njuics.demos.petsalon.web.*;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.web.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
/*
@Component
public class ServiceResourceAssembler implements ResourceAssembler<Service, Resource<Service>>{
  @Override
  public Resource<Service> toResource(Service service){
    return new Resource<>(service,
      linkTo(methodOn(ServiceController.class).one(service.getId())).withSelfRel(),
      linkTo(methodOn(ServiceController.class).all()).withRel("services"));
  }
}
*/
