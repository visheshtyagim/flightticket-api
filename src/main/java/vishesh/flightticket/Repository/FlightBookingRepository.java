package vishesh.flightticket.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import vishesh.flightticket.bean.Flight;
import vishesh.flightticket.bean.FlightBooking;
import org.springframework.data.repository.CrudRepository;

public interface FlightBookingRepository extends CrudRepository<FlightBooking, Integer> {
  List<FlightBooking> findByFlightNumber(String flightNumber);
}
