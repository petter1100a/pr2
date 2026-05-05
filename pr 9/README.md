# Distributed Hotel Booking System using Java RMI

## Aim
To design and develop a distributed Hotel Booking application using Java Remote Method Invocation (RMI), consisting of a server that manages bookings and client machines that can invoke booking and cancellation operations.

## Requirements
- **JDK (Java Development Kit)**: Version 8 or higher.
- **Terminal/Command Prompt**: To compile and run the application.

## Theory
### Java RMI (Remote Method Invocation)
Java RMI allows an object residing in one Java Virtual Machine (JVM) to invoke methods on an object residing in another JVM. This is a core technology for building distributed applications in Java.

### Components:
1.  **Remote Interface**: Defines the methods that can be called remotely (must extend `java.rmi.Remote`).
2.  **Remote Object (Implementation)**: Implements the remote interface and extends `UnicastRemoteObject`.
3.  **RMI Registry**: A naming service that allows clients to look up remote objects by name.
4.  **Server**: Creates the remote object and registers it with the RMI Registry.
5.  **Client**: Looks up the remote object in the registry and invokes methods on it.

## How to Run

### 1. Compile all Java files
Open your terminal in the project directory and run:
```bash
javac *.java
```

### 2. Start the Server
Run the Server class to initialize the RMI registry and bind the service:
```bash
java HotelServer
```
*Note: Keep this terminal window open.*

### 3. Run the Client
Open a **new** terminal window and run:
```bash
java HotelClient
```

### 4. Operations
Once the client is running, you can:
- **Book a Room**: Choose option 1 and enter the guest's name.
- **Cancel a Booking**: Choose option 2 and enter the guest's name.
- **Exit**: Choose option 3.

## File Descriptions
- `Hotel.java`: The Remote Interface defining `bookRoom()` and `cancelBooking()`.
- `HotelImpl.java`: Implementation of the `Hotel` interface.
- `HotelServer.java`: Main class to host the RMI service.
- `HotelClient.java`: Client application to interact with the server.
