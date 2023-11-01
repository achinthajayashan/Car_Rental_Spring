package lk.easycar.rent.repo;

import lk.easycar.rent.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentalRepo extends JpaRepository<Rental,String> {

    @Query(value = "SELECT rentID FROM Rental ORDER BY rentID DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
