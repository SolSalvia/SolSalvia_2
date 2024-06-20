import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


    public class ExportJSON {

        private RegistroPersonas registro;

        public ExportJSON(RegistroPersonas registro) {
            this.registro = registro;
        }

        public void exportar(Persona[] personas, TestResult resultadoTest) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ExportData data = new ExportData();

            List<Persona> sanas = new ArrayList<>();
            for (Persona persona : personas) {
                boolean estaAislada = false;
                for (Test test : resultadoTest.getResult().values()) {
                    if (persona.getDni().equals(test.getDni()) && test.getTemperature() >= 38) {
                        estaAislada = true;
                        break;
                    }
                }
                if (!estaAislada) {
                    sanas.add(persona);
                }
            }
            data.setSanos(sanas.toArray(new Persona[0]));

            //Casos aislamiento
            List<CasoAislamiento> aislamiento = new ArrayList<>();
            for (Test test : resultadoTest.getResult().values()) {
                if (test.getTemperature() >= 38) {
                    String barrio = registro.obtenerBarrioPorDni(test.getDni());
                    CasoAislamiento caso = new CasoAislamiento(test.getKitNum(), test.getTemperature(), barrio);
                    aislamiento.add(caso);
                }
            }
            data.setAislar(aislamiento.toArray(new CasoAislamiento[0]));

            try (FileWriter writer = new FileWriter("datos.json")) {
                gson.toJson(data, writer);
                System.out.println("Datos exportados a datos.json");
            } catch (IOException e) {
                System.err.println("Error al exportar JSON: " + e.getMessage());
            }
        }

        private static class ExportData {
            private Persona[] sanos;
            private CasoAislamiento[] aislar;

            public Persona[] getSanos() {
                return sanos;
            }

            public void setSanos(Persona[] sanos) {
                this.sanos = sanos;
            }

            public CasoAislamiento[] getAislar() {
                return aislar;
            }

            public void setAislar(CasoAislamiento[] aislar) {
                this.aislar = aislar;
            }
        }

        private static class CasoAislamiento {
            private Integer kit;
            private Float temperature;
            private String barrio;

            public CasoAislamiento(Integer kit, Float temperature, String barrio) {
                this.kit = kit;
                this.temperature = temperature;
                this.barrio = barrio;
            }

            public Integer getKit() {
                return kit;
            }

            public void setKit(Integer kit) {
                this.kit = kit;
            }

            public Float getTemperature() {
                return temperature;
            }

            public void setTemperature(Float temperature) {
                this.temperature = temperature;
            }

            public String getBarrio() {
                return barrio;
            }

            public void setBarrio(String barrio) {
                this.barrio = barrio;
            }
        }
    }
