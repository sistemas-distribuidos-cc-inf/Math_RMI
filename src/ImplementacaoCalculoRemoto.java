import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

public class ImplementacaoCalculoRemoto extends UnicastRemoteObject implements InterfaceCalculoRemoto {

    public ImplementacaoCalculoRemoto() throws RemoteException {
    }
    public void mensagemServidor(String mensagem) throws RemoteException {
        System.out.println("Cliente fala: " + mensagem);
    }
    @Override
    public double metodoCalcular(double val1, double val2, int operacao) throws RemoteException {
        if (operacao == 0) {
            return val1 + val2;
        } else if (operacao == 1) {
            return val1 - val2;
        } else if (operacao == 2) {
            return val1 * val2;
        } else if (operacao == 3) {
            try{
                if(val2 == 0){
                    throw new ArithmeticException("NÃO PODE DIVIDIR POR 0");
                }else{
            return val1 / val2;
            }
            }catch(Exception arithmeticException){
                JOptionPane.showMessageDialog(null, arithmeticException.toString());
            }
        }
        return 0;
    }
}