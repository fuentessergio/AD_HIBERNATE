package excepciones;

public class DepartamentoNoEncontradoException extends Exception{
    public DepartamentoNoEncontradoException(){
        super("El departamento es nulo o no se encuentra en la BBDD");
    }
}
