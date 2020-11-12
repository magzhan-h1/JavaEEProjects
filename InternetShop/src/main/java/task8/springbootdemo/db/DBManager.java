package task8.springbootdemo.db;

import java.util.ArrayList;
import java.sql.Date;


public class DBManager {
    private static Long id = 5L;
    private static ArrayList<ShopItem> items = new ArrayList<ShopItem>();
    public static Date defaultDate = new Date(100, 9, 10);

    static {
        items.add(new ShopItem(1L, "IPhone 12 Pro Max", "IPhone 12 Pro Max 512GB, 5G Network, Display 6.7, Frequency 6GHZ", 2499, 5, 5, "/images/iphone.jpg"));
        items.add(new ShopItem(2L, "IPhone 11 Pro Max 256GB Gold", "Display diagonal, inch 6.5 Display Resolution2688 ", 1500, 5, 3, "/images/image1.jpg"));
        items.add(new ShopItem(3L, "Samsung Galaxy A21s 32Gb Black", "Samsung Galaxy A21 32GB, 5G Network, Display 6", 800, 5, 4, "/images/image2.jpg"));
        items.add(new ShopItem(4L, "Nokia 106 Grey", "Nokia 106 Pureview SoC Qualcomm Snapdragon 845, GPU Adreno 630", 250, 5, 2, "/images/image3.jpg"));
    }

    public static ArrayList<ShopItem> getAllItem(){
        return items;
    }

    public static void addItem(ShopItem item) {
        item.setId(id);
        id++;
        items.add(item);
    }

    public static ShopItem getItem(Long id) {
        for(ShopItem it : items) {
            if (it.getId() == id) {
                return it;
            }
        }
        return null;
    }
}
