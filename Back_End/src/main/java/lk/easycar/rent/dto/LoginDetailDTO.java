package lk.easycar.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class LoginDetailDTO {

    private String loginID;
    private UserDTO user;
    private String date;
    private String time;

}
