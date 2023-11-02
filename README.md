# sec_c_sec_c_srikannan.esakkiappan__corejava_project_2
## Parkin
### Database Design

## Database Tables

### `Leaserdetails`

| Field           | Type          | Constraints         |
|-----------------|---------------|---------------------|
| id              | INT           | PRIMARY KEY         |
| name            | VARCHAR(15)   | NOT NULL            |
| email           | VARCHAR(50)   | NOT NULL, UNIQUE    |
| address         | VARCHAR(120)  | NOT NULL            |
| phonenumber     | VARCHAR(15)   | NOT NULL            |
| password        | VARCHAR(150)  | NOT NULL            |
| mapurl          | VARCHAR(150)  | NOT NULL, UNIQUE    |
| placephotourl   | VARCHAR(150)  | NOT NULL            |
| lattitude       | DOUBLE        | NOT NULL            |
| longitude       | DOUBLE        | NOT NULL            |


### `Tenantdetails`

| Field         | Type         | Constraints         |
|---------------|--------------|---------------------|
| id            | INT          | PRIMARY KEY         |
| name          | VARCHAR(15)  | NOT NULL            |
| email         | VARCHAR(50)  | NOT NULL, UNIQUE    |
| address       | VARCHAR(120) | NOT NULL            |
| phonenumber   | VARCHAR(15)  | NOT NULL            |
| password      | VARCHAR(150) | NOT NULL            |
| bikephotourl  | VARCHAR(150) | NOT NULL            |


### `ParkingPlaceBooking`

| Field          | Type         | Constraints         |
|----------------|--------------|---------------------|
| bookingId      | INT          | AUTO_INCREMENT, PRIMARY KEY |
| leaserId       | INT          | NOT NULL            |
| tenantName     | VARCHAR(15)  | NOT NULL            |
| tenantPhone    | VARCHAR(15)  | NOT NULL            |
| tenantEmail    | VARCHAR(50)  | NOT NULL            |
| startingPeriod | DATETIME     | NOT NULL            |
| endingPeriod   | DATETIME     | NOT NULL            |
| amount         | DOUBLE       | NOT NULL            |
| status         | VARCHAR(255) | NOT NULL            |
| tenantBikeImg  | VARCHAR(150) | NOT NULL            |




### `EER Diagram`

<img width="508" alt="Screenshot 2023-11-02 194434" src="https://github.com/fssa-batch3/sec_c_sec_c_srikannan.esakkiappan__corejava_project_2/assets/116251899/9c3bfe3c-e326-4428-b055-4ae173ace31c">

