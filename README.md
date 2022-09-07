----- 

The objective of this service is to save the data in mysql as well as publish the messages to kafka topic in order to follow the cqrs pattern.

Api's
-----


1. Save Product--> localhost:8081/e-auction/api/v1/seller/add-product   
{
    "productId": 93,
    "sellerId": 33,
    "productName": "Frame",
    "shortDescription": "Hand Painted Art Signed Framed Landscape Painting",
    "detailedDescription": "In overall  excellent condition",
    "category": "Painting",
    "startingPrice": 5300.0,
    "bidEndDate": "2022-11-23"
}

2.  Get Product --> localhost:8081/e-auction/api/v1/seller/products

3. Place a bid -->  localhost:8081/e-auction/api/v1/buyer/place-bid

   {
    "firstName": "Raja",
    "lastName": "Kumara",
    "address": "yelahanka",
    "city": "bangalore",
    "state": "karnatka",
    "pin": "852369",
    "phone": "7418529635",
    "email": "rajkumar@gmail.com",
    "productId": 93,
    "bidAmount": "6000.0"
}

4. Get buyer details of particular bid product --> localhost:8081/e-auction/api/v1/seller/show-bids/{productId}

   
