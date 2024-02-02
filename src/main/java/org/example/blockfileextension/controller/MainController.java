package org.example.blockfileextension.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.blockfileextension.service.FileExtensionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final FileExtensionService fileExtensionService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("extensions", fileExtensionService.getAllExtensions());
        model.addAttribute("count", fileExtensionService.countAllExtensions());
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
}
