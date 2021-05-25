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
            return other.modelo == null;
        } else return modelo.equals(other.modelo);
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
        sb.append("Modelo del celular: ").append(modelo).append("\n");
        sb.append("Marca del celular: ").append(marca).append("\n");
        sb.append("Sistema operativo: ").append(sistemaOperativo).append("\n");
        sb.append("Precio: ").append(precio).append("MXN\n");
        sb.append("Tamaño de pantalla: ").append(tamanioPantalla).append(" pulgadas\n");
        sb.append("Tamaño de memoria: ").append(memInterna).append("GB\n");
        sb.append("Año de fabricación: ").append(anio).append("\n");
        sb.append("Color: ").append(color);
        return sb.toString();
    }

    public String prettyString() {
        return modelo + " $" + precio;
    }

}
