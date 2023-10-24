package lk.easycar.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerID;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String licenseNo;
    private MultipartFile frontImage;
    private MultipartFile backImage;
    private UserDTO user;

}
