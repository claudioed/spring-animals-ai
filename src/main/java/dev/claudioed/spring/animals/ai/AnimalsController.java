package dev.claudioed.spring.animals.ai;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalsController {
  private final AnimalService animalService;
  public AnimalsController(AnimalService animalService) {
    this.animalService = animalService;
  }
  @GetMapping
  public List<Animal> animals(@RequestParam("query") String query) {
    return this.animalService.animals(query);
  }
  @GetMapping ("/{id}")
  public Animal get(@PathVariable("id") String id) {
    return this.animalService.get(id);
  }

}