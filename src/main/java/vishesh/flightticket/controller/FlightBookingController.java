package vishesh.flightticket.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vishesh.flightticket.Repository.FlightBookingRepository;
import vishesh.flightticket.Service.FlightBookingService;
import vishesh.flightticket.Service.FlightService;
import vishesh.flightticket.bean.Flight;
import vishesh.flightticket.bean.FlightBooking;
import vishesh.flightticket.bean.FlightRequest;
import vishesh.flightticket.bean.FlightResponse;
import vishesh.flightticket.utils.Constants;

@RestController
public class FlightBookingController {

  @Autowired
  private FlightBookingService flightBookingService;

  @Autowired
  private FlightService flightService;

  @RequestMapping(value = "/bookSeat", method = RequestMethod.POST)
  public @ResponseBody FlightResponse bookSeat(@RequestBody FlightRequest flightRequest) {
    if (Objects.isNull(flightRequest) || Objects.isNull(flightRequest.getFlightNumber()) || Objects.isNull(flightRequest.getUserName())) {
      return FlightResponse.buildFlightResponseMessage(Constants.ERROR, "Required Fields Missing");
    }

    Flight flight = flightService.getFlight(flightRequest.getFlightNumber());
    List<FlightBooking> flightBookings = flightBookingService.getAllFlightBookingByFlightId(flightRequest.getFlightNumber());

    if (flightBookings.size() == flight.getSeats()) {
      return FlightResponse.buildFlightResponseMessage(Constants.ERROR, "Tickets full");
    }

    FlightBooking flightBooking = new FlightBooking();

    flightBooking.setFlightNumber(flightRequest.getFlightNumber());
    flightBooking.setUserName(flightRequest.getUserName());

    flightBookingService.addFlightBooking(flightBooking);

    return FlightResponse.buildFlightResponse(Constants.SUCCESS);
  }

}
