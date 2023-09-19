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
    @Id
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private boolean approved;
    private int ranking;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime lastEdited;
    
    
    @OneToMany(mappedBy = "member")
    List<Reservation> reservations;
    
    public void addReservation(Reservation reservation){
        if(reservations == null){
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }
    
    
    public Member(String user, String password, String email,
                  String firstName, String lastName, String street, String city, String zip){
        this.username = user;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;        
    }
}
