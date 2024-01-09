package ejercicios;

import entidades.Departamentos;
import entidades.Empleados;
import excepciones.DepartamentoNoEncontradoException;
import excepciones.EmpleadoNoEncontradoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

/**
 * 6. Modifica el ejercicio 5.1.5 para que se creen dos almacenes (por ejemplo con
 * ArrayList): uno de empleados y otro de departamentos.
 * Antes de cargar el departamento desde la BdD en el objeto empleado, comprueba que si ya está en
 * el almacén.
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        int[] idsEmpleados = {202, 301, 702, 502, 420};  // Ejemplo de IDs de empleados

        try (Session session = sessionFactory.openSession()){
            ArrayList<Empleados> empleados = new ArrayList<>();
            ArrayList<Departamentos> departamentos = new ArrayList<>();

            for(int idEmpleado : idsEmpleados){
                Empleados empleado = cargarEmpleado(session,idEmpleado,empleados);
                Departamentos departamento = cargarDepartamento(session,empleado.getIdDepartamento(),departamentos);
                System.out.println(empleado.getNombre() + " su departamento es "  + departamento.getNombreDepartamento());
            }
        }
    }


    public static Empleados cargarEmpleado(Session session, int id, ArrayList<Empleados> empleadosList) {
        try {
            // Verificar si el empleado ya está en la base de datos
            Empleados empleado = session.get(Empleados.class, id);
            if (empleado == null) {
                throw new EmpleadoNoEncontradoException();
            }

            // Si el empleado no está en el almacén, agregarlo
            if (!empleadosList.contains(empleado)) {
                empleadosList.add(empleado);
            }

            return empleado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Departamentos cargarDepartamento(Session session, int idDepartamento, ArrayList<Departamentos> departamentosList) {
        try {
            // Verificar si el departamento ya está en el almacén
            Departamentos departamentoEnAlmacen = obtenerDepartamentoDesdeAlmacen(idDepartamento, departamentosList);

            if (departamentoEnAlmacen == null) {
                // Si el departamento no está en el almacén, cargarlo desde la base de datos y agregarlo al almacén
                Departamentos departamento = session.load(Departamentos.class, idDepartamento);
                if (departamento != null) {
                    departamentosList.add(departamento);
                } else {
                    throw new DepartamentoNoEncontradoException();
                }
                return departamento;
            } else {
                // Si el departamento ya está en el almacén, devolverlo directamente
                return departamentoEnAlmacen;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Departamentos obtenerDepartamentoDesdeAlmacen(int idDepartamento, ArrayList<Departamentos> departamentosList) {
        for (Departamentos departamento : departamentosList) {
            if (departamento.getIdDepartamento() == idDepartamento) {
                return departamento;
            }
        }
        return null;
    }
}
