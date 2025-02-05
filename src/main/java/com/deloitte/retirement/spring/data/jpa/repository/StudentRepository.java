package com.deloitte.retirement.spring.data.jpa.repository;

import com.deloitte.retirement.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    List<Student> findByFirstNameAndLastName(String firstName,String lastName);

    //JPQL
    @Query("Select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("Select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String firstName);

    //Native Query
    @Query(value = "Select * from tbl_student s where s.email_address= ?1",
            nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    //Query Named Params
    @Query(value = "Select * from tbl_student s where s.email_address= :emailId",
            nativeQuery = true)
    Student getStudentByEmailAddressNativeQueryNamedParams(@Param("emailId") String emailId);

    @Transactional
    @Modifying
    @Query(value = "Update tbl_student s set s.first_name=:firstName , s.last_name=:lastName where s.email_address=:emailId",
            nativeQuery = true)
    int updateStudentNameByEmailId(String emailId,String firstName, String lastName);
}
