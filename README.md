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

![image](https://github.com/user-attachments/assets/ef3ae4bc-06af-4694-b0a3-6a45ae95c49d)
![image](https://github.com/user-attachments/assets/8110f36f-e796-48b4-8bca-6e95e3906d01)





