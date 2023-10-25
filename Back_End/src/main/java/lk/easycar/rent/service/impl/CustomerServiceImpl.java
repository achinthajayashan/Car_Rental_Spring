package lk.easycar.rent.service.impl;

//import com.sun.org.apache.xpath.internal.operations.Mult;
import lk.easycar.rent.dto.CustomerDTO;
import lk.easycar.rent.entity.Customer;
import lk.easycar.rent.entity.User;
import lk.easycar.rent.repo.CustomerRepo;
import lk.easycar.rent.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

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

//        try {
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//            File uploadsDir = new File(projectPath + "/uploads");
//            uploadsDir.mkdir();
//
//            String fileName1 = img_front.getOriginalFilename();
//            String fileName2 = img_back.getOriginalFilename();
//            File file = new File(uploadsDir, fileName1);
//            File file1 = new File(uploadsDir,fileName2);
//
//            img_front.transferTo(file);
//            img_back.transferTo(file1);
//
//            map.setFrontImage("uploads/" + img_front.getOriginalFilename());
//            map.setBackImage("uploads/" + img_back.getOriginalFilename());
//
//
//        } catch (IOException | URISyntaxException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(map);
        customerRepo.save(map);
    }
}


