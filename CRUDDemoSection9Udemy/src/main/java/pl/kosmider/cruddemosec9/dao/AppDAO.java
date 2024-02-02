package pl.kosmider.cruddemosec9.dao;

import pl.kosmider.cruddemosec9.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
