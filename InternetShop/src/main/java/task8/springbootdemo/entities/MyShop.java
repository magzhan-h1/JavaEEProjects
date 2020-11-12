package task8.springbootdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Component
@Table(name = "item")
public class MyShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 500)
    private String description ;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "stars")
    private int stars;

    @Column(name = "date")
    private Date date;

    @Column(name = "is_top")
    private Boolean istop;

    @Column(name = "smallpicture_url", length = 250)
    private String SmallpictureUrl;

    @Column(name = "largepicture_url", length = 500)
    private String LargepictureUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    private Brands brand;
}
