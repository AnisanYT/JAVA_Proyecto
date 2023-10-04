package proyectovale;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Modificaciones {

    //modifier a customer
    public void modificar(int position, Cliente[] vector, int positionVector, Instructor[] vectorInstructor, servicios[] vectorServicios) {
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
                } else if (wantT == 2) {
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
                } else {
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida.");
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
            case 3:
//                    Instructor inss = vectorInstructor[i];
//                    String[] container = inss.getServiceAssigned();
//                    Cliente client = vector[positionVector];
//                    String[] serviceAssigned = client.getServiceSignedUp();
                String find = "";
                String choose = "";
                Cliente client = vector[positionVector];
                String[] serviceAssigned = client.getServiceSignedUp();
                for (int i = 0; i < serviceAssigned.length; i++) {
                    if (serviceAssigned[i] != null) {
                        find = "";
                        for (int j = 0; j < vectorInstructor.length; j++) {
                            if (vectorInstructor[j] != null) {
                                Instructor inss = vectorInstructor[j];
                                String[] container = inss.getServiceAssigned();
                                if (serviceAssigned[i] != null) {
                                    for (String valor : container) {
                                        if (valor != null) {
                                            if (serviceAssigned[i] == valor) {
                                                find = find + j + ". " + vectorInstructor[j].getName() + " " + vectorInstructor[j].getLastname() + "\n";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Encontrados en: " + serviceAssigned[i] + "\n" + find));
                        choose = choose + "Entrenador en " + serviceAssigned[i] + ": " + vectorInstructor[option].getName() + " " + vectorInstructor[option].getLastname() + "\n";
                        JOptionPane.showMessageDialog(null, choose);
                    }

                }
                vector[positionVector].setInstructor(choose);
                String ser = "";
                Cliente clients = vector[positionVector];
                String[] serviceAssigneds = clients.getServiceSignedUp();
                for (String servicio : serviceAssigneds) {
                    if (servicio == null) {
                        System.out.println("");
                    } else {
                        ser = ser + servicio + ", ";
                    }
                }
                JOptionPane.showMessageDialog(null,
                        "¡Estado cambiado!" + "\nNuevos datos: \nCliente: " + vector[positionVector].getName()
                        + "\nApellido: " + vector[positionVector].getLastname() + "\nNumero de codigo (Para fines de Rifa): " + vector[positionVector].getCodeNumber()
                        + "\nServicios suscrito: " + ser + "\nEstado: " + vector[positionVector].getState() + "\nInstructor o instructores: \n" + vector[positionVector].getInstructor());
                break;

            default:
                JOptionPane.showMessageDialog(null, "Inserte una opcion valida.");
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

    //modifier a instructor
    public void modificar(Instructor[] instructor, int position, int option, servicios[] servicios) {
        switch (option) {
            case 1:
                String find = "";
                for (int i = 0; i < servicios.length; i++) {
                    find = find + i + ". " + servicios[i].getName() + "\n";
                }
                Instructor ins = instructor[position];
                String[] services = ins.getServiceAssigned();
                String ser = "";
                for (String valor : services) {
                    if (valor != null) {
                        ser = ser + valor + "\n";
                    }
                }
                try {
                    int positionOption = Integer.parseInt(JOptionPane.showInputDialog("Estos son los servicios actualmente disponibles: \n" + find
                            + "\n¿Cual desea asignar a este instructor?\n\n** Tome en cuenta que no puede añadir un servicio igual.\nEstos "
                            + "son los servicios asignados a " + instructor[position].getName() + "  " + instructor[position].getLastname() + "\n" + ser));
                    boolean finded = false;
                    for (String valor : services) {
                        if (servicios[positionOption].getName() == valor) {
                            JOptionPane.showMessageDialog(null, "Este instructor ya tiene este servicio. Intente con escoger otro.");
                            finded = true;
                        }
                    }

                    if (finded == false) {
                        instructor[position].setServiceAssigned(addData(services, servicios[positionOption].getName()));
                        Instructor ins2 = instructor[position];
                        String[] services2 = ins2.getServiceAssigned();
                        String ser2 = "";
                        for (String valor : services2) {
                            if (valor != null) {
                                ser2 = ser2 + valor + "\n";
                            }
                        }
                        JOptionPane.showMessageDialog(null, "¡Servicio añadido exitosamente!\nNombre: "
                                + instructor[position].getName() + "\nApellido: " + instructor[position].getLastname() + "\nID: " + instructor[position].getID() + "\n"
                                + "Servicios: " + ser2 + "\nServicio nuevo a este instructor: " + servicios[positionOption].getName());
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Parece que hubo un error " + e + "\nIntentelo otra vez.");
                }
                break;
            case 2:
                Instructor ins2 = instructor[position];
                String[] services2 = ins2.getServiceAssigned();
                String ser2 = "";
                for (int i = 0; i < services2.length; i++) {
                    if (services2[i] != null) {
                        ser2 = ser2 + i + ". " + services2[i] + "\n";
                    }
                }

                try {
                    int deleteOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Estos son los servicios de " + instructor[position].getName()
                            + " " + instructor[position].getLastname() + "\n" + ser2 + "\n¿Cual desea borrar?"));
                    String delete = services2[deleteOption];
                    services2[deleteOption] = null;
                    instructor[position].setServiceAssigned(services2);
                    Instructor ins3 = instructor[position];
                    String[] services3 = ins3.getServiceAssigned();
                    String ser3 = "";
                    for (String valor : services3) {
                        if (valor != null) {
                            ser3 = ser3 + valor + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, "¡Servicio borrado exitosamente!\nNombre: "
                            + instructor[position].getName() + "\nApellido: " + instructor[position].getLastname() + "\nID: " + instructor[position].getID() + "\n"
                            + "Servicios: " + ser3 + "\nServicio borrado a este instructor: " + delete);
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Parece que hubo un error: " + e + "\nIntentalo otra vez.");
                }

                break;
            case 3:
                try {
                int option4 = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea cambiar de " + servicios[position].getName() + "? \n1. Horario\n2. Precio"));
                if (option4 == 1) {
                    String regex = "^[lmkjvsdLMKJVSD]{1}:[ ]*[0-9]{1,2}[ ]*-+[ ]+[0-9]{1,2}$";
                    Pattern pattern = Pattern.compile(regex);
                    String schedule = JOptionPane.showInputDialog("¿Cual será el nuevo horario de " + servicios[position].getName() + "?"
                            + "\nHorario actual: " + servicios[position].getSchedule()
                            + "\n\n**Tenga en cuenta que debe de tener un formato similar a este: V: 7 - 12"
                            + "\n\n**Formato de Dias: "
                            + "\nL: Lunes"
                            + "\nM: Martes"
                            + "\nK: Miercoles"
                            + "\nJ: Jueves"
                            + "\nV: Viernes"
                            + "\nS: Sabado"
                            + "\nD: Domingo");
                    Matcher matcher = pattern.matcher(schedule);
                    String scheduleBefore = servicios[position].getSchedule();
                    if (matcher.matches()) {
                        servicios[position].setSchedule(schedule);
                        JOptionPane.showMessageDialog(null, "¡Horario actualizado!\n"
                                + "\nServicio: " + servicios[position].getName()
                                + "\nHorario: " + servicios[position].getSchedule() + "(Actualizado)"
                                + "\nPrecio: " + servicios[position].getPrice()
                                + "\n\nHorario anterior: " + scheduleBefore);
                    } else {
                        JOptionPane.showMessageDialog(null, "Lo siento no se puede, tiene que seguir el formato establecido.");
                    }
                } else if (option4 == 2) {
                    int priceBefore = servicios[position].getPrice();
                    int price = Integer.parseInt(JOptionPane.showInputDialog("¿Cual será el nuevo precio de este servicio?\n"
                            + "El precio actual de " + servicios[position].getName() + " es de: " + servicios[position].getPrice()));
                    servicios[position].setPrice(price);
                    JOptionPane.showMessageDialog(null, "¡Precio actualizado!\n"
                            + "\nServicio: " + servicios[position].getName()
                            + "\nHorario: " + servicios[position].getSchedule()
                            + "\nPrecio: " + servicios[position].getPrice() + "(Actualizado)"
                            + "\n\nPrecio anterior: " + priceBefore);
                } else {
                    JOptionPane.showMessageDialog(null, "Tiene que proporcionar una opcion correta");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Parece que hubo un error: " + e + "\nIntentalo otra vez.");
            }
            break;
            default:
                JOptionPane.showMessageDialog(null, "Debe de insertar una opcion valida.");
        }
    }

}
