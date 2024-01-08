package ejercicios;

import entidades.Departamentos;
import entidades.Empleados;
import entidades.Localizaciones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

/**
 * 3. Modifica el empleado 301 para que cobre un 5 % más. También cambia el departamento 20 a la localización 4000.
 * En ambos casos debes asegurarte de que existan.
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        incrementarSalario(session,301);
        actualizarLocalizacionDelDepartamento(session,20,4000);
        session.close();
    }
    private static void incrementarSalario (Session session, int idEmpleado){
        // para actualizar un objeto hay que cargarlo antes con load o get
        Empleados empleado = session.get(Empleados.class,idEmpleado);

        if(empleado != null){
            // crea un nuevo salario aumentando un 5%
            BigDecimal nuevoSalario = empleado.getSalario().multiply(new BigDecimal("1.05"));
            empleado.setSalario(nuevoSalario);

            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                session.update(empleado);
                transaction.commit();

            } catch (Throwable t) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.err.println("ERROR: " + t.getCause() + " " + t.getMessage());
            }
        } else System.out.println("No existe el empleado buscado por ese ID");
    }
    private static void actualizarLocalizacionDelDepartamento(Session session, int idDepartamento, int nuevaLocalizacion){
        Departamentos departamento = session.get(Departamentos.class,idDepartamento);

        if(departamento != null){
            Localizaciones localizacion = session.get(Localizaciones.class,nuevaLocalizacion);

            if(localizacion != null){
                departamento.setIdLocalizacion(nuevaLocalizacion);

            Transaction transaction = null;
                try {
                    transaction = session.beginTransaction();
                    session.update(departamento);
                    transaction.commit();
                } catch (Throwable t){
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    System.err.println("ERROR: " + t.getCause() + " " + t.getMessage());
                }
            } else System.out.println("No existe ese id de localización");
        } else System.out.println("No existe ese id de departamento");
    }
}

