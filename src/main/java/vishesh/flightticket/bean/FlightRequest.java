package vishesh.flightticket.bean;

public class FlightRequest {
  private String flightNumber;
  private int noOfSeats;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  private String userName;

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public int getNoOfSeats() {
    return noOfSeats;
  }

  public void setNoOfSeats(int noOfSeats) {
    this.noOfSeats = noOfSeats;
  }
}
