package vishesh.flightticket.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vishesh.flightticket.Repository.FlightBookingRepository;
import vishesh.flightticket.bean.FlightBooking;

@Service
public class FlightBookingService {

  @Autowired
  private FlightBookingRepository flightBookingRepository;

  public List<FlightBooking> getAllFlightBookingByFlightId(String flight_number) {
    List<FlightBooking> flightBookings = new ArrayList<>();

    flightBookingRepository.findByFlightNumber(flight_number).forEach(flightBookings::add);

    return flightBookings;
  }

  public FlightBooking getFlightBooking(int id) {
    return (FlightBooking) flightBookingRepository.findById(id).orElse(null);
  }

  public void addFlightBooking(FlightBooking flightBooking) {
    flightBookingRepository.save(flightBooking);
  }

  public void updateFlightBooking(int id, FlightBooking flightBooking) {
    flightBookingRepository.save(flightBooking);
  }

  public void deleteFlightBooking(int id) {
    flightBookingRepository.deleteById(id);
  }
}
