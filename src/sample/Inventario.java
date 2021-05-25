package sample;

import java.util.ArrayList;

public class Inventario {
    private String empleado;
    private Celular vitrina[][];
    private final int MAXF = 3;
    private final int MAXC = 5;
    private Celular[] total;
    private final int MAX = 25;
    private int ocupados;

    //Constructor vacio
    public Inventario() {
        vitrina = new Celular[MAXF][MAXC];
        total = new Celular[MAX];
    }

    //Constructor
    public Inventario(String empleado) {
        this();
        this.empleado = empleado;
        this.ocupados = ocupados;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Inventario other = (Inventario) obj;
        if (empleado == null) {
            if (other.empleado != null)
                return false;
        } else if (!empleado.equals(other.empleado))
            return false;
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i, j;

        sb = new StringBuilder();
        sb.append("\n");
        sb.append("Mostrador de celulares\n");
        sb.append("Empleado: " + empleado + "\n");
        for (i = 0; i < MAXF; i++) {
            for (j = 0; j < MAXC; j++)
                if (vitrina[i][j] != null)
                    sb.append(vitrina[i][j].getModelo() + " " + vitrina[i][j].getMarca() + " " + vitrina[i][j].getSistemaOperativo() + " " + vitrina[i][j].getPrecio() + " " + vitrina[i][j].getTamanioPantalla() + " " + vitrina[i][j].getMemInterna() + " " + vitrina[i][j].getAnio() + " " + vitrina[i][j].getColor() + "    ");
                else
                    sb.append("Vacío" + "\t");
            sb.append("\n");
        }
        return sb.toString();

    }

    //Da de alta celular
    public int[] altaCelular(String modelo, String marca, String sistemaOperativo, int precio, double tamanioPantalla, int memInterna, int anio, String color) {
        int i, j, fila, columna;
        boolean encontre;
        int[] resp;
        Celular uno;

        resp = new int[2];
        encontre = false;
        if (marca.equals("Apple")) {
            j = 0;
            while (j < MAXC && vitrina[0][j] != null)
                j++;
            if (j < MAXC) { //hay lugar
                encontre = true;
                resp[0] = 0;
                resp[1] = j;
            } else { //no hay lugar
                resp[0] = -1;
                resp[1] = -1;
            }
        } else if (marca.equals("Samsung")) {
            i = 1;
            j = 0;
            while (j < MAXC && vitrina[i][j] != null)
                j++;
            if (j < MAXC) { //hay lugar
                encontre = true;
                resp[0] = i;
                resp[1] = j;
            } else { //no hay lugar
                resp[0] = -1;
                resp[1] = -1;
            }
        } else {
            i = 2;
            j = 0;
            while (i < MAXF && !encontre) {
                j = 0;
                while (j < MAXC && vitrina[i][j] != null)
                    j++;
                if (j < MAXC)
                    encontre = true;
                else
                    i++;
            }
            if (encontre) {
                resp[0] = i;
                resp[1] = j;
            }
        }
        if (encontre) {//si hay lugar
            uno = new Celular(modelo, marca, sistemaOperativo, precio, tamanioPantalla, memInterna, anio, color);
            fila = resp[0];
            columna = resp[1];
            vitrina[fila][columna] = uno;
        }
        return resp;
    }


    //Eliminar un Celular de la matriz
    public boolean bajaCelular(String modelo) {
        for (int i = 0; i < vitrina.length; i++) {
            for (int j = 0; j < vitrina[0].length; j++) {
                if (vitrina[i][j] != null) {
                    if (vitrina[i][j].getModelo().equals(modelo)) {
                        vitrina[i][j] = null;
                        return true;
                    }
                }

            }
        }
        return false;
    }


    //Busca todos los atributos del Celular
    public Celular buscaCelular(String modelo) {
        Celular resp = null;
        for (int i = 0; i < vitrina.length; i++) {
            for (int j = 0; j < vitrina[0].length; j++) {
                if (vitrina[i][j] != null) {
                    if (vitrina[i][j].getModelo().equals(modelo)) {
                        resp = vitrina[i][j];
                    }

                }
            }
        }
        return resp;
    }

    //Busca todos los atributos del Celular
    public String buscaCelularOS(String modelo) {
        Celular resp = null;
        ArrayList<Celular> a = new ArrayList<>();
        for (int i = 0; i < vitrina.length; i++) {
            for (int j = 0; j < vitrina[0].length; j++) {
                if (vitrina[i][j] != null) {
                    if (vitrina[i][j].getSistemaOperativo().equals(modelo)) {
                        resp = vitrina[i][j];
                        a.add(resp);
                    }

                }
            }
        }
        return cel2string(a);
    }

    //Busca todos los atributos del Celular
    public String buscaCelularMarca(String modelo) {
        Celular resp = null;
        ArrayList<Celular> a = new ArrayList<>();
        for (int i = 0; i < vitrina.length; i++) {
            for (int j = 0; j < vitrina[0].length; j++) {
                if (vitrina[i][j] != null) {
                    if (vitrina[i][j].getMarca().equals(modelo)) {
                        resp = vitrina[i][j];
                        a.add(resp);
                    }

                }
            }
        }
        return cel2string(a);
    }


    //Indica el porcentaje de ocupacion de la matriz
    public double indicaOcupacion() {
        int i, j, cuantos;
        double por;
        cuantos = 0;
        for (i = 0; i < MAXF; i++) {
            for (j = 0; j < MAXC; j++) {
                if (vitrina[i][j] != null) {
                    cuantos++;
                }
            }
        }
        por = (double) cuantos / (MAXF * MAXC);
        return por;
    }

    public static <T extends Comparable<T>> int cuantosMenorA(T a[], int n, T goals) {
        int cuantos, i;
        cuantos = 0;
        for (i = 0; i < n; i++)
            if (a[i].compareTo(goals) < 0)
                cuantos++;
        return cuantos;
    }

    public int cuentaPorSO(String sistemaOperativo) {
        String k;
        int c, j, i;
        c = 0;
        for (i = 0; i < MAXF; i++)
            for (j = 0; j < MAXC; j++) {
                if (vitrina[i][j] != null) {
                    k = vitrina[i][j].getSistemaOperativo();
                    if (k.equals(sistemaOperativo)) {
                        c++;
                    }
                }
            }
        return c;
    }

    public int cuentaPorMarca(String marca) {
        String k;
        int c, j, i;
        c = 0;
        for (i = 0; i < MAXF; i++)
            for (j = 0; j < MAXC; j++) {
                if (vitrina[i][j] != null) {
                    k = vitrina[i][j].getMarca();
                    if (k.equals(marca)) {
                        c++;
                    }
                }
            }
        return c;
    }

    public static <T extends Comparable<T>> int mayorArreglo(T a[], int n) {
        int mayor, i;
        mayor = 0;
        for (i = 1; i < n; i++)
            if (a[i].compareTo(a[mayor]) > 0)
                mayor = i;
        return mayor;
    }

    public ArrayList<Celular> getFlattenedVitrina() {
        ArrayList<Celular> a = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            for (int j = 0; j <= vitrina[i].length - 1; j++) {
                if (vitrina[i][j] != null && vitrina[i][j].getModelo() != null)
                    a.add(vitrina[i][j]);
            }
        }
        return a;
    }

    public String cel2string(ArrayList<Celular> b) {
        StringBuilder a = new StringBuilder();
        for (Celular celular : b) {
            a.append(celular.toString());
            a.append("\n---------------\n");
        }
        return a.toString();
    }


}
