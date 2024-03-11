import java.util.ArrayList;

class Equipo {
    private String nombreEquipo;
    private String paisEquipo;
    private ArrayList<Ciclista> ciclistas;

    public Equipo(String nombreEquipo, String paisEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.paisEquipo = paisEquipo;
        this.ciclistas = new ArrayList<>();
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getPaisEquipo() {
        return paisEquipo;
    }

    public void setPaisEquipo(String paisEquipo) {
        this.paisEquipo = paisEquipo;
    }

    public ArrayList<Ciclista> getCiclistas() {
        return ciclistas;
    }

    // Método para agregar un ciclista al equipo
    protected void agregarCiclista(Ciclista ciclista, int tiempo) {
        ciclista.agregarTiempo(tiempo);
        ciclistas.add(ciclista);
    }

    // Método para calcular el tiempo total de los ciclistas del equipo
    protected int calcularTiempoTotal() {
        int tiempoTotal = 0;
        for (Ciclista ciclista : ciclistas) {
            tiempoTotal += ciclista.getTiempoAcumulado();
        }
        return tiempoTotal;
    }

    // Método para imprimir los datos del equipo en pantalla
    protected void imprimirDatosEquipo() {
        System.out.println("Nombre del Equipo: " + nombreEquipo);
        System.out.println("País del Equipo: " + paisEquipo);
        System.out.println("Tiempo Total de los Ciclistas: " + calcularTiempoTotal() + " minutos");
        System.out.println("Listado de Ciclistas:");
        for (Ciclista ciclista : ciclistas) {
            imprimirDatosCiclista(ciclista);
        }
    }

    // Método para imprimir los datos de un ciclista en pantalla
    private void imprimirDatosCiclista(Ciclista ciclista) {
        System.out.println(" ★ " + ciclista.getNombre());
/*      System.out.println("Identificador: " + ciclista.getIdentificador());
        System.out.println("Tiempo en Carreras: " + ciclista.getTiempoAcumulado() + " minutos");
        System.out.println(ciclista.imprimirTipo());
        if (ciclista instanceof Velocista) {
            Velocista velocista = (Velocista) ciclista;
            System.out.println("Potencia Promedio: " + velocista.getPotenciaPromedio() + " j/s");
            System.out.println("Velocidad Promedio en Sprint: " + velocista.getVelocidadSprint() + " km/h");
        } else if (ciclista instanceof Escalador) {
            Escalador escalador = (Escalador) ciclista;
            System.out.println("Aceleración Promedio en Subida: " + escalador.getAceleracionSubida() + " m/s²");
            System.out.println("Grado de Rampa Soportada: " + escalador.getGradoRampa() + "°");
        } else if (ciclista instanceof Contrarrelojista) {
            Contrarrelojista contrarrelojista = (Contrarrelojista) ciclista;
            System.out.println("Velocidad Máxima: " + contrarrelojista.getVelocidadMaxima() + " km/h");
        }
        System.out.println("----------------------------");
        */
    }
}