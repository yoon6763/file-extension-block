package org.example.blockfileextension.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.blockfileextension.data.FileExtension;

@Data
@AllArgsConstructor
public class FileExtensionCreateDto {

    private String extension;

    public FileExtension toEntity() {
        return FileExtension.builder()
                .extension(extension)
                .build();
    }
}
