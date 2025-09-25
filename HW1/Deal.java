import java.util.Scanner;

public class Deal {
        public static void main(String[] args) {
            int poker = 5;

            Scanner sc = new Scanner(System.in);
            int PLAYERS = sc.nextInt();

            String[] SUITS = {"Tép", "Rô", "Cơ", "Bích"};

            String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "At"};

            int n = SUITS.length * RANKS.length;

            if (poker * PLAYERS > n)
                throw new RuntimeException("Too many players");

            String[] deck = new String[n];
            for (int i = 0; i < RANKS.length; i++) {
                for (int j = 0; j < SUITS.length; j++) {
                    deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
                }
            }

            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n-i));
                String temp = deck[r];
                deck[r] = deck[i];
                deck[i] = temp;
            }

            for (int i = 0; i < PLAYERS * poker; i++) {
                System.out.println(deck[i]);
                if (i % poker == poker - 1)
                    System.out.println();
            }
        }
}
