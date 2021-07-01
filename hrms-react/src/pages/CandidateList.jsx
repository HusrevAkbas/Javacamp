import React, {useState, useEffect} from 'react'
import { Table } from 'semantic-ui-react'
import CandidateService from '../services/CandidateService';

export default function CandidateList () {

  const [candidates, setCandidate] = useState([])
  useEffect(()=>{
    let candidateService = new CandidateService();
    candidateService.getCandidates().then(result=>setCandidate(result.data.data))
  })

  return(
    <Table celled fixed singleLine>
  <Table.Header>
    <Table.Row>
      <Table.HeaderCell>Name</Table.HeaderCell>
      <Table.HeaderCell>Birth Year</Table.HeaderCell>
      <Table.HeaderCell>Email</Table.HeaderCell>
    </Table.Row>
  </Table.Header>

  <Table.Body>
    {
      candidates.map(candidate=>(
        <Table.Row key={candidate.id}>
          <Table.Cell>{candidate.firstName +' '+candidate.lastName}</Table.Cell>
          <Table.Cell>{candidate.birthYear}</Table.Cell>
          <Table.Cell>{candidate.email}</Table.Cell>
        </Table.Row>
      ))
    }
  </Table.Body>
</Table>
  )
}
