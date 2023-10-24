package lk.easycar.rent.service.impl;

import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.entity.Customer;
import lk.easycar.rent.entity.User;
import lk.easycar.rent.repo.CustomerRepo;
import lk.easycar.rent.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {

        Customer customer =new Customer(dto.getCustomerID(), dto.getName(), dto.getAddress(), dto.getEmail(), dto.getContactNo(), dto.getLicenseNo(), "","",new User(dto.getUser().getUsername(),dto.getUser().getPassword(),"Customer"));

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();

            dto.getFrontImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFrontImage().getOriginalFilename()));
            dto.getBackImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getBackImage().getOriginalFilename()));

            customer.setFrontImage("uploads/" + dto.getFrontImage().getOriginalFilename());
            customer.setBackImage("uploads/" + dto.getBackImage().getOriginalFilename());


        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
//        Customer map = mapper.map(dto, Customer.class);
        System.out.println(customer);
        customerRepo.save(customer);
    }
}
