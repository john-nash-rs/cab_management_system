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
"riderId": "d0da57bd-6f70-4b59-8c03-fbd474883838"
}'

## Confirm a ride

curl --location 'http://localhost:8080/api/bookings/confirm-ride' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: sessionid=2pamdzssnfqtyykrzim2g9w1k6a4dwej' \
--data-urlencode 'riderId=d0da57bd-6f70-4b59-8c03-fbd474883838' \
--data-urlencode 'driverId=d0b5ffa4-b177-46be-b4c2-41787a66279e' \
--data-urlencode 'bookingId=1' \
--data-urlencode 'pickupLocation=Location A' \
--data-urlencode 'dropoffLocation=Location B'

## Cancel a ride

curl --location --request POST 'http://localhost:8080/api/bookings/cancel-booking/2' \
--header 'Cookie: sessionid=2pamdzssnfqtyykrzim2g9w1k6a4dwej'

## Make a payment

curl --location 'http://localhost:8080/api/bookings/make-payment/2' \
--header 'Content-Type: application/json' \
--header 'Cookie: sessionid=2pamdzssnfqtyykrzim2g9w1k6a4dwej' \
--data '{
"amount": 50.0
}'