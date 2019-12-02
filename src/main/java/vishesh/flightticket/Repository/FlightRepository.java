package vishesh.flightticket.Repository;

import vishesh.flightticket.bean.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, String> {

}
