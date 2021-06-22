package gammingStore.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface GameCategoryRepository {

    @Repository
    public interface GameRepository extends CrudRepository<GameCategory, Long> { }

}
