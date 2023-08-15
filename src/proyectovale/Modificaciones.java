package proyectovale;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Modificaciones {

    public void modificarcliente(int position, Cliente[] vector, int positionVector, Instructor[] vectorInstructor, servicios[] vectorServicios) {
        //position, choose in the switch 
        //vector[] is the vector of customer in parameter
        //ID is Customer's ID
        String findSerice = ""; //Concat the service finded and show after
        switch (position) {
            case 1:
                int wantT = Integer.parseInt(JOptionPane.showInputDialog("1.Borrar\n2.Añadir"
                        + "\n¿Qué desea hacer?"));
                if (wantT == 1) {
                    //show the service information 
                    Cliente client = vector[positionVector];
                    String[] informationService = client.getServiceSignedUp();
                    for (int i = 0; i < informationService.length; i++) {
                        if (informationService[i] != null) {
                            findSerice = findSerice + i + ". " + informationService[i] + "\n";
                        }
                    }

                    int positionOfvector = Integer.parseInt(JOptionPane.showInputDialog("Los servicios encontrados"
                            + "fueron los siguientes: \n" + findSerice + "\n¿Cual servicio desea borrarle a este cliente?"));
                    informationService[positionOfvector] = null;
                    vector[positionVector].setServiceSignedUp(informationService);
                    /*                    
                    Cliente clieente = vector[positionVector];
                    String[] guarda = clieente.getServiceSignedUp();
                    for (String string : guarda) {
                        System.out.println(string);
                    }
                     */
                    String[] onlyWithOutNull = new String[4];
                    String find = "";
                    String choose = "";
                    int findUnique = 0;
                    boolean finded = false;
                    int count = 0;
                    //onlyWithOutNull only has the services, and void the nulls
                    for (int i = 0; i < informationService.length; i++) {
                        if (informationService[i] != null) {
                            for (int j = 0; j < onlyWithOutNull.length; j++) {
                                if (onlyWithOutNull[j] == null) {
                                    onlyWithOutNull[j] = informationService[i];
                                    break;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < onlyWithOutNull.length; i++) {
                        find = "";
                        count = 0;
                        for (int j = 0; j < vectorInstructor.length; j++) {
                            if (vectorInstructor[j] != null) {
                                Instructor ins = vectorInstructor[j];
                                String[] services = ins.getServiceAssigned();
                                for (String service : services) {
                                    if (onlyWithOutNull[i] != null && service != null) {
                                        if (onlyWithOutNull[i] == service) {
                                            find = find + j + ". " + vectorInstructor[j].getName() + " " + vectorInstructor[j].getLastname() + "\n";
                                            finded = true;
                                            count++;
                                            findUnique = j;
                                        }
                                    }
                                }
                            }
                        }
                        if (finded && count > 1) {
                            int position1 = Integer.parseInt(JOptionPane.showInputDialog("Estos son los instructores"
                                    + " con el servicio de " + onlyWithOutNull[i] + ": \n" + find));
                            choose = choose + "Entrenador en " + onlyWithOutNull[i] + ": " + vectorInstructor[position1].getName() + " " + vectorInstructor[position1].getLastname() + "\n";
                        }
                        if (finded && count == 1) {
                            choose = choose + "Entrenador en " + onlyWithOutNull[i] + ": " + vectorInstructor[findUnique].getName() + " " + vectorInstructor[findUnique].getLastname() + "\n";
                        }
                    }
                    vector[positionVector].setInstructor(choose);
                } else {
                    String find = "";
                    Cliente cl = vector[positionVector];
                    String[] datas = cl.getServiceSignedUp();
                    for (int i = 0; i < vectorServicios.length; i++) {
                        find = find + i + ". " + vectorServicios[i].getName() + "\n";
                    }
                    boolean dontFindRepeat = true;
                    int addService = Integer.parseInt(JOptionPane.showInputDialog(find + "\n¿Cual servicio desea escoger?"));
                    for (int i = 0; i < datas.length; i++) {
                        for (int j = 0; j < vectorServicios.length; j++) {
                            if (datas[i] != null && vectorServicios[j] != null) {
                                if (datas[i] == vectorServicios[addService].getName()) {
                                    dontFindRepeat = false;
                                }
                            }
                        }
                    }
                    if (dontFindRepeat) {
                        String[] newVector = addData(datas, vectorServicios[addService].getName());
                        for (String num : newVector) {
                            System.out.println(num);
                        }
                        String finds = "";
                        vector[positionVector].setServiceSignedUp(newVector);
                        String before = vector[positionVector].getInstructor();
                        //update the instructors 
                        for (int i = 0; i < vectorInstructor.length; i++) {
                            if (vectorInstructor[i] != null) {
                                Instructor inss = vectorInstructor[i];
                                String[] container = inss.getServiceAssigned();
                                for (String string : container) {
                                    if (string == vectorServicios[addService].getName()) {
                                        finds = finds + i + ". " + vectorInstructor[i].getName() + " " + vectorInstructor[i].getLastname() + "\n";
                                    }
                                }
                            }
                        }
                        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Estos son los entrenadores disponibles"
                                + " en el nuevo servicio escogido por el cliente: \n" + finds + "\n¿Cual sera el entrenador asignado?"));
                        String after = before + "Entrenador de " + vectorServicios[addService].getName() + ": "
                                + vectorInstructor[option].getName() + " " + vectorInstructor[option].getLastname();
                        vector[positionVector].setInstructor(after);
                        String ser = "";
                        Cliente client = vector[positionVector];
                        String[] serviceAssigned = client.getServiceSignedUp();
                        for (String servicio : serviceAssigned) {
                            if (servicio == null) {
                                System.out.println("");
                            } else {
                                ser = ser + servicio + ", ";
                            }
                        }
                        JOptionPane.showMessageDialog(null,
                                "¡Servicio añadido Exitosamente!" + "\nNuevos datos: \nCliente: " + vector[positionVector].getName()
                                + "\nApellido: " + vector[positionVector].getLastname() + "\nNumero de codigo (Para fines de Rifa): " + vector[positionVector].getCodeNumber()
                                + "\nServicios suscrito: " + ser + "\nEstado: " + vector[positionVector].getState() + "\nInstructor o instructores: \n " + vector[positionVector].getInstructor());
                    } else {
                        JOptionPane.showMessageDialog(null, "Este cliente ya escogio este servicio, deberia de escoger otro.");
                    }
                }
                break;
            case 2:
                String status = "Activo";
                String status2 = "Deshabilitado";
                ImageIcon icon = new ImageIcon("src\\img\\Confirmar.png");
                if (vector[positionVector].getState() == status) {
                    int input = JOptionPane.showConfirmDialog(null, "El estado actual del cliente es ACTIVO, \n¿Esta seguro de cambiarlo a DESHABILITADO?",
                            "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, icon);
                    if (input == 0) {
                        vector[positionVector].setState("Deshabilitado");
                        String ser = "";
                        Cliente client = vector[positionVector];
                        String[] serviceAssigned = client.getServiceSignedUp();
                        for (String servicio : serviceAssigned) {
                            if (servicio == null) {
                                System.out.println("");
                            } else {
                                ser = ser + servicio + ", ";
                            }
                        }
                        JOptionPane.showMessageDialog(null,
                                "¡Estado cambiado!" + "\nNuevos datos: \nCliente: " + vector[positionVector].getName()
                                + "\nApellido: " + vector[positionVector].getLastname() + "\nNumero de codigo (Para fines de Rifa): " + vector[positionVector].getCodeNumber()
                                + "\nServicios suscrito: " + ser + "\nEstado: " + vector[positionVector].getState() + "\nInstructor o instructores: \n " + vector[positionVector].getInstructor());
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceso cancelado.");
                        break;
                    }
                } else {
                    int input = JOptionPane.showConfirmDialog(null, "El estado actual del cliente es DESHABILITADO, \n¿Esta seguro de cambiarlo a ACTIVO?",
                            "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, icon);
                    if (input == 0) {
                        vector[positionVector].setState("Activo");
                        String ser = "";
                        Cliente client = vector[positionVector];
                        String[] serviceAssigned = client.getServiceSignedUp();
                        for (String servicio : serviceAssigned) {
                            if (servicio == null) {
                                System.out.println("");
                            } else {
                                ser = ser + servicio + ", ";
                            }
                        }
                        JOptionPane.showMessageDialog(null,
                                "¡Estado cambiado!" + "\nNuevos datos: \nCliente: " + vector[positionVector].getName()
                                + "\nApellido: " + vector[positionVector].getLastname() + "\nNumero de codigo (Para fines de Rifa): " + vector[positionVector].getCodeNumber()
                                + "\nServicios suscrito: " + ser + "\nEstado: " + vector[positionVector].getState() + "\nInstructor o instructores: \n " + vector[positionVector].getInstructor());
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceso cancelado.");
                        break;
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    public String[] addData(String[] vector, String newdata) {
        int newSize = vector.length + 1;
        String[] newVector = new String[newSize];

        for (int i = 0; i < vector.length; i++) {
            newVector[i] = vector[i];
        }
        newVector[newSize - 1] = newdata;
        return newVector;
    }

    public void modificarcliente() {
    }

    public void modificarcliente(int pos) {
    }
}
