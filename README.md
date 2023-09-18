# sec_c_sec_c_srikannan.esakkiappan__corejava_project_2
## Parkin
### Database Design

## userdetails Table

| Column          | Data Type | Constraints                         |
|-----------------|-----------|-------------------------------------|
| id              | INT       | NOT NULL, AUTO_INCREMENT, PRIMARY KEY |
| name            | VARCHAR   | NOT NULL                            |
| email           | VARCHAR   | NOT NULL, UNIQUE                    |
| address         | VARCHAR   | NOT NULL                            |
| phonenumber     | VARCHAR   | NOT NULL                            |
| password        | VARCHAR   | NOT NULL                            |
| mapurl          | VARCHAR   | NOT NULL, UNIQUE                    |
| placephotourl   | VARCHAR   | NOT NULL                            |

## Tenantdetails Table

| Column          | Data Type | Constraints                         |
|-----------------|-----------|-------------------------------------|
| id              | INT       | NOT NULL, AUTO_INCREMENT, PRIMARY KEY |
| name            | VARCHAR   | NOT NULL                            |
| email           | VARCHAR   | NOT NULL, UNIQUE                    |
| address         | VARCHAR   | NOT NULL                            |
| phonenumber     | VARCHAR   | NOT NULL                            |
| password        | VARCHAR   | NOT NULL                            |
| bikephotourl    | VARCHAR   | NOT NULL                            |



