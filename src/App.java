// Version: 1.0
import javax.swing.JOptionPane;
public class App {
    public static void main(String[] args) throws Exception {
        Object[] options = {"Conversor de divisas", "Conversor de temperaturas", "Salir"};
        String seleccion = (String) JOptionPane.showInputDialog(null, 
            "Seleccione una opción", "Conversor", JOptionPane.QUESTION_MESSAGE, 
            null, options, options[0]);

        try {
            if (seleccion.equals("Conversor de divisas")) {
                convertirDivisas();
            } else if (seleccion.equals("Conversor de temperaturas")) {
                convertirTemperaturas();
            } else {
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
            System.exit(0);
        }    
    }

    private static void convertirDivisas() {
         
    }
    
    private static void convertirTemperaturas() {

    } 
}
