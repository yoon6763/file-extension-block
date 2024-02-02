package org.example.blockfileextension.repository;

import org.example.blockfileextension.data.FileExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileExtensionRepository extends JpaRepository<FileExtension, Long> {
    void deleteByExtension(String extension);

    @Query("SELECT COUNT(e) FROM FileExtension e")
    long countAll();

    boolean existsByExtension(String extension);

    @Query("SELECT e FROM FileExtension e WHERE e.isFixedExtension = false")
    List<FileExtension> findCustomExtensions();

    @Query("SELECT COUNT(e) FROM FileExtension e WHERE e.isFixedExtension = false")
    long countCustomExtensions();
}
