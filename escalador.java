class Escalador extends Ciclista {
    private float aceleracionSubida;
    private float gradoRampa;

    public Escalador(int identificador, String nombre, float aceleracionSubida, float gradoRampa) {
        super(identificador, nombre);
        this.aceleracionSubida = aceleracionSubida;
        this.gradoRampa = gradoRampa;
    }

    public float getAceleracionSubida() {
        return aceleracionSubida;
    }

    public void setAceleracionSubida(float aceleracionSubida) {
        this.aceleracionSubida = aceleracionSubida;
    }

    public float getGradoRampa() {
        return gradoRampa;
    }

    public void setGradoRampa(float gradoRampa) {
        this.gradoRampa = gradoRampa;
    }

    @Override
    public String imprimirTipo() {
        return "Es un Escalador";
    }
}