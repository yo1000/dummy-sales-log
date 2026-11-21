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
| `APP_THREAD_NOISESPERSEC`            | integer | `0`          | Number of non-member sales per sec         |
| `APP_MEMBER_MAXID`                   | integer | `500000`     | Members are chosen from IDs `1..MAXID`     |
| `APP_MEMBER_PURCHASESPERSEC`         | integer | `3`          | Number of member sales per sec             |
| `APP_MEMBER_THREADS`                 | integer | `16`         | Threads for member sales                   |
| `APP_CATALOG_LOCATION`               | string  | `classpath:data/` | Location of brands/genres/products CSV |
| `APP_DATA_TYPE`                      | string  | `mem`        | Data store type (`mem`, `db`, `file`)      |
| `APP_DATA_FILE_PATH`                 | string  |              | Data storing file path (`file` type only)  |
| `SPRING_DATASOURCE_URL`              | string  |              | DB connection url (`db` type only)         |
| `SPRING_DATASOURCE_USERNAME`         | string  |              | DB connection username (`db` type only)    |
| `SPRING_DATASOURCE_PASSWORD`         | string  |              | DB connection password (`db` type only)    |
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
| items[].id        | number | Product ID            |
| items[].name      | string | Product name          |
| items[].color     | string | Color / pattern (may be empty) |
| items[].brand     | object |                       |
| items[].brand.id  | number | Brand ID              |
| items[].brand.name | string | Brand name           |
| items[].genre     | object |                       |
| items[].genre.id  | number | Genre ID              |
| items[].genre.name | string | Genre name           |
| items[].unitPrice | number |                       |
| items[].quantity  | number |                       |
| items[].subtotal  | number | unitPrice * quantity  |
| customer          | object | `null` for non-members |
| customer.id       | number | Member ID             |
| total             | number | sum(items[].subtotal) |
| givenPoint        | number |                       |

Examples:

```json
{
  "id": "52cad3c7-3584-4227-a899-73a28db2d765",
  "dateTime": "1999-02-11 10:00:00",
  "discount": 0,
  "paidPoint": 0,
  "paidCash": 27500,
  "items": [
    {
      "id": 45982,
      "name": "オーバーサイズスウェット",
      "color": "ネイビー",
      "brand": {
        "id": 106,
        "name": "ビーゼク"
      },
      "genre": {
        "id": 1,
        "name": "トップス"
      },
      "unitPrice": 11000,
      "quantity": 1,
      "subtotal": 11000
    },
    {
      "id": 45962,
      "name": "ワイドチノパンツ",
      "color": "ベージュ",
      "brand": {
        "id": 106,
        "name": "ビーゼク"
      },
      "genre": {
        "id": 2,
        "name": "パンツ"
      },
      "unitPrice": 16500,
      "quantity": 1,
      "subtotal": 16500
    }
  ],
  "customer": {
    "id": 264589
  },
  "total": 27500,
  "givenPoint": 275
}
```


Catalog
----------------------------------------

Brands, genres and products are loaded from CSV files in `APP_CATALOG_LOCATION`
(`brands.csv`, `genres.csv`, `products.csv`). The bundled data is in `src/main/resources/data`.


Buying patterns
----------------------------------------

Members are chosen at random from IDs `1..APP_MEMBER_MAXID`.
Each member's patterns are calculated from the member ID, so the same member always behaves the same way.

`BuyingPattern.forCustomer(id)`

| Brand combination        | Ratio | Behavior                                         |
|--------------------------|-------|--------------------------------------------------|
| `SINGLE_BRAND`           | 3/10  | Buys only from the main brand                    |
| `MAIN_BRAND_WITH_OTHERS` | 5/10  | 80% from the main brand, 20% from other brands   |
| `VARIOUS_BRANDS`         | 2/10  | Buys from various brands at random               |

| Budget       | Ratio  | Target total per sale |
|--------------|--------|-----------------------|
| `SUPER_HIGH` | 1/100  | 300,000 - 2,000,000   |
| `HIGH`       | 9/100  | 80,000 - 300,000      |
| `MIDDLE`     | 70/100 | 10,000 - 80,000       |
| `LOW`        | 20/100 | 1,000 - 10,000        |

The main brand is chosen from brands that fit the budget, weighted by the brand coefficient.

`PointBehaviorPattern.forCustomer(id)`

| Point behavior           | Ratio |
|--------------------------|-------|
| `NOT_USE`                | 1/50  |
| `RANDOM`                 | 20/50 |
| `FULL_PAYMENT_ONLY`      | 20/50 |
| `EXPENSIVE_PAYMENT_ONLY` | 3/50  |
| `FRACTIONS_ONLY`         | 6/50  |

Non-member sales (`customer: null`) draw a buying pattern at random for each sale and never use points.
