import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCalculoRemoto extends Remote {
    /**
     *
     * @param val1
     * @param val2
     * @param operacao
     * @return
     * @throws RemoteException
     */
    public double metodoCalcular(double val1, double val2, int operacao) throws RemoteException;
    /**
     *
     * @param mensagem
     * @throws RemoteException
     */
    public void mensagemServidor(String mensagem) throws RemoteException;
}