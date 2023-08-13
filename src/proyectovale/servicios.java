package proyectovale;


public class servicios {

    String name;
    String schedule;
    int price;

    public servicios(String name, String schedule, int price) {
        this.name = name;
        this.schedule = schedule;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
