package sej.springexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sej.springexample.model.School;
import sej.springexample.model.Student;
import sej.springexample.repository.SchoolRepository;
import sej.springexample.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service //컨트롤러도 아니고 내부에서 자바 로직을 처리하는 클래스
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void findStudentInfo() {
        School school = new School("banigo");
        schoolRepository.save(school);

        Student stu1 = new Student("girin");
        Student stu2 = new Student("deajee");
        Student stu3 = new Student("bani");

        stu1.setSchool(school);
        stu2.setSchool(school);
        stu3.setSchool(school);

        studentRepository.save(stu1);
        studentRepository.save(stu2);
        studentRepository.save(stu3);

        List<Student> students = studentRepository.findAll();

        for (Student s: students) {
            System.out.println(s.getUserName() + ", " + s.getSchool().getName());
        }
    }

    @Transactional
    public void findSchoolInfo() {
        School sc1 = new School("art go");
        sc1.registerStudent(new Student("hong"));
        sc1.registerStudent(new Student("Yu"));

        School sc2 = new School("gwa go");
        sc2.registerStudent(new Student("nara"));
        sc2.registerStudent(new Student("minha"));

        schoolRepository.save(new HashSet<School>(){{
            add(sc1);
            add(sc2);
        }});

        List<School> schools = schoolRepository.findAll();

        for (School s : schools) {
            System.out.println(s.toString());
        }
    }


}
