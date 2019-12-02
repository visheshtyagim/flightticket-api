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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

  @Id
  @Column(name = "flight_number", nullable = false, updatable = false)
  private String flight_number;

  @Column(name = "seats", nullable = false)
  private int seats;

  public Flight() {}

  public Flight(String flight_number, int seats) {
    this.flight_number = flight_number;
    this.seats = seats;
  }

  public String getFlightNumber() {
    return flight_number;
  }

  public void setFlightNumber(String flight_number) {
    this.flight_number = flight_number;
  }

  public int getSeats() {
    return seats;
  }

  public void setSeats(int seats) {
    this.seats = seats;
  }

  @Override
  public String toString() {
    return "Flight{" +
      "flight_number='" + flight_number + '\'' +
      ", seats=" + seats +
      '}';
  }
}
