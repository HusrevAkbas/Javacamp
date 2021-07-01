import axios from 'axios'
 export default class JobAdvertisementService {
   getJobAdvertisements () {
     return axios.get("http://localhost:8080/api/jobadvertisement/getall")
   }

    addEmployer (postReq) {
      axios.post('http://localhost:8080/api/jobadvertisement/add', postReq)
    }
 }
