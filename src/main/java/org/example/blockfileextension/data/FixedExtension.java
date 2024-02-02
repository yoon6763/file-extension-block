package org.example.blockfileextension.data;

import lombok.Getter;

import java.util.List;

@Getter
public enum FixedExtension {

    BAT("bat"),
    CMD("cmd"),
    COM("com"),
    CPL("cpl"),
    EXE("exe"),
    SCR("scr"),
    JS("js");

    final String extension;

    FixedExtension(String extension) {
        this.extension = extension;
    }

    static public List<FixedExtension> getAllFixedExtensions() {
        return List.of(BAT, CMD, COM, CPL, EXE, SCR, JS);
    }

}
