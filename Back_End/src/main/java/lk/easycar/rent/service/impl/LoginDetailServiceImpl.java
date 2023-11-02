package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.LoginDetailDTO;
import lk.easycar.rent.entity.Driver;
import lk.easycar.rent.entity.LoginDetail;
import lk.easycar.rent.repo.CustomerRepo;
import lk.easycar.rent.repo.LoginDetailRepo;
import lk.easycar.rent.service.LoginDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class LoginDetailServiceImpl implements LoginDetailService {

    @Autowired
    private LoginDetailRepo loginDetailRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveLoginDetail(LoginDetailDTO loginDetailDTO) {
        LoginDetail map =mapper.map(loginDetailDTO, LoginDetail.class);

        loginDetailRepo.save(map);
    }
}
