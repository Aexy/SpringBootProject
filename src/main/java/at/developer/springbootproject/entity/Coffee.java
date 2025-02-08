package at.developer.springbootproject.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "coffee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;
    private String productName;

    private int arabica; // Percentage of Arabica in the blend (0-100)

    private double rating; // 0.0 to 10.0 with one decimal place

    private LocalDate datePurchased;

    @OneToMany(mappedBy = "coffee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OriginCountry> origins;
}