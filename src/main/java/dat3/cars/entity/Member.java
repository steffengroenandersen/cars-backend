package dat3.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import dat3.security.entity.UserWithRoles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private boolean approved;
    private int ranking;

    
    
    @OneToMany(mappedBy = "member")
    List<Reservation> reservations = new ArrayList<>();
    
    public void addReservation(Reservation reservation){
        /*
        if(reservations == null){
            reservations = new ArrayList<>();
        }
        
         */
        reservations.add(reservation);
    }
    
    
    public Member(String username, String password, String email,
                  String firstName, String lastName, String street, String city, String zip){
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;        
    }
}
