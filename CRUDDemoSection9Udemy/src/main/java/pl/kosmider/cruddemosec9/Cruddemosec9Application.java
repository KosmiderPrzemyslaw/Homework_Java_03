package pl.kosmider.cruddemosec9;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kosmider.cruddemosec9.dao.AppDAO;
import pl.kosmider.cruddemosec9.entity.Instructor;
import pl.kosmider.cruddemosec9.entity.InstructorDetail;

@SpringBootApplication
public class Cruddemosec9Application {

    public static void main(String[] args) {
        SpringApplication.run(Cruddemosec9Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
           // createInstructor(appDAO);

            findInstructor(appDAO);
        };
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
                ("Madhu", "Bary", "mad@saa");

        InstructorDetail instructorDetail = new InstructorDetail
                ("yotobe//", "guitar");

        tempInstructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
    }
}
