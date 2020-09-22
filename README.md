# Leadiro Project by delwynb 🚀

A Sample Project for Leadiro 

What does it include:

- Basic Authentication
- Email and Post Code validation APIs
- Name Cleaning Algorithm

## Basic Authentication

Added a basic authentication for the application with configurable admin username and password.

The admin credentials can be configured in the `application.yaml` file.  
The properties `admin.username` and `admin.password` will be added to the Authentication Manager on start up.
Bcrypt used to encode the password.
 
## Email and Post Code validation APIs

Email validation API - validates email parameter and returns a JSON response of the result. 

#### Example usage:
- Invalid email [http://localhost:8090/validate/email?email=abc@xyc](http://localhost:8090/validate/email?email=abc@xyc)  
- Valid email [http://localhost:8090/validate/email?email=abc@xyc.com](http://localhost:8090/validate/email?email=abc@xyc.com)  

UK Post Code validation API - validates the postcode parameter using `https://postcodes.io/` APIs.
First checks if the postcode is valid before requesting for the postcode details.
Returns a JSON of the postcode and its region.

#### Example usage:
- Invalid postcode [http://localhost:8090/validate/postcode?postcode=LEADIRO](http://localhost:8090/validate/postcode?postcode=LEADIRO)
- Valid postcode [http://localhost:8090/validate/postcode?postcode=EC2Y9DT](http://localhost:8090/validate/postcode?postcode=EC2Y9DT)

## Name Cleaning Algorithm

This API accepts an array of name strings then parses every entry to a list of Name objects with first and last fields. 
Invalid name strings marked as `Unable to parse this invalid value` on last field, the invalid value in first field.

#### Example usage:

API 
- POST [http://localhost:8090/parse/name](http://localhost:8090/parse/name)
- Sample JSON BODY 
```
[
           "Leadiro User",
           "User, Leadiro",
           " leadiro     User ",
           "Leadiro John Del User",
           "Csar Leadiro User",
           "Dr Leadiro User",
           "D.R. Leadiro User",
           "Rev. Leadiro User",
           "Leadiro",
           "Leadiro (John) User",
           "Leadiro \"Rambo\" User",
           "Leadiro 'Rambo' User",
           "Leadiro User a.k.a The Terminator",
           "Leadiro User M.BA.",
           "Leadiro J. R. User",
           "Leadiro User, Bsc",
           "Leadiro User - Bsc",
           "Leadiro User | Bsc",
           "~~~ Leadiro User ~~~",
           "Leadiro User Certified Professional",
           "Leadiro User 99",
           "Leadiro User II.",
           "Leadiro User Jr."
]
```
- Sample Result
```
[
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "Del User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "Unable to parse this invalid value"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     },
     {
         "first": "Leadiro",
         "last": "User"
     }
 ]
```



### Tools used

- Intellij IDE
- `google-java-format` plugin 
- Lombok plugin
