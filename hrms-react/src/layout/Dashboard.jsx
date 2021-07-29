import React from 'react'
import Sidebar from './Sidebar';
import { Grid } from 'semantic-ui-react'
import CandidateList from '../pages/CandidateList';
import EmployerList from '../pages/EmployerList';
import JobAdvertisementList from '../pages/JobAdvertisementList';
import JobAdvertisementAdd from '../pages/JobAdvertisementAdd';

export default function Dashboard () {
  return (
    <div className="dashboard">
      <Grid>
        <Grid.Row>
          <Grid.Column width={3}>
            <Sidebar/>
          </Grid.Column>
          <Grid.Column width={13}>
            <JobAdvertisementAdd/>
            <CandidateList/>
            <EmployerList/>
            <JobAdvertisementList/>
          </Grid.Column>
        </Grid.Row>
      </Grid>
    </div>
  );
}
