import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Blackjack {
    public static void whoWon(int dealersSum, int playersSum) {
        if(dealersSum == playersSum) {
            System.out.println("Draw!\n");
        }
        if(dealersSum < playersSum) {
            System.out.println("You won!!!!\n");
        }
        if(dealersSum > playersSum) {
            System.out.println("You lost... happens.\n");
        }
    }
    public static boolean wrongInput(String input) {
        if(!("OUT".equalsIgnoreCase(input) || "STAY".equalsIgnoreCase(input) || "HIT".equalsIgnoreCase(input))) {
            System.out.println("Wrong input!");
            return true;
        }
        return false;
    }
    public static boolean if21(String who, int sum) {
        if(sum >= 21) {
            if(sum == 21) {
                System.out.printf("%s won by hitting 21!%n", who);
            } else {
                System.out.printf("%s lost by hitting over 21!%n", who);
            }
            return true;
        }
        return false;
    }
    public static boolean ifBust(int dealersSum, int playersSum){
        if (if21("You", playersSum) || if21("Dealer", dealersSum)) {
            return true;
        }
        return false;
    }
    public static int handToSum(ArrayList<Character> hand) {
        int sum = 0;
        for(char c : hand) {
            if(Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
                if(c == '0') {
                    sum += 10;
                }
            } else {
                switch(c) {
                    case 'A':
                        sum += 11;
                        break;
                    default:
                        sum += 10;
                }
            }
        }
        if(sum > 21) {
            for(char c: hand) {
                if(c == 'A') {
                    sum -= 10;
                    if(sum <= 21) {
                        break;
                    }
                }
            }
        }
        return sum;
    }
    public static void instructions(){
        System.out.println("Available requests in game:");
        System.out.println(" HIT - to ask for another card;");
        System.out.println(" STAY - to keep your hand;");
        System.out.println(" OUT - to end game and close program.\n");
        System.out.println("Cards:\n");
        System.out.println(" A - ace\n 0 - 10 \n J - Jack\n Q - Queen\n K - King\n");
        System.out.println("Good luck!\n");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean end;
        String input = "";
        int dealersSum;
        int playersSum;
        ArrayList dealersHand = new ArrayList();
        ArrayList playersHand = new ArrayList();
        char[] cards = {'A','2','3','4','5','6','7','8','9','0','J','Q','K'};
        Stack deck = new Stack();
        Stack shuffledDeck = new Stack();
        for(char c: cards) {
            for(int i = 0; i < 4; i++) {
                deck.add(c);
            }
        }
        System.out.println("Welcome to Blackjack!\n");
        instructions();
        do{
            input = "";
            System.out.println("\nNew game:");
            end = false;
            shuffledDeck = deck;
            Collections.shuffle(shuffledDeck);
            playersHand.clear();
            dealersHand.clear();
            dealersSum = 0;
            playersSum = 0;
            playersHand.add(shuffledDeck.pop());
            dealersHand.add(shuffledDeck.pop());
            playersHand.add(shuffledDeck.pop());
            dealersHand.add(shuffledDeck.pop());
            System.out.printf("Dealers hand is: %c and unknown card%n", dealersHand.get(1));
            System.out.println("Your hand is: " + playersHand);
            playersSum = handToSum(playersHand);
            ifBust(dealersSum, playersSum);
            while(!(input.equalsIgnoreCase("STAY") || input.equalsIgnoreCase("OUT")) || end) {
                do {
                    System.out.print("What do you want to do: ");
                    input = scanner.next();
                } while (wrongInput(input));
                switch (input.toUpperCase()) {
                    case "OUT":
                        System.out.println("Goodbye!");
                        break;
                    case "HIT":
                        playersHand.add(shuffledDeck.pop());
                        System.out.printf("You added %c to your hand%n", playersHand.get(playersHand.size() - 1));
                        playersSum = handToSum(playersHand);
                        System.out.println("Your hand is: " + playersHand);
                        if(ifBust(dealersSum, playersSum)) {
                            end = true;
                            break;
                        }
                        break;
                    case "STAY":
                        System.out.println("You chose to stay");
                        break;
                }
                if(end) {
                    break;
                }
            }
            if(end) {
                continue;
            }
            if(input.equalsIgnoreCase("OUT")){
                break;
            }

                if(dealersHand.size() == 2) {
                    System.out.println("Dealer shows his other card.");
                    System.out.println("Dealers hand is: " + dealersHand + "\n");
                    dealersSum = handToSum(dealersHand);
                    if(ifBust(dealersSum, playersSum)) {
                        break;
                    }
                }
                while(dealersSum < 17) {
                    System.out.println("Dealers sum of card is lower then 17, he gets another card");
                    dealersHand.add(shuffledDeck.pop());
                    System.out.println("Dealers hand is: " + dealersHand + "\n");
                    dealersSum = handToSum(dealersHand);
                    if(ifBust(dealersSum, playersSum)) {
                        end = true;
                    }
                }
                if(!end) {
                    whoWon(dealersSum, playersSum);
                }


        } while (input != "OUT");
    }
}