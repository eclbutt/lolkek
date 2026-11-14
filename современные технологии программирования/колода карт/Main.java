package cards;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Создание колоды
        Deck deck = new Deck();

        // Создание структуры для сданных карт
        List<Card> hand = new ArrayList<>();

        System.out.println("Количество карт в колоде: "
                + deck.getCardCount());

        // Перетасовка
        deck.shuffle();

        // Сдача трех карт
        System.out.println("\n--- Сдача карт ---");

        for (int i = 0; i < 3; i++) {
            Card card = deck.dealCard();

            if (card != null) {
                hand.add(card);
                System.out.println("Сдана карта: " + card);
            }
        }

        System.out.println("\nКарт в колоде: "
                + deck.getCardCount());

        System.out.println("Карт на руках: "
                + hand.size());

        // Возвращение первой карты
        System.out.println("\n--- Возвращение карты ---");

        Card returnedCard = hand.remove(0);
        deck.returnCard(returnedCard);

        System.out.println("Карт в колоде: "
                + deck.getCardCount());

        // Проверка дублирования
        System.out.println("\n--- Проверка дублирования ---");

        deck.returnCard(returnedCard);

        // Вывод оставшихся карт на руках
        System.out.println("\n--- Карты на руках ---");

        for (Card card : hand) {
            System.out.println(card);
        }
    }
}