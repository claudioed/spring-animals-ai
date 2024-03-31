package dev.claudioed.spring.animals.ai;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
  private final AnimalRepository animalRepository;
  public AnimalService(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }
  public List<Animal> animals(String query) {
    return animalRepository.animals(query);
  }
  public Animal get(String id) {
    return animalRepository.get(id);
  }

}