package org.example.blockfileextension.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.blockfileextension.service.FileExtensionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final FileExtensionService fileExtensionService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("extensions", fileExtensionService.getCustomExtensions());
        model.addAttribute("count", fileExtensionService.countCustomExtensions());
        model.addAttribute("fixedExtensions", fileExtensionService.getFixedExtensionsInfo());
        model.addAttribute("fixedExtensionsInfo", fileExtensionService.getFixedExtensionsInfo());
        return "index";
    }

    @PostMapping("/custom/add")
    public String addCustomExtension(@RequestParam("customExtension") String customExtension) {
        fileExtensionService.addExtension(customExtension);
        return "redirect:/";
    }

    @GetMapping("/custom/remove")
    public String removeExtension(@RequestParam("extension") String extension) {
        fileExtensionService.removeExtension(extension);
        return "redirect:/";
    }

    @PostMapping("/fixed/add")
    public String addFixedExtension(@RequestParam("fixedExtension") String fixedExtension) {
        fileExtensionService.addFixedExtension(fixedExtension);
        return "redirect:/";
    }

    @PostMapping("/fixed/remove")
    public String removeFixedExtension(@RequestParam("fixedExtension") String fixedExtension) {
        fileExtensionService.removeExtension(fixedExtension);
        return "redirect:/";
    }

    @GetMapping("/fixed/toggle")
    public String toggleFixedExtension(@RequestParam("extension") String extension) {
        fileExtensionService.toggleFixedExtension(extension);
        return "redirect:/";
    }
}
