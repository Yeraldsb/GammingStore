package gammingStore.Controller;

import gammingStore.models.Game;
import gammingStore.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
public class GameController {
    private GameService gameService;
    private CategoryService categoryService;
    private PublisherService publisherService;
    private PlatformService platformService;
    private EtiquetaService etiquetaService;
    private PegiService pegiService;
    private PEGIcontentService pegIcontentService;


    @Autowired
    public GameController(GameService gameService, CategoryService categoryService, PublisherService publisherService,
                          PlatformService platformService, EtiquetaService etiquetaService, PegiService pegiService,
                          PEGIcontentService pegIcontentService) {
        this.gameService = gameService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
        this.platformService = platformService;
        this.etiquetaService = etiquetaService;
        this.pegiService = pegiService;
        this.pegIcontentService = pegIcontentService;
    }

    @GetMapping("/games/new")
    String newGame(Model model) {
        Game game = new Game();
        model.addAttribute("game", game);
        model.addAttribute("title", "Create new game");
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("publishers", publisherService.allPublishers());
        model.addAttribute("platforms", platformService.allPlatforms());
        model.addAttribute("etiquetas", etiquetaService.allEtiquetas());
        model.addAttribute("pegis", pegiService.allPegis());
        model.addAttribute("PEGIcontents", pegIcontentService.allPEGIcontents());
        return "games/edit";

    }
    @GetMapping("/games/edit/{id}")
    String editGame(Model model, @PathVariable Long id){
        Game game = gameService.findById(id);
        model.addAttribute("game", game);
        model.addAttribute("title", "Edit game");
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("publishers", publisherService.allPublishers());
        model.addAttribute("platforms", platformService.allPlatforms());
        model.addAttribute("etiquetas", etiquetaService.allEtiquetas());
        model.addAttribute("pegis", pegiService.allPegis());
        model.addAttribute("PEGIcontents", pegIcontentService.allPEGIcontents());
        return "games/edit";
    }
    @GetMapping("games/delete/{id}")
    public String remove(@PathVariable Long id) {
        gameService.delete(id);
        return "redirect:/home";
    }
    @PostMapping("/games/new")
    public String addGame(@ModelAttribute Game game, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        gameService.save(game);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        game.setPhoto(fileName);
        gameService.save(game);
        String uploadDir = "game-photo/" + game.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return "redirect:/home";
    }

    @GetMapping("/games/search")
    String searchGame(Model model, @RequestParam String word){
        model.addAttribute("title", "Games that contains " + word);
        model.addAttribute("games", gameService.searchByName(word) );

        return "home";

    }
}

