import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class RegistroPersonas {
    private List<Persona> people;
    private Integer amountReagents;
    private Integer counterKits;

    public RegistroPersonas() {
        this.people = new ArrayList<>();
        this.amountReagents = 3;
        this.counterKits = 1;
    }

    public RegistroPersonas(List<Persona> people, Integer amountReagents, Integer counterKits) {
        this.people = new ArrayList<>(people);
        this.amountReagents = amountReagents;
        this.counterKits = counterKits;

    }

    public List<Persona> getPeople() {
        return people;
    }

    public void setPeople(List<Persona> people) {
        this.people = people;
    }

    public Integer getAmountReagents() {
        return amountReagents;
    }
    public void setAmountReagents(Integer amountReagents){
        amountReagents = amountReagents;
    }
    public Integer getCounterKits(){
        return counterKits++;
    }
    public void setCounterKits(Integer counterKits) {
        this.counterKits = counterKits;

    }
    public void addPerson(Persona person) throws ReactivoInsuficienteException{
        if(amountReagents <= 0){
            throw new ReactivoInsuficienteException(amountReagents);
        }
        if(!verifyDNI(person.getDni())){
            person.setKitNumber(getCounterKits());
            people.add(person);
            amountReagents--;
        }else{
            System.out.println("El DNI " + person.getDni() + " ya está registrado.");
        }
    }

    public boolean verifyDNI(String dni){
        for(Persona person : people){
            if(person.getDni().equals(dni)){
                return true;
            }
        }
        return false;
    }
    public void testear(TestResult resultadoTest){
        Random rand = new Random();
        for(Persona p : people){
            float temperature = 36 + rand.nextFloat() * 3;
            Test test = new Test(p.getKitNumber(), p.getDni(), temperature);
            resultadoTest.addResult(test);
        }
    }
    public void aislar(TestResult resultadoTest){
        for(Test test : resultadoTest.getResult().values()){
            if(test.getTemperature() >= 38){
                try{
                    throw new AislamientoException(test.getKitNum(), obtenerBarrioPorDni(test.getDni()));
                }catch (AislamientoException e){
                    System.out.println("Aislamiento necesario: Kit " + e.getNumKit() + ", Barrio: " + e.getBarrio());
                    //GUARDAR en archivo binario urgente.dat
                }
            }
        }
    }

    public String obtenerBarrioPorDni(String dni){
        for(Persona p : people){
            if(p.getDni().equals(dni)){
                return p.getNeighborhood();
            }
        }
        return null;
    }
    private void saveFile(AislamientoException aislamientoException){
        String filename = "urgente.dat";
        try(ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(filename, true))) {
            archivo.writeObject(aislamientoException);
            System.out.println("Datos de aislamiento guardados en " + filename);
        }catch(IOException exc){
            System.err.println("Error al guardar en archivo: " + exc.getMessage());
        }
    }
}
