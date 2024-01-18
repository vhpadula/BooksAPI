# BooksAPI
API created for getting used to Spring 3

## Lesson 1: Initial Architecture and API Implementation
Added initial arquitecture. It contains packages for the models, controllers, repositories, services, dto, util and unit testing for each of them. Added mocked database to resources. 
The API now is able to do CRUD operations for books, and also Get and Create reviews for the respective books.
Each book is stored in a SQL database with the attributes correlated in the Book.java in the 'model' package.
The reviews are stored in a separate table with a foreign key to the associated book_id.
The Unit tests all passed and the API was tested in Postman.

- Get All Books:
![image](https://github.com/vhpadula/BooksAPI/assets/64943143/a9b3729d-7b39-4cf3-84c8-66f78b1ad5c9)

- Get Book by ID:
![image](https://github.com/vhpadula/BooksAPI/assets/64943143/00e1a8e8-d077-4b3f-a76b-8e8a76551077)

- Create Book:
![image](https://github.com/vhpadula/BooksAPI/assets/64943143/8ee1f56a-4968-49f8-89f3-219bf151e2b9)

- Update Book:
![image](https://github.com/vhpadula/BooksAPI/assets/64943143/f7ca094c-92c4-4a8f-bc01-f8496f4fcd10)

- Delete Book:
![image](https://github.com/vhpadula/BooksAPI/assets/64943143/bb12d79c-e6ec-4fa9-a883-951a494743f5)

- Get Reviews By Book ID:
![image](https://github.com/vhpadula/BooksAPI/assets/64943143/fd906ec3-6834-454d-bd94-ae08af12e9ce)

- Create Review For Book ID:
![image](https://github.com/vhpadula/BooksAPI/assets/64943143/b7eab542-eb23-4a2f-9950-f378deff1804)
