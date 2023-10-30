package lk.easycar.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PaymentDTO {
    private String paymentID;
    private double waiverDeductions;
    private String waiverSlip;
    private double extraMileagePayment;
}
