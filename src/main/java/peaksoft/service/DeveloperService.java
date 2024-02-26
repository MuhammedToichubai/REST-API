package peaksoft.service;

import peaksoft.models.Developer;

import java.util.List;

/**
 * @author Mukhammed Asantegin
 */
public interface DeveloperService {
    List<Developer> findAll();

    Developer save(Developer developer);

    Developer update(Long id, Developer developer);

    String deleteById(Long id);

    boolean existByEmail(String email);
}
