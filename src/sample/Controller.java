package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    @FXML
    private Button exploreButton;
    @FXML
    private Button modelSearchButton;
    @FXML
    private Button OSSearchButton;
    @FXML
    private Button brandSearchButton;
    @FXML
    private Button createButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField searchTermField;
    @FXML
    private TextField createModelField;
    @FXML
    private TextField createBrandField;
    @FXML
    private TextField createOSField;
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
    private TableView<Celular> displayTable;
    @FXML
    private TableColumn<Celular, String> col1;
    @FXML
    private TableColumn<Celular, String> col2;
    @FXML
    private TableColumn<Celular, String> col3;

    @FXML
    public File displayBrowser() {
        Stage filer = new Stage();
        FileChooser FC = new FileChooser();
        FC.setTitle("Choose resource File");
        FC.getExtensionFilters().addAll((
                new FileChooser.ExtensionFilter("Text Files .txt", "*.txt"))
        );
        File selectedFile = FC.showOpenDialog(filer);
        System.out.println(selectedFile.getName());
        selectedFileLabel.setText(selectedFile.getName());
        return selectedFile;
    }
}
