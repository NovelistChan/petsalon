package njuics.demos.petsalon.service;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import njuics.demos.petsalon.web.*;
import njuics.demos.petsalon.model.*;
import njuics.demos.petsalon.web.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class OwnerResourceAssembler implements ResourceAssembler<Owner, Resource<Owner>>{
  @Override
  public Resource<Owner> toResource(Owner owner){
    return new Resource<>(owner,
      linkTo(methodOn(OwnerController.class).one(owner.getId())).withSelfRel(),
      linkTo(methodOn(OwnerController.class).all()).withRel("owners"));
  }
}
