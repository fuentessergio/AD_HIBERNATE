package ejercicios;

import entidades.Departamentos;
import entidades.Empleados;
import excepciones.DepartamentoNoEncontradoException;
import excepciones.EmpleadoNoEncontradoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 5. Crea un método para cargar objetos de tipo empleado que reciba su id como
 * argumento. Los cargará usando get() para comprobar que existan. Un vez los
 * tenga, debe cargar también su departamento pero usaremos load() ya que sabemos que existe.
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        int idEmpleado = 606;

        try(Session session = sessionFactory.openSession()){
            Empleados empleado = cargarEmpleado(session, idEmpleado);
            Departamentos departamento = cargarDepartamento(session,empleado.getIdDepartamento());
            // System.out.println(empleado.getNombre() + " su departamento es " + departamento.getNombreDepartamento());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Empleados cargarEmpleado(Session session, int id){
        try{
            Empleados empleado = session.get(Empleados.class,id);
            if(empleado == null){
                throw new EmpleadoNoEncontradoException();
            }
            return empleado;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Departamentos cargarDepartamento (Session session, Integer id){
        try{
            if(id == null){
                throw new DepartamentoNoEncontradoException();
            }
            Departamentos departamento = session.load(Departamentos.class,id);
            return departamento;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
