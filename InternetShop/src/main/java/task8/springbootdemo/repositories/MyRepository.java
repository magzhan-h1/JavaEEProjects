package task8.springbootdemo.repositories;

import task8.springbootdemo.entities.Brands;
import task8.springbootdemo.entities.MyShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MyRepository extends JpaRepository<MyShop, Long> {

    MyShop findByIdEquals(Long id);
    List<MyShop> findByNameContaining(String name);

    List<MyShop> findByNameContainingAndBrandEqualsAndPriceBetweenOrderByPriceAsc(String name, Brands brand, int price_from, int price_to);
    List<MyShop> findByNameContainingAndBrandEqualsAndPriceBetweenOrderByPriceDesc(String name, Brands brand,int price_from, int price_to);

    List<MyShop> findByNameContainingAndBrandEqualsAndPriceBetween(String name, Brands brand, int price_from, int price_to);

    MyShop findByBrandEquals(Brands brands);
}
