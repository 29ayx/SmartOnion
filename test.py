import requests
import random

def generate_combination(words):
    # Randomly select three words and concatenate them
    return ''.join(random.choices(words, k=3))

def send_post_request(url, words):
    # Generate email and password using the specified format
    email = generate_combination([words[0], words[2], words[0]])
    password = generate_combination([words[1], words[1], words[0]])
    
    # Form data dictionary
    data = {
        "name": "Onion",
        "type": test,
        "quantity": 1
    }
    
    # Send POST request
    response = requests.post(url, data=data)
    
    # Return response status and content
    return response.status_code, response.text

# URL to send request to
url = 'http://localhost:8080/tasks'

# Array of words to use in combinations
words = ['hello', 'world', 'word3']

# Send the POST request and print the result
status_code, response_content = send_post_request(url, words)
print("Status Code:", status_code)
print("Response Content:", response_content)
