package org.example.ui2048;

import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Game implements Runnable {
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private final int size;
    private static int [][] board;
    private boolean change;
    private Controller controller;
    private static int [][] lastBoardState;
    private static int [][] nextBoardState;

    Game(int size, Controller controller) {
        this.size = size;
        this.controller = controller;
        board = new int[size][size];
    }

    public void createGame()
    {
        controller.setHighestScore(countScore());
        board = new int[size][size];
        createNewNumber();
        createNewNumber();
        controller.setBoard(getCellsValue(), getCellsColor());
    }

    public void print()
    {
        for(int[] i : board)
        {
            for(int j : i)
                System.out.print((j != 0 ? j : " ") + " ");
            System.out.println();
        }
    }

    private void createNewNumber()
    {
        while(true)
        {
            int x = random.nextInt(size), y = random.nextInt(size);
            if(board[x][y] == 0)
            {
                board[x][y] = random.nextInt(10) < 9 ? 2 : 4;
                break;
            }
        }
    }


    public String[] getCellsValue()
    {
        return Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
    }

    public Color[] getCellsColor()
    {
        return Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .mapToObj(this::getColorByValue)
                .toArray(Color[]::new);
    }

    //TODO zmień kolorki
    private Color getColorByValue(int value)
    {
        return switch (value) {
            case 0 -> Color.WHITE;
            case 2 -> Color.GRAY;
            case 4 -> Color.BEIGE;
            case 8 -> Color.WHEAT;
            case 16 -> Color.ALICEBLUE;
            case 32 -> Color.BISQUE;
            case 64 -> Color.BLANCHEDALMOND;
            case 128 -> Color.CYAN;
            case 256 -> Color.CORAL;
            case 512 -> Color.VIOLET;
            case 1024 -> Color.TURQUOISE;
            case 2048 -> Color.TAN;
            default -> new Color(1, 1, 1, 1);
        };
    }


    private void compressRows()
    {
        for(int[] row : board)
            for(int i = 0; i < size; i++)
            {
                if(row[i] != 0)
                {
                    int j = i;
                    while(j - 1 >= 0 && row[j - 1] == 0)
                    {
                        change = true;
                        row[j - 1] = row[j];
                        row[j] = 0;
                        j--;
                    }
                }
            }
    }


    private void mergeRows()
    {
        for(int[] row : board)
            for(int i = 1; i < size; i++)
            {
                if(row[i] == row[i - 1] && row[i] != 0)
                {
                    row[i - 1] += row[i];
                    row[i] = 0;
                    change = true;
                }
            }
    }


    int countScore()
    {
        int score = 0;
        for(int[] i : board)
            for(int j : i)
                score += j;
        return score;
    }


    public void rotateClockwise()
    {
        int [][] next = new int[size][size];
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
                next[j][size - i - 1] = board[i][j];

        }
        board = next;
    }


    public void rotateClockwise(int k)
    {
        for(int i = 1; i <= k; i++)
            rotateClockwise();
    }


    public void moveLeft()
    {
        change = false;
        compressRows();
        mergeRows();
        compressRows();
        if(change)
            createNewNumber();
    }


    public void moveRight()
    {
        rotateClockwise(2);
        moveLeft();
        rotateClockwise(2);
    }


    public void moveDown()
    {
        rotateClockwise(1);
        moveLeft();
        rotateClockwise(3);
    }


    public void moveUp()
    {
        rotateClockwise(3);
        moveLeft();
        rotateClockwise(1);
    }

    //TODO okienko
    public void win()
    {
        System.out.println("YOU WIN!");
        System.out.println("Do you want to continue? (y/n)");
        if(scanner.nextLine().equals("y"))
            createGame();
    }


    public boolean canUserMove()
    {
        for(int[] i : board)
            for(int j : i)
                if(j == 0)
                    return true;

        for(int[] i : board)
            for(int j = 1; j < i.length; j++)
                if(i[j] == i[j-1])
                    return true;

        rotateClockwise(1);

        for(int[] i : board)
            for(int j = 1; j < i.length; j++)
                if(i[j] == i[j-1])
                {
                    rotateClockwise(3);
                    return true;
                }

        rotateClockwise(3);

        return false;
    }

    //TODO okienko
    public void gameOver()
    {
        System.out.println("GAME OVER!");
        System.out.println("Do you want to reset? (y/n)");
        if(scanner.nextLine().equals("y"))
            createGame();
    }

    @Override
    public void run() {

    }
}
