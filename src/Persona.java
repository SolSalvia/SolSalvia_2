public class Persona {
    private String name;
    private Integer age;
    private String neighborhood;
    private String dni;
    private String occupation;
    private Integer kitNumber;

    public Persona() {
    }

    public Persona(String name, Integer age, String neighborhood, String dni, String occupation, Integer kitNumber) {
        this.name = name;
        this.age = age;
        this.neighborhood = neighborhood;
        this.dni = dni;
        this.occupation = occupation;
        this.kitNumber = kitNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(Integer kitNumber) {
        this.kitNumber = kitNumber;
    }
}
