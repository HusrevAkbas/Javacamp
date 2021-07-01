import axios from 'axios'
 export default class EmployerService {
   getEmployers () {
     return axios.get("http://localhost:8080/api/employers/getall")
   }

   addEmployer (postReq) {
     axios.post('http://localhost:8080/api/employers/add', postReq)
   }
 }
