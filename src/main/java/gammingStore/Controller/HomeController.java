package gammingStore.Controller;

import gammingStore.models.*;
import gammingStore.services.*;
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
    private PublisherService publisherService;
    private PegiService pegiService;

    @Autowired
    public HomeController(GameService gameService, CategoryService categoryService, PlatformService platformService, PublisherService publisherService, PegiService pegiService) {
        this.gameService = gameService;
        this.categoryService = categoryService;
        this.platformService = platformService;
        this.publisherService = publisherService;
        this.pegiService = pegiService;
    }

    @GetMapping(path={"/", "/home", "/index"})
    public String home (Model model, @RequestParam(required = false) Long categoryId, Long platformId, Long publisherId, Long pegiId) {


        List<Game> games;
        if(categoryId == null ) {
            games = gameService.allGames();
            if(platformId == null){
                games = gameService.allGames();
                if(publisherId == null) {
                    games = gameService.allGames();
                    if(pegiId == null) {
                        games = gameService.allGames();
                    } else {
                        Pegi pegi = pegiService.getPegi(pegiId);
                        games = pegi.getGames();
                    }
                } else {
                    Publisher publisher = publisherService.getPublisher(publisherId);
                    games = publisher.getGames();
                }

            }  else{
                Platform platform = platformService.getPlatform(platformId);
                games = platform.getGames();
            }

        }

        else{
            Category category = categoryService.getCategory(categoryId);
            games = category.getGames();

        }
        model.addAttribute("title", "Game list");
        model.addAttribute("games", games);
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("platforms", platformService.allPlatforms());
        model.addAttribute("publishers", publisherService.allPublishers());
        model.addAttribute("pegis", pegiService.allPegis());
        return "home";
    }
}
