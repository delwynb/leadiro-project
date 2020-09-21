# Leadiro Project by delwynb 🚀

A Sample Project for Leadiro 

What does it include:

- Basic Authentication
- Email and Post Code validation APIs
- Name Cleaning Algorithm

### Basic Authentication

Added a basic authentication for the application with configurable admin username and password.

The admin credentials can be configured in the `application.yaml` file.  
The properties `admin.username` and `admin.password` will be added to the Authentication Manager on start up.
Bcrypt used to encode the password.
 
### Email and Post Code validation APIs

Email validation API - validates email parameter and returns a JSON response of the result. 

Example usage: 
- Invalid email [http://localhost:8090/validate/email?email=abc@xyc](http://localhost:8090/validate/email?email=abc@xyc)  
- Valid email [http://localhost:8090/validate/email?email=abc@xyc.com](http://localhost:8090/validate/email?email=abc@xyc.com)  

Post Code validation API - validates the postcode parameter using `https://postcodes.io/` APIs.
First checks if the postcode is valid before requesting for the postcode details.
Returns a JSON of the postcode and its region.

Example usage:
- Invalid postcode [http://localhost:8090/validate/postcode?postcode=LEADIRO](http://localhost:8090/validate/postcode?postcode=LEADIRO)
- Valid postcode [http://localhost:8090/validate/postcode?postcode=EC2Y209DT](http://localhost:8090/validate/postcode?postcode=EC2Y209DT)

### Name Cleaning Algorithm

### Tools used

- Intellij IDE
- `google-java-format` plugin 
- Lombok plugin
