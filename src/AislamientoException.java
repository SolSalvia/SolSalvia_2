import java.io.Serializable;

public class AislamientoException extends Exception implements Serializable {
        private Integer numKit;
        private String barrio;

        public AislamientoException(Integer numKit, String barrio) {
            super("Aislamiento necesario: Kit " + numKit + ", Barrio: " + barrio);
            this.numKit = numKit;
            this.barrio = barrio;
        }

        public Integer getNumKit() {
            return numKit;
        }

        public void setNumKit(Integer numKit) {
            this.numKit = numKit;
        }

        public String getBarrio() {
            return barrio;
        }

        public void setBarrio(String barrio) {
            this.barrio = barrio;
        }
}
