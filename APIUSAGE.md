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