package task8.springbootdemo.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
public class ShopItem {
    private Long id;
    private String name;
    private String description;
    private int price;
    private int amount;
    private int stars;
    private String pictureUrl;

}
