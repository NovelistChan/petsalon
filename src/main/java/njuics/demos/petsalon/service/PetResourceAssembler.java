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
public class PetResourceAssembler implements ResourceAssembler<Pet, Resource<Pet>>{
  @Override
  public Resource<Pet> toResource(Pet pet){
    return new Resource<>(pet,
      linkTo(methodOn(PetController.class).one(pet.getId())).withSelfRel(),
      linkTo(methodOn(PetController.class).all()).withRel("pets"));
  }
}
*/
