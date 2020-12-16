# gateManagerTask
Gate Manager Task


used technologies:

-Java 8
-Maven
-MySQL 8
-Spring Boot


Authorization: in header
--header 'Authorization: L8qq9PZyRg6ieKGEKhZolGC0vJWLw8iEJ88DRdyOg'

Request:

curl --location --request GET 'localhost:9095/api/v1/gatemanager/flights?number=fl1' \
--header 'Authorization: L8qq9PZyRg6ieKGEKhZolGC0vJWLw8iEJ88DRdyOg'

Responses:



{
    "results": {
        "flightNumber": "fl1",
        "gateNumber": "gt1",
        "arrivalTime": "2020-06-01T11:49:39"
    },
    "code": "200.000.001",
    "message": "Gate is available"
}

=============================================


{
    "code": "200.403.003",
    "message": "Gate unavailable"
}


Request:

curl --location --request PATCH 'localhost:9095/api/v1/gatemanager/gates/gt1' \
--header 'Authorization: L8qq9PZyRg6ieKGEKhZolGC0vJWLw8iEJ88DRdyOg' \
--header 'Content-Type: application/json' \
--data-raw '{
    "available": true,
    "unavailableFrom": "16:00:00",
    "unavailableTo": "18:00:00"
}'


Response:

{
    "results": {
        "gateNumber": "gt1",
        "available": true,
        "unavailableFrom": "16:00:00",
        "unavailableTo": "18:00:00"
    },
    "code": "200.403.002",
    "message": "Gate updated"
}
