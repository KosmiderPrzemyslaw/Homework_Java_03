package pl.kosmider.cruddemosec9.dao;

import pl.kosmider.cruddemosec9.entity.Course;
import pl.kosmider.cruddemosec9.entity.Instructor;
import pl.kosmider.cruddemosec9.entity.InstructorDetail;
import pl.kosmider.cruddemosec9.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course course);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student student);

    void deleteStudentById(int theId);

}
