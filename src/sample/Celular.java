package sample;

public class Celular implements Comparable<Celular> {

    private String modelo;
    private String marca;
    private String sistemaOperativo;
    private int precio;
    private double tamanioPantalla;
    private int memInterna;
    private int anio;
    private String color;

    public Celular() {
    }

    public Celular(String modelo, String marca, String sistemaOperativo, int precio, double tamanioPantalla, int memInterna, int anio, String color) {
        this();
        this.modelo = modelo;
        this.marca = marca;
        this.sistemaOperativo = sistemaOperativo;
        this.precio = precio;
        this.tamanioPantalla = tamanioPantalla;
        this.memInterna = memInterna;
        this.anio = anio;
        this.color = color;
    }

    //Getters & Setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public int getPrecio() {
        return precio;
    }

    public double getTamanioPantalla() {
        return tamanioPantalla;
    }

    public int getMemInterna() {
        return memInterna;
    }

    public int getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Celular other = (Celular) obj;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        return true;
    }

    @Override
    public int compareTo(Celular otro) {
        return modelo.compareTo(otro.getModelo());
    }

    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("\n");
        sb.append("Celular: \n");
        sb.append("Modelo del celular: " + modelo + "\n");
        sb.append("Marca del celular: " + marca + "\n");
        sb.append("Sistema operativo: " + sistemaOperativo + "\n");
        sb.append("Precio: " + precio + "MXN\n");
        sb.append("Tamaño de pantalla: " + tamanioPantalla + " pulgadas\n");
        sb.append("Tamaño de memoria: " + memInterna + "GB\n");
        sb.append("Año de fabricación: " + anio + "\n");
        sb.append("Color: " + color);
        return sb.toString();
    }

    public String prettyString() {
        return modelo + " $" + precio;
    }

}
