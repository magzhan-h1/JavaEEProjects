package task8.springbootdemo.service;

import task8.springbootdemo.entities.Brands;
import task8.springbootdemo.entities.Countries;
import task8.springbootdemo.entities.MyShop;

import java.util.List;

public interface ItemService {
    void addNewItem(MyShop item);
    List<MyShop> getAllItems();
    List<MyShop> onlyTop();
    MyShop getItem(Long id);
    void EditItem(MyShop item);
    void deleteItem(MyShop item);
    List<MyShop> getSearchItems(String name);
    List<MyShop> getSearchItemsFromToByName(String name, Brands brand, int price_from, int price_to);
    List<MyShop> getSearchItemsFromToByNameOrderByAsc(String name, Brands brand, int price_from, int price_to);
    List<MyShop> getSearchItemsFromToByNameOrderByDesc(String name, Brands brand, int price_from, int price_to);
    MyShop getExample1(Brands brands);


    List<Countries> getAllCountries();
    Countries getCountry(Long id);
    void EditCountry(Countries countries);
    void deleteCountry(Countries countries);
    void addNewCountry(Countries countries);
    Brands getBrandbyName(String name);


    List<Brands> getAllBrands();
    Brands getBrand(Long id);
    void EditBrand(Brands brands);
    void deleteBrand(Brands brands);
    void addNewBrand(Brands brands);
}
