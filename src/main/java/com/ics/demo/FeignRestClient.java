package com.ics.demo;

import com.ics.demo.models.Appointment;
import com.ics.demo.models.Company;
import com.ics.demo.models.Movie;
import com.ics.demo.models.Student;
import feign.Param;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@FeignClient(name = "client", url = "http://10.51.10.111:9090")


@FeignClient(name = "client", url = "http://10.51.10.111:2000", configuration = FeignConfig.class)
public interface FeignRestClient {

    @RequestMapping(method = RequestMethod.GET,value = "movies")
    List<Movie> getAllMovies();

    @RequestMapping(method = RequestMethod.GET,value = "movies/{id}")
    Movie findById(@PathVariable(name = "id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "movies")
    Movie createMovie(@RequestBody Movie movie);

    @RequestMapping(method = RequestMethod.POST, value = "companies/{companyid}/attachments")
    Student findbyId(@PathVariable(name = "studentid") Long id);

    @RequestMapping(method = RequestMethod.PATCH, value = "movies/{id}")
    Movie update(@PathVariable("id") Long id,@RequestBody Movie movie);

    @RequestMapping(method = RequestMethod.GET, value = "companies")
    List<Company> getallCompanies() ;

    @RequestMapping(method = RequestMethod.GET, value = "companies/{companyId}/departments")
    Company findbyId(@PathVariable("companyId") Long id, @RequestParam(name = "studentId") Long studentId);

    @

    @RequestMapping(method = RequestMethod.PATCH, value = "companies/{companyId}/attachments")
    Company AllocateDepartment(@PathVariable("studentId") Long id, @RequestParam(name = "departmentId") Long departmentId);

    @RequestMapping(method = RequestMethod.POST, value = "students")
    Student createStudent(@RequestBody Student student);


    @RequestMapping(method = RequestMethod.POST, value = "appointments")
    Appointment createAppointment(@RequestBody Appointment appointment);

    @RequestMapping(method = RequestMethod.PATCH, value = "appointments/{appointmentId}")
    Appointment ConfirmAppointment(@PathVariable("appointmentId") Long id,@RequestParam(name = "studentId") Long studentId);


}
