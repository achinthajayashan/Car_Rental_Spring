package lk.easycar.rent.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RentalDTO {

    private String rentID;
    private String customerID;
    private String pickupDate;
    private String pickupTime;
    private String  duration;
    private String status;
    private String declineReason;
    private List<RentCarDetailDTO> rentDetails;
}
