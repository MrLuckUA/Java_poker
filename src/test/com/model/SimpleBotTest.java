package com.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleBotTest {
    private Combinations combinations;
    private ArrayList<Card> cards;
    private Player player;
    private SimpleBot simpleBot;
    @Before
    public void beforeCombinationsTest() throws Exception{
        combinations = new Combinations();
        cards = new ArrayList<>();
        player = new Player();
        simpleBot = new SimpleBot();
    }

    @Test
    public void thinkWhenStackMoreThan750noPrevRateAndPowerIsMoreThan40() {
        cards.add(new Card(3,4));
        cards.add(new Card(3,2));
        cards.add(new Card(5,1));
        cards.add(new Card(5,4));
        double move = simpleBot.think(cards, 800,1500, 0);
        assertEquals(200, move,0);
    }
    @Test
    public void thinkWhenStackMoreThan750noPrevRateAndPowerIsMoreThan20() {
        cards.add(new Card(3,4));
        cards.add(new Card(3,2));
        double move = simpleBot.think(cards, 800,1500, 0);
        assertEquals(100, move,0);
    }
    @Test
    public void thinkWhenStackMoreThan750noPrevRateAndPowerIsLessThan20() {
        cards.add(new Card(3,4));
        double move = simpleBot.think(cards, 800,1500, 0);
        assertEquals(0, move,0);
    }

    @Test
    public void thinkWhenStackMoreThan750AndPowerIsMoreThan70WithPrevRateMore500() {
        cards.add(new Card(3,4));
        cards.add(new Card(3,2));
        cards.add(new Card(3,1));
        double move = simpleBot.think(cards, 1200,1500, 600);
        assertEquals(600, move,0);
    }

    @Test
    public void thinkWhenStackMoreThan750AndPowerIsMoreThan70WithPrevRateLess500() {
        cards.add(new Card(3,4));
        cards.add(new Card(3,2));
        cards.add(new Card(3,1));
        double move = simpleBot.think(cards, 1200,1500, 200);
        assertEquals(500, move,0);
    }

    @Test
    public void thinkWhenStackMoreThan750AndPowerIsMoreThan50AndBankIsLessThen800WithPrevRateLess100() {
        cards.add(new Card(11,4));
        cards.add(new Card(11,2));
        cards.add(new Card(7,4));
        cards.add(new Card(7,2));
        double move = simpleBot.think(cards, 1200,700, 50);
        assertEquals(200, move,0);
    }
    @Test
    public void thinkWhenStackMoreThan750AndPowerIsMoreThan50AndBankIsLessThen800WithPrevRateMore100() {
        cards.add(new Card(11,4));
        cards.add(new Card(11,2));
        cards.add(new Card(7,4));
        cards.add(new Card(7,2));
        double move = simpleBot.think(cards, 1200,700, 150);
        assertEquals(200, move,0);
    }

    @Test
    public void thinkWhenStackMoreThan750AndPowerIsMoreThan50AndBankIsMoreThen800() {
        cards.add(new Card(11,4));
        cards.add(new Card(11,2));
        cards.add(new Card(7,4));
        cards.add(new Card(7,2));
        double move = simpleBot.think(cards, 1200,900, 50);
        assertEquals(50, move,0);
    }
    @Test
    public void thinkWhenStackMoreThan750AndPowerIsMoreThan40AndBankIsLessThen600() {
        cards.add(new Card(5,4));
        cards.add(new Card(5,2));
        cards.add(new Card(7,4));
        cards.add(new Card(7,2));
        double move = simpleBot.think(cards, 1200,500, 100);
        assertEquals(200, move,0);
    }
    @Test
    public void thinkWhenStackMoreThan750AndPowerIsMoreThan40AndBankIsMoreThen600() {
        cards.add(new Card(5,4));
        cards.add(new Card(5,2));
        cards.add(new Card(7,4));
        cards.add(new Card(7,2));
        double move = simpleBot.think(cards, 1200,700, 100);
        assertEquals(100, move,0);
    }
    @Test
    public void thinkWhenStackMoreThan750AndPowerIsMoreThan20() {
        cards.add(new Card(5,4));
        cards.add(new Card(5,2));
        double move = simpleBot.think(cards, 1200,700, 100);
        assertEquals(100, move,0);
    }
    @Test
    public void thinkWhenStackMoreThan750AndPowerIsLessThan20() {
        cards.add(new Card(5,4));
        combinations.setCards(cards);
        double move = simpleBot.think(cards, 1200,700, 100);
        assertEquals(-1, move,0);
    }

    @Test
    public void thinkWhenStackLessThan750AndPowerMoreThen70() {
        cards.add(new Card(5,4));
        cards.add(new Card(5,3));
        cards.add(new Card(5,1));
        combinations.setCards(cards);
        double move = simpleBot.think(cards, 400,700, 0);
        assertEquals(400, move,0);
    }
    @Test
    public void thinkWhenStackLessThan750AndNoPrevRate() {
        cards.add(new Card(5,4));
        combinations.setCards(cards);
        double move = simpleBot.think(cards, 300,700, 0);
        assertEquals(0, move,0);
    }
    @Test
    public void thinkWhenStackLessThan750AndPowerLessThen70AndPrevRateMoreThan0() {
        cards.add(new Card(5,4));
        combinations.setCards(cards);
        double move = simpleBot.think(cards, 400,700, 50);
        assertEquals(-1, move,0);
    }

/*
    @Test
    public void checkStackIsMoreThan750() {
        assertTrue(simpleBot.getStackBotMoreOrEqual(800, 750));
    }
    @Test
    public void checkPrevRateIsEqual0() {
        assertTrue(simpleBot.getPrevRateBotEqual(0, 0));
    }
    @Test
    public void checkPrevRateIsMore0() {
        assertTrue(simpleBot.getPrevRateBotMore(5, 0));
    }
    @Test
    public void checkPrevRateIsMoreOrEqual500() {
        assertTrue(simpleBot.getPrevRateBotMoreOrEqual(600, 500));
    } @Test
    public void checkPrevRateIsLessOrEqual100() {
        assertTrue(simpleBot.getPrevRateBotLessOrEqual(50, 100));
    }
    @Test
    public void checkBankIsMore600() {
        assertTrue(simpleBot.getBankBotLessOrEqual(700, 600));
    }@Test
    public void checkBankIsMore800() {
        assertTrue(simpleBot.getBankBotLessOrEqual(1000, 800));
    }
    @Test
    public void checkPowerIsMore40() {
        assertTrue(simpleBot.getPowerBotMoreOrEqual(40, 40));
    }
    @Test
    public void checkPowerIsMore20() {
        assertTrue(simpleBot.getPowerBotMoreOrEqual(30, 20));
    }
    @Test
    public void checkPowerIsMore70() {
        assertTrue(simpleBot.getPowerBotMoreOrEqual(75, 70));
    }
    @Test
    public void checkPowerIsMore50() {
        assertTrue(simpleBot.getPowerBotMoreOrEqual(55, 50));
    }*/
}
