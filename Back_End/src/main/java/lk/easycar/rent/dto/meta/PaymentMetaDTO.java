package lk.easycar.rent.dto.meta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PaymentMetaDTO {
    private String paymentID;
    private double waiverDeductions;
    private String  waiverSlip;
    private double extraMileagePayment;
}
