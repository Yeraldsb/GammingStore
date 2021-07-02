package gammingStore.services;

import gammingStore.models.*;
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

    public List<Publisher> allPublishers() {
        return (List<Publisher>) publisherRepository.findAll();
    }

    public Publisher getPublisher(Long publisherId) {
        return publisherRepository.findById(publisherId).get();
    }
}
