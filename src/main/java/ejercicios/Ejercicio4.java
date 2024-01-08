package ejercicios;

import entidades.Departamentos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 4. Elimina el departamento ”Ventas”. ¿Puedes? ¿por qué? ¿cómo puedes ajustar
 * tu programa para que tenga en cuenta estas situaciones? Prueba a eliminar el
 * departamento 80.
 */

public class Ejercicio4 {
    /*Al intentar borrar el departamento de ventas salta una excepcion ConstraintViolationException
    porque es una clave ajena de empleados. El 80 si lo permite borrar*/

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Departamentos departamento80 = session.get(Departamentos.class,80);
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(departamento80);
            transaction.commit();
        }catch (Throwable t){
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("ERROR: " + t.getCause() + " " + t.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

