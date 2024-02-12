import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 * Esta clase implementa la interfaz remota para realizar cálculos.
 * Extiende UnicastRemoteObject para facilitar la comunicación remota.
 */
public class ImplementacaoCalculoRemoto extends UnicastRemoteObject implements InterfaceCalculoRemoto {

    /**
     * Constructor por defecto de la clase.
     * Llama al constructor de la superclase UnicastRemoteObject.
     * @throws RemoteException Si ocurre un error durante la comunicación remota.
     */
    public ImplementacaoCalculoRemoto() throws RemoteException {
    }

    /**
     * Método para enviar un mensaje al servidor.
     * Imprime el mensaje recibido desde el cliente.
     * @param mensagem El mensaje a enviar al servidor.
     * @throws RemoteException Si ocurre un error durante la comunicación remota.
     */
    public void mensagemServidor(String mensagem) throws RemoteException {
        System.out.println("Cliente fala: " + mensagem);
    }

    /**
     * Método para realizar cálculos basados en la operación especificada.
     * @param val1 El primer valor del cálculo.
     * @param val2 El segundo valor del cálculo.
     * @param operacao El tipo de operación a realizar.
     *                 0 para suma, 1 para resta, 2 para multiplicación, 3 para división.
     * @return El resultado del cálculo.
     * @throws RemoteException Si ocurre un error durante la comunicación remota.
     */
    @Override
    public double metodoCalcular(double val1, double val2, int operacao) throws RemoteException {
        if (operacao == 0) {
            return val1 + val2;
        } else if (operacao == 1) {
            return val1 - val2;
        } else if (operacao == 2) {
            return val1 * val2;
        } else if (operacao == 3) {
            try {
                if (val2 == 0) {
                    throw new ArithmeticException("NÃO PODE DIVIDIR POR 0");
                } else {
                    return val1 / val2;
                }
            } catch (Exception arithmeticException) {
                // Muestra un mensaje de error si ocurre una excepción aritmética
                JOptionPane.showMessageDialog(null, arithmeticException.toString());
            }
        }
        return 0; // Devuelve 0 si la operación no es válida
    }
}
