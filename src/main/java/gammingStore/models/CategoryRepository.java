package gammingStore.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryRepository {

    @Repository
    public interface Category extends CrudRepository<Category, Long> { }

}
