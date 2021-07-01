import axios from 'axios'
 export default class CandidateService {
   getCandidates () {
     return axios.get("http://localhost:8080/api/candidates/getall")
   }

   addCandidate (postReq) {
     axios.post('http://localhost:8080/api/candidates/add', postReq)
   }
 }
