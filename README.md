# Leadiro Project by delwynb 🚀

### What does it include:

- Basic Authentication
- Email and Post Code validation APIs
- Name Cleaning Algorithm API
- Dealing With Data Search and Get Record API

## Build and Run using Docker
- `docker build -t leadiro-project-delwynb .`
- `docker run -d -p 80:8090 leadiro-project-delwynb`


## Basic Authentication

Added a basic authentication for the application with configurable admin username and password.

The admin credentials can be configured in the `application.yaml` file.  
The properties `admin.username` and `admin.password` will be added to the Authentication Manager on start up.
Bcrypt used to encode the password.

Defaults to `admin/password123` 
 
## Email and Post Code validation APIs

Email validation API - validates email parameter and returns a JSON response of the result. 

API 
* GET `http://localhost:8090/validate/email`
* PARAMETERS - email

#### Example usage:
- Invalid email [http://localhost:8090/validate/email?email=abc@xyc](http://localhost:8090/validate/email?email=abc@xyc)  
- Valid email [http://localhost:8090/validate/email?email=abc@xyc.com](http://localhost:8090/validate/email?email=abc@xyc.com)  

UK Post Code validation API - validates the postcode parameter using `https://postcodes.io/` APIs.
First checks if the postcode is valid before requesting for the postcode details.
Returns a JSON of the postcode and its region.

API 
* GET `http://localhost:8090/validate/postcode`
* PARAMETERS - postcode

#### Example usage:
- Invalid postcode [http://localhost:8090/validate/postcode?postcode=LEADIRO](http://localhost:8090/validate/postcode?postcode=LEADIRO)
- Valid postcode [http://localhost:8090/validate/postcode?postcode=EC2Y9DT](http://localhost:8090/validate/postcode?postcode=EC2Y9DT)

## Name Cleaning Algorithm

This API accepts an array of name strings then parses every entry to a list of Name objects with first and last fields. 
Invalid name strings marked as `Unable to parse this invalid value` on last field, the invalid value in first field.

#### Example usage:

API 
- POST [http://localhost:8090/parse/name](http://localhost:8090/parse/name)
- BODY - JSON array of Strings
- Example JSON BODY 
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
- Example Response
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

## Dealing with Data

This part implements end points for searching and retrieving data from
`https://collections.museumsvictoria.com.au/api/search` API.

#### Search by Keywords

API

- POST `http://localhost:8090/museum`
- BODY - JSON Array of Strings
- Example JSON Body
```
[
	"Art",
	"banking"
]
```
- Example Response
```
[
    {
        "id": "items/2004136",
        "displayTitle": "Scrapbook - Kodak Australasia Pty Ltd, Advertising Clippings, 'Business Systems, Markets Division', Coburg, 1971 - 1976"
    },
    {
        "id": "items/2004123",
        "displayTitle": "Scrapbook - Kodak Australasia Pty Ltd, Advertising Clippings, 'Business Photo Systems', Coburg, 1959-1965"
    },
    {
        "id": "items/2106237",
        "displayTitle": "Invitation - from Mr. H. K. Morter, Manager State Savings Bank Bulleen, Victoria, Mar 1976"
    },
    {
        "id": "items/2106241",
        "displayTitle": "Booklet - 'Baby's Book of Happy Events', State Savings Bank of Victoria, Victoria, circa 1960s"
    },
    {
        "id": "items/2006478",
        "displayTitle": "Christmas Card - State Savings Bank of Victoria, 1980s"
    },
    {
        "id": "items/2006747",
        "displayTitle": "Christmas Card - State Savings Bank of Victoria, 1983"
    },
    {
        "id": "items/2006752",
        "displayTitle": "Christmas Card - State Savings Bank of Victoria, 1980s"
    },
    {
        "id": "items/2006761",
        "displayTitle": "Christmas Card - State Savings Bank of Victoria, 1980s"
    },
    {
        "id": "items/1467021",
        "displayTitle": "Badge - 'Hiroshima Never Again', 1970s"
    },
    {
        "id": "items/1467019",
        "displayTitle": "Badge - Never Underestimate the Power of a Woman, Melbourne, 1970s"
    },
    {
        "id": "items/1467024",
        "displayTitle": "Badge - Amnesty International, 1970s"
    },
    {
        "id": "items/2009854",
        "displayTitle": "Christmas Card - State Savings Bank of Victoria, 1980s"
    },
    {
        "id": "items/2028012",
        "displayTitle": "Salary Book - Kodak Archive, Series 9, 'Staff', Sub-Series 1, 'Salaries', Head Office Salaries, 1931-1937"
    },
    {
        "id": "items/2029803",
        "displayTitle": "Cash Book - Kodak Archive, Series 5, 'Accounting Journals', Cash Expenditure Head Office Account, Feb 1929 - Nov 1929"
    },
    {
        "id": "items/1460466",
        "displayTitle": "Photograph - Kodak Australasia Ltd, 6th or 7th War Loan Bonds Appeal with Tank and Kodak Staff, Abbotsford, Victoria, 3 April 1918 - 31 July 1919"
    },
    {
        "id": "items/2281125",
        "displayTitle": "Photograph - Kodak Australasia, 6th or 7th War Loan Bonds Appeal with Tank & Kodak Staff, Abbotsford, Victoria, 3 April 1918-31 July 1919"
    },
    {
        "id": "items/2195919",
        "displayTitle": "Photograph - Kodak Australasia Pty Ltd, Portrait of John O'Meara, 1980s"
    },
    {
        "id": "articles/16557",
        "title": "Colonial Square, Melbourne Museum",
        "displayTitle": "Colonial Square, Melbourne Museum"
    },
    {
        "id": "items/1460467",
        "displayTitle": "Photograph - Kodak Australasia Pty Ltd, 6th War Loan Bond Appeal with Tank and Kodak Staff, Abbotsford, WWI, April 1918"
    },
    {
        "id": "items/1467005",
        "displayTitle": "Badge - 'Let's Talk about Living Together, 1970s"
    }
]
```

#### Get Record by ID

API

- GET `http://localhost:8090/museum/{id}`
- PATH VARIABLE - id
- Example Request [http://localhost:8090/museum/2004136](http://localhost:8090/museum/2004136)
- Example Response
```
{
    "id": "items/2004136",
    "qualifierRank": "None",
    "recordType": "item",
    "displayTitle": "Scrapbook - Kodak Australasia Pty Ltd, Advertising Clippings, 'Business Systems, Markets Division', Coburg, 1971 - 1976",
    "dateModified": "2020-07-08T06:34:00Z",
    "category": "History & Technology",
    "discipline": "Technology",
    "type": "Object",
    "registrationNumber": "HT 34735",
    "objectName": "Scrapbook - Kodak Australasia Pty Ltd, Advertising Clippings, 'Business Systems, Markets Division', Coburg, 1971 - 1976",
    "objectSummary": "Scrapbook compiled by Kodak Australasia Pty Ltd. It contains approximately 143 archival items produced 1971 - 1976. \n\nThe archival items include promotional clippings and advertisement proofs for Kodak products. The products and subjects include business machines, copiers, micrographic services, microfilm, plates, printers, movie cameras, slide projectors, projection screens, sound projector, copying film and papers, pocket cameras. \n\nAdvertising slogans include 'how to turn any microfilm into a 5 cent dry copy. With a new Kodak reader/printer' and 'For people who think they can't afford microfilm ... Kodak Micrographic Services Australia-Wide!' \n\nAdvertising clippings and proofs relate to the following publications:  \nAustralian Accountant, Australian Business Communications, Australian Financial Review, Australian Library Journal, B.P.N, Modern Office, Time, Factory Equipment News, Australian Municipal Journal, Blueprint, C.E.N, Computer Master, Computer Weekly, Data Trend, Educational Books and Equipment, Engineering Australia, Executive Buyer's Guide, Factory Equipment News, Impetus\nIndustrial Engineer, Information Efficiency, Insurance & Banking Record, Journal of Institute Engineers, Management Australia, Manufacturer's Monthly, Modern Building, Pace, Rydges, Small Offset Australia, Sydney Morning Herald, Tasmanian Architect Conv. Programme, The Age, The Australian, The Chartered Secretary, The Insurance & Banking Record\n\nKodak manufactured and distributed a wide range of photographic products to Australasia, such as film, paper, chemicals, cameras and miscellaneous equipment. Its client base included amateur and professional photographers, as well as specialist medical and graphic art professionals who used photography, x-ray and other imaging techniques.\n\nThis scrapbook is part of the Kodak collection of products, promotional materials, photographs and working life artefacts collected from Kodak Australasia in 2005, when the Melbourne manufacturing plant at Coburg closed down.",
    "physicalDescription": "Large black hardcover scrapbook with 105 brown paper pages. The book contains paper-based advertising clippings. \n\nClippings are printed in black and white on both gloss and matte paper. A typed index with handwritten corrections on the first page lists all contents, it has minor additions made in blue and black ink. Page numbers are written in ink on the top outer corners of each page, and handwritten titles are on most pages.  Clippings are attached with sticky tape and glue. A number of clippings have come loose inside the scrapbook. A number of pages have been left blank, and quite a few have been cut out of the book. \n\nThe promotional materials range in size from 212 mm (W) x 276 mm (H) to 172 mm (W) x 257 mm (H).",
    "inscription": "Yellow sticker on front cover, centre, typed, black ink: 'BUSINESS SYSTEMS / MARKETS DIVISION'",
    "acquisitionInformation": "Donation from Kodak (Australasia) Pty Ltd, Ms. Kate Metcalf - Kodak (Australasia) Pty Ltd, 2005",
    "acknowledgement": "Courtesy of Kodak (Australasia) Pty Ltd.",
    "audioVisualContentSummaries": [],
    "tradeLiteraturePublicationTypes": [],
    "indigenousCulturesLocalities": [],
    "indigenousCulturesCulturalGroups": [],
    "collectionNames": [
        "Kodak Heritage Collection"
    ],
    "classifications": [
        "Manufacturing & industry",
        "Photographic products",
        "Promotional materials"
    ],
    "keywords": [
        "Scrapbooks",
        "Advertising",
        "Photography",
        "Retailing",
        "Marketing",
        "Promotional Materials",
        "Photographic Film",
        "Photographic Copiers",
        "Photographic Duplicating Machines",
        "Photographic Printing Processes",
        "Photographic Equipment & Supplies",
        "Technology & Innovation",
        "Technology Changes",
        "Innovation & Design"
    ],
    "bibliographies": [],
    "modelNames": [],
    "brands": [
        {
            "name": "Kodak"
        }
    ],
    "relatedItemIds": [],
    "relatedSpecimenIds": [],
    "relatedArticleIds": [
        "articles/13477",
        "articles/13478",
        "articles/2884",
        "articles/2882"
    ],
    "relatedSpeciesIds": [],
    "associations": [
        {
            "type": "Compiled By",
            "name": "Kodak (Australasia) Pty Ltd",
            "date": "1971 - 1976",
            "streetAddress": "173 - 199 Elizabeth Street",
            "locality": "Coburg",
            "region": "Greater Melbourne",
            "state": "Victoria",
            "country": "Australia"
        }
    ],
    "dimensions": [
        {
            "configuration": "Overall Dimensions",
            "dimensions": "287 mm (Width), 21 mm (Depth), 432 mm (Height)"
        }
    ],
    "media": [
        {
            "id": "media/743828",
            "dateModified": "2016-11-09T05:49:00Z",
            "caption": "Scrapbook - Kodak Australasia Pty Ltd, Advertising Clippings, 'Business Systems, Markets Division', Coburg, 1971 - 1976",
            "credit": "Courtesy of Kodak (Australasia) Pty Ltd",
            "rightsStatement": "Copyright Kodak (Australasia) Pty Ltd / All Rights Reserved",
            "creators": [],
            "sources": [
                "Museums Victoria"
            ],
            "type": "image",
            "large": {
                "width": "2000",
                "height": "3000",
                "uri": "https://collections.museumsvictoria.com.au/content/media/28/743828-large.jpg",
                "size": "974605"
            },
            "medium": {
                "width": "1000",
                "height": "1500",
                "uri": "https://collections.museumsvictoria.com.au/content/media/28/743828-medium.jpg",
                "size": "188773"
            },
            "small": {
                "width": "333",
                "height": "500",
                "uri": "https://collections.museumsvictoria.com.au/content/media/28/743828-small.jpg",
                "size": "26322"
            },
            "thumbnail": {
                "width": "250",
                "height": "250",
                "uri": "https://collections.museumsvictoria.com.au/content/media/28/743828-thumbnail.jpg",
                "size": "10555"
            }
        },
        {
            "id": "media/743829",
            "dateModified": "2016-11-09T05:49:00Z",
            "caption": "Scrapbook - Kodak Australasia Pty Ltd, Advertising Clippings, 'Business Systems, Markets Division', Coburg, 1971 - 1976",
            "credit": "Courtesy of Kodak (Australasia) Pty Ltd",
            "rightsStatement": "Copyright Kodak (Australasia) Pty Ltd / All Rights Reserved",
            "creators": [],
            "sources": [
                "Museums Victoria"
            ],
            "type": "image",
            "large": {
                "width": "2000",
                "height": "3000",
                "uri": "https://collections.museumsvictoria.com.au/content/media/29/743829-large.jpg",
                "size": "699357"
            },
            "medium": {
                "width": "1000",
                "height": "1500",
                "uri": "https://collections.museumsvictoria.com.au/content/media/29/743829-medium.jpg",
                "size": "136054"
            },
            "small": {
                "width": "333",
                "height": "500",
                "uri": "https://collections.museumsvictoria.com.au/content/media/29/743829-small.jpg",
                "size": "20544"
            },
            "thumbnail": {
                "width": "250",
                "height": "250",
                "uri": "https://collections.museumsvictoria.com.au/content/media/29/743829-thumbnail.jpg",
                "size": "7911"
            }
        },
        {
            "id": "media/743827",
            "dateModified": "2016-11-09T05:49:00Z",
            "caption": "Scrapbook - Kodak Australasia Pty Ltd, Advertising Clippings, 'Business Systems, Markets Division', Coburg, 1971 - 1976",
            "credit": "Courtesy of Kodak (Australasia) Pty Ltd",
            "rightsStatement": "Copyright Kodak (Australasia) Pty Ltd / All Rights Reserved",
            "creators": [],
            "sources": [
                "Museums Victoria"
            ],
            "type": "image",
            "large": {
                "width": "1876",
                "height": "3000",
                "uri": "https://collections.museumsvictoria.com.au/content/media/27/743827-large.jpg",
                "size": "929823"
            },
            "medium": {
                "width": "938",
                "height": "1500",
                "uri": "https://collections.museumsvictoria.com.au/content/media/27/743827-medium.jpg",
                "size": "171334"
            },
            "small": {
                "width": "313",
                "height": "500",
                "uri": "https://collections.museumsvictoria.com.au/content/media/27/743827-small.jpg",
                "size": "22245"
            },
            "thumbnail": {
                "width": "250",
                "height": "250",
                "uri": "https://collections.museumsvictoria.com.au/content/media/27/743827-thumbnail.jpg",
                "size": "8964"
            }
        },
        {
            "id": "media/743826",
            "dateModified": "2016-11-09T05:49:00Z",
            "caption": "Scrapbook - Kodak Australasia Pty Ltd, Advertising Clippings, 'Business Systems, Markets Division', Coburg, 1971 - 1976",
            "credit": "Courtesy of Kodak (Australasia) Pty Ltd",
            "rightsStatement": "Copyright Kodak (Australasia) Pty Ltd / All Rights Reserved",
            "creators": [],
            "sources": [
                "Museums Victoria"
            ],
            "type": "image",
            "large": {
                "width": "2000",
                "height": "3000",
                "uri": "https://collections.museumsvictoria.com.au/content/media/26/743826-large.jpg",
                "size": "763649"
            },
            "medium": {
                "width": "1000",
                "height": "1500",
                "uri": "https://collections.museumsvictoria.com.au/content/media/26/743826-medium.jpg",
                "size": "84116"
            },
            "small": {
                "width": "333",
                "height": "500",
                "uri": "https://collections.museumsvictoria.com.au/content/media/26/743826-small.jpg",
                "size": "9718"
            },
            "thumbnail": {
                "width": "250",
                "height": "250",
                "uri": "https://collections.museumsvictoria.com.au/content/media/26/743826-thumbnail.jpg",
                "size": "3878"
            }
        }
    ]
}
```

### Tools used

- Intellij IDE
- `google-java-format` plugin 
- Lombok plugin
- Postman
