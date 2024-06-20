import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistroPersonas registro = new RegistroPersonas();

        try {
            registro.addPerson(new Persona("Martin Lopez", 39, "Faro", "53424355", "Desempleado", 0));
            registro.addPerson(new Persona("Aylen Salvia", 25, "Norte", "87654321", "Docente", 0));
            registro.addPerson(new Persona("Malena Rodriguez", 40, "Sur", "12312312", "Medico", 0));
        } catch (ReactivoInsuficienteException e) {
            System.out.println(e.getMessage());
            solicitarMasReactivos(registro);
        }

        //Muestro las personas en el sistema
        System.out.println("Personas registradas:");
        for (Persona p : registro.getPeople()) {
            System.out.println("Nombre: " + p.getName() + ", Edad: " + p.getAge() + ", Barrio: " + p.getNeighborhood() +
                    ", DNI: " + p.getDni() + ", Ocupación: " + p.getOccupation() + ", Kit Number: " + p.getKitNumber());
        }

        //Se testea la temperatura
        TestResult result = new TestResult();
        registro.testear(result);

        //Se muestran los resultados de los test
        System.out.println("\nResultados de los tests:");
        for (Test test : result.getResult().values()) {
            System.out.println("Kit Number: " + test.getKitNum() + ", DNI: " + test.getDni() + ", Temperatura: " + test.getTemperature());
        }

        // Se aisla a los que tienen la temperatura elevada
        registro.aislar(result);

        ExportJSON exportador = new ExportJSON();
        exportador.exportar(registro.getPeople().toArray(new Persona[0]), result);
    }
        private static void solicitarMasReactivos(RegistroPersonas registro){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Quiere tener más reactivos al SSM? s/n");
            String r = scanner.nextLine();
            if(r.equalsIgnoreCase("s")) {
                registro.setAmountReagents(registro.getAmountReagents() + 5);
                System.out.println("Se han agregado 5 reactivos adicionales. Intentando nuevamente agregar personas...");
            }else{
                System.out.println("Operación cancelada. No se han agregado más reactivos.");
            }
        }
    }
