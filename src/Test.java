public class Test {
    private Integer kitNum;
    private String dni;
    private Float temperature;

    public Test() {
    }

    public Test(Integer kitNum, String dni, Float temperature) {
        this.kitNum = kitNum;
        this.dni = dni;
        this.temperature = temperature;
    }

    public Integer getKitNum() {
        return kitNum;
    }

    public void setKitNum(Integer kitNum) {
        this.kitNum = kitNum;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }
}
