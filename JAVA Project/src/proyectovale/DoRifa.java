package proyectovale;

import java.util.Random;
import javax.swing.JOptionPane;

public class DoRifa implements rifasObligatory {

    Random random = new Random();
    int[] winners = new int[1];

    public void randomizer(Cliente[] cliente) {
        //this vector is for save the winners data
        int[] numberDontRepeat = new int[3];
        /*this vector route the customer's code number and and make a new vector for indentifier
    the code winner through this winner and after that extract the number like a position in customer vector */
        int[] data = new int[1];
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null) {
                data = addData(data, cliente[i].getCodeNumber());
            }
        }
        numberDontRepeat[0] = random.nextInt(1, data.length);
        int temp = numberDontRepeat[0];
        boolean pass = true;
        do {
            int newn = random.nextInt(1, data.length);
            if (temp != newn) {
                numberDontRepeat[1] = newn;
                pass = false;
            }
        } while (pass == true);
        temp = numberDontRepeat[0];
        int temp2 = numberDontRepeat[1];
        pass = true;
        do {
            int newn = random.nextInt(1, data.length);
            if (temp != newn && temp2 != newn) {
                numberDontRepeat[2] = newn;
                pass = false;
            }
        } while (pass == true);
        for (int i = 0; i < numberDontRepeat.length; i++) {
            System.out.println("-------------\n" + numberDontRepeat[i]);;
        }
        JOptionPane.showMessageDialog(null, "¡Ganadores!\n"
                + "Ganador 1: " + cliente[numberDontRepeat[0] - 1].getName() + " " + cliente[numberDontRepeat[0] - 1].getLastname() + "\n"
                + "Ganador 2: " + cliente[numberDontRepeat[1] - 1].getName() + " " + cliente[numberDontRepeat[1] - 1].getLastname() + "\n"
                + "Ganador 3: " + cliente[numberDontRepeat[2] - 1].getName() + " " + cliente[numberDontRepeat[2] - 1].getLastname() + "\n"
                + "\n¡Felicidades a los ganadores!");
        for (int i = 0; i < numberDontRepeat.length; i++) {
            winners = addData(winners, numberDontRepeat[i]);
        }

    }

    public int[] addData(int[] route, int newData) {
        int newSize = route.length + 1;
        int[] newVector = new int[newSize];

        for (int i = 0; i < route.length; i++) {
            newVector[i] = route[i];
        }
        newVector[newSize - 1] = newData;
        return newVector;
    }

    public void winnersName(Cliente[] clienteVector) {
        String find = "";
        System.out.println("GANADORES DE RIFA\n");
        for (int i = 1; i < winners.length; i++) {
            find = "";
            for (int j = 0; j < clienteVector.length; j++) {
                if (clienteVector[j] != null) {
                    if (clienteVector[j].getCodeNumber() == winners[i]) {
                        find = find + clienteVector[j].getName() + " " + clienteVector[j].getLastname();
                    }
                }
            }
            System.out.println(find);
        }

    }

}
