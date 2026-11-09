# API CLIMA (Assignment)

API: https://api.open-meteo.com/v1/forecast
City: Madrid, Spain
Data Format: JSON

## What to expect:

An API call to api.open-meteo.com with the city of Madrid as parameter.
And receive the information returned by said API to then be displayed in the console in a neat fashion.

## Execution process:

Import of the necessary modules
Declare the URL
Start main with a main title println statement
Create HttpClient which will be the one to send out our requests
Build the HttpRequest where we prepare the URL and the call
Send out the requests through the cliente's .send() method and save the response from the API to an HttpResponse object of type "String".

Check if there was any error
Save the returned information as logs to the "evidencias" directory
Transform the returned JSON into a format that Java can work with
Declare variables to store the parameters that the JSON contains. Like viento (wind), and temperatura (temperature).

Print all parameters to the console
Format the climatic condition from a number code so it displays a human-readable string with a describirClima() function.

Error handling in case the script throws an error.

## IA USAGE: True 
As the activity requested, I used AI, in this case ChatGPT, to first explain in different ways what SOC is and a difference to microservices along with other doubts I had before starting.
Then I had ChatGPT come up with the code and then explain to me what each part does, since I have not yet made any HttpRequests through Java prior to this. Only through express (from JavaScript) and Python with the requests module.
At the end I used ChatGPT to translate this very README.md file into spanish since I wrote it in english to be able to publish this as a project in my GitHub page.