package excepciones;

public class EmpleadoNoEncontradoException extends Exception{
    public EmpleadoNoEncontradoException(){
        super("El empleado es nulo o no se encuentra en la BBDD");
    }
}
