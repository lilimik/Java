package ru.itis.springbootsemester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsemester.models.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByAndStorageName(String fileName);
}
