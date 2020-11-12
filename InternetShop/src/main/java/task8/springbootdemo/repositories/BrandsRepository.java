package task8.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task8.springbootdemo.entities.Brands;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BrandsRepository extends JpaRepository<Brands, Long> {
    Brands findByNameEquals(String name);
}
