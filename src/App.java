
// Version: 1.0
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Object[] options = { "Conversor de divisas", "Conversor de temperaturas", "Salir" };
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
        DecimalFormat df = new DecimalFormat("#.00");
        boolean advance = true;
        while (advance) {
            String[] options = { "Pesos a Dólares", "Pesos a Euros", "Pesos a Libras esterlinas",
                    "Pesos a Yen Japones", "Pesos a Won Sur Coreano" };// Opciones del menú

            String seleccion = (String) JOptionPane.showInputDialog(null,
                    "Seleccione una opción", "Conversor de divisas", JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            if (seleccion == null){                        
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                    System.exit(0);
            }        
            String input = JOptionPane.showInputDialog(null,
                    "Ingrese la cantidad de pesos a convertir");

            double pesos = 0.0;

            try {
                pesos = Double.parseDouble(input);
                if (pesos < 0) {
                    throw new NegativeNumberException("No se aceptan números negativos");
                }
                if (seleccion.equals("Pesos a Dólares")) {
                    double dolares = pesos / 20.0;
                    JOptionPane.showMessageDialog(null,
                            pesos + " Pesos equivalen a " + df.format(dolares) + " Dólares");
                } else if (seleccion.equals("Pesos a Euros")) {
                    double euros = pesos / 23.0;
                    JOptionPane.showMessageDialog(null,
                            pesos + " Pesos equivalen a " + df.format(euros) + " Euros");
                } else if (seleccion.equals("Pesos a Libras esterlinas")) {
                    double libras = pesos / 27.0;
                    JOptionPane.showMessageDialog(null,
                            pesos + " Pesos equivalen a " + df.format(libras) + " Libras esterlinas");
                } else if (seleccion.equals("Pesos a Yen Japones")) {
                    double yen = pesos / 0.18;
                    JOptionPane.showMessageDialog(null,
                            pesos + " Pesos equivalen a " + df.format(yen) + " Yen japones");
                } else {
                    double won = pesos / 0.017;
                    JOptionPane.showMessageDialog(null,
                            pesos + " Pesos equivalen a " + df.format(won) + " Won sur coreano");
                }

                int choose = JOptionPane.showConfirmDialog(null,
                        "¿Desea realizar otra conversión?", "Conversor de divisas",
                        JOptionPane.YES_NO_OPTION);
                if (choose == JOptionPane.NO_OPTION || choose == JOptionPane.CANCEL_OPTION) {
                    advance = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                }
            } catch (NegativeNumberException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            } finally {
                if (pesos < 0) {
                    advance = false;
                }
            }
        }
    }

    private static void convertirTemperaturas() {

    }
}
