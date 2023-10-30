package lk.easycar.rent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@IdClass(RentDetailPK.class)
public class RentCarDetail {

    @Id
    private String rentId;
    @Id
    private String carId;

    private String driverId;

    @OneToOne(cascade = {CascadeType.ALL})
    private Payment payment;


    @ManyToOne
    @JoinColumn(name = "rentId",referencedColumnName = "rentID",insertable = false,updatable = false)
    private Rental rent;

    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carID",insertable = false,updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverId",referencedColumnName = "driverID",insertable = false,updatable = false)
    private Driver driver;

}
