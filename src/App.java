
// Version: 1.0
import java.text.DecimalFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Object[] options = { "Conversor de divisas", "Conversor de temperaturas", "Salir" };
        ImageIcon doubt = new ImageIcon("src\\img\\doubt.png");
        ImageIcon thanks = new ImageIcon("src\\img\\thanks.png");
        ImageIcon foreignExchange = new ImageIcon("src\\img\\foreignExchange.png");
        ImageIcon conversion = new ImageIcon("src\\img\\conversion.png");
        ImageIcon amount = new ImageIcon("src\\img\\amount.png");
        ImageIcon err = new ImageIcon("src\\img\\error.png");
        String seleccion = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción", "Conversor", JOptionPane.QUESTION_MESSAGE,
                doubt, options, options[0]);

        try {
            if (seleccion.equals("Conversor de divisas")) {
                convertCurrencies(thanks, foreignExchange, conversion, amount, err );
            } else if (seleccion.equals("Conversor de temperaturas")) {
                convertTemperatures(thanks,  conversion, amount,  err);
            } else {
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor");
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gracias por usar el conversor",
                    "Conversor", JOptionPane.INFORMATION_MESSAGE, thanks);
            System.exit(0);
        }
    }

    private static void convertCurrencies(Icon thanks, Icon foreignExchange, Icon conversion, Icon amount, Icon err ) {
        DecimalFormat df = new DecimalFormat("#.00");
        
        boolean advance = true;
        while (advance) {
            String[] options = { "Pesos a Dólares", "Dólares a Pesos", "Pesos a Euros", "Euros a Pesos", 
                "Pesos a Libras esterlinas", "Libras esterlinas a Pesos", "Pesos a Yen Japones",
                "Yen Japones a Pesos", "Pesos a Won Sur Coreano", "Won Sur Coreano a Pesos" };
            
            Object seleccion = JOptionPane.showInputDialog(null,
                "Seleccione una opción", "Conversor de divisas", JOptionPane.QUESTION_MESSAGE,
                foreignExchange, options, options[0]);

            if (seleccion == null) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor",
                        "Conversor", JOptionPane.INFORMATION_MESSAGE, thanks);
                System.exit(0);
            }
            
            Object input = JOptionPane.showInputDialog(null,
                    "Ingrese la cantidad de pesos a convertir", "Conversor de divisas",
                    JOptionPane.QUESTION_MESSAGE, amount, null, null);

            input = ((String) input).trim();

            if (((String) input).isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "El valor ingresado no puede estar vacío.",
                        "Error", JOptionPane.ERROR_MESSAGE, err);
                JOptionPane.showMessageDialog(null, "Programa finalizado",
                        "Conversor", JOptionPane.INFORMATION_MESSAGE, thanks);
                return;
            }

            double pesos, dolares, euros, libras, yen, won;
            double change = Double.parseDouble(String.valueOf(input));

            try {
                if (change <= 0) {
                    throw new NegativeNumberException("No se aceptan números negativos");
                }

                if (seleccion.equals("Pesos a Dólares")) {
                    dolares = change / 546;
                    JOptionPane.showMessageDialog(null,
                            change + " Pesos equivalen a " + df.format(dolares) + " Dólares",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Pesos a Euros")) {
                    euros = change / 600.6;
                    JOptionPane.showMessageDialog(null,
                            change + " Pesos equivalen a " + df.format(euros) + " Euros",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Pesos a Libras esterlinas")) {
                    libras = change / 698.88;
                    JOptionPane.showMessageDialog(null,
                            change + " Pesos equivalen a " + df.format(libras) + " Libras esterlinas",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Pesos a Yen Japones")) {
                    yen = change /3.87;
                    JOptionPane.showMessageDialog(null,
                            change + " Pesos equivalen a " + df.format(yen) + " Yen japones",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Pesos a Won Sur Coreano")) {
                    won = change / 2.33;
                    JOptionPane.showMessageDialog(null,
                            change + " Pesos equivalen a " + df.format(won) + " Won sur coreano",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Dólares a Pesos")) {
                    pesos = 546 * change;
                    JOptionPane.showMessageDialog(null,
                            change + " Dólares equivalen a " + df.format(pesos) + " Pesos",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Euros a Pesos")) {
                    pesos = 600.6 * change;
                    JOptionPane.showMessageDialog(null,
                            change + " Euros equivalen a " + df.format(pesos) + " Pesos",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Libras esterlinas a Pesos")) {
                    pesos = 698.88 * change;
                    JOptionPane.showMessageDialog(null,
                            change + " Libras esterlinas equivalen a " + df.format(pesos) + " Pesos",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Yen Japones a Pesos")) {
                    pesos = 3.87 * change;
                    JOptionPane.showMessageDialog(null,
                            change + " Yen japones equivalen a " + df.format(pesos) + " Pesos",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Won Sur Coreano a Pesos")) {
                    pesos = 2.33 * change;
                    JOptionPane.showMessageDialog(null,
                            change + " Won sur coreano equivalen a " + df.format(pesos) + " Pesos",
                            "Conversor de divisas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else {
                    JOptionPane.showMessageDialog(null, "Gracias",
                            "Conversor", JOptionPane.INFORMATION_MESSAGE, thanks);
                    System.exit(0);
                }

                int choose = JOptionPane.showConfirmDialog(null,
                        "¿Desea realizar otra conversión?", "Conversor de divisas",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, amount);
                if (choose == JOptionPane.NO_OPTION || choose == JOptionPane.CLOSED_OPTION) {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el conversor",
                            "Conversor", JOptionPane.INFORMATION_MESSAGE, thanks);
                    JOptionPane.showMessageDialog(null, "Programa finalizado",
                            "Conversor", JOptionPane.INFORMATION_MESSAGE, thanks);
                    advance = false;
                }
            } catch (NegativeNumberException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (change <= 0) {
                    advance = false;
                }
            }
        }
    }

    private static void convertTemperatures(Icon conversion, Icon amount, Icon gracias, Icon err){
        DecimalFormat df = new DecimalFormat("#.00");
        Object[] options = { "Celsius a Fahrenheit", "Fahrenheit a Celsius", "Celsius a Kelvin", 
                "Kelvin a Celsius", "Fahrenheit a Kelvin",  "Kelvin a Fahrenheit"};
        boolean advance = true;
        while (advance) {
            Object seleccion = JOptionPane.showInputDialog(null,
                "Seleccione el tipo de conversión", "Conversor de temperaturas",
                JOptionPane.QUESTION_MESSAGE, conversion, options, options[0]);

            if (seleccion == null) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el conversor",
                        "Conversor", JOptionPane.INFORMATION_MESSAGE, gracias);
                System.exit(0);
            }

            Object input = JOptionPane.showInputDialog(null,
                    "Ingrese la cantidad de grados a convertir", "Conversor de temperaturas",
                    JOptionPane.QUESTION_MESSAGE, amount, null, null);
            input = ((String) input).trim();

            while (((String) input).isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "El valor ingresado no puede estar vacío.",
                        "Error", JOptionPane.ERROR_MESSAGE, err);
                JOptionPane.showMessageDialog(null, "Programa finalizado",
                        "Conversor", JOptionPane.INFORMATION_MESSAGE, gracias);

                return;
            }

            double celsius, fahrenheit, kelvin;
            double change = Double.parseDouble(String.valueOf(input));

            try {
                if (seleccion.equals("Celsius a Fahrenheit")) {
                    fahrenheit = (change * 9 / 5) + 32;
                    JOptionPane.showMessageDialog(null,
                            change + " Grados Celsius equivalen a " + df.format(fahrenheit) + " Grados Fahrenheit",
                            "Conversor de temperaturas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Celsius a Kelvin")) {
                    kelvin = change + 273.15;
                    JOptionPane.showMessageDialog(null,
                            change + " Grados Celsius equivalen a " + df.format(kelvin) + " Grados Kelvin",
                            "Conversor de temperaturas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Fahrenheit a Celsius")) {
                    celsius = (change - 32) * 5 / 9;
                    JOptionPane.showMessageDialog(null,
                            change + " Grados Fahrenheit equivalen a " + df.format(celsius) + " Grados Celsius",
                            "Conversor de temperaturas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Fahrenheit a Kelvin")) {
                    kelvin = (change - 32) * 5 / 9 + 273.15;
                    JOptionPane.showMessageDialog(null,
                            change + " Grados Fahrenheit equivalen a " + df.format(kelvin) + " Grados Kelvin",
                            "Conversor de temperaturas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Kelvin a Celsius")) {
                    celsius = change - 273.15;
                    JOptionPane.showMessageDialog(null,
                            change + " Grados Kelvin equivalen a " + df.format(celsius) + " Grados Celsius",
                            "Conversor de temperaturas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else if (seleccion.equals("Kelvin a Fahrenheit")) {
                    fahrenheit = (change - 273.15) * 9 / 5 + 32;
                    JOptionPane.showMessageDialog(null,
                            change + " Grados Kelvin equivalen a " + df.format(fahrenheit) + " Grados Fahrenheit",
                            "Conversor de temperaturas", JOptionPane.INFORMATION_MESSAGE, conversion);
                } else {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el conversor",
                            "Conversor", JOptionPane.INFORMATION_MESSAGE, gracias);
                    System.exit(0);
                }
                int choose = JOptionPane.showConfirmDialog(null,
                        "¿Desea realizar otra conversión?", "Conversor de temperaturas",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, amount);
                if (choose == JOptionPane.NO_OPTION || choose == JOptionPane.CLOSED_OPTION) {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el conversor",
                            "Conversor", JOptionPane.INFORMATION_MESSAGE, gracias);
                    JOptionPane.showMessageDialog(null, "Programa finalizado",
                            "Conversor", JOptionPane.INFORMATION_MESSAGE, gracias);
                    advance = false;
                }         
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }      
        }
    }
}