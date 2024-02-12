import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 * Esta clase representa un cliente para un sistema de cálculo remoto utilizando RMI.
 */
public class Cliente {

    /**
     * Este método es el punto de entrada principal para el cliente.
     * Solicita al usuario dos valores y una operación, realiza el cálculo remoto y muestra el resultado.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        try {
            // Busca la interfaz remota registrada en el servidor RMI
            InterfaceCalculoRemoto objCalculoRemoto = (InterfaceCalculoRemoto) Naming.lookup("rmi://localhost:1234/calc");
            // Solicita al usuario el primer valor
            int val1 = Integer.parseInt(JOptionPane.showInputDialog("Entre com o primeiro valor"));
            // Muestra un diálogo de opciones para que el usuario elija una operación
            String opcao[] = {"+", "-", "*", "/"};
            int operacao = JOptionPane.showOptionDialog(null, "Escolha uma das operacoes", "Tipo de operacao",
                    0, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
            // Solicita al usuario el segundo valor
            int val2 = Integer.parseInt(JOptionPane.showInputDialog("Entre com o segundo valor"));
            // Realiza el cálculo remoto y obtiene el resultado
            double resultado = objCalculoRemoto.metodoCalcular(val1, val2, operacao);
            // Muestra el resultado al usuario
            System.out.println("A resposta eh : " + resultado);
            // Envía un mensaje al servidor
            objCalculoRemoto.mensagemServidor("Recebi a Resposta");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // Maneja excepciones relacionadas con la conexión remota
            System.out.println("Erro:" + e.toString());
        } catch (Exception e) {
            // Maneja otras excepciones, como entradas inválidas del usuario
            JOptionPane.showMessageDialog(null, "Entrada inválida", e.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }
}
