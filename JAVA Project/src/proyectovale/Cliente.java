package proyectovale;

public class Cliente extends Persona{
    int codeNumber;
    String[] serviceSignedUp;
    String state; 
    String instructor;

    public Cliente(String name, String lastname, String ID, int codNumber, String[] serSigUp, String state, String instructor) {
        super(name, lastname, ID);
        this.codeNumber = codNumber; 
        this.serviceSignedUp = serSigUp; 
        this. state = state;
        this.instructor = instructor;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String[] getServiceSignedUp() {
        return serviceSignedUp;
    }

    public void setServiceSignedUp(String[] serviceSignedUp) {
        this.serviceSignedUp = serviceSignedUp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
    
}
