package vishesh.flightticket.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.repository.EntityGraph;
import vishesh.flightticket.Service.FlightService;

@Entity
@Table(name = "flightbooking")
public class FlightBooking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private String pnr;

  @Column(name = "flight_number", nullable = false)
  private String flightNumber;

  @NotNull
  @Size(max = 250)
  @Column(name = "user_name", nullable = false, updatable = false)
  private String userName;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flight_number) {
    this.flightNumber = flight_number;
  }
}
