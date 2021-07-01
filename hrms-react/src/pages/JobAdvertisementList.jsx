import React, {useState, useEffect} from 'react'
import { Table } from 'semantic-ui-react'
import JobAdvertisementService from '../services/JobAdvertisementService';

export default function JobAdvertisementList () {

  const [jobAdvertisements, setJobAdvertisement] = useState([])
  useEffect(()=>{
    let jobAdvertisementService = new JobAdvertisementService();
    jobAdvertisementService.getJobAdvertisements().then(result=>setJobAdvertisement(result.data.data))
  })

  return(
    <Table celled fixed singleLine>
  <Table.Header>
    <Table.Row>
      <Table.HeaderCell>Title</Table.HeaderCell>
      <Table.HeaderCell>Description</Table.HeaderCell>
      <Table.HeaderCell>Open Position</Table.HeaderCell>
      <Table.HeaderCell>Release Date</Table.HeaderCell>
      <Table.HeaderCell>City</Table.HeaderCell>
      <Table.HeaderCell>Company Name</Table.HeaderCell>
    </Table.Row>
  </Table.Header>

  <Table.Body>
    {
      jobAdvertisements.map(jobAdvertisement=>(
        <Table.Row key={jobAdvertisement.id}>
          <Table.Cell>{jobAdvertisement.jobPosition.title}</Table.Cell>
          <Table.Cell>{jobAdvertisement.jobDescription}</Table.Cell>
          <Table.Cell>{jobAdvertisement.openPositionCount}</Table.Cell>
          <Table.Cell>{jobAdvertisement.releaseDate}</Table.Cell>
          <Table.Cell>{jobAdvertisement.city.name}</Table.Cell>
          <Table.Cell>{jobAdvertisement.employer.companyName}</Table.Cell>
        </Table.Row>
      ))
    }
  </Table.Body>
</Table>
  )
}
