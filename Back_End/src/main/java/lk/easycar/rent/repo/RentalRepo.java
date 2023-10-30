package lk.easycar.rent.repo;

import lk.easycar.rent.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental,String> {
}
