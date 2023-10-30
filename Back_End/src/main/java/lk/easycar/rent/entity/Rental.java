package lk.easycar.rent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Rental {
    @Id
    private String rentID;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerID",referencedColumnName = "customerID",nullable = false)
    private Customer cusID;
    private String pickupDate;
    private String pickupTime;
    private String  duration;
    private String status;
    private String declineReason;

    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL)
    private List<RentCarDetail> rentDetails;


}
