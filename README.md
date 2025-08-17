🔹 What your current code is doing

1. Database setup (Flights + Passengers)

  We have two tables:

  flight → Stores flight details (id, flightNumber, origin, destination, departureTime)

  passenger → Stores passenger details (id, name, email, phoneNumber, checkedIn, flight_id)

  We inserted some initial records using data.sql.

2. Spring Boot REST APIs

You exposed REST endpoints like:

/flights → Returns the list of flights.

/passengers → Returns the list of passengers.

/checkin (POST) → Marks a passenger as checked-in for a given flight.

✅ When you call /checkin, your service:

Looks up the passenger in DB

3. Kafka Producer Integration

After updating the passenger in DB, you publish an event to Kafka.

The code:

kafkaTemplate.send("flight-checkin-topic", passenger);


✅ This means:

Take the Passenger object

Serialize it into JSON (thanks to JsonSerializer in your Kafka config)

Send it to Kafka under topic → flight-checkin-topic

So right now, every successful check-in = DB update + Event published to Kafka.

But you don’t yet have any consumer to read that event, so it just goes to Kafka and sits there.

Marks checkedIn = true

Saves it back to DB
