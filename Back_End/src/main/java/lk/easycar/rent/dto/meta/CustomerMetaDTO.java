package lk.easycar.rent.dto.meta;

import lk.easycar.rent.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerMetaDTO {
    private String customerID;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String licenseNo;
    private String frontImage;
    private String backImage;
    private UserDTO user;
}
