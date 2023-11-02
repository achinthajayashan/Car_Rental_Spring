package lk.easycar.rent.repo;

import lk.easycar.rent.entity.Driver;
import lk.easycar.rent.entity.LoginDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDetailRepo extends JpaRepository<LoginDetail,String> {
}
