package lk.easycar.rent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Payment {

    @Id
    private String paymentID;
    private double waiverDeductions;
    private String waiverSlip;
    private double extraMileagePayment;
}
