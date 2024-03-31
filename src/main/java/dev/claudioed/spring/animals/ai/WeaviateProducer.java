package dev.claudioed.spring.animals.ai;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.WeaviateVectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WeaviateProducer {

    @Bean
    public VectorStore vectorStore(EmbeddingClient embeddingClient) {
        WeaviateVectorStore.WeaviateVectorStoreConfig config = WeaviateVectorStore.WeaviateVectorStoreConfig.builder()
                .withScheme("http")
                .withHost("localhost:8080")
                .withFilterableMetadataFields(List.of(
                        WeaviateVectorStore.WeaviateVectorStoreConfig.MetadataField.text("name"),
                        WeaviateVectorStore.WeaviateVectorStoreConfig.MetadataField.text("description")
                ))
                // Consistency level can be: ONE, QUORUM, or ALL.
                .withConsistencyLevel(WeaviateVectorStore.WeaviateVectorStoreConfig.ConsistentLevel.ONE)
                .build();
        return new WeaviateVectorStore(config, embeddingClient);
    }

}
