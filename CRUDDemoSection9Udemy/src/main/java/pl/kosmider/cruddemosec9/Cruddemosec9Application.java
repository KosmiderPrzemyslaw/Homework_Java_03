package pl.kosmider.cruddemosec9;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kosmider.cruddemosec9.dao.AppDAO;
import pl.kosmider.cruddemosec9.entity.Course;
import pl.kosmider.cruddemosec9.entity.Instructor;
import pl.kosmider.cruddemosec9.entity.InstructorDetail;

import java.util.List;

@SpringBootApplication
public class Cruddemosec9Application {

    public static void main(String[] args) {
        SpringApplication.run(Cruddemosec9Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createInstructor(appDAO);

            //findInstructor(appDAO);

            deleteInstructor(appDAO);

            //findInstructorDetailById(appDAO);

            //deleteInstructorDetail(appDAO);

            //createInstructorWithCourses(appDAO);

            //findInstructorWithCourses(appDAO);

            //findCoursesForInstructor(appDAO);

            //findInstructorWithCoursesJoinFetch(appDAO);

            //updateInstructor(appDAO);

            //updateCourse(appDAO);


        };
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;

        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("Enjoy the Simple Things");

        appDAO.update(tempCourse);

        System.out.println("DONE");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;

        //find the instructor

        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        //update the instructor

        System.out.println("Updating instructor:  " + theId);
        tempInstructor.setLastName("Test");

        appDAO.update(tempInstructor);

        System.out.println("DONE !");

    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;

        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("DONE");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor instructorById = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor " + instructorById);

        // find courses for instructor

        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        instructorById.setCourses(courses);
        System.out.println("The associated courses: " + instructorById.getCourses());

        System.out.println("DONE!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor instructorById = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor " + instructorById);
        System.out.println("the associated courses: " + instructorById.getCourses());

        System.out.println("DONE!");

    }

    private void createInstructorWithCourses(AppDAO appDAO) {


        Instructor tempInstructor = new Instructor
                ("Susan", "Public", "susanpublic.lov@.com");

        InstructorDetail instructorDetail = new InstructorDetail
                ("yotobe_susan//", "video games");

        tempInstructor.setInstructorDetail(instructorDetail);

        //create some courses

        Course tempCourse1 = new Course("Guitar - the ultimate guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");
        Course tempCourse3 = new Course("Swim - How to swim");
        Course tempCourse4 = new Course("Sing - how to sing");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);
        tempInstructor.add(tempCourse3);
        tempInstructor.add(tempCourse4);

        //save the instructor
        //NOTE: thios will also save the courses becouse CascadeType.PERSIST

        System.out.println("Saving instructor " + tempInstructor);
        System.out.println("The courses " + tempInstructor.getCourses());

        appDAO.save(tempInstructor);

        System.out.println("DONE");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {

        int theId = 6;

        System.out.println("DELETING INSTRUCTOR DETAIL " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("DONE!");
    }

    private void findInstructorDetailById(AppDAO appDAO) {

        //get the instructor details
        int theId = 2;
        InstructorDetail tempInstrutorDetail = appDAO.findInstructorDetailById(theId);
        //print the instructor detail
        System.out.println("tempInstructorDetail " + tempInstrutorDetail);

        //print the associated instructor

        System.out.println("the associated instructor: " + tempInstrutorDetail.getInstructor());


    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleteing instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;

        System.out.println("Finding instructor id: " + theId);

        Instructor tempsInstructor = appDAO.findInstructorById(theId);

        System.out.println("Temp instructor " + tempsInstructor);
        System.out.println("The associated instructor details " + tempsInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor
                ("Chad", "Darbyu", "d@saa");

        InstructorDetail instructorDetail = new InstructorDetail
                ("yotobe//", "music");

        tempInstructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
    }
}
