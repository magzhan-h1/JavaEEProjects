package task8.springbootdemo.service.impl;

import org.springframework.stereotype.Service;
import task8.springbootdemo.entities.Brands;
import task8.springbootdemo.entities.Countries;
import task8.springbootdemo.entities.MyShop;
import task8.springbootdemo.repositories.BrandsRepository;
import task8.springbootdemo.repositories.CountriesRepository;
import task8.springbootdemo.repositories.MyRepository;
import task8.springbootdemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private MyRepository repository;

    @Autowired
    private CountriesRepository countriesRepository;

    @Autowired
    private BrandsRepository brandsRepository;
    @Override
    public void addNewItem(MyShop item) {
        repository.save(item);
    }

    @Override
    public List<MyShop> getAllItems() {
        return repository.findAll();
    }

    @Override
    public List<MyShop> onlyTop() {
        return null;
    }

    @Override
    public MyShop getItem(Long id) {
        return repository.findByIdEquals(id);
    }

    @Override
    public void EditItem(MyShop item) {
            repository.save(item);
    }

    @Override
    public void deleteItem(MyShop item) {

    }
    @Override
    public List<MyShop> getSearchItems(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public List<MyShop> getSearchItemsFromToByName(String name, Brands brand, int price_from, int price_to) {
        return repository.findByNameContainingAndBrandEqualsAndPriceBetween(name, brand,price_from, price_to);
    }

    @Override
    public List<MyShop> getSearchItemsFromToByNameOrderByAsc(String name, Brands brand, int price_from, int price_to) {
        return repository.findByNameContainingAndBrandEqualsAndPriceBetweenOrderByPriceAsc(name, brand, price_from, price_to);
    }

    @Override
    public List<MyShop> getSearchItemsFromToByNameOrderByDesc(String name, Brands brand, int price_from, int price_to) {
        return repository.findByNameContainingAndBrandEqualsAndPriceBetweenOrderByPriceDesc(name, brand, price_from, price_to);
    }

    @Override
    public MyShop getExample1(Brands brands) {
        return repository.findByBrandEquals(brands);
    }


    @Override
    public List<Countries> getAllCountries() {
        return countriesRepository.findAll();
    }

    @Override
    public Countries getCountry(Long id) {
        return countriesRepository.getOne(id);
    }

    @Override
    public void EditCountry(Countries countries) {

    }

    @Override
    public void deleteCountry(Countries countries) {

    }

    @Override
    public void addNewCountry(Countries countries) {
        countriesRepository.save(countries);
    }

    @Override
    public Brands getBrandbyName(String name) {
        return brandsRepository.findByNameEquals(name);
    }


    @Override
    public List<Brands> getAllBrands() {
        return brandsRepository.findAll();
    }

    @Override
    public Brands getBrand(Long id) {
        return brandsRepository.getOne(id);
    }

    @Override
    public void EditBrand(Brands brands) {

    }

    @Override
    public void deleteBrand(Brands brands) {

    }

    @Override
    public void addNewBrand(Brands brands) {
        brandsRepository.save(brands);
    }

}
