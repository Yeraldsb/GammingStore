package gammingStore.Controller;

import gammingStore.models.Game;
import gammingStore.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameController {
    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    String listGames (Model model) {
        List<Game> games = gameService.allGames();
        model.addAttribute("title", "Game list");
        model.addAttribute("games", games);
        return "games/all";
    }
}
