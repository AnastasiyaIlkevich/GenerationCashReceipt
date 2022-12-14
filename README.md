<h1 align="center">Generation cash receip</h1>
<h2 align="center">Тестовое задание на курс backend-разработка</h2>



## Содержание
* Описание задачи
* Инструменты и технологии
* Старт программы
* API
* Задачи дальнейшей реализации проекта - TODO

## Описание задачи
### [📝 Задание](./Docum/Backend_dev_course_tesy.pdf) 

## Инструменты и технологии
  - IntelliJ IDEA
  - Docker Desktop
  - Postman
- Внедрённые:
  - JDK 17
  - Gradl 7.5
  - Springboot
  - Spring Web
  - Spring Data JPA
  - Hibernate
  - PostgreSQL
  - Logging
  - Liquibase
  - Swagger (не заработал)
  - TODO
- Внедряемые:
  - JUnit
  - Docker (Первое освоение. Разбираюсь с настройками.)
  
  
  ## Старт программы

1. Клонируйте этот репозиторий командой:
```sh
$ git clone https://github.com/AnastasiyaIlkevich/GenerationCashReceipt.git
```
2. В IntelliJ IDEA соберите проект в формате jar. Для этого выполните следующие действия:
	- откройте build.gradle:
	- запустите bootJar - ___Run___.

3. Запуск:
	- откройте папку с проектом …\generationCashReceipt\build\libs
	- Запустите командную строку в этой папке и введите для старта команду:
  ```sh
java -jar generation-0.0.1-SNAPSHOT.jar
```
  - Для тестирования rest controller пройдите по одному из ниже предложенных вариантов http://localhost:8080/"..."
  
  |Значение “...”|RestController|
|----|-----|
|receipt|CashReceiptController| 
|discount|DiscountCardController| 
|product|ProductController| 
|shop|ShopInfoController|

  ## API

## CashReceiptController localhost:8080/receipt: 
Методы работы GET/POST/PUT/DELETE.
### Method : GET
localhost:8080/receipt - представляет список Cash Receipt (далее - чек).

localhost:8080/receipt/{id} - предоставляет конкретный чек.
### Method : POST
localhost:8080/receipt - создаёт новый чек, распечатывает (не до конца реализовано) и сохраняет в txt файле (не до конца реализовано).
На данный момент, в чек будет записана информация дефолтного магазина.
__RequestBody__ :
 {
 "setProduct": [{
                "id","name"
            }],
 "discountCard": {
            "id",
            "cardNumber"
        }
 }
 
 ### Method : POST
localhost:8080/receipt/shop/{id} - создаёт новый чек, распечатывает (не до конца реализовано) и сохраняет в txt файле (не до конца реализовано).
Указания Id shop изменяет дефолтное значение магазина на нужное вам. На для этого сначала эту информацию нужно внести.
__RequestBody__ :
 {
 "setProduct": [{
                "id","name"
            }],
 "discountCard": {
            "id",
            "cardNumber"
        }
 }


### Method : PUT
localhost:8080/receipt/{id} - изменяет чек (не реализовано)

__RequestBody__ :
  {
        "dateCreation",
        "setProduct": [
            {
                "id"
                "name"
                "price"
            }
        ],
        "shopInfo": {
            "id",
            "shopName",
            "address",
            "phoneNumber"
        },
        "discountCard": {
            "id",
            "cardNumber",
            "discount"
        }
    },
   
    }

### Method : DELETE
localhost:8080/receipt/{id} - удаляет чек по id

## DiscountCardController localhost:8080/discount: 
Методы работы GET/POST/PUT/DELETE.
### Method : GET
localhost:8080/discount - представляет список Discount Card (далее - карт).

localhost:8080/discount/{id} - предоставляет конкретный карту.
### Method : POST
localhost:8080/discount - создаёт новую карту с указанной скидкой.

__RequestBody__ :
 {
 "discountCard": {
            "cardNumber",
            "discount"
        }
 }

### Method : PUT
localhost:8080/discount/{id} - изменяет карту

__RequestBody__ :
 {
 "discountCard": {
            "cardNumber",
            "discount"
        }
 }

### Method : DELETE
localhost:8080/discount/{id} - удаляет карту по id

## ProductController localhost:8080/product: 
Методы работы GET/POST/PUT/DELETE.
### Method : GET
localhost:8080/product - представляет список Product (далее - товар).

localhost:8080/product/{id} - предоставляет конкретный товар.
### Method : POST
localhost:8080/product - создаёт новый товар.

__RequestBody__ :
{
                "name",
                "price"
            }

### Method : PUT
localhost:8080/product/{id} - изменяет данные товара.

__RequestBody__ :
 {
                "name",
                "price"
            }


### Method : DELETE
localhost:8080/product/{id} - удаляет товар по id

## ShopInfoController localhost:8080/shop: 
Методы работы GET/POST/PUT/DELETE.
### Method : GET
localhost:8080/shop - представляет список  Shop (далее - магазин).

localhost:8080/shop/{id} - предоставляет конкретный магазинов.
### Method : POST
localhost:8080/shop - создаёт новый магазин.

__RequestBody__ :
{
                "hopName", 
                 "address", 
                  "phoneNumber"
            }

### Method : PUT
localhost:8080/shop/{id} - изменяет данные магазина.

__RequestBody__ :
 {
                "hopName", 
                 "address", 
                  "phoneNumber"
            }


### Method : DELETE
localhost:8080/shop/{id} - удаляет магазин по id

  ## Задачи дальнейшей реализации проекта - TODO

  - TODO  - create logic for calculating prices and discounts.
  - TODO  -Create a product print on the receipt
  - TODO  -Create a print of the price and discount on the receipt
  - TODO  -Create Tests

