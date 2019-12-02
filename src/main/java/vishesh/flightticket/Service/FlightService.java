package vishesh.flightticket.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vishesh.flightticket.Repository.FlightRepository;
import vishesh.flightticket.bean.Flight;

@Service
public class FlightService {

  @Autowired
  private FlightRepository flightRepository;

  public List<Flight> getAllFlights() {
    List<Flight> flights = new ArrayList<>();

    flightRepository.findAll().forEach(flights::add);

    return flights;
  }

  public Flight getFlight(String flight_id) {
    return (Flight) flightRepository.findById(flight_id).orElse(null);
  }

  public void addFlight(Flight flight) {
    flightRepository.save(flight);
  }

  public void updateFlight(int flight_id, Flight flight) {
    flightRepository.save(flight);
  }

  public void deleteFlight(String flight_id) {
    flightRepository.deleteById(flight_id);
  }
}
