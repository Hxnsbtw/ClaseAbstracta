import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class prueba {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Equipo> equipos = new HashMap<>();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    agregarEquipo();
                    break;
                case 2:
                    agregarCiclista();
                    break;
                case 3:
                    verInfoEquipo();
                    break;
                case 4:
                    buscarCiclista();
                    break;
                case 5:
                    System.out.println("Usted esta saliendo del programa. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Seleccione una opción de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SELECCIONE UNA OPCIÓN DEL MENÚ =====");
        System.out.println("1. Agregar equipo");
        System.out.println("2. Agregar ciclista");
        System.out.println("3. Ver información de equipo");
        System.out.println("4. Buscar ciclista");
        System.out.println("5. Salir");
    }

    private static void agregarEquipo() {
        System.out.print("Ingrese el NOMBRE del equipo: ");
        String nombreEquipo = scanner.nextLine();

        System.out.print("Ingrese el PAÍS del equipo: ");
        String paisEquipo = scanner.nextLine();

        Equipo nuevoEquipo = new Equipo(nombreEquipo, paisEquipo);
        equipos.put(nombreEquipo, nuevoEquipo);

        System.out.println("Equipo agregado correctamente.");
    }

    private static void agregarCiclista() {
        System.out.print("Ingrese el NOMBRE DEL EQUIPO al que pertenece el ciclista: ");
        String nombreEquipo = scanner.nextLine();

        if (!equipos.containsKey(nombreEquipo)) {
            System.out.println("Equipo NO ENCONTRADO. Por favor, agregue el equipo primero.");
            return;
        }

        Equipo equipo = equipos.get(nombreEquipo);

        System.out.print("Ingrese el IDENTIFICADOR CICLISTA: ");
        int identificador = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese el NOMBRE DEL CICLISTA: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el TIEMPO EN CARRERA DEL CICLISTA minutos: ");
        int tiempo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Seleccione el TIPO DE CICLISTA: ");
        System.out.println(" ");
        System.out.println("1. Velocista");
        System.out.println("2. Escalador");
        System.out.println("3. Contrarrelojista");
        int tipoCiclista = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        Ciclista nuevoCiclista = null;

        switch (tipoCiclista) {
            case 1:
                System.out.print("Ingrese la POTENCIA EN PROMEDIO del velocista (j/s): ");
                double potenciaPromedio = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner
                System.out.print("Ingrese la VELOCIDAD PROMEDIO en sprint del velocista (km/h): ");
                double velocidadSprint = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner

                nuevoCiclista = new Velocista(identificador, nombre, potenciaPromedio, velocidadSprint);
                break;
            case 2:
                System.out.print("Ingrese la ACELERACIÓN PROMEDIO en subida del escalador (m/s²): ");
                float aceleracionSubida = scanner.nextFloat();
                scanner.nextLine(); // Limpiar el buffer del scanner
                System.out.print("Ingrese el GRADO DE RAMPA soportada del escalador (°): ");
                float gradoRampa = scanner.nextFloat();
                scanner.nextLine(); // Limpiar el buffer del scanner

                nuevoCiclista = new Escalador(identificador, nombre, aceleracionSubida, gradoRampa);
                break;
            case 3:
                System.out.print("Ingrese la VELOCIDAD MÁXIMA del contrarrelojista (km/h): ");
                double velocidadMaxima = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner

                nuevoCiclista = new Contrarrelojista(identificador, nombre, velocidadMaxima);
                break;
            default:
                System.out.println("Tipo de ciclista no válido.");
                return;
        }

        equipo.agregarCiclista(nuevoCiclista, tiempo);
        System.out.println("Ciclista añadido correctamente al equipo.");
    }

    private static void verInfoEquipo() {
        System.out.print("Ingrese el NOMBRE DEL EQUIPO que desea ver: ");
        String nombreEquipo = scanner.nextLine();
        System.out.println("----------------------------");

        if (!equipos.containsKey(nombreEquipo)) {
            System.out.println("Equipo no encontrado.");
            return;
        }

        Equipo equipo = equipos.get(nombreEquipo);
        equipo.imprimirDatosEquipo();
    }

    private static void buscarCiclista() {
        System.out.print("Ingrese el IDENTIFICADOR DEL CICLISTA a buscar: ");
        int identificador = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        Ciclista ciclistaEncontrado = null;

        for (Equipo equipo : equipos.values()) {
            for (Ciclista ciclista : equipo.getCiclistas()) {
                if (ciclista.getIdentificador() == identificador) {
                    ciclistaEncontrado = ciclista;
                    break;
                }
            }
        }

        if (ciclistaEncontrado != null) {
            System.out.println("Ciclista encontrado:");
            imprimirDatosCiclista(ciclistaEncontrado);
        } else {
            System.out.println("Ciclista no encontrado.");
        }
    }

    private static void imprimirDatosCiclista(Ciclista ciclista) {
        System.out.println("Nombre: " + ciclista.getNombre());
        System.out.println("Identificador: " + ciclista.getIdentificador());
        System.out.println("Tiempo Acumulado: " + ciclista.getTiempoAcumulado() + " minutos");
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
    }
    
}