package org.example.blockfileextension.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@ControllerAdvice
public class FileExtensionExceptionHandler {

    @ExceptionHandler(FileExtensionException.class)
    public RedirectView handleException(FileExtensionException e, RedirectAttributes attributes) {
        attributes.addFlashAttribute("error", e.getMessage());
        return new RedirectView("/");
    }

}
