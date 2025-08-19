POST - http://localhost:8080/api/student/create

{
 "firstName": "Sunil",
 "lastName": "Joseph",
 "email": "sunil@gmail.com",
 "street": "Ameerpet",
 "city": "Hyderabad",
 "subjectsLearning": [
    {
      "subjectName": "Mathematics",
      "marksObtained": 98.5
    },
    {
      "subjectName": "Physics",
      "marksObtained": 87.5
    },
    {
      "subjectName": "Chemistry",
      "marksObtained": 90.5
    }
  ]
}


Case-2 : GET - http://localhost:8080/api/student/getAll

Case-3 : GET - http://localhost:8080/api/student/getFirstNameById/2   -- returns firstName 

Case-4 : GET - http://localhost:8080/api/student/getLastNameById/1

