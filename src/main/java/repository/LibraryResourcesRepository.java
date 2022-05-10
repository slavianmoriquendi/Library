package repository;

import domain.LibraryResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryResourcesRepository extends JpaRepository<LibraryResource,Long> {
}
