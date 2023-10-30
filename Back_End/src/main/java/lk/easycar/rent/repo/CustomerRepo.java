package lk.easycar.rent.repo;

import lk.easycar.rent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "SELECT customerID FROM Customer ORDER BY customerID DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
