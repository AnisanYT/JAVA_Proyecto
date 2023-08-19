package proyectovale;

import javax.swing.JOptionPane;

public class ProyectoVale {

    public static void main(String[] args) {
        int seguir = 0;
        Mantenimiento mante = new Mantenimiento();
        mante.registerServices();
        mante.instructorAuto();
        mante.customerAuto();

        do {
            int option = 0;
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("Eliga una opción: "
                        + "\n1. Registrar cliente\n2. Registrar instructor\n3. Modificaciones en Servicios e Instructores"
                        + "\n4. Modificaciones de clientes\n5. Realizar una rifa\n6. Listados\n7. Salir"));
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
                    mante.modifierTheInstructorOrService();
                    break;
                case 4:
                    mante.modifierTheCustomer();
                    break;
                case 5:
                    mante.toDoRifa();
                    break;
                case 6:
                    try {
                    mante.listCustomers();
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Parece que hubo un error " + e);
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Parece que hubo un error " + e);
                } catch (AssertionError e) {
                    JOptionPane.showMessageDialog(null, "Parece que hubo un error " + e);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Parece que hubo un error " + e);
                }
                break;
                case 7:
                    seguir = 1;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida.");
            }
            

        } while (seguir == 0);

    }

}
