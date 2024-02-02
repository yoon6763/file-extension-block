package org.example.blockfileextension.repository;

import org.example.blockfileextension.data.FileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileExtensionRepository extends JpaRepository<FileExtension, Long> {
    void deleteByExtension(String extension);
}
