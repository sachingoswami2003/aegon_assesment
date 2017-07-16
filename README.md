# Aegon Room Booking Service
A basic booking system for a small hotel  

Hotel has 5 rooms available to hire, 2 Single rooms charged at £100 per night and 3 double rooms at £200 per night. Breakfast is available for an additional £5 per person

Front end access to the booking system is to be handled elsewhere you are only required to create RESTFUL services which expose specific functionality. 

## Building and Running
The application needs to generate  Java classes before it can compile.

Build: ``mvn clean install``

### Swagger
Swagger2 documentation is produced at runtime.
With the service running you can view the Swagger documentation at: 
``$SERVICE_URL/swagger-ui.html``

For example:
``http://localhost:8081/swagger-ui.html``

### Documentation
####Data Model
Created Four Object Model - Book, Customer, OccupiedRoom, Room 

Room and OccupiedRoom have parent and child relationship

Customer and Book have parent and child relationship  

#### Service Method details

1-getRoomDetails  will retrieve any bookings for a specific room ID
2-getCustomerRoomDetails will retrieve any bookings for a specific customer ID
3-checkRoomsAvailabiltyForGivenDates to determine the availability of a specific room during a given date range
4-saveRoomDetails  create a new booking for customer 
5-updateRoomDetails to amend an existing booking. 
4-findBookingsCost  able to get a total cost for their booking.

## H2 Database
In memory database 
Added data.Sql data file , upload services run

## Test Case
Added unit Test case to test services functionality by using Mockito for unit testing 

