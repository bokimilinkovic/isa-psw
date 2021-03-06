package team47pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import team47pack.models.MedFileEntry;

import java.util.List;

// @author: Lupus7 (Sinisa Canak)
public interface MedEntryRepo extends JpaRepository<MedFileEntry, Long>, JpaSpecificationExecutor<MedFileEntry> {
    List<MedFileEntry> findAll();
}
