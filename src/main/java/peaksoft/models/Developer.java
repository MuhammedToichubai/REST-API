package peaksoft.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "developers")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_gen")
    @SequenceGenerator(name = "dev_gen", sequenceName = "dev_seq", allocationSize = 1, initialValue = 10)
    private Long id;
    private String fullName;
    private String email;
    private String programmingLanguage;
    private BigDecimal salary;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @PrePersist
    private void prePersist(){
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt = ZonedDateTime.now();
    }

    public Developer(String fullName, String email, String programmingLanguage, BigDecimal salary) {
        this.fullName = fullName;
        this.email = email;
        this.programmingLanguage = programmingLanguage;
        this.salary = salary;
    }
}
