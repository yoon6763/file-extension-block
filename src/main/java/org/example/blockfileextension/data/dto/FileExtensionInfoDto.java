package org.example.blockfileextension.data.dto;

import lombok.Data;
import org.example.blockfileextension.data.FileExtension;

@Data
public class FileExtensionInfoDto {

    private String extension;

    public FileExtensionInfoDto(String extension) {
        this.extension = extension;
    }

    public static FileExtensionInfoDto from(FileExtension fileExtension) {
        return new FileExtensionInfoDto(fileExtension.getExtension());
    }
}
