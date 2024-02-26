package peaksoft.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.models.Developer;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from developers d where d.id = ?1", nativeQuery = true)
    void deleteDevByID(Long id);


    @Query("""
            select case when count(d) > 0
            then true 
            else false end 
            from Developer d 
            where d.email ilike (:email)
            """)
   boolean existsByEmail(String email);



}