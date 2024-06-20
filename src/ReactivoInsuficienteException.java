public class ReactivoInsuficienteException extends Exception {
        private Integer cantReagents;

        public ReactivoInsuficienteException(Integer cantReagents){
            super("Reactivos insuficientes: " + cantReagents);
            this.cantReagents = cantReagents;
        }

        public Integer getCantReagents() {
            return cantReagents;
        }

        public void setCantReagents(Integer cantReagents) {
            this.cantReagents = cantReagents;
        }
    }

