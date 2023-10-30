package lk.easycar.rent.service.impl;

//import com.sun.org.apache.xpath.internal.operations.Mult;
import lk.easycar.rent.dto.CustomDTO;
import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.dto.meta.CustomerMetaDTO;
import lk.easycar.rent.entity.Customer;
import lk.easycar.rent.entity.User;
import lk.easycar.rent.repo.CustomerRepo;
import lk.easycar.rent.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        Customer map = mapper.map(dto, Customer.class);
        map.setUser(new User(dto.getUser().getUserName(),dto.getUser().getPassword(),"customer"));
        MultipartFile img_front = dto.getFrontImage();
        MultipartFile img_back = dto.getBackImage();


        System.out.println(map);

        try {

            String projectPath = System.getProperty("user.dir");
            System.out.println("Project Location: " + projectPath);
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

//            if (!uploadsDir.exists()) {
//                if (uploadsDir.mkdirs()) {
//                    System.out.println("Directory created successfully: " + projectPath);
//                } else {
//                    System.err.println("Failed to create directory: " + projectPath);
//                }
//            } else {
//                System.out.println("Directory already exists: " + projectPath);
//            }


            dto.getFrontImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFrontImage().getOriginalFilename()));
            dto.getBackImage().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getBackImage().getOriginalFilename()));

            map.setFrontImage("uploads/" + dto.getFrontImage().getOriginalFilename());
            map.setBackImage("uploads/" + dto.getBackImage().getOriginalFilename());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(map);
        customerRepo.save(map);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public CustomDTO userIdGenerate() {
        return new CustomDTO(customerRepo.getLastIndex());
    }
}


