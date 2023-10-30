package lk.easycar.rent.dto;

import lk.easycar.rent.entity.Car;
import lk.easycar.rent.entity.Driver;
import lk.easycar.rent.entity.Payment;
import lk.easycar.rent.entity.Rental;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Data
public class RentCarDetailDTO {

    private String rentID;
    private String carID;
    private String driverID;
    private PaymentDTO  payment;



}
