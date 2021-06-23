package gammingStore.Controller;

import gammingStore.models.Game;
import gammingStore.services.CategoryService;
import gammingStore.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GameController {
    private GameService gameService;
    private CategoryService categoryService;

    @Autowired
    public GameController(GameService gameService, CategoryService categoryService) {
        this.gameService = gameService;
        this.categoryService = categoryService;
    }

    @GetMapping("/games/new")
    String newGame(Model model) {
        Game game = new Game();
        model.addAttribute("game", game);
        model.addAttribute("title", "Create new game");
        model.addAttribute("categories", categoryService.allCategories());
        return "games/edit";

    }
    @GetMapping("/games/edit/{id}")
    String editGame(Model model, @PathVariable Long id){
        Game game = gameService.findById(id);
        model.addAttribute("game", game);
        model.addAttribute("title", "Edit game");
        model.addAttribute("categories", categoryService.allCategories());
        return "games/edit";
    }
    @GetMapping("games/delete/{id}")
    public String remove(@PathVariable Long id) {
        gameService.delete(id);
        return "redirect:/home";
    }
    @PostMapping("/games/new")
    public String addGame(@ModelAttribute Game game) {
        gameService.save(game);
        return "redirect:/home";
    }
}

