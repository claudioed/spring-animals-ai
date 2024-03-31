package dev.claudioed.spring.animals.ai;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WeaviateAnimalsRepository implements AnimalRepository{
    private final VectorStore vectorStore;
    public WeaviateAnimalsRepository(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }
    @Override
    public List<Animal> animals(String query) {
        this.vectorStore.similaritySearch(
                SearchRequest
                        .query(query)
                        .withTopK(5));
        return null;
    }

    @Override
    public void store(Animal animal) {
        this.vectorStore.add(List.of(new Document(animal.name(), Map.of("name", animal.name(), "description", animal.description()))));
    }

    @Override
    public Animal get(String id) {
        return null;
    }
}
