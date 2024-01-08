package ejercicios;

import entidades.Departamentos;
import entidades.Localizaciones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.ObjectInputFilter;
import java.lang.module.Configuration;
import java.util.ArrayList;

/**
 * 1. Crea un proyecto con Hibernate que te permita insertar una nueva localización en
 * la BdD (el pueblo donde vivas) y añade a ella 3 departamentos que te inventes.
 */
public class Ejercicio1 {
    public static void main(String[] args) {

        Localizaciones localizacion = new Localizaciones();
        localizacion.setIdPais("ES");
        localizacion.setIdLocalizacion(1);
        localizacion.setDireccion("Calle Pico de Cotos");
        localizacion.setCodigoPostal("28400");
        localizacion.setCiudad("Collado Villalba");
        localizacion.setProvincia("Madrid");

        Departamentos departamento1 = new Departamentos();
        departamento1.setIdDepartamento(100);
        departamento1.setNombreDepartamento("Departamento1");
        departamento1.setIdDirector(100);
        departamento1.setIdLocalizacion(localizacion.getIdLocalizacion());

        Departamentos departamento2 = new Departamentos();
        departamento2.setIdDepartamento(101);
        departamento2.setNombreDepartamento("Departamento2");
        departamento2.setIdDirector(100);
        departamento2.setIdLocalizacion(localizacion.getIdLocalizacion());

        Departamentos departamento3 = new Departamentos();
        departamento3.setIdDepartamento(102);
        departamento3.setNombreDepartamento("Departamento3");
        departamento3.setIdDirector(100);
        departamento3.setIdLocalizacion(localizacion.getIdLocalizacion());

        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(localizacion);
            session.persist(departamento1);
            session.persist(departamento2);
            session.persist(departamento3);
            transaction.commit();
            session.close();
        } catch (Throwable t){
            System.err.println("ERROR: " + t.getCause() + ":" + t.getMessage());
        }
    }
}
