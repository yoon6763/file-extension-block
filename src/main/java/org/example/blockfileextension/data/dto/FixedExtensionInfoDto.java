package org.example.blockfileextension.data.dto;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FixedExtensionInfoDto {
    private String extension;
    private boolean isSelected;

    public String getExtension() {
        return extension;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
