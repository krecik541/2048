package org.example.ui2048;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Text highestScore;

    @FXML
    private Text score;
    @FXML
    private AnchorPane scoreBoard;
    @FXML
    private Rectangle r0;
    @FXML
    private Rectangle r1;
    @FXML
    private Rectangle r2;
    @FXML
    private Rectangle r3;
    @FXML
    private Rectangle r4;
    @FXML
    private Rectangle r5;
    @FXML
    private Rectangle r6;
    @FXML
    private Rectangle r7;
    @FXML
    private Rectangle r8;
    @FXML
    private Rectangle r9;
    @FXML
    private Rectangle r10;
    @FXML
    private Rectangle r11;
    @FXML
    private Rectangle r12;
    @FXML
    private Rectangle r13;
    @FXML
    private Rectangle r14;
    @FXML
    private Rectangle r15;
    @FXML
    private Text t0;
    @FXML
    private Text t1;
    @FXML
    private Text t2;
    @FXML
    private Text t3;
    @FXML
    private Text t4;
    @FXML
    private Text t5;
    @FXML
    private Text t6;
    @FXML
    private Text t7;
    @FXML
    private Text t8;
    @FXML
    private Text t9;
    @FXML
    private Text t10;
    @FXML
    private Text t11;
    @FXML
    private Text t12;
    @FXML
    private Text t13;
    @FXML
    private Text t14;
    @FXML
    private Text t15;


    public void setScore(int score)
    {
        this.score.setText(Integer.toString(score));
    }
    public void setHighestScore(int score)
    {
        System.out.println(highestScore.getText().compareTo(Integer.toString(score)));
        if(highestScore.getText().compareTo(Integer.toString(score)) < 0)
            this.highestScore.setText(Integer.toString(score));
    }
    public void setScoreBoard(Color color, double cornerRadii, double insets)
    {
        this.scoreBoard.setBackground(new Background(new BackgroundFill(color, new CornerRadii(cornerRadii), new Insets(insets))));
    }
    public void setBoard(String[] s, Color[] c)
    {
        r0.setFill(c[0]);
        r1.setFill(c[1]);
        r2.setFill(c[2]);
        r3.setFill(c[3]);
        r4.setFill(c[4]);
        r5.setFill(c[5]);
        r6.setFill(c[6]);
        r7.setFill(c[7]);
        r8.setFill(c[8]);
        r9.setFill(c[9]);
        r10.setFill(c[10]);
        r11.setFill(c[11]);
        r12.setFill(c[12]);
        r13.setFill(c[13]);
        r14.setFill(c[14]);
        r15.setFill(c[15]);

        t0.setText(s[0]);
        t1.setText(s[1]);
        t2.setText(s[2]);
        t3.setText(s[3]);
        t4.setText(s[4]);
        t5.setText(s[5]);
        t6.setText(s[6]);
        t7.setText(s[7]);
        t8.setText(s[8]);
        t9.setText(s[9]);
        t10.setText(s[10]);
        t11.setText(s[11]);
        t12.setText(s[12]);
        t13.setText(s[13]);
        t14.setText(s[14]);
        t15.setText(s[15]);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setScore(0);
        setHighestScore(0);
    }
}