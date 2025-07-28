import java.util.Scanner;

public class SudokuGame {

    private static final int SIZE = 9;
    private static int[][] board = new int[SIZE][SIZE];
    private static boolean[][] fixed = new boolean[SIZE][SIZE]; // Para identificar números fixos
    private static boolean gameStarted = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        if (args.length > 0 && args.length % 3 == 0) {
            initializeBoard(args);
            gameStarted = true;
        }

        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Iniciar um novo jogo");
            System.out.println("2. Colocar um novo número");
            System.out.println("3. Remover um número");
            System.out.println("4. Verificar jogo");
            System.out.println("5. Verificar status do jogo");
            System.out.println("6. Limpar tabuleiro");
            System.out.println("7. Finalizar o jogo");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    startNewGame(scanner);
                    break;
                case 2:
                    placeNumber(scanner);
                    break;
                case 3:
                    removeNumber(scanner);
                    break;
                case 4:
                    displayBoard();
                    break;
                case 5:
                    checkGameStatus();
                    break;
                case 6:
                    clearBoard();
                    break;
                case 7:
                    endGame();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();
        } while (opcao != 7);

        scanner.close();
    }

    private static void initializeBoard(String[] args) {
        for (int i = 0; i < args.length; i += 3) {
            int row = Integer.parseInt(args[i]);
            int col = Integer.parseInt(args[i + 1]);
            int value = Integer.parseInt(args[i + 2]);
            board[row][col] = value;
            fixed[row][col] = true;
        }
    }

    private static void startNewGame(Scanner scanner) {
        if (gameStarted) {
            System.out.println("Já existe um jogo em andamento. Deseja iniciar um novo? (1 - Sim, 2 - Não)");
            int choice = scanner.nextInt();
            if (choice != 1) {
                return;
            }
        }

        System.out.println("Informe os números iniciais e suas posições (formato: linha coluna valor). Digite '0' para encerrar.");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
                fixed[i][j] = false;
            }
        }

        while (true) {
            System.out.print("Linha (0 para encerrar): ");
            int row = scanner.nextInt();
            if (row == 0) break;

            System.out.print("Coluna: ");
            int col = scanner.nextInt();
            System.out.print("Valor: ");
            int value = scanner.nextInt();

            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && value >= 1 && value <= 9) {
                board[row][col] = value;
                fixed[row][col] = true;
            } else {
                System.out.println("Posição ou valor inválido!");
            }
        }

        gameStarted = true;
    }

    private static void placeNumber(Scanner scanner) {
        if (!gameStarted) {
            System.out.println("Inicie um jogo primeiro!");
            return;
        }

        System.out.print("Informe a linha: ");
        int row = scanner.nextInt();
        System.out.print("Informe a coluna: ");
        int col = scanner.nextInt();
        System.out.print("Informe o número: ");
        int value = scanner.nextInt();

        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || value < 1 || value > 9) {
            System.out.println("Posição ou valor inválido!");
            return;
        }

        if (fixed[row][col]) {
            System.out.println("Não é possível alterar um número fixo!");
            return;
        }

        board[row][col] = value;
    }

    private static void removeNumber(Scanner scanner) {
        if (!gameStarted) {
            System.out.println("Inicie um jogo primeiro!");
            return;
        }

        System.out.print("Informe a linha: ");
        int row = scanner.nextInt();
        System.out.print("Informe a coluna: ");
        int col = scanner.nextInt();

        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.println("Posição inválida!");
            return;
        }

        if (fixed[row][col]) {
            System.out.println("Não é possível remover um número fixo!");
            return;
        }

        board[row][col] = 0;
    }

    private static void displayBoard() {
        if (!gameStarted) {
            System.out.println("Nenhum jogo iniciado!");
            return;
        }

        System.out.println("=== TABULEIRO ATUAL ===");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void checkGameStatus() {
        if (!gameStarted) {
            System.out.println("Status: Jogo não iniciado (Sem erros)");
            return;
        }

        boolean complete = true;
        boolean valid = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    complete = false;
                }
                if (!isValid(i, j)) {
                    valid = false;
                }
            }
        }

        if (!complete) {
            System.out.println("Status: Jogo incompleto" + (valid ? " (Sem erros)" : " (Com erros)"));
        } else {
            System.out.println("Status: Jogo completo" + (valid ? " (Sem erros)" : " (Com erros)"));
        }
    }

    private static boolean isValid(int row, int col) {
        int value = board[row][col];
        if (value == 0) return true;

        // Verifica linha e coluna
        for (int i = 0; i < SIZE; i++) {
            if ((i != col && board[row][i] == value) || (i != row && board[i][col] == value)) {
                return false;
            }
        }

        // Verifica subgrade 3x3
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (i != row && j != col && board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void clearBoard() {
        if (!gameStarted) {
            System.out.println("Nenhum jogo iniciado!");
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!fixed[i][j]) {
                    board[i][j] = 0;
                }
            }
        }

        System.out.println("Tabuleiro limpo!");
    }

    private static void endGame() {
        if (!gameStarted) {
            System.out.println("Jogo não iniciado!");
            return;
        }

        boolean complete = true;
        boolean valid = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    complete = false;
                }
                if (!isValid(i, j)) {
                    valid = false;
                }
            }
        }

        if (complete && valid) {
            System.out.println("Parabéns! Você completou o jogo com sucesso!");
        } else {
            System.out.println("O jogo ainda não está completo ou contém erros!");
        }
    }
}