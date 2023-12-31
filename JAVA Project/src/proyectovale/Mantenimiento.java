package proyectovale;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mantenimiento {

    Instructor[] instructor = new Instructor[10];
    Cliente customer[] = new Cliente[20];
    servicios servicesVector[] = new servicios[4];
    DoRifa dr = new DoRifa();
//  recepcionClientes = new Recepcion_Clientes(espacio);
    Object[] servicesOptions = {"Ejercicios con maquinas", "Ejercicios funcionales", "Aerobicos", "Calistenia"};
    int numberCountCode = 1;
    Modificaciones modifi = new Modificaciones();

    public void singUpACustomer() {
        String[] MachineWorkout = new String[3];
        String[] FuctionalWorkout = new String[3];
        String[] InAerobics = new String[3];
        String[] InCalistenic = new String[3];
        String validate[] = new String[servicesVector.length];
        boolean Continue = true;
        String name = "";
        String lastname = "";
        String ID = "";
        int pass = 1;
        try {
            name = JOptionPane.showInputDialog("Nombre del cliente: ");
            lastname = JOptionPane.showInputDialog("Apellido: ");
            ID = "";

            boolean yes = false;
            boolean equal = false;
            do {
                ID = JOptionPane.showInputDialog("ID: ");
                equal = false;
                for (int i = 0; i < customer.length; i++) {
                    if (customer[i] != null) {
                        if (ID.equals(customer[i].getID())) {
                            equal = true;
                        }
                    }
                }
                if (equal == true) {
                    JOptionPane.showMessageDialog(null, "Ya hay un cliente con ese ID.");
                } else {
                    yes = true;
                }

            } while (yes != true);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe de insertar un dato");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Parece que a ocurrido un error, puede deberse a que no has colocado un ID apropiado.");
            pass = 0;
        }
        if (pass == 1) {
            do {
                try {
                    int counter = 0;
                    Object serviceChoose = JOptionPane.showInputDialog(null, "Escoga el servicio que desea: ", "Escoga", JOptionPane.QUESTION_MESSAGE, null, servicesOptions, servicesOptions[0]);
                    String serviceCho = serviceChoose.toString();
                    for (int i = 0; i <= validate.length; i++) {
                        if (validate[i] != null) {
                            if (validate[i] == serviceCho) {
                                JOptionPane.showMessageDialog(null, "Lo siento, debe de escoger un servicio diferente, ya usted registro este anteriormente.");
                                break;
                            }
                        } else {
                            validate[i] = serviceCho;
                            for (int j = 0; j < validate.length; j++) {
                                if (validate[j] != null) {
                                    counter = counter + 1;
                                }
                            }
                            if (counter == 4) {
                                JOptionPane.showMessageDialog(null, "Ya has escogido todos los servicios diponibles.");
                                Continue = false;
                                break;
                            }
                            int option = Integer.parseInt(JOptionPane.showInputDialog("¿Quiere escoger otro servicio? \n1. Si \n2. No"));
                            if (option != 1) {
                                Continue = false;
                            }
                            break;
                        }
                    }
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Inserte un dato");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Inserte un dato");
                }

            } while (Continue == true);
            int position = 0;
            int position1 = 0;
            int position2 = 0;
            int position3 = 0;
            for (String elementoA : validate) {
                if ("Ejercicios con maquinas".equals(elementoA)) {
                    for (int i = 0; i < instructor.length; i++) {
                        if (instructor[i] != null) {
                            Instructor instruct = instructor[i];
                            String[] serviceAssigned = instruct.getServiceAssigned();
                            for (String elementoB : serviceAssigned) {
                                if (elementoA == elementoB) {
                                    MachineWorkout[position] = instructor[i].getName() + " " + instructor[i].getLastname();
                                    position = position + 1;
                                }
                            }
                        }
                    }
                } else if ("Ejercicios funcionales".equals(elementoA)) {
                    for (int i = 0; i < instructor.length; i++) {
                        if (instructor[i] != null) {
                            Instructor instruct = instructor[i];
                            String[] serviceAssigned = instruct.getServiceAssigned();
                            for (String elementoB : serviceAssigned) {
                                if (elementoA == elementoB) {
                                    FuctionalWorkout[position1] = instructor[i].getName() + " " + instructor[i].getLastname();
                                    position1 = position1 + 1;
                                }
                            }
                        }
                    }
                } else if ("Aerobicos".equals(elementoA)) {
                    for (int i = 0; i < instructor.length; i++) {
                        if (instructor[i] != null) {
                            Instructor instruct = instructor[i];
                            String[] serviceAssigned = instruct.getServiceAssigned();
                            for (String elementoB : serviceAssigned) {
                                if (elementoA == elementoB) {
                                    InAerobics[position2] = instructor[i].getName() + " " + instructor[i].getLastname();
                                    position2 = position2 + 1;
                                }
                            }
                        }
                    }
                } else if ("Calistenia".equals(elementoA)) {
                    for (int i = 0; i < instructor.length; i++) {
                        if (instructor[i] != null) {
                            Instructor instruct = instructor[i];
                            String[] serviceAssigned = instruct.getServiceAssigned();
                            for (String elementoB : serviceAssigned) {
                                if (elementoA == elementoB) {
                                    InCalistenic[position3] = instructor[i].getName() + " " + instructor[i].getLastname();
                                    position3 = position3 + 1;
                                }
                            }
                        }
                    }
                }
            }
            //this variables save what is the services to client choose of each one 
            String machine = "";
            String functional = "";
            String calistenic = "";
            String aerobic = "";
            for (int i = 0; i < validate.length; i++) {
                if (validate[i] == "Ejercicios con maquinas") {
                    machine = validate[i];
                } else if (validate[i] == "Ejercicios funcionales") {
                    functional = validate[i];
                } else if (validate[i] == "Aerobicos") {
                    aerobic = validate[i];
                } else if (validate[i] == "Calistenia") {
                    calistenic = validate[i];
                }
            }
            //This variables count how much instructor there is in each one services, for example if in
            //the Machine work's service there is two instructors assigned, the variable "machineWork" count two 
            int machineWork = 0;
            int functionalWork = 0;
            int calistenicWork = 0;
            int aerobicWork = 0;
            //how much instructor there is in each one vector instructor find
            for (int i = 0; i < MachineWorkout.length; i++) {
                if (MachineWorkout[i] != null) {
                    machineWork = machineWork + 1;
                }
            }
            for (int i = 0; i < FuctionalWorkout.length; i++) {
                if (FuctionalWorkout[i] != null) {
                    functionalWork = functionalWork + 1;
                }
            }
            for (int i = 0; i < InCalistenic.length; i++) {
                if (InCalistenic[i] != null) {
                    calistenicWork = calistenicWork + 1;
                }
            }
            for (int i = 0; i < InAerobics.length; i++) {
                if (InAerobics[i] != null) {
                    aerobicWork = aerobicWork + 1;
                }
            }
            String findValue = "";
            String instructors = "";
            //Validate workoutMachine there is one more intructor 
            if (machineWork > 1 && "Ejercicios con maquinas".equals(machine)) { //if counting machineWork is greater of one , its say
                //that there is more of one instructor in Machine WorkOut and machine is "Ejercicios con Maquina" validated that was choose for the client
                //and ente to the "true if", if not so to do the "if else"
                for (int i = 0; i < MachineWorkout.length; i++) {
                    if (MachineWorkout[i] != null) {
                        findValue = findValue + i + ". " + MachineWorkout[i] + "\n";  //concatenation of the results
                        /*Example:  0. Carlos Segura  -> First result
                                      1. Pedro Morera   -> Second result*/
                    }
                }
                int option = 0;
                boolean Continue2;
                do {
                    Continue2 = false;
                    try {
                        option = Integer.parseInt(JOptionPane.showInputDialog(null, "Hay mas de 1 entrenador en Ejercicios de maquinas, "
                                + "debe de seleccionar a uno para que sea entrenador de este cliente: \n" + findValue));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Tienes que insertar un dato.");
                        Continue2 = true;
                    }
                } while (Continue2 == true);

                instructors = instructors + "Entrenador de Ejercicio en Maquina: " + MachineWorkout[option] + "\n";
                /*instructor's concatenation save 
                                                                                                                                                                    the option with line break for more order*/
            } else if (machineWork == 1 && "Ejercicios con maquinas".equals(machine)) { //if only one instructor in this service, dont ask, only save this
                instructors = instructors + "Entrenador de Ejercicio en Maquina: " + MachineWorkout[0] + "\n";
            } else if (machineWork == 0) { //if no one there is assigned in this service or the client dont choose this service so dont do nothing
                System.out.println("");
            }
            findValue = "";
            //Validate functional WorkOut there is one more intructor 
            if (functionalWork > 1 && "Ejercicios funcionales".equals(functional)) {
                for (int i = 0; i < FuctionalWorkout.length; i++) {
                    if (FuctionalWorkout[i] != null) {
                        findValue = findValue + i + ". " + FuctionalWorkout[i] + "\n";
                    }
                }
                boolean Continue2;
                int option = 0;
                do {
                    Continue2 = false;
                    try {
                        option = Integer.parseInt(JOptionPane.showInputDialog(null, "Hay mas de 1 entrenador en Ejercicios de maquinas, "
                                + "debe de seleccionar a uno para que sea entrenador de este cliente: \n" + findValue));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Tienes que insertar un dato.");
                        Continue2 = true;
                    }
                } while (Continue2 == true);
                instructors = instructors + "Entrenador de Ejercicio funcionales: " + FuctionalWorkout[option] + "\n";
            } else if (functionalWork == 1 && "Ejercicios funcionales".equals(functional)) {
                instructors = instructors + "Entrenador de Ejercicio funcionales: " + FuctionalWorkout[0] + "\n";
            } else if (functionalWork == 0) {
                System.out.println("");
            }
            findValue = "";
            //Validate Aerobics there is one more intructor 
            if (aerobicWork > 1 && "Aerobicos".equals(aerobic)) {
                for (int i = 0; i < InAerobics.length; i++) {
                    if (InAerobics[i] != null) {
                        findValue = findValue + i + ". " + InAerobics[i] + "\n";
                    }
                }
                boolean Continue2;
                int option = 0;
                do {
                    Continue2 = false;
                    try {
                        option = Integer.parseInt(JOptionPane.showInputDialog(null, "Hay mas de 1 entrenador en Ejercicios de maquinas, "
                                + "debe de seleccionar a uno para que sea entrenador de este cliente: \n" + findValue));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Tienes que insertar un dato.");
                        Continue2 = true;
                    }
                } while (Continue2 == true);
                instructors = instructors + "Entrenador de Aerobicos: " + InAerobics[option] + "\n";
            } else if (aerobicWork == 1 && "Aerobicos".equals(aerobic)) {
                instructors = instructors + "Entrenador de Aerobicos: " + InAerobics[0] + "\n";
            } else if (aerobicWork == 0) {
                System.out.println("");
            }
            findValue = "";
            //Validate Calistenics there is one more intructor 
            if (calistenicWork > 1 && "Calistenia".equals(calistenic)) {
                for (int i = 0; i < InCalistenic.length; i++) {
                    if (InCalistenic[i] != null) {
                        findValue = findValue + i + ". " + InCalistenic[i] + "\n";
                    }
                }
                boolean Continue2;
                int option = 0;
                do {
                    Continue2 = false;
                    try {
                        option = Integer.parseInt(JOptionPane.showInputDialog(null, "Hay mas de 1 entrenador en Ejercicios de maquinas, "
                                + "debe de seleccionar a uno para que sea entrenador de este cliente: \n" + findValue));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Tienes que insertar un dato.");
                        Continue2 = true;
                    }
                } while (Continue2 == true);
                instructors = instructors + "Entrenador de Calistenia: " + InCalistenic[option] + "\n";
            } else if (calistenicWork == 1 && "Aerobicos".equals(calistenic)) {
                instructors = instructors + "Entrenador de Calistenia: " + InCalistenic[0] + "\n";
            } else if (calistenicWork == 0) {
                System.out.println("");
            }
            ImageIcon icon = new ImageIcon("src\\img\\ListoOk.png");
            for (int i = 0; i < customer.length; i++) {
                if (customer[i] != null) {
                    System.out.println(customer[i].getCodeNumber());
                    if (customer[i].getCodeNumber() == numberCountCode) {
                        numberCountCode = numberCountCode + 1;
                    }
                }

            }
            for (int i = 0; i < customer.length; i++) {
                if (customer[i] == null) {
                    customer[i] = new Cliente(name, lastname, ID, numberCountCode, validate, "Activo", instructors);
                    String ser = "";
                    Cliente client = customer[i];
                    String[] serviceAssigned = client.getServiceSignedUp();
                    for (String servicio : serviceAssigned) {
                        if (servicio == null) {
                            System.out.println("");
                        } else {
                            ser = ser + servicio + ", ";
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Cliente registrado con exito. \nCliente: " + customer[i].getName()
                            + "\nApellido: " + customer[i].getLastname() + "\nNumero de codigo (Para fines de Rifa): " + customer[i].getCodeNumber()
                            + "\nServicios suscrito: " + ser + "\nEstado: " + customer[i].getState() + "\nInstructor o instructores: \n " + customer[i].getInstructor(), "Registro exitoso",
                            JOptionPane.INFORMATION_MESSAGE, icon);

                    numberCountCode = numberCountCode + 1;
                    break;
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Puede que haya habido un error, vuelve a intentarlo despues");
        }

    }

    public void registerServices() {
        servicesVector[0] = new servicios("Ejercicios con maquinas", "L: 7 - 12", 15000);
        servicesVector[1] = new servicios("Ejercicios funcionales", "L: 17 - 19", 10000);
        servicesVector[2] = new servicios("Aerobicos", "V: 7 - 12", 15000);
        servicesVector[3] = new servicios("Calistenia", "M: 12 - 17", 15000);
    }

    public void registerInstructor() {
        boolean next = true;
        boolean yes = false;
        boolean equal = false;
        String serviceChooseForUser = "";
        String[] vectorServicesAssigned = new String[3];
        String ID = "";
        String name = JOptionPane.showInputDialog(null, "Nombre del instructor: ");
        String lastName = JOptionPane.showInputDialog(null, "Apellido: ");
        do {
            ID = JOptionPane.showInputDialog(null, "ID del instructor: ");
            equal = false;
            for (int i = 0; i < instructor.length; i++) {
                if (instructor[i] != null) {
                    if (ID.equals(instructor[i].getID())) {
                        equal = true;
                    }
                }
            }
            if (equal == true) {
                JOptionPane.showMessageDialog(null, "Ya hay un instructor con ese ID.");
            } else {
                yes = true;
            }

        } while (yes != true);

        do {
            int assignedService = 0;
            boolean con;
            do {
                con = false;
                try {
                    assignedService = Integer.parseInt(JOptionPane.showInputDialog("¿Qué servicio tendra asiganado este instructor?"
                            + "\n1. " + servicesVector[0].getName() + "\n2. " + servicesVector[1].getName() + "\n3. " + servicesVector[2].getName() + "\n4. " + servicesVector[3].getName() + "\n5. Salir"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe de proporcionar un dato valido.");
                    con = true;
                }
            } while (con == true);

            System.out.println("Opcion es: " + assignedService);
            if (assignedService == 5) {
                next = false;
                break;
            }
            if (assignedService == 1) {
                serviceChooseForUser = "Ejercicios con maquinas";
            } else if (assignedService == 2) {
                serviceChooseForUser = "Ejercicios funcionales";
            } else if (assignedService == 3) {
                serviceChooseForUser = "Aerobicos";
            } else if (assignedService == 4) {
                serviceChooseForUser = "Calistenia";
            }
            for (int i = 0; i < vectorServicesAssigned.length; i++) {
                if (vectorServicesAssigned[i] != null) {
                    if (vectorServicesAssigned[i] == serviceChooseForUser) {
                        JOptionPane.showMessageDialog(null, "El instructor debe de desempeñar un servicio diferente.");
                        break;
                    }
                } else {
                    vectorServicesAssigned[i] = serviceChooseForUser;
                    int continues = Integer.parseInt(JOptionPane.showInputDialog("¿Deseas continuar asignandole otros servicios a este instructor?"
                            + "\n1. Si\n2. No"));
                    if (continues != 1) {
                        next = false;
                        break;
                    }
                    break;
                }
            }
        } while (next == true);
        String ser = "";
        for (int i = 0; i < instructor.length; i++) {
            if (instructor[i] == null) {
                instructor[i] = new Instructor(name, lastName, ID, vectorServicesAssigned);
                Instructor instruct = instructor[i];
                String[] serviceAssigned = instruct.getServiceAssigned();
                for (String servicio : serviceAssigned) {
                    if (servicio != null) {
                        ser = ser + servicio + "\n";
                    }

                }

                JOptionPane.showMessageDialog(null, "Instructor registrado con los siguientes datos: "
                        + "\nNombre: " + instructor[i].getName() + "\nApellido: " + instructor[i].getLastname()
                        + "\nID: " + instructor[i].getID() + "\nServicios asignados: " + ser);
                break;
            }
        }
    }
//Initializacion of instructor, when we start the program, already there this instructor

    public void instructorAuto() {
        String[] vector = {"Ejercicios con maquinas", "Calistenia"};
        instructor[0] = new Instructor("Daniel", "Mora", "1", vector);
        String[] vector1 = {"Aerobicos", "Calistenia"};
        instructor[1] = new Instructor("Joset", "Perez", "2", vector1);
        String[] vector2 = {"Calistenia", "Ejercicios funcionales"};
        instructor[2] = new Instructor("Mario", "Contreras", "3", vector2);
        String[] vector3 = {"Ejercicios con maquinas", "Ejercicios funcionales"};
        instructor[3] = new Instructor("Carlos", "Rojas", "4", vector3);
    }

    public void customerAuto() {
        String[] vector = {"Ejercicios con maquinas", "Calistenia"};
        customer[0] = new Cliente("Luis", "Garcia", "122", 1, vector, "Activo", "Entrenador de Calistenia: Daniel\n"
                + "Entrenador de Ejercicios con maquinas: Carlos\n");
        String[] vector2 = {"Calistenia", "Ejercicios funcionales"};
        customer[1] = new Cliente("Hector", "Cortés", "133", 2, vector2, "Activo", "Entrenador de Calistenia: Joset\n"
                + "Entrenador de Ejercicios funcionales: Mario\n");
        customer[2] = new Cliente("Mario", "Mora", "144", 3, vector2, "Activo", "Entrenador de Calistenia: Joset\n"
                + "Entrenador de Ejercicios funcionales: Mario\n");
        customer[3] = new Cliente("Nick", "Mendez", "155", 4, vector2, "Activo", "Entrenador de Calistenia: Joset\n"
                + "Entrenador de Ejercicios funcionales: Mario\n");
        customer[4] = new Cliente("Bryan", "Matarrita", "166", 5, vector2, "Activo", "Entrenador de Calistenia: Joset\n"
                + "Entrenador de Ejercicios funcionales: Mario\n");
    }

    // Here we going to make the metod that modifier the customer
    public void modifierTheCustomer() {
        boolean findCustomer = false;
        int vectorPosition = 0;
        String idClient = JOptionPane.showInputDialog(null, "ID del cliente: ");
        for (int i = 0; i < customer.length; i++) {
            if (customer[i] != null) {
                if (customer[i].getID().equals(idClient)) {
                    findCustomer = true;
                    vectorPosition = i;
                    JOptionPane.showMessageDialog(null, "Cliente encontrado con el ID " + idClient + ": \n" + customer[i].getName() + " " + customer[i].getLastname());
                }
            }
        }
        if (findCustomer) {
            try {
                int option = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Que espacio desea modificar del cliente? "
                        + "\n1. Servicios inscritos"
                        + "\n2. Actividad del cliente"
                        + "\n3. Cambiar instructor"));
                modifi.modificar(option, customer, vectorPosition, instructor, servicesVector);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error, intente nuevamente." + e);
            }

//            System.out.println("Verificar cambios");
//            Cliente clieente = customer[vectorPosition];
//            String[] guarda = clieente.getServiceSignedUp();
//            for (String string : guarda) {
//                System.out.println(string);
//            }
        } else {
            JOptionPane.showMessageDialog(null, "Lo siento, no se encontro ningun cliente con"
                    + "el siguiente ID: \n" + idClient);
        }

    }

    // Here we going to make the metod that modifier the Intructor
    public void modifierTheInstructorOrService() {
        int wanToDo = 0;
        boolean continues;
        do {
            continues = false;
            try {
                wanToDo = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea hacer? \n1. Modificar servicios de un instructor\n2. Modificar servicios"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Proporcione un dato");
                continues = true;
            }
        } while (continues == true);

        switch (wanToDo) {
            case 1:
                boolean findCustomer = false;
                int vectorPosition = 0;
                String idInstructor = JOptionPane.showInputDialog(null, "ID del instructor: ");
                for (int i = 0; i < instructor.length; i++) {
                    if (instructor[i] != null) {
                        if (instructor[i].getID().equals(idInstructor)) {
                            findCustomer = true;
                            vectorPosition = i;
                            JOptionPane.showMessageDialog(null, "Instructor encontrado con el ID " + idInstructor + ": \n" + instructor[i].getName() + " " + instructor[i].getLastname());
                        }
                    }
                }
                if (findCustomer) {
                    int option = 0;
                    boolean continues2;
                    do {
                        continues2 = false;
                        try {
                            option = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea \n1. Añadir\n2. Borrar\nalgun servicio a este instructor? "));
                            if (option >= 3) {
                                JOptionPane.showMessageDialog(null, "Debe de ser una opcion mostrada en pantalla");
                                continues2 = true;
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Proporcione un dato");
                            continues2 = true;
                        }
                    } while (continues2 == true);

                    modifi.modificar(instructor, vectorPosition, option, servicesVector);
                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento, no se encontro ningun instructor con"
                            + "el siguiente ID: \n" + idInstructor);
                }
                break;
            case 2:
                String find = "";
                for (int i = 0; i < servicesVector.length; i++) {
                    find = find + i + ". " + servicesVector[i].getName() + "\n";
                }
                int positionOption = Integer.parseInt(JOptionPane.showInputDialog("Estos son los servicios actualmente disponibles: \n" + find + "\n¿Cual deseas modificar?"));
                modifierTheService(positionOption, 3);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Seleccione una de las opciones mostradas en pantalla.");
        }
        //No way => No puede ser
    }

    // Here we going to make the metod that modifier the Service
    public void modifierTheService(int positionOption, int wanToDo) {
        modifi.modificar(instructor, positionOption, wanToDo, servicesVector);
    }

    public void toDoRifa() {
        dr.randomizer(customer);
    }

    public void listCustomers() {
        int option = Integer.parseInt(JOptionPane.showInputDialog("¿Que listado desea generar?\n"
                + "1. Listado de clientes (Activos e Inactivos)\n"
                + "2. Generar lista de Servicios asignados a un determinado Instructor\n"
                + "3. Generar lista de clientes inscritos en un determinado servicio\n"
                + "4. Listado de clientes que han ganado la rifa"));
        switch (option) {
            case 1:
                System.out.println("CLIENTES ACTUALMENTE INSCRITOS (Activos e Inactivos)\n");

                for (int i = 0; i < customer.length; i++) {
                    if (customer[i] != null) {
                        System.out.println("----------------------------------------------------------------------------------------------------------");
                        System.out.printf("%10s  %10s  %10s  ", "Codigo", "Nombre", "Apellido\n");
                        Cliente client = customer[i];
                        String[] customerServices = client.getServiceSignedUp();
                        String ser = "";
                        for (String customerService : customerServices) {
                            if (customerService != null) {
                                ser = ser + customerService + "\n";
                            }
                        }
                        String schedule = "";
                        for (String customerService : customerServices) {
                            if (customerService != null) {
                                for (int j = 0; j < servicesVector.length; j++) {
                                    if (servicesVector[j] != null) {
                                        if (customerService == servicesVector[j].getName()) {
                                            schedule = schedule + servicesVector[j].getSchedule() + "\n";
                                        }
                                    }
                                }
                            }
                        }

                        System.out.printf("%10s  %10s  %10s  ", customer[i].getCodeNumber(), customer[i].getName(), customer[i].getLastname() + "\n");
                        System.out.println("SERVICIOS INSCRITOS: \n"
                                + ser);
                        System.out.println("HORARIOS: \n"
                                + schedule);
                        System.out.println("INSTRUCTORES: \n"
                                + customer[i].getInstructor());
                    }
                }
                break;
            case 2:
//                String find = "";
//                for (int i = 0; i < servicesVector.length; i++) {
//                    find = find + i + ". " + servicesVector[i].getName() + "\n";
//                }
                String options = JOptionPane.showInputDialog("ID del instructor");
                int option1 = 0;
                boolean find = false;
                for (int i = 0; i < instructor.length; i++) {
                    if (instructor[i] != null) {
                        if (options.equals(instructor[i].getID())) {
                            option1 = i;
                            find = true;
                        }
                    }
                }
                if (find == true) {
                    searchInstructo(option1, instructor);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun entrenador con el ID de " + options);
                }

                break;
            case 3:
                String find2 = "";
                for (int i = 0; i < servicesVector.length; i++) {
                    find2 = find2 + i + ". " + servicesVector[i].getName() + "\n";
                }
                String fin = "";
                boolean findw = false;
                int position = Integer.parseInt(JOptionPane.showInputDialog("Estos son los servicios, eliga uno \n"
                        + "para realizar la busqueda\n" + find2));
                for (int i = 0; i < customer.length; i++) {
                    if (customer[i] != null) {
                        Cliente iss = customer[i];
                        String[] servicesCustomer = iss.getServiceSignedUp();
                        for (String elementService : servicesCustomer) {
                            if (elementService != null) {
                                if (elementService == servicesVector[position].getName()) {
                                    fin = fin + customer[i].getName() + " " + customer[i].getLastname() + "\n";
                                    findw = true;
                                }
                            }
                        }
                    }
                }
                if (findw) {
                    JOptionPane.showMessageDialog(null, "Clientes en el servicicio de "
                            + servicesVector[position].getName()
                            + "\n" + fin);
                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento, no se encontró ningun cliente\ninscrito a "
                            + servicesVector[position].getName());
                }

                break;
            case 4:
                dr.winnersName(customer);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void searchInstructo(int position, Instructor[] vector) {
        Instructor ins = vector[position];
        String[] services = ins.getServiceAssigned();
        String ser = "";
        for (String service : services) {
            if (service != null) {
                ser = ser + service + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, "Usted esta viendo la informacion del instructor \n"
                + instructor[position].getName() + " con ID " + instructor[position].getID() + "\nServicios asignados: \n" + ser);

    }
}
