package proyectovale;

import javax.swing.JOptionPane;

public class ProyectoVale {

    public static void main(String[] args) {
        int seguir = 0;
        Mantenimiento mante = new Mantenimiento();
        mante.registerServices();
        mante.instructorAuto();
        int option = 0;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("Eliga una opción: "
                        + "\n1. Registrar cliente\n2. Registrar instructor\n3. Mantenimiento servicios\n4. Modificaciones\n5. Listados"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Inserte una opción correcta.");
            }
            switch (option) {
                case 1:
                    mante.singUpACustomer();
                    break;
                case 2:
                    mante.registerInstructor();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5: 
                    
                    break;
                default:
                    throw new AssertionError();
            }

        } while (seguir == 0);

    }

}
