package proyectovale;

public class Instructor extends Persona {
    String[] serviceAssigned;
    public Instructor(String name, String lastname, String ID, String[] serviceAssigned) {
        super(name, lastname, ID);
        this.serviceAssigned = serviceAssigned;
    }

    public String[] getServiceAssigned() {
        return serviceAssigned;
    }

    public void setServiceAssigned(String[] serviceAssigned) {
        this.serviceAssigned = serviceAssigned;
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
