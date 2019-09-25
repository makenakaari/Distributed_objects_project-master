package com.ics.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull(groups = Movie.Update.class)
    private Long id;
    private int companyId;
    private int studentId;
    private int departmentId;

    public Company(int companyId){
        this.companyId = companyId;

    }

    public int getCompanyId(){ return companyId};

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return departmentId;
    }

    public void setTeacherId(int teacherId) {
        this.departmentId = teacherId;
    }
}
