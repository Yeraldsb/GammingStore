package gammingStore.Controller;

import gammingStore.models.Category;
import gammingStore.models.Game;
import gammingStore.models.Platform;
import gammingStore.services.CategoryService;
import gammingStore.services.GameService;
import gammingStore.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private GameService gameService;
    private CategoryService categoryService;
    private PlatformService platformService;

    @Autowired
    public HomeController(GameService gameService, CategoryService categoryService, PlatformService platformService) {
        this.gameService = gameService;
        this.categoryService = categoryService;
        this.platformService = platformService;
    }

    @GetMapping(path={"/", "/home", "/index"})
    public String home (Model model, @RequestParam(required = false) Long categoryId, Long platformId) {
        List<Game> games;
        if (categoryId == null) {
            games = gameService.allGames();
        } else {
            Category category = categoryService.getCategory(categoryId);
            games = category.getGames();
        }


        model.addAttribute("title", "Game list");
        model.addAttribute("games", games);
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("platforms", platformService.allPlatforms());
        return "home";
    }
}
