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
public class CarMetaDTO {
    String carID;
    String regNo;
    String brand;
    String type;
    String passenger;
    String color;
    String transmissionType;
    String fuelType;
    String extraMileagePrice;
    String currentMileage;
    String wavierPayment;
    String availability;
    String freeMileageDaily;
    String freeMileageDailyPrice;
    String freeMileageMonthly;
    String freeMileageMonthlyPrice;
    String frontImage;
    String  rearImage;
    String  sideImage;
    String  interiorImage;
}
