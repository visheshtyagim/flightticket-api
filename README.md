**Problem statement 1 :-**
An airline company has reached out to you to create an online flight ticket booking system. The
airline company is looking for a solution where the user can visit their website and / or use their
apps to book the tickets. They are also looking forward to partnering with various vendors to sell
their tickets.
You have been chosen to create the backend system for the same. The company wants you to
create API’s that will allow the following functionalities.
You can assume each flight is uniquely identified by the flight number.
You need not take authorisation into consideration and assume all API’s to be non-authorised.
You can use any database / file store to save and read the information.

**A) Get Available Seats.**
For an input of flight number and fetch the current number of available seats.
The response would be a body with Status : Success / Failure and an integer count.
Sample
Request …../getAvailableSeats?flightNumber=abc.
Response (Json) { “status” : “Success”, “count” : 10}
Or { “status” : “Failure”}

**B) Book ticket**
For an input of a flight number and a user name book a seat on the flight for the provided user.
You can assume this is the only information currently required to be stored in the system. Also,
you can assume that all payment information has been captured and has been successful before
this API call.
The response should contain a seat number (assuming the seat numbering from 1-n, where n is
the total number of seats in the airplane)
Sample
Request …../bookSeat
Request (Json) {“flightNumber” : “abc”, “userName”:”John”}
Response (Json) { “status” : “Success”, “seatNumber” : 1}
Or { “status” : “Failure”, “message” : “Tickets full”}

**C) Schedule flight**
This will be used to schedule a new flight for which bookings will be taken after being scheduled.
Sample
Request …../scheduleFlight
Request (Json) {“flightNumber” : “abc”, “noOfSeats”:50}
Response (Json) { “status” : “Success”}
Or { “status” : “Failure”, “message” : “Flight already exists”}


Tech Stack:
1. Java 1.8
2. Mysql 5.7.27
3. Spring Maven