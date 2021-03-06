import React, {useState, useEffect} from 'react'
import { Form, Input, TextArea, Button, Select } from 'semantic-ui-react'
import { useFormik } from 'formik'
import CityService from '../services/CityService';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import JobPositionService from '../services/JobPositionService';
import JobAdvertisementService from '../services/JobAdvertisementService';

export default function JobAdvertisementAdd () {

    const [jobPositions, setjobPosition] = useState([])

    useEffect(()=>{
      let jobPositionService = new JobPositionService();
      jobPositionService.getJobPositions().then(result=>setjobPosition(result.data.data))
    },[])

    const jobPositionOptions = jobPositions.map((pos)=> {
      let obj = {key: pos.title, text: pos.title, value: pos};
      return obj;
    })

    const [cities, setCity] = useState([])
    useEffect(()=>{
      let cityService = new CityService();
      cityService.getCities().then(result=>setCity(result.data.data))
    },[])

    const cityOptions = cities.map((city)=> {
      let obj = {key: city.name, text: city.name, value: city};
      return obj;
    })

    const setDate=(value)=>{
      var date = value.getDate();
      if(date<10){
        date = "0" + date;
      }
      var month = value.getMonth() + 1;
      if(month<10){
        month = "0" + month;
      }
      var year = value.getFullYear();
      // You can turn it in to your desired format
      return date + '-' + month + '-' + year;//format: dd-mm-yyyy;
    }

  const formik = useFormik({
    initialValues: {
      jobPosition: {id:"", title:""},
      city: {id:"", name:""},
      openPositionCount: "",
      jobDescription: "React test ",
      minimumSalary: "",
      maximumSalary: "",
      activeState: false,
      workPlaceType: "",
      workTimeType: "",
      employer: {id:75},
      releaseDate: setDate(new Date()),
      applicationDeadline: setDate(new Date())
    },
    onSubmit: formData => {
      console.log(JSON.stringify(formData.applicationDeadline,null,2))
      const jobAdvertisementService = new JobAdvertisementService();
      jobAdvertisementService.add(formData);
    }
  })

  // const handleDropdownBlur = (e, { name, value }) => formik.setFieldTouched(name, value);
  const handleDropdownChange = (e, { name, value }) => formik.setFieldValue(name, value);

  return(
  <Form onSubmit = {formik.handleSubmit}>
    <Form.Group widths='equal'>
      <Form.Field
        id="jobPosition"
        name="jobPosition"
        control={Select}
        options={jobPositionOptions}
        label={{ children: '???? Pozisyonu', htmlFor: 'form-select-control-jobPosition' }}
        placeholder='??ehir giriniz'
        search
        searchInput={{ id: 'form-select-control-jobPosition'}}
        onChange = {handleDropdownChange}
      />
      <Form.Field
        id='openPositionCount'
        name="openPositionCount"
        control={Input}
        label='A????k pozisyon say??s??'
        placeholder=''
        onChange= {formik.handleChange}
        value= {formik.values.openPositionCount}
      />
      <Form.Field
        id="city"
        name="city"
        control={Select}
        options={cityOptions}
        label={{ children: '??ehir', htmlFor: 'form-select-control-cityId' }}
        placeholder='??ehir giriniz'
        search
        searchInput={{ id: 'form-select-control-cityId'}}
        onChange = {handleDropdownChange}
      />
      <Form.Field>
        <label>applicationDeadline</label>
        <DatePicker
          onChange={(date) => formik.setFieldValue('applicationDeadline', setDate(date))}
          value={formik.values.applicationDeadline}
        />
      </Form.Field>
    </Form.Group>
    <Form.Field
      id='jobDescription'
      name="jobDescription"
      control={TextArea}
      label='???? A????klamas??'
      placeholder='????i buraya tan??mlay??n??z'
      onChange = {formik.handleChange}
      value= {formik.values.jobDescription}
    />
    <Form.Group widths="equal">
      <Form.Field
        id='minimumSalary'
        name="minimumSalary"
        control={Input}
        label='Minimum ??cret'
        placeholder=''
        onChange= {formik.handleChange}
        value= {formik.values.minimumSalary}
      />
      <Form.Field
        id='maximumSalary'
        name="maximumSalary"
        control={Input}
        label='Maksimum ??cret'
        placeholder=''
        onChange= {formik.handleChange}
        value= {formik.values.maximumSalary}
      />
      <Form.Field
        id="workPlaceType"
        name="workPlaceType"
        control={Select}
        options={[
          { key: 'r', text: 'Uzaktan ??al????ma', value: 'remote'},
          { key: 'o', text: 'Ofiste ??al????ma', value: 'office'}
        ]}
        label={{ children: '??al????ma Mekan??', htmlFor: 'form-select-control-workPlaceType' }}
        placeholder='??al????ma mekan?? se??iniz'
        search
        searchInput={{ id: 'form-select-control-workPlaceType', name: 'city' }}
        onChange = {handleDropdownChange}
      />
      <Form.Field
        id="workTimeType"
        name="workTimeType"
        control={Select}
        options={[
          { key: 'p', text: 'Yar?? zamanl??', value: 'parttime'},
          { key: 'f', text: 'Tam zamanl??', value: 'fulltime'}
        ]}
        label={{ children: '??al????ma Zaman??', htmlFor: 'form-select-control-workTimeType' }}
        placeholder='??al????ma zaman?? se??iniz'
        search
        searchInput={{ id: 'form-select-control-workTimeType', name: 'city' }}
        onChange = {handleDropdownChange}
      />
    </Form.Group>
    <Form.Group widths="equal">
      <Form.Field
        id='form-button-control-public'
        name="confirm"
        type="submit"
        control={Button}
        content='Confirm'
      />
      <Form.Field
        id='reset'
        name="reset"
        control={Button}
        content='Reset'
        onClick = { formik.handleReset }
      />
    </Form.Group>
  </Form>
)
}
