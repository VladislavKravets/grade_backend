OpenApi: http://localhost:8080/swagger-ui/index.html

/api/student/getGradesByStudentEmail  -- приймає email і діапазон дати і повертай всі оцінки студента. Приклад запиту:
http://localhost:8080/api/student/getAbsencesByStudentEmail?email=s30001@g&startDate=2022-01-01&endDate=2023-01-01
<br>Повертає:
[{"grade":96,"courseCourseNameName":"Колоїдна хімія","createdAt":"2022-06-11T15:00:43.19027+03:00"},{"grade":10,"courseCourseNameName":"Іноземна мова (за професійним спрямуванням)","createdAt":"2022-02-23T01:59:27.324908+02:00"}]

/api/student/getAbsencesByStudentEmail -- приймає email і діапазон дати і повертай всі пропуски студента. Приклад запиту:
http://localhost:8080/api/student/getAbsencesByStudentEmail?email=s30001@g&startDate=2022-01-01&endDate=2023-01-01
<br>Повертає:
[{"courseCourseNameName":"Практика першої мови (англійська)","data":"2022-05-27T12:00:44.505792+03:00"},{"courseCourseNameName":"Ботаніка","data":"2022-09-11T07:41:42.345805+03:00"}]

/api/teacher/getTeacherInfoByEmail -- приймає email викладача і повертає інформацію про нього. Приклад запиту:
http://localhost:8080/api/teacher/getTeacherInfoByEmail?email=t1@g
<br>Повертає:
{"name":"Станіслав","patronimic":"Михайлович","sex":"MALE","surname":"Первунінський","active":true,"departmentName":"програмного забезпечення автоматизованих систем","departmentFacultyName":"факультет інформаційних технологій і систем","positionName":"професор","scientificDegreeName":"доктор технічних наук"}

/api/teacher/getGroupByTeacherEmail -- приймає email викладача і повертає список його груп. Приклад запиту:
http://localhost:8080/api/teacher/getGroupByTeacherEmail?email=t914@g
<br>Повертає:
[{"id":1067,"name":"Т-71"},{"id":1405,"name":"ГРС-82"},{"id":1070,"name":"ГРС-72"},{"id":1683,"name":"ГРС-92"},{"id":1685,"name":"ЗГРС-92"},{"id":1082,"name":"ЗГРС-72"},{"id":1404,"name":"Т-81"}]

/api/teacher/getStudentsByStudentGroupId -- приймає id групи і повертає список студентів групи. Приклад запиту:
http://localhost:8080/api/teacher/getStudentsByStudentGroupId?id=1067
<br>Повертає:
[{"name":"Лариса","patronimic":"Альбертович","surname":"Абуеіда","email":"s30886@g"},{"name":"Свєта","patronimic":"Мухамметисламович","surname":"Бобилєв","email":"s31136@g"}]

/api/teacher/getGroupInfo -- приймає id групи і повертає інформацію про неї. Приклад запиту:
http://localhost:8080/api/teacher/getGroupInfo?id=1067
<br>Повертає:
{"name":"Т-71","active":true,"beginYears":1,"creationYear":2017,"studySemesters":8,"studyYears":3.84,"specializationName":"Туризм","specializationDegreeName":"Бакалавр","specializationDepartmentName":"туризму та готельно-ресторанної справи","specializationFacultyName":"факультет харчових технологій та сфери обслуговування","specializationSpecialityName":"Туризм","specializationProgramHeadName":"Світлана","specializationProgramHeadPatronimic":"Станіславівна","specializationProgramHeadSurname":"Бєляєва"}

17.04.2023
getStudentByStudentGroupName -> getStudentsByStudentGroupId
getGradeByStudentId -> getGradesByStudentEmail
getAbsenceByStudentId -> getAbsencesByStudentEmail