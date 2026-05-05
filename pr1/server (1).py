from xmlrpc.server import SimpleXMLRPCServer

# Function
def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)

# Server setup
server = SimpleXMLRPCServer(("localhost", 8000))
server.register_function(factorial, "factorial")

print("Server is running on port 8000...")
server.serve_forever()