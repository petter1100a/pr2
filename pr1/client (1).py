import xmlrpc.client

# Connect to server
server = xmlrpc.client.ServerProxy("http://localhost:8000/")

# Input
num = int(input("Enter number: "))

# Call server function
result = server.factorial(num)

print(f"Factorial of {num} = {result}")