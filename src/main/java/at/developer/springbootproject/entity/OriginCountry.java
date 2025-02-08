package at.developer.springbootproject.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "origin_country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OriginCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryName;

    @ManyToOne
    @JoinColumn(name = "coffee_id", nullable = false)
    private Coffee coffee;
}
