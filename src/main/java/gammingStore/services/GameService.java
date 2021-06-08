package gammingStore.services;

import gammingStore.models.Game;
import gammingStore.models.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public List<Game> allGames() {
        List<Game> allGames = (List<Game>) gameRepository.findAll();
        return allGames;
    }
    public void save(Game game) {
        gameRepository.save(game);
    }
    public Game findById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}
