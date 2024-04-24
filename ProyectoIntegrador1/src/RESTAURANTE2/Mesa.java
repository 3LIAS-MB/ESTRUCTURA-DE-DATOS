package RESTAURANTE2;

public class Mesa {
    private static int contadorMesas = 1;

    private int numeroMesa ;
    private int capacidad; // 2 o 4
    private String estado; // libre, ocupada
    private String servicio; // ninguno, espera, atendido, servida
    private int comensales;

    public Mesa(int capacidad) {
        this.numeroMesa =  contadorMesas++;
        this.capacidad = capacidad;
        this.estado = "libre";
        this.servicio = "ninguno";
        this.comensales = 0;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public String getEstado() {
        return estado;
    }

    public String getServicio() {
        return servicio;
    }

    public int getComensales() {
        return comensales;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void ocuparMesa(int numComensales) {
        if (estado.equals("libre") && comensales == 0 && (capacidad == 2 || (capacidad == 4 && numComensales <= 4))) {
            estado = "ocupada";
            servicio = "espera";
            comensales = numComensales;
            System.out.println("Mesa " + numeroMesa + " ocupada por " + comensales + " personas.");
        } else {
            System.out.println("No es posible ocupar la mesa. Verifica la disponibilidad y capacidad.");
        }
    }


    public void atenderMesa() {
        if (estado.equals("ocupada") && servicio.equals("espera")) {
            servicio = "atendida"; // DE ATENDIDA A 'preparando'
            System.out.println("Mesa " + numeroMesa + " atendida.");
        } else {
            System.out.println("La mesa no puede ser atendida en este momento.");
        }
    }



}
