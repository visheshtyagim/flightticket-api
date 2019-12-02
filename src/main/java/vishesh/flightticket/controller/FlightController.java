package vishesh.flightticket.controller;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vishesh.flightticket.Service.FlightService;
import vishesh.flightticket.bean.Flight;
import vishesh.flightticket.bean.FlightRequest;
import vishesh.flightticket.bean.FlightResponse;
import vishesh.flightticket.utils.Constants;

@RestController
public class FlightController {

  @Autowired
  private FlightService flightService;

  @RequestMapping(value = "/getAvailableSeats", method = RequestMethod.GET, params = {"flightNumber"})
  public @ResponseBody FlightResponse getFlight(@RequestParam(value = "flightNumber") String flightNumber) {
    Flight flight = flightService.getFlight(flightNumber);

    if (Objects.isNull(flight)) {
      return FlightResponse.buildFlightResponse(Constants.ERROR);
    }

    return FlightResponse.buildFlightResponseSuccess(Constants.SUCCESS, flight.getSeats());
  }

  @RequestMapping(value = "/addFlight", method = RequestMethod.POST)
  public @ResponseBody FlightResponse addFlight(@RequestBody FlightRequest flightRequest) {
    if (Objects.isNull(flightRequest) || Objects.isNull(flightRequest.getFlightNumber()) || Objects.isNull(flightRequest.getNoOfSeats())) {
      return FlightResponse.buildFlightResponseMessage(Constants.ERROR, "Required Fields Missing");
    }

    if (Objects.nonNull(flightService.getFlight(flightRequest.getFlightNumber()))) {
      return FlightResponse.buildFlightResponseMessage(Constants.ERROR, "Flight already exists");
    }

    Flight flight = new Flight();

    flight.setFlightNumber(flightRequest.getFlightNumber());
    flight.setSeats(flightRequest.getNoOfSeats());

    flightService.addFlight(flight);

    return FlightResponse.buildFlightResponse(Constants.SUCCESS);
  }
}
