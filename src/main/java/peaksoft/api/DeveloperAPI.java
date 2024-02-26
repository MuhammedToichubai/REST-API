package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Developer;
import peaksoft.service.DeveloperService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dev")
public class DeveloperAPI {
    private final DeveloperService developerService;

    @GetMapping
    public List<Developer> findAll(){
        return developerService.findAll();
    }

    @PostMapping
    public Developer save(@RequestBody Developer developer){
       return developerService.save(developer);
    }

    @PutMapping("/{id}")
    public Developer update(@RequestBody Developer developer,@PathVariable Long id){
        return developerService.update(id, developer);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return developerService.deleteById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDev(@PathVariable Long id){
        return developerService.deleteById(id);
    }


    @GetMapping("/exists")
    public boolean existByEmail(@RequestParam String email){
        return developerService.existByEmail(email);
    }








}
