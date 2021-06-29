package gammingStore.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PlatformRepository extends CrudRepository<Platform, Long> { }



