package cinema;
import java.util.Scanner;

public class Cinema {
    public static int maxIncome(int rows, int seats) {
        if(rows * seats <= 60) {
            return rows * seats * 10;
        } else if (rows % 2 == 0) {
            return rows * seats * 9;
        } else {
            return ((rows / 2 * 10) + ((rows / 2 + 1) * 8)) * seats;
        }
    }
    
    public static void stats(int income, int tickets, int rows, int seats) {
        float prec = (float) tickets / (rows * seats);
        System.out.println("\nNumber of purchased tickets: " + tickets);
        System.out.printf("Percentage: %.2f%%\n", prec * 100);
        System.out.println("Current income: $" + income);
        System.out.println("Total income: $" + maxIncome(rows, seats));
    }
    
    
    public static void showSeats(char[][] arr, int rows, int seats) {
       System.out.println("\n\nCinema:");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                System.out.print(arr[i][j]);
                if (j != seats) {
                    System.out.print(" ");
                }
        }
            System.out.println();
        } 
    }

    public static void fillingCin(char[][] arr, int rows, int seats) {
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = ' ';
                } else if (i == 0) {
                    arr[i][j] = (char) (j + '0');
                } else if (j == 0) {
                    arr[i][j] = (char) (i + '0');
                } else {
                    arr[i][j] = 'S';
                }
            }
        }
    }
    public static int buyTicket(char[][] arr, int rows, int seats) {
        Scanner scanner = new Scanner(System.in);
        boolean ifBad = false;
        int irow;
        int iseat;
        int price;
        do {
            System.out.println("\n\nEnter a row number:\n> ");
            irow = scanner.nextInt();
            System.out.println("\nEnter a seat number in that row:\n> ");
            iseat = scanner.nextInt();
            if (irow <= 0 || irow > rows || iseat <=0 || iseat > seats) {
                System.out.println("Wrong Input!");
               ifBad = true; 
            } else if (arr[irow][iseat] == 'B') {
                System.out.println("That ticket has already been purchased!");
                ifBad = true;
            } else {
                ifBad = false;
            }
           } while (ifBad);
        if(rows * seats <= 60) {
            price = 10;
        } else {
            if (irow <= rows / 2) {
                price = 10;
            } else {
                price = 8;
            }
        }
        System.out.println("\n\nTicket price: $" + price + "\n");
        arr[irow][iseat] = 'B';
        return price;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n> ");
        int rows = scan.nextInt();
        System.out.print("\nEnter the number of seats in each row:\n> ");
        int seats = scan.nextInt();
        char[][] cin = new char[rows + 1][seats + 1];
        fillingCin(cin, rows, seats);
        int choice;
        int income = 0;
        int tickets = 0;
        do {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.print("0. Exit\n > ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    showSeats(cin, rows, seats);
                    break;
                case 2:
                    income += buyTicket(cin, rows, seats);
                    tickets++;
                    break;
                case 3:
                    stats(income, tickets, rows, seats);
                case 0:
                    break;
                    
            }
        } while (choice != 0);
    }
}