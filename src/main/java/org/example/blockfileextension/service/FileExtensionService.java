package org.example.blockfileextension.service;

import lombok.RequiredArgsConstructor;
import org.example.blockfileextension.data.dto.FileExtensionCreateDto;
import org.example.blockfileextension.data.dto.FileExtensionInfoDto;
import org.example.blockfileextension.repository.FileExtensionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FileExtensionService {

    private final FileExtensionRepository fileExtensionRepository;

    @Transactional
    public void addExtension(String extension) {
        fileExtensionRepository.save(new FileExtensionCreateDto(extension).toEntity());
    }

    @Transactional
    public void removeExtension(String extension) {
        fileExtensionRepository.deleteByExtension(extension);
    }

    public long countAllExtensions() {
        return fileExtensionRepository.countAll();
    }

    public List<FileExtensionInfoDto> getAllExtensions() {
        return fileExtensionRepository.findAll().stream()
                .map(FileExtensionInfoDto::from)
                .collect(Collectors.toList());
    }

}
