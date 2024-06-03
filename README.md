dummy-sales-log
========================================

Random dummy sales log is automatically generated and continuously produce to the topic.


Requirements & Setup
----------------------------------------

### Requirements

- Java 21
- Docker


### Build and Run

```bash
./mvnw clean package && docker compose up --build
```


Main environment variables
----------------------------------------

| property                             | type    | default      | note                                       |
|--------------------------------------|---------|--------------|--------------------------------------------|
| `SPRING_KAFKA_BOOTSTRAPSERVERS`      | string  |              | Kafka bootstrap servers                    |
| `SPRING_KAFKA_TEMPLATE_DEFAULTTOPIC` | string  | `sales-log`  | Kafka topic name                           |
| `APP_TIMECOMPRESSION_INITIALDATE`    | date    | `1999-02-11` | Calculation start date of Sales            |
| `APP_MONITOR_ENABLED`                | boolean | `false`      | Point status monitor endpoint (`/monitor`) |
| `APP_DATA_INMEMORY_ENABLED`          | boolean | `true`       | InMemory data store enabling toggle        |
| `APP_DATA_FILE_ENABLED`              | boolean | `false`      | File data store enabling toggle            |
| `APP_DATA_FILE_PATH`                 | string  |              | File data store persistence path           |
| `LOGGING_LEVEL_COM_YO1000_SALESLOG`  | string  | `info`       |                                            |


Topic
----------------------------------------

- Default topic name: `sales-log`
- Value format: JSON

JSON layout

| property          | type   | note                  |
|-------------------|--------|-----------------------|
| id                | string |                       |
| dateTime          | string |                       |
| discount          | number |                       |
| paidPoint         | number |                       |
| paidCash          | number |                       |
| items             | array  |                       |
| items[].id        | number |                       |
| items[].name      | string |                       |
| items[].unitPrice | number |                       |
| items[].quantity  | number |                       |
| items[].subtotal  | number | unitPrice * quantity  |
| customer          | object |                       |
| customer.id       | number |                       |
| customer.name     | string |                       |
| customer.gender   | string |                       |
| total             | number | sum(items[].subtotal) |
| givenPoint        | number |                       |

Examples:

```json
{
  "id": "7314ec48-05ce-4ef3-88b9-473749acc966",
  "dateTime": "1999-03-27 04:20:29",
  "discount": 0,
  "paidPoint": 0,
  "paidCash": 31000,
  "items": [
    {
      "id": 8,
      "name": "Mega Phoenix",
      "unitPrice": 10000,
      "quantity": 3,
      "subtotal": 30000
    },
    {
      "id": 16,
      "name": "Remedy",
      "unitPrice": 1000,
      "quantity": 1,
      "subtotal": 1000
    }
  ],
  "customer": {
    "id": 4,
    "name": "Quistis",
    "gender": "FEMALE"
  },
  "total": 31000,
  "givenPoint": 310
}
```
