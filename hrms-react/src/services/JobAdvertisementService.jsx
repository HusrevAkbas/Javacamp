import axios from 'axios'
 export default class JobAdvertisementService {
   getAll () {
     return axios.get("http://localhost:8080/api/jobadvertisement/getall")
   }

   add (postReq) {
    axios.post('http://localhost:8080/api/jobadvertisement/add', postReq)
  .then(function (response) {
    console.log(response);
  })
   }
 }
