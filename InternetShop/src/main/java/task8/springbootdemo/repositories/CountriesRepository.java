package task8.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task8.springbootdemo.entities.Countries;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountriesRepository extends JpaRepository<Countries, Long> {

}
