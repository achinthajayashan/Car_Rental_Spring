package lk.easycar.rent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {
    @Id
    private String customerID;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String licenseNo;
    private String frontImage;
    private String backImage;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
