package lk.easycar.rent.repo;

import lk.easycar.rent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car,String> {

    @Query(value = "SELECT carID FROM Car ORDER BY carID DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
