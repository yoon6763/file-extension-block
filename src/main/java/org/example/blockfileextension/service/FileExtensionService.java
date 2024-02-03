package org.example.blockfileextension.service;

import lombok.RequiredArgsConstructor;
import org.example.blockfileextension.data.FixedExtension;
import org.example.blockfileextension.data.dto.FileExtensionCreateDto;
import org.example.blockfileextension.data.dto.FileExtensionInfoDto;
import org.example.blockfileextension.data.dto.FileFixedExtensionCreateDto;
import org.example.blockfileextension.data.dto.FixedExtensionInfoDto;
import org.example.blockfileextension.exception.ErrorCode;
import org.example.blockfileextension.exception.FileExtensionException;
import org.example.blockfileextension.repository.FileExtensionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FileExtensionService {

    private final FileExtensionRepository fileExtensionRepository;
    @Value("${extension.max-length}")
    private int MAX_CUSTOM_EXTENSIONS;

    @Transactional
    public void addExtension(String extension) {
        checkEmptyExtension(extension);
        checkDuplicateExtension(extension);
        checkMaxLength(extension);
        fileExtensionRepository.save(new FileExtensionCreateDto(extension).toEntity());
    }

    private void checkMaxLength(String extension) {
        if (extension.length() > MAX_CUSTOM_EXTENSIONS) {
            throw new FileExtensionException(ErrorCode.MAX_EXTENSION_LENGTH_EXCEEDED);
        }
    }

    private void checkEmptyExtension(String extension) {
        if (extension.isEmpty()) {
            throw new FileExtensionException(ErrorCode.EMPTY_EXTENSION);
        }
    }

    private void checkDuplicateExtension(String extension) {
        if (fileExtensionRepository.existsByExtension(extension)) {
            throw new FileExtensionException(ErrorCode.DUPLICATED_EXTENSION);
        }
    }

    @Transactional
    public void addFixedExtension(String extension) {
        fileExtensionRepository.save(new FileFixedExtensionCreateDto(extension).toEntity());
    }

    @Transactional
    public void removeExtension(String extension) {
        fileExtensionRepository.deleteByExtension(extension);
    }

    public long countCustomExtensions() {
        return fileExtensionRepository.countCustomExtensions();
    }

    public List<FileExtensionInfoDto> getCustomExtensions() {
        return fileExtensionRepository.findCustomExtensions().stream()
                .map(FileExtensionInfoDto::from)
                .collect(Collectors.toList());
    }

    public List<FixedExtensionInfoDto> getFixedExtensionsInfo() {
        List<FixedExtensionInfoDto> fixedExtensions = new ArrayList<>();

        for (FixedExtension fileExtension : FixedExtension.getAllFixedExtensions()) {
            fixedExtensions.add(new FixedExtensionInfoDto(
                    fileExtension.getExtension(),
                    fileExtensionRepository.existsByExtension(fileExtension.getExtension()
                    )));
        }

        return fixedExtensions;
    }

    @Transactional
    public void toggleFixedExtension(String fixedExtension) {
        if (fileExtensionRepository.existsByExtension(fixedExtension)) {
            fileExtensionRepository.deleteByExtension(fixedExtension);
        } else {
            fileExtensionRepository.save(new FileFixedExtensionCreateDto(fixedExtension).toEntity());
        }
    }
}
