/api/student/getGradeByStudentId  -- приймає email і діапазон дати і повертай всі оцінки студента. Приклад запиту:
http://localhost:8080/api/student/getGradeByStudentId?email=u3@g&startDate=2022-01-01&endDate=2023-01-01

/api/student/getAbsenceByStudentId  -- приймає email і діапазон дати і повертай всі пропуски студента. Приклад запиту:
http://localhost:8080/api/student/getAbsenceByStudentId?email=u3@g&startDate=2022-01-01&endDate=2023-01-01

/api/teacher/getTeacherInfoByEmail -- приймає email викладача і повертає інформацію про нього. Приклад запиту:
http://localhost:8080/api/teacher/getTeacherInfoByEmail?email=t1@g

/api/teacher/getGroupByTeacherEmail -- приймає email викладача і повертає список його груп. Приклад запиту:
http://localhost:8080/api/teacher/getGroupByTeacherEmail?email=t914@g

/api/teacher/getStudentByStudentGroupName -- приймає id групи і повертає список студентів групи. Приклад запиту:
http://localhost:8080/api/teacher/getStudentByStudentGroupName?id=1067

/api/teacher/getGroupInfo -- приймає id групи і повертає інформацію про неї. Приклад запиту:
http://localhost:8080/api/teacher/getGroupInfo?id=1067
