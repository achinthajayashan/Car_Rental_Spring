package lk.easycar.rent.controller;

import lk.easycar.rent.dto.LoginDetailDTO;
import lk.easycar.rent.dto.UserDTO;
import lk.easycar.rent.service.DriverService;
import lk.easycar.rent.service.LoginDetailService;
import lk.easycar.rent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/loginDetail")
public class LoginDetailController {

    @Autowired
    private LoginDetailService service;


    @PostMapping
    public ResponseUtil saveLoginDetail(LoginDetailDTO loginDetailDTO){
        service.saveLoginDetail(loginDetailDTO);
        return new ResponseUtil("OK","Successfully Loaded",loginDetailDTO);
    }

}
