package Controllers;

import Models.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HangManGameController implements Initializable {
    @FXML
    private JFXTextField txtWord1;
    @FXML
    private JFXTextField txtWord2;
    @FXML
    private JFXTextField txtWord3;
    @FXML
    private JFXTextField txtWord4;
    @FXML
    private JFXTextField txtWord5;
    @FXML
    private JFXTextField txtWord6;
    @FXML
    private JFXTextField txtWord7;
    @FXML
    private JFXTextField txtWord8;
    @FXML
    private JFXTextField txtWord9;
    @FXML
    private JFXTextField txtWord10;
    @FXML
    private JFXTextField txtWord11;
    @FXML
    private JFXTextField txtWord12;
    @FXML
    private JFXTextField txtWord13;
    @FXML
    private JFXTextField txtWord14;
    @FXML
    private JFXTextField txtWord15;
    @FXML
    private JFXTextField txtWord16;
    @FXML
    private JFXTextField txtWord17;
    @FXML
    private Label lbGuessLeft;
    @FXML
    private Label lbScore;
    @FXML
    private Label lbNamePlayer;
    @FXML
    private Label lbRecordScore;
    @FXML
    private Label lbNameRecordScore;
    @FXML
    private Label lbWord;
    @FXML
    ComboBox<Category> comCategory = new ComboBox<Category>();
    @FXML
    ComboBox<Models.Level> comlLevel = new ComboBox<Models.Level>();
    @FXML
    private JFXButton btnA;
    @FXML
    private JFXButton btnB;
    @FXML
    private JFXButton btnC;
    @FXML
    private JFXButton btnD;
    @FXML
    private JFXButton btnE;
    @FXML
    private JFXButton btnF;
    @FXML
    private JFXButton btnG;
    @FXML
    private JFXButton btnH;
    @FXML
    private JFXButton btnI;
    @FXML
    private JFXButton btnJ;
    @FXML
    private JFXButton btnK;
    @FXML
    private JFXButton btnL;
    @FXML
    private JFXButton btnM;
    @FXML
    private JFXButton btnN;
    @FXML
    private JFXButton btnO;
    @FXML
    private JFXButton btnP;
    @FXML
    private JFXButton btnQ;
    @FXML
    private JFXButton btnR;
    @FXML
    private JFXButton btnW;
    @FXML
    private JFXButton btnS;
    @FXML
    private JFXButton btnT;
    @FXML
    private JFXButton btnU;
    @FXML
    private JFXButton btnV;
    @FXML
    private JFXButton btnX;
    @FXML
    private JFXButton btnY;
    @FXML
    private JFXButton btnZ;
    @FXML
    private ImageView img;
    private String sortedWord;
    private int guess = 0;
    private int wrongGuess = 0;
    private int countLetter = 0;
    private int pointsPerLetter = 0;
    private int extraPoints = 0;
    private int score = 0;
    private int idPlayer = 0;
    private Map<Integer, JFXTextField> txtMap;



    public void btnA_Click(ActionEvent actionEvent) {
        checkLetter("A", btnA);
    }

    public void btnB_Click(ActionEvent actionEvent) {
        checkLetter("B", btnB);
    }

    public void btnC_Click(ActionEvent actionEvent) {
        checkLetter("C", btnC);
    }

    public void btnD_Click(ActionEvent actionEvent) {
        checkLetter("D", btnD);
    }
    public void btnE_Click(ActionEvent actionEvent) {
        checkLetter("E", btnE);
    }

    public void btnF_Click(ActionEvent actionEvent) {
        checkLetter("F", btnF);
    }

    public void btnG_Click(ActionEvent actionEvent) {
        checkLetter("G", btnG);
    }

    public void btnH_Click(ActionEvent actionEvent) {
        checkLetter("H", btnH);
    }

    public void btnI_Click(ActionEvent actionEvent) {
        checkLetter("I", btnI);
    }

    public void btnJ_Click(ActionEvent actionEvent) {
        checkLetter("J", btnJ);
    }

    public void btnK_Click(ActionEvent actionEvent) {
        checkLetter("K", btnK);
    }

    public void btnL_Click(ActionEvent actionEvent) {
        checkLetter("L", btnL);
    }

    public void btnM_Click(ActionEvent actionEvent) {
        checkLetter("M", btnM);
    }

    public void btnN_Click(ActionEvent actionEvent) {
        checkLetter("N", btnN);
    }

    public void btnO_Click(ActionEvent actionEvent) {
        checkLetter("O", btnO);
    }

    public void btnP_Click(ActionEvent actionEvent) {
        checkLetter("P", btnP);
    }

    public void btnQ_Click(ActionEvent actionEvent) {
        checkLetter("Q", btnQ);
    }

    public void btnR_Click(ActionEvent actionEvent) {
        checkLetter("R", btnR);
    }

    public void btnW_Click(ActionEvent actionEvent) {
        checkLetter("W", btnW);
    }

    public void btnS_Click(ActionEvent actionEvent) {
        checkLetter("S", btnS);
    }

    public void btnT_Click(ActionEvent actionEvent) {
        checkLetter("T", btnT);
    }

    public void btnU_Click(ActionEvent actionEvent) {
        checkLetter("U", btnU);
    }

    public void btnV_Click(ActionEvent actionEvent) {
        checkLetter("V", btnV);
    }

    public void btnX_Click(ActionEvent actionEvent) {
        checkLetter("X", btnX);
    }

    public void btnY_Click(ActionEvent actionEvent) {
        checkLetter("Y", btnY);
    }

    public void btnZ_Click(ActionEvent actionEvent) {
        checkLetter("Z", btnZ);
    }

    public void hideButtons(){
        btnA.setDisable(true);
        btnB.setDisable(true);
        btnC.setDisable(true);
        btnD.setDisable(true);
        btnE.setDisable(true);
        btnF.setDisable(true);
        btnG.setDisable(true);
        btnH.setDisable(true);
        btnI.setDisable(true);
        btnJ.setDisable(true);
        btnK.setDisable(true);
        btnL.setDisable(true);
        btnM.setDisable(true);
        btnN.setDisable(true);
        btnO.setDisable(true);
        btnP.setDisable(true);
        btnQ.setDisable(true);
        btnR.setDisable(true);
        btnW.setDisable(true);
        btnS.setDisable(true);
        btnT.setDisable(true);
        btnU.setDisable(true);
        btnV.setDisable(true);
        btnX.setDisable(true);
        btnY.setDisable(true);
        btnZ.setDisable(true);
    }

    public void showButtons() {
        btnA.setDisable(false);
        btnB.setDisable(false);
        btnC.setDisable(false);
        btnD.setDisable(false);
        btnE.setDisable(false);
        btnF.setDisable(false);
        btnG.setDisable(false);
        btnH.setDisable(false);
        btnI.setDisable(false);
        btnJ.setDisable(false);
        btnK.setDisable(false);
        btnL.setDisable(false);
        btnM.setDisable(false);
        btnN.setDisable(false);
        btnO.setDisable(false);
        btnP.setDisable(false);
        btnQ.setDisable(false);
        btnR.setDisable(false);
        btnW.setDisable(false);
        btnS.setDisable(false);
        btnT.setDisable(false);
        btnU.setDisable(false);
        btnV.setDisable(false);
        btnX.setDisable(false);
        btnY.setDisable(false);
        btnZ.setDisable(false);
    }

    private void clearTxt(){
        txtWord1.setText(null);
        txtWord2.setText(null);
        txtWord3.setText(null);
        txtWord4.setText(null);
        txtWord5.setText(null);
        txtWord6.setText(null);
        txtWord7.setText(null);
        txtWord8.setText(null);
        txtWord9.setText(null);
        txtWord10.setText(null);
        txtWord11.setText(null);
        txtWord12.setText(null);
        txtWord13.setText(null);
        txtWord14.setText(null);
        txtWord15.setText(null);
        txtWord16.setText(null);
        txtWord17.setText(null);
    }

    private void clearSpaces(){
        txtWord1.setVisible(false);
        txtWord2.setVisible(false);
        txtWord3.setVisible(false);
        txtWord4.setVisible(false);
        txtWord5.setVisible(false);
        txtWord6.setVisible(false);
        txtWord7.setVisible(false);
        txtWord8.setVisible(false);
        txtWord9.setVisible(false);
        txtWord10.setVisible(false);
        txtWord11.setVisible(false);
        txtWord12.setVisible(false);
        txtWord13.setVisible(false);
        txtWord14.setVisible(false);
        txtWord15.setVisible(false);
        txtWord16.setVisible(false);
        txtWord17.setVisible(false);

    }

    public void btnCancel_Click(ActionEvent actionEvent) {
        comCategory.valueProperty().set(null);
        comlLevel.valueProperty().set(null);
        lbGuessLeft.setText(null);
        lbWord.setText(null);
        hideButtons();
        lbScore.setText(null);
        lbNamePlayer.setText(null);
        clearTxt();
        cleanHangMan();
        clearSpaces();
    }


    public void btnPlay_Click(ActionEvent actionEvent) {
        // filter the word by level and category
        DBWord dbgame = new DBWord();
        Word word = new Word();
        word.setIdCategory(comCategory.getValue().getId());
        word.setIdLevel(comlLevel.getValue().getId());
        ArrayList<Word> wordList = dbgame.getByCategoryLevel(word);
        // sort random
        Collections.shuffle(wordList);
        sortedWord = wordList.get(0).getName();
        lbWord.setText(sortedWord);
        guess = comlLevel.getValue().getNumTry();
        lbGuessLeft.setText(String.valueOf(guess));
        pointsPerLetter = comlLevel.getValue().getPtLetter();
        extraPoints = comlLevel.getValue().getExtraPt();
        showButtons();
        loadSpaces();
        countLetter = 0;
    }

    private void loadSpaces(){
        for (int i = 1; i <= sortedWord.length(); i++){
            txtMap.get(i).setVisible(true);
        }
    }

    public void checkLetter(String letter, JFXButton button){
        boolean foundLetter = false;
        button.setDisable(true);
        char[] secrectStrCharArr=sortedWord.toUpperCase().toCharArray();
            char guessChar = letter.toUpperCase().toCharArray()[0];
            for(int i=0;i<secrectStrCharArr.length;i++){
                if(guessChar==secrectStrCharArr[i]){
                    setLetterInSpace(i+1,guessChar);
                    foundLetter = true;
                    countLetter++;
                    if (countLetter == sortedWord.length()){
                        winHangMan();
                        calcScore();
                    }
                }
            }
            if (foundLetter == false){
                guessLeft();
                wrongGuess++;
            }
        }


    public void guessLeft(){
        lbGuessLeft.setText(String.valueOf(--guess));
        if (guess == 0){
            drawHangMan();
            Alert alert = new Alert(Alert.AlertType.NONE, "Game Over!", ButtonType.OK);
            alert.showAndWait();
            btnOkGameOver_Click(null);
        }
    }

    public void btnOkGameOver_Click(ActionEvent actionEvent) {
        comCategory.valueProperty().set(null);
        comlLevel.valueProperty().set(null);
        lbGuessLeft.setText(null);
        lbWord.setText(null);
        hideButtons();
        lbScore.setText(null);
        lbNamePlayer.setText(null);
        txtWord1.setText(null);
    }

    public void winHangMan(){
        Alert alert = new Alert(Alert.AlertType.NONE, "You Win! Congrats Champ!", ButtonType.OK);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/player.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                PlayerController controller = fxmlLoader.getController();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                root1.getStylesheets().add("Style/style.css");
                stage.setScene(new Scene(root1));
                controller.stage = stage;
                stage.showAndWait();
                getHighScore();
                btnCancel_Click(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void calcScore(){
        if (wrongGuess > 0){
            score = ((countLetter - wrongGuess) * pointsPerLetter);
        } else {
            score = (countLetter * pointsPerLetter) + extraPoints;
        }
        lbScore.setText(String.valueOf(score));
        DBScore dbScore = new DBScore();
        Score score = new Score();
        score.setScore(this.score);
        score.setIdPlayer(dbScore.getLastPlayer().getId());
        dbScore.insert(score);
        lbNamePlayer.setText(dbScore.getLastPlayer().getName());
    }


    private void drawHangMan(){
        File file = new File("src/hangman.png");
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }

    private void cleanHangMan(){
        img.setImage(null);
    }


    public void setLetterInSpace(int position, char letter) {
        JFXTextField txt = txtMap.get(position);
        txt.setText(String.valueOf(letter));
    }


    private void comCategory_Load(){
        DBCategory dbcategory = new DBCategory();
        comCategory.getItems().setAll(dbcategory.getAll());
        comCategory.setConverter(new StringConverter<Category>() {
            @Override
            public String toString(Category object) {
                if (object != null){
                    return object.getName();
                }
                return null;
            }

            @Override
            public Category fromString(String string) {
                return null;
            }
        });
    }

    private void comLevel_Load(){
        DBLevel dblevel = new DBLevel();
        comlLevel.getItems().setAll(dblevel.getAll());
        comlLevel.setConverter(new StringConverter<Level>() {
            @Override
            public String toString(Level object) {
                if (object != null){
                    return object.getName();
                }
                return null;
            }

            @Override
            public Level fromString(String string) {
                return null;
            }
        });
    }

    private void getHighScore(){
        DBScore dbscore = new DBScore();
        Score score = dbscore.highScore();
        lbNameRecordScore.setText(score.getNamePlayer());
        lbRecordScore.setText(String.valueOf(score.getScore()));
    }

    private void initMap(){
        txtMap = new HashMap<Integer, JFXTextField>();
        txtMap.put(1, txtWord1);
        txtMap.put(2, txtWord2);
        txtMap.put(3, txtWord3);
        txtMap.put(4, txtWord4);
        txtMap.put(5, txtWord5);
        txtMap.put(6, txtWord6);
        txtMap.put(7, txtWord7);
        txtMap.put(8, txtWord8);
        txtMap.put(9, txtWord9);
        txtMap.put(10, txtWord10);
        txtMap.put(11, txtWord11);
        txtMap.put(12, txtWord12);
        txtMap.put(13, txtWord13);
        txtMap.put(14, txtWord14);
        txtMap.put(15, txtWord15);
        txtMap.put(16, txtWord16);
        txtMap.put(17, txtWord17);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comCategory_Load();
        comLevel_Load();
        getHighScore();
        hideButtons();
        initMap();
    }
}
