package lk.easycar.rent.repo;

import lk.easycar.rent.entity.Car;
import lk.easycar.rent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

    User findByUserName(String userName);

}
