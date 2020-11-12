package task8.springbootdemo.controllers;

import org.springframework.web.util.CookieGenerator;
import task8.springbootdemo.entities.Brands;
import task8.springbootdemo.entities.Countries;
import task8.springbootdemo.entities.MyShop;
import task8.springbootdemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CookieGenerator generator;
    @Autowired
    private MyShop shopItem;

    @Autowired
    private Countries countries;

    @GetMapping(value = "/")
    public String index(Model model, HttpServletRequest request){
        List<MyShop> items = itemService.getAllItems();
        model.addAttribute("items", items);

        List<Brands> brands = itemService.getAllBrands();
        model.addAttribute("brands", brands);
        return "index";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model){

        return "redirect:/additem";
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model,
                          @PathVariable(name = "id") Long id){
        MyShop it = itemService.getItem(id);
        model.addAttribute("it", it);

        List<Brands> brands = itemService.getAllBrands();
        model.addAttribute("brands", brands);
        return "details";
    }

    @GetMapping(value = "/additem")
    public String additem(Model model){
        List<Brands> brands = itemService.getAllBrands();
        model.addAttribute("brands", brands);
        return "additem";
    }

    @PostMapping(value = "/additem")
    public String addItem(Model model,
                            @RequestParam( name = "name") String name,
                            @RequestParam( name = "description") String description,
                            @RequestParam( name = "price") int price,
                            @RequestParam( name = "brand") Long brand_id,
                            @RequestParam( name = "amount") int amount,
                            @RequestParam( name = "stars") int stars,
                            @RequestParam( name = "picUrlsm") String picUrlsm,
                            @RequestParam( name = "picUrllge") String picUrllge,
                            @RequestParam( name = "top") Boolean top
    ){
        Date date = new Date(System.currentTimeMillis());
        Brands brand = itemService.getBrand(brand_id);
        shopItem.setName(name);
        shopItem.setDescription(description);
        shopItem.setPrice(price);
        shopItem.setAmount(amount);
        shopItem.setSmallpictureUrl(picUrlsm);
        shopItem.setLargepictureUrl(picUrllge);
        shopItem.setStars(stars);
        shopItem.setDate(date);
        shopItem.setIstop(top);
        shopItem.setBrand(brand);
        MyShop item = shopItem;
        itemService.addNewItem(item);
        shopItem.setId(shopItem.getId()+1);
        List<MyShop> items = itemService.getAllItems();
        model.addAttribute("items", items);

        return "redirect:/";
    }

    @GetMapping(value = "/search/{id}")
    public String search(Model model,
                         @PathVariable(name = "id") Long brand_id){
        Brands brand = itemService.getBrand(brand_id);
        List<MyShop> items = null;
        String name = "";
        int price_to = 1000000000;
        int price_from = 0;
        String order = "";
        model.addAttribute("name", name);
        model.addAttribute("price_to", price_to);
        model.addAttribute("price_from", price_from);
        model.addAttribute("order", order);
        model.addAttribute("brand_id", brand_id);

        items = itemService.getSearchItemsFromToByName(name, brand, price_from, price_to);
        model.addAttribute("items", items);

        List<Brands> brands = itemService.getAllBrands();
        model.addAttribute("brands", brands);


        return "search";
    }

    @PostMapping(value = "/search")
    public String search(Model model,
                          @RequestParam( name = "name", defaultValue = "") String name,
                          @RequestParam( name = "price_from", defaultValue = "0") int price_from,
                          @RequestParam( name = "price_to", defaultValue = "1000000000") int price_to,
                          @RequestParam( name = "order", defaultValue = "") String order,
                          @RequestParam( name = "brand_id", defaultValue = "1") Long brand_id

    ){
        Brands brand = itemService.getBrand(brand_id);
        List<MyShop> items = null;
        if(order.equals("asc")){
            items = itemService.getSearchItemsFromToByNameOrderByAsc(name, brand, price_from, price_to);
        }
        else if(order.equals("desc")){
            items = itemService.getSearchItemsFromToByNameOrderByDesc(name, brand, price_from, price_to);
        }
        else{
            items = itemService.getSearchItemsFromToByName(name, brand, price_from, price_to);
        }

        model.addAttribute("name", name);
        model.addAttribute("price_to", price_to);
        model.addAttribute("price_from", price_from);
        model.addAttribute("order", order);
        model.addAttribute("items", items);
        model.addAttribute("brand_id", brand_id);


        List<Brands> brands = itemService.getAllBrands();
        model.addAttribute("brands", brands);

        return "search";
    }
}
