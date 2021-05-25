package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    @FXML
    private TextField searchTermField;
    @FXML
    private TextField createModelField;
    @FXML
    private TextField createBrandField;
    @FXML
    private TextField createOSField;
    @FXML
    private TextField createPriceField;
    @FXML
    private TextField createSSField;
    @FXML
    private TextField createMemField;
    @FXML
    private TextField createYearField;
    @FXML
    private TextField createColorField;
    @FXML
    private TextField deleteModelField;
    @FXML
    private Label selectedFileLabel;
    @FXML
    private Label statusFieldLabel;
    @FXML
    private TextArea logArea;
    @FXML
    private TableView<Repisa> displayTable;
    @FXML
    private TableColumn<Repisa, String> col1;
    @FXML
    private TableColumn<Repisa, String> col2;
    @FXML
    private TableColumn<Repisa, String> col3;
    @FXML
    private TableColumn<Repisa, String> col4;
    @FXML
    private TableColumn<Repisa, String> col5;

    private ObservableList<Repisa> displayList;

    Inventario miInventario = new Inventario("Teresa García");

    @FXML
    public void searchByModel() {
        logArea.setText(miInventario.buscaCelular(searchTermField.getText()).toString());
    }

    @FXML
    public void searchByOS() {
        logArea.setText(miInventario.buscaCelularOS(searchTermField.getText()).toString());
    }

    @FXML
    public void searchByBrand() {
        logArea.setText(miInventario.buscaCelularMarca(searchTermField.getText()).toString());
    }

    @FXML
    public void displayBrowser() {
        Stage filer = new Stage();
        FileChooser FC = new FileChooser();
        FC.setTitle("Choose resource File");
        FC.getExtensionFilters().addAll((
                new FileChooser.ExtensionFilter("Text Files .txt", "*.txt"))
        );
        File selectedFile = FC.showOpenDialog(filer);
        System.out.println(selectedFile.getName());
        selectedFileLabel.setText(selectedFile.getName() + " cargado.");
        loadData(selectedFile);
    }

    private void loadData(File textFile) {
        File miArchivo;
        Scanner lectura;
        int i, n;
        String modelo, marca, sistemaOperativo, color;
        int precio, memInterna, anio;
        double tamanioPantalla;
        int resp[];
        double porcentaje;
        porcentaje = miInventario.indicaOcupacion();

        miArchivo = textFile;
        try {
            lectura = new Scanner(miArchivo);
            n = lectura.nextInt();
            for (i = 1; i <= n; i++) {
                modelo = lectura.next();
                marca = lectura.next();
                sistemaOperativo = lectura.next();
                precio = lectura.nextInt();
                tamanioPantalla = lectura.nextDouble();
                memInterna = lectura.nextInt();
                anio = lectura.nextInt();
                color = lectura.next();
                // Index new cellphone
                resp = miInventario.altaCelular(modelo, marca, sistemaOperativo, precio, tamanioPantalla, memInterna, anio, color);
                if (resp[0] == -1) {
                    System.out.println("Alta no exitosa");
                } else {
                    System.out.println("Alta exitosa");
                }
            }
            lectura.close();
            System.out.println(miInventario.toString());
            // Refresh table
            refreshTable();

//            //Buscando celulares por Sistema Operativo
//            System.out.println("Busca celulares por Sistema Operativo");
//            System.out.println("El numero de celulares con SO Android: " + miInventario.cuentaPorSO("Android"));
//            System.out.println("El numero de celulares con SO iOS: " + miInventario.cuentaPorSO("iOS"));
//
//            System.out.println("\n");
//
//            //Buscando celulares por marca
//            System.out.println("Busca celulares por marca");
//            System.out.println("El numero de celulares de marca Apple: " + miInventario.cuentaPorMarca("Apple"));
//            System.out.println("El numero de celulares de marca Samsung: " + miInventario.cuentaPorMarca("Samsung"));
//            System.out.println("El numero de celulares de marca Xiaomi: " + miInventario.cuentaPorMarca("Xiaomi"));
//            System.out.println("El numero de celulares de marca Huawei: " + miInventario.cuentaPorMarca("Huawei"));
//
//            System.out.println("\n");
//
//            //Imprimiendo el porcentaje de ocupación de la matriz
//            System.out.println("Porcentaje de ocupación: ");
//            System.out.println("El porcentaje de ocupación es de: " + porcentaje);
//            System.out.println("\n");
//
//
//            //Buscando celular por modelo:
//            System.out.println("Busca celulares por modelo:");
//            System.out.println(miInventario.buscaCelular("iPhoneSE"));
//            System.out.println(miInventario.buscaCelular("GalaxyS20+"));
//            System.out.println(miInventario.buscaCelular("Y9"));
//

        } catch (FileNotFoundException e) {
            System.out.println("Error, archivo no encontrado");
        }
    }

    @FXML
    public void initialize() {

        col1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDev1()));
        col2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDev2()));
        col3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDev3()));
        col4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDev4()));
        col5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDev5()));

        //TEST DATA
        File selectedFile = new File("C:\\Users\\x220\\Desktop\\ProyectoFinal1\\graphicalStore\\src\\Celulares.txt");
        loadData(selectedFile);
        //TEST DATA
    }

    private void refreshTable() {

        List<Celular> flatVitrina = miInventario.getFlattenedVitrina();
        List<Repisa> repisas = new ArrayList<>();
        repisas.add(new Repisa(flatVitrina.subList(0, 5)));
        repisas.add(new Repisa(flatVitrina.subList(5, 10)));
        repisas.add(new Repisa(flatVitrina.subList(10, flatVitrina.size())));
        displayList = FXCollections.observableList(repisas);
        displayTable.getItems().setAll(displayList);
    }

    public static class Repisa {
        private final SimpleStringProperty dev1;
        private final SimpleStringProperty dev2;
        private final SimpleStringProperty dev3;
        private final SimpleStringProperty dev4;
        private final SimpleStringProperty dev5;

        public Repisa(List<Celular> a) {
            this.dev1 = new SimpleStringProperty(a.get(0).prettyString());
            this.dev2 = new SimpleStringProperty(a.get(1).prettyString());
            this.dev3 = new SimpleStringProperty(a.get(2).prettyString());
            this.dev4 = new SimpleStringProperty(a.get(3).prettyString());
            this.dev5 = new SimpleStringProperty(a.get(4).prettyString());
        }

        public String getDev1() {
            return dev1.get();
        }

        public String getDev2() {
            return dev2.get();
        }


        public String getDev3() {
            return dev3.get();
        }


        public String getDev4() {
            return dev4.get();
        }


        public String getDev5() {
            return dev5.get();
        }


    }

    @FXML
    private void createDevice() {
        int resp[] = miInventario.altaCelular(createModelField.getText(), createBrandField.getText(), createOSField.getText(), new Integer(createPriceField.getText()), new Double(createSSField.getText()), new Integer(createMemField.getText()), new Integer(createYearField.getText()), createColorField.getText());
        String stat = "";
        if (resp[0] == -1) {
            stat = "Alta no exitosa";
        } else {
            stat = "Alta exitosa";
        }
        System.out.println(stat);
        statusFieldLabel.setText(stat);
        refreshTable();
    }

    @FXML
    private void deleteDevice() {
        boolean resp = miInventario.bajaCelular(deleteModelField.getText());
        if (resp)
            statusFieldLabel.setText("Celular dado de baja.");
        else
            statusFieldLabel.setText("Error");

        refreshTable();
    }
}
