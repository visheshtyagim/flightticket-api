package vishesh.flightticket.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightResponse {

  @JsonProperty("status")
  private String status;

  @JsonProperty("count")
  @JsonInclude(Include.NON_DEFAULT)
  private int count;

  @JsonProperty("message")
  private String message;

  public static FlightResponse buildFlightResponseSuccess(String status, int count) {
    return FlightResponse.builder()
      .status(status)
      .count(count)
      .build();
  }

  public static FlightResponse buildFlightResponse(String status) {
    return FlightResponse.builder()
      .status(status)
      .build();
  }

  public static FlightResponse buildFlightResponseMessage(String status, String message) {
    return FlightResponse.builder()
      .status(status)
      .message(message)
      .build();
  }
}
