package pl.coderslab.charity.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range(min = 1)
    private Integer quantity;

    @ManyToMany
    @JoinColumn(name = "category_id")
    @NotNull
    @ToString.Exclude
    private List<Category> categories = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @NotNull
    @Column(length = 60)
    private String street;

    @NotNull
    @Column(length = 60)
    private String city;

    @NotNull
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    @Column(length = 6)
    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Donation donation = (Donation) o;
        return id != null && Objects.equals(id, donation.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
