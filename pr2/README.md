# RMI String Concatenation Application

## Overview
This is a distributed application using Java RMI (Remote Method Invocation) where a client submits two strings to a server, and the server returns their concatenation.

---

## Theory for Practical Examination

### 1. What is RMI (Remote Method Invocation)?
Java RMI is an API that allows an object to invoke methods on an object running in another Java Virtual Machine (JVM). It provides a mechanism to create distributed applications in Java, where the methods of remote objects can be invoked from other JVMs, potentially on different hosts.

### 2. RMI Architecture
The RMI architecture consists of three distinct layers:
1.  **Stub & Skeleton Layer**: 
    - **Stub**: A client-side object that acts as a proxy for the remote object. It forwards method calls to the server.
    - **Skeleton**: A server-side object that receives the request from the stub and invokes the actual method on the remote object. (Modern Java RMI handles this automatically).
2.  **Remote Reference Layer**: Manages the creation and management of remote references.
3.  **Transport Layer**: Handles the actual connection between the two JVMs using TCP/IP.

### 3. Key Components of an RMI Application
-   **Remote Interface**: Defines the methods that can be called remotely. It must extend `java.rmi.Remote`.
-   **Remote Implementation**: The class that implements the remote interface and defines the business logic.
-   **RMI Registry**: A naming service where remote objects are registered by name so that clients can look them up.
-   **Server**: Creates the remote object, exports it, and registers it with a name in the RMI registry.
-   **Client**: Looks up the remote object in the registry and invokes its methods.

### 4. Requirements
-   **Platform**: Java Runtime Environment (JRE) and Java Development Kit (JDK).
-   **Network**: TCP/IP connectivity if running on different machines.
-   **Port**: A port (default 1099, but here we use 5000) must be available for the RMI Registry.

---

## Components in this Practical

### 1. **StringConcat.java** (Remote Interface)
- Defines the remote interface that the server implements
- Contains method: `concat(String a, String b) throws RemoteException`

### 2. **StringConcatImpl.java** (Remote Implementation)
- Implements the `StringConcat` interface
- Extends `UnicastRemoteObject` to make it a remote object
- Implements the actual concatenation logic

### 3. **Server.java** (Server Application)
- Starts the RMI registry on port 5000 (using `LocateRegistry.createRegistry`)
- Binds the `StringConcatImpl` object to the registry with the name "concat"

### 4. **Client.java** (Client Application)
- Looks up the remote object from the RMI registry using `Naming.lookup`
- Accepts two strings as user input from the console
- Calls the remote `concat()` method and displays the result

---

## How to Run

### Step 1: Compile All Files
Open terminal in the project directory and run:
```powershell
javac StringConcat.java StringConcatImpl.java Server.java Client.java
```

### Step 2: Start RMI Registry (Terminal 1)
*Note: Our Server.java handles registry creation, but manually starting it is often standard practice.*
```powershell
rmiregistry 5000
```
**Leave this terminal running.**

### Step 3: Start the Server (Terminal 2)
```powershell
java Server
```
**Expected output:** `Server ready...`

### Step 4: Run the Client (Terminal 3)
```powershell
java Client
```

### Step 5: Interaction
```
Enter first string: Hello
Enter second string:  World
Result: Hello World
```

---

## Architecture Diagram

```
┌──────────────┐
│   Client     │
│  (RMI Stub)  │
└──────┬───────┘
       │ Naming.lookup()
       │ concat(String, String)
       │
    Network (Port 5000)
       │
└──────┬───────────────────────┐
│   RMI Registry              │
│   - Stores remote objects   │
│   - Lookup service          │
└──────────────┬──────────────┘
               │
       ┌───────┴───────┐
       │               │
┌──────▼─────────────┐ │
│   Server           │ │
│  ┌──────────────┐  │ │
│  │StringConcatImpl  │ │
│  │ concat(a,b)  │  │ │
│  └──────────────┘  │ │
└────────────────────┘ │
```

---

## Troubleshooting

### Issue: Port 5000 already in use
**Solution:** Change the port number in both `Server.java` and `Client.java` or stop the process currently using port 5000.

### Issue: java.rmi.ConnectException
**Solution:** Ensure `rmiregistry` is running and the `Server` has successfully started before running the `Client`.

---

## Files Summary
- `StringConcat.java`: Remote Interface.
- `StringConcatImpl.java`: Implementation of Remote Interface.
- `Server.java`: RMI Server.
- `Client.java`: RMI Client.
