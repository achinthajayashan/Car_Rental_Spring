package lk.easycar.rent.service;

import lk.easycar.rent.entity.User;

public interface UserService {

    User findByUserName(String userName);
}
