package gammingStore.services;

import gammingStore.models.Category;
import gammingStore.models.CategoryRepository;
import gammingStore.models.Publisher;
import gammingStore.models.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;


    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> allCategories() {
        return (List<Publisher>) publisherRepository.findAll();
    }
}
