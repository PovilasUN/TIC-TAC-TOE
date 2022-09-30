package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameStatus = true;
        boolean xTurn = true;
        int size = 3;
        String xCord;
        String yCord;
        int y;
        int x;
        char[][] array = new char[size + 1][size + 1];
        printEmptyArray(size, array);
        while (gameStatus) {
            xCord = scanner.next();
            yCord = scanner.next();
            try {
                x = Integer.parseInt(xCord);
                y = Integer.parseInt(yCord);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (x > 3 || x < 1 || y > 3 || y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (array[x][y] == 'X' || array[x][y] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                if (xTurn) {
                    array[x][y] = 'X';
                    printBoard(array);
                    xTurn = false;
                } else {
                    array[x][y] = 'O';
                    printBoard(array);
                    xTurn = true;
                }
                if (isWinner('X', array) && !isWinner('O', array)) {
                    System.out.println("X wins");
                    gameStatus = false;
                } else if (!isWinner('X', array) && isWinner('O', array)) {
                    System.out.println("O wins");
                    gameStatus = false;
                } else if (!isWinner('X', array) && !isWinner('O', array) && arrayHasSpaces(size, array)) {
                    System.out.println("Draw");
                    gameStatus = false;
                }
            }
        }
    }
    public static void printBoard(char[][] input) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", input[1][1], input[1][2], input[1][3]);
        System.out.printf("| %c %c %c |\n", input[2][1], input[2][2], input[2][3]);
        System.out.printf("| %c %c %c |\n", input[3][1], input[3][2], input[3][3]);
        System.out.println("---------");
    }
    public static boolean isWinner(char element, char[][] input) {
        return input[1][1] == element && input[1][2] == element && input[1][3] == element ||
                input[2][1] == element && input[2][2] == element && input[2][3] == element ||
                input[3][1] == element && input[3][2] == element && input[3][3] == element ||
                input[1][1] == element && input[2][1] == element && input[3][1] == element ||
                input[1][2] == element && input[2][2] == element && input[3][2] == element ||
                input[1][3] == element && input[2][3] == element && input[3][3] == element ||
                input[1][1] == element && input[2][2] == element && input[3][3] == element ||
                input[1][3] == element && input[2][2] == element && input[3][1] == element;
    }
    public static boolean arrayHasSpaces(int size, char[][] input) {
        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                if (input[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printEmptyArray(int size, char[][] input) {
        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                input[i][j] = ' ';
            }
        }
        printBoard(input);
    }
}