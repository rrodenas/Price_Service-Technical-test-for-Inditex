# Price Service - Technical Test for Inditex

This is a **Spring Boot REST API** that retrieves the correct product price based on the requested date, product ID, and brand ID.  
It uses an **H2 in-memory database** and applies priority rules to select the applicable price.

---

## 🔧 Technologies Used
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data JPA**
- **H2 Database**
- **JUnit 5**
- **Maven**

---

## 🚀 API Endpoint
### `GET /prices`

**Query Parameters:**
- `productId` → Product ID  
- `brandId` → Brand ID  
- `date` → Date in format `yyyy-MM-dd'T'HH:mm:ss`

#### Example Request:
```bash
GET http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14T16:00:00

#### Example Response:
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 2,
    "startDate": "2020-06-14T15:00:00",
    "endDate": "2020-06-14T18:30:00",
    "price": 25.45,
    "currency": "EUR"
}





