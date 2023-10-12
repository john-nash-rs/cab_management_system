# API cURL

## Register a driver

curl --location 'http://localhost:8080/api/users/register/driver' \
--header 'Content-Type: application/json' \
--data-raw '{
"username": "driver_username_new_2",
"password": "driver_password_new_2",
"email": "driver_email_new_2@example.com"
}'

## Register a Rider: cURL

curl --location 'http://localhost:8080/api/users/register/rider' \
--header 'Content-Type: application/json' \
--data-raw '{
"username": "rider_username",
"password": "rider_password",
"email": "rider_email@example.com"
}'

## Book a ride

curl --location 'http://localhost:8080/api/bookings/book-ride' \
--header 'Content-Type: application/json' \
--header 'Cookie: sessionid=2pamdzssnfqtyykrzim2g9w1k6a4dwej' \
--data '{
"riderId": "617192f6-a6c7-4503-bce4-7a8af86de10d"
}'

## Confirm a ride

curl --location 'http://localhost:8080/api/bookings/confirm-ride' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: sessionid=2pamdzssnfqtyykrzim2g9w1k6a4dwej' \
--data-urlencode 'riderId=617192f6-a6c7-4503-bce4-7a8af86de10d' \
--data-urlencode 'driverId=03d4b505-4447-4a7e-a30a-07e159dcdccc' \
--data-urlencode 'bookingId=1' \
--data-urlencode 'pickupLocation=Location A' \
--data-urlencode 'dropoffLocation=Location B'

## Cancel a ride

curl --location --request POST 'http://localhost:8080/api/bookings/cancel-booking/2' \
--header 'Cookie: sessionid=2pamdzssnfqtyykrzim2g9w1k6a4dwej'

## Make a payment

curl --location 'http://localhost:8080/api/bookings/make-payment/1' \
--header 'Content-Type: application/json' \
--header 'Cookie: sessionid=2pamdzssnfqtyykrzim2g9w1k6a4dwej' \
--data '{
"amount": 50.0
}'

## Post the rating

curl --location --request POST 'http://localhost:8080/api/users/rating' \
--header 'Content-Type: application/json' \
--data '{
"userId": 2,
"rating": 4.7,
"review": "Professional driver!"
}'

## Get the rating

curl --location --request GET 'http://localhost:8080/api/users/rating/2'

