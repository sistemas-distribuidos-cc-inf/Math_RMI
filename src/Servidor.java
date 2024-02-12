import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Esta clase representa el servidor para el sistema de cálculo remoto utilizando RMI.
 */
public class Servidor {
    
    /**
     * Constructor por defecto de la clase Servidor.
     * Configura el servidor RMI para aceptar conexiones en el puerto 1234 y vincula la implementación remota.
     * @throws RemoteException Si ocurre un error de comunicación remota.
     */
    public Servidor() throws RemoteException {
        try {
           // Crea el registro RMI en el puerto 1234
           LocateRegistry.createRegistry(1234);
           // Vincula la implementación remota con el nombre "calc" en el registro
           Naming.rebind("rmi://localhost:1234/calc", new ImplementacaoCalculoRemoto());
        } catch (Exception e) {
            // Maneja excepciones imprimiendo el rastreo de la pila
            e.printStackTrace();
        }
    }
    
    /**
     * Método principal que crea una instancia del servidor.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     * @throws RemoteException Si ocurre un error de comunicación remota.
     */
    public static void main(String[] args) throws RemoteException {
       // Crea una instancia del servidor
       new Servidor();
    }
}
