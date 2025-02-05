package com.deloitte.retirement.spring.data.jpa.repository;

import com.deloitte.retirement.spring.data.jpa.entity.Guardian;
import com.deloitte.retirement.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian(){

//        Guardian guardian= Guardian.builder()
//                .name("Mukti")
//                .email("pandamukti72@gmail.com")
//                .mobile("987654321")
//                .build();
//
//        Student student= Student.builder()
//                .firstName("Shreyam")
//                .lastName("Panda")
//                .emailId("shreyamdev1999@gmail.com")
//                .guardian(guardian)
//                .build();

        Guardian guardian= Guardian.builder()
                .name("Debashree")
                .email("debashree75@gmail.com")
                .mobile("1234567890")
                .build();

        Student student= Student.builder()
                .firstName("Rahul")
                .lastName("Singh")
                .emailId("rahul@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void testFindStudentByFirstName(){
        List<Student> studentList=studentRepository
                .findByFirstName("Shreyam");
        System.out.println(studentList);
    }

    @Test
    public void testFindStudentByGuardianName(){
        List<Student> studentList=studentRepository
                .findByGuardianName("Mukti");
        System.out.println(studentList);
    }

    @Test
    public void testGetStudentByEmailAddress(){
        Student student=studentRepository
                .getStudentByEmailAddress("shreyamdev1999@gmail.com");
        System.out.println(student);
    }

    @Test
    public void testGetStudentFirstNameByEmailAddress(){
        String student=studentRepository
                .getStudentFirstNameByEmailAddress("shreyamdev1999@gmail.com");
        System.out.println(student);
    }

    @Test
    public void testGetStudentByEmailAddressNative(){
        Student student=studentRepository
                .getStudentByEmailAddressNative("rahul@gmail.com");
        System.out.println(student);
    }

    @Test
    public void testGetStudentByEmailAddressNativeQueryNamedParams(){
        Student student=studentRepository
                .getStudentByEmailAddressNativeQueryNamedParams("rahul@gmail.com");
        System.out.println(student);
    }

    @Test
    public void testUpdateStudentNameByEmailId(){
        studentRepository
                .updateStudentNameByEmailId("rahul@gmail.com","Rahul","Sharma");
    }



}