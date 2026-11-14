package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        String[] suits = {
                "Черви", "Бубны", "Трефы", "Пики"
        };

        String[] ranks = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Валет",
                "Дама", "Король", "Туз"
        };

        // Создание 52 карт
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Перетасовка колоды
    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Колода перетасована.");
    }

    // Сдача одной карты
    public Card dealCard() {
        if (cards.isEmpty()) {
            System.out.println("Колода пуста!");
            return null;
        }

        return cards.remove(0);
    }

    // Возвращение карты в колоду
    public boolean returnCard(Card card) {

        if (card == null) {
            System.out.println("Нельзя вернуть пустую карту.");
            return false;
        }

        if (cards.contains(card)) {
            System.out.println("Такая карта уже есть в колоде!");
            return false;
        }

        cards.add(card);
        System.out.println("Карта возвращена: " + card);

        return true;
    }

    // Количество карт в колоде
    public int getCardCount() {
        return cards.size();
    }

    // Вывод карт колоды
    public void showDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}