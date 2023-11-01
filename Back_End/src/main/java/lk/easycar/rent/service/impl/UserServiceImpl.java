package lk.easycar.rent.service.impl;

import lk.easycar.rent.entity.User;
import lk.easycar.rent.repo.UserRepo;
import lk.easycar.rent.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepoRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public User findByUserName(String userName) {
        return mapper.map(userRepoRepo.findByUserName(userName), User.class);
    }
}
