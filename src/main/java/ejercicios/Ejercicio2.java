package ejercicios;

import entidades.Empleados;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 2. Inserta 5 empleados nuevos asociados al departamento creado en el ejercicio
 * 5.1.1
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        //claves ajenas de tabla empleados
        String idTrabajo = "IT_PROG";
        int idDirector = 100;
        int idDepartamento = 101;

        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            for (int i = 0; i <= 5; i++) {
                Empleados empleado = new Empleados();
                empleado.setIdEmpleado(1000 + i);
                empleado.setNombre("Nombre " + i);
                empleado.setApellido("Apellido " + i);
                empleado.setEmail("email" + i + "@example.com");
                empleado.setTelefono("123456789");
                empleado.setFechaContratacion(Date.valueOf("1987-6-17")); // new date esta obsoleto
                empleado.setIdTrabajo(idTrabajo);
                empleado.setSalario(new BigDecimal("1000"));
                empleado.setComision(new BigDecimal("0.10"));
                empleado.setIdDirector(idDirector);
                empleado.setIdDepartamento(idDepartamento);

                session.persist(empleado);
            }
            transaction.commit();
        }catch (Throwable t){
            if (transaction != null) {
                try {
                    transaction.rollback();
                    System.out.println("La transacción se ha revertido debido a un error. Mensaje: " + t.getMessage());
                } catch (Exception rollbackException) {
                    System.err.println("Error al revertir la transacción: " + rollbackException.getMessage());
                }
            }
            System.err.println("ERROR: " + t.getCause() + " " + t.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
