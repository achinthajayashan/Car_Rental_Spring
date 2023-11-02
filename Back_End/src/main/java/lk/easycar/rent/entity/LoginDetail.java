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
public class LoginDetail {
    @Id
    private String loginID;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
//    @JoinColumn(name = "user",referencedColumnName = "user",nullable = false)
    private User user;
    private String date;

    private String time;



}
