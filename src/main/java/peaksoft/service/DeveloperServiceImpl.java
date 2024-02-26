package peaksoft.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Developer;
import peaksoft.repository.DeveloperRepository;

import java.util.List;

/**
 * @author Mukhammed Asantegin
 */
@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService{
    private final DeveloperRepository developerRepo;

    @Override
    public List<Developer> findAll() {
        return developerRepo.findAll();
    }

    @Override
    public Developer save(Developer developer) {
        return developerRepo.save(developer);
    }

    @Override @Transactional
    public Developer update(Long id, Developer developer) {
        Developer foundDev = developerRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Developer with id: " + id + " not found!"));
        foundDev.setFullName(developer.getFullName());
        foundDev.setEmail(developer.getEmail());
        foundDev.setSalary(developer.getSalary());
        foundDev.setProgrammingLanguage(developer.getProgrammingLanguage());
        return foundDev;
    }

    @Override
    public String deleteById(Long id) {
        developerRepo.deleteDevByID(id);
         return "Success deleted";
    }

    @Override
    public boolean existByEmail(String email) {
        return developerRepo.existsByEmail(email);
    }
}
