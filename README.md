# sec_c_sec_c_srikannan.esakkiappan__corejava_project_2
## Parkin
### Database Design

## Database Tables

### `Leaserdetails`

| Field           | Type          | Constraints  |
|-----------------|---------------|--------------|
| id              | INT           | PRIMARY KEY  |
| name            | VARCHAR(15)   | NOT NULL     |
| email           | VARCHAR(50)   | NOT NULL, UNIQUE |
| address         | VARCHAR(120)  | NOT NULL     |
| phonenumber     | VARCHAR(15)   | NOT NULL     |
| password        | VARCHAR(15)   | NOT NULL     |
| mapurl          | VARCHAR(150)  | NOT NULL, UNIQUE |
| placephotourl   | VARCHAR(150)  | NOT NULL     |
| lattitude       | DOUBLE        | NOT NULL     |
| longitude       | DOUBLE        | NOT NULL     |

### `Tenantdetails`

| Field           | Type          | Constraints  |
|-----------------|---------------|--------------|
| id              | INT           | PRIMARY KEY  |
| name            | VARCHAR(15)   | NOT NULL     |
| email           | VARCHAR(50)   | NOT NULL, UNIQUE |
| address         | VARCHAR(120)  | NOT NULL     |
| phonenumber     | VARCHAR(15)   | NOT NULL     |
| password        | VARCHAR(15)   | NOT NULL     |
| bikephotourl    | VARCHAR(150)  | NOT NULL     |

### `ParkingPlaceBooking`

| Field           | Type          | Constraints  |
|-----------------|---------------|--------------|
| bookingId       | INT           | PRIMARY KEY, AUTO_INCREMENT |
| leaserEmail     | VARCHAR(255)  | NOT NULL     |
| tenantEmail     | VARCHAR(255)  | NOT NULL, UNIQUE |
| startingPeriod  | DATETIME      | NOT NULL     |
| endingPeriod    | DATETIME      | NOT NULL     |
| amount          | DOUBLE        | NOT NULL     |
| status          | VARCHAR(255)  | NOT NULL     |



