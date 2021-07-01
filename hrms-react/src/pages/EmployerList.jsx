import React, {useState, useEffect} from 'react'
import { Table } from 'semantic-ui-react'
import EmployerService from '../services/EmployerService';

export default function EmployerList () {

  const [employers, setEmployer] = useState([])
  useEffect(()=>{
    let employerService = new EmployerService();
    employerService.getEmployers().then(result=>setEmployer(result.data.data))
  })

  return(
    <Table celled fixed singleLine>
  <Table.Header>
    <Table.Row>
      <Table.HeaderCell>Company Name</Table.HeaderCell>
      <Table.HeaderCell>Web Site</Table.HeaderCell>
      <Table.HeaderCell>Email</Table.HeaderCell>
      <Table.HeaderCell>Phone Number</Table.HeaderCell>
    </Table.Row>
  </Table.Header>

  <Table.Body>
    {
      employers.map(employer=>(
        <Table.Row key={employer.id}>
          <Table.Cell>{employer.companyName}</Table.Cell>
          <Table.Cell>{employer.webSiteAdress}</Table.Cell>
          <Table.Cell>{employer.email}</Table.Cell>
          <Table.Cell>{employer.phoneNumber}</Table.Cell>
        </Table.Row>
      ))
    }
  </Table.Body>
</Table>
  )
}
