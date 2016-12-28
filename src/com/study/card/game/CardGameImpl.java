/*
 * @(#)CardGameImpl.java $version 2016. 11. 15.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.study.card.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author SuJi, Lee
 *
 */
public class CardGameImpl implements CardGame {
	private static final String[] CARD_SHAPE = {"S", "D", "H", "C"};
	private static final int CARD_TOTAL_SIZE = 52;
	private static final int CARD_MAX_NUMBER = 13;
	private static final int CARD_NUMBER_OF_PLAYER = 7;
	private static final int MAX_SUM_SIZE = 100;
	private static final int FIX_WINNER_CNT = 1;

	private Set<Card> cardSet;
	private int cardGamePlayerNumber;
	private Map<Integer, CardPlayer> cardPlayerMap;

	public CardGameImpl(int cardGamePlayerNumber) {
		if (cardGamePlayerNumber * CARD_NUMBER_OF_PLAYER >= CARD_TOTAL_SIZE) {
			throw new IllegalArgumentException("Game player is too many. Change the Player.");
		}

		this.cardGamePlayerNumber = cardGamePlayerNumber;
		this.cardSet = new HashSet<Card>(CARD_TOTAL_SIZE);
		this.cardPlayerMap = new HashMap<Integer, CardPlayer>(cardGamePlayerNumber);
	}

	@Override
	public void cardGamePlay() {
		suffleCard(); //1. 카드를 섞는다.
		divideCard();//2. 카드를 나누고, 각 player의 합을 계산한다.
		printWinner();// 3. 위너를 출력한다.
	}

	@Override
	public void suffleCard() {
		Random random = new Random();

		while (cardSet.size() != CARD_TOTAL_SIZE) {
			int shapeIndex = random.nextInt(CARD_SHAPE.length);
			int cardNumber = random.nextInt(CARD_MAX_NUMBER) + 1;
			Card card = new Card();
			card.setCardValue(CARD_SHAPE[shapeIndex] + cardNumber);
			card.setCardNumber(cardNumber);
			cardSet.add(card);
		}
	}

	@Override
	public void divideCard() {
		int person = 0;
		int sum = 0;
		Set<Card> cardData = new HashSet<Card>(CARD_NUMBER_OF_PLAYER);
		Card[] card = cardSet.toArray(new Card[0]);

		for (int cardIndex = 0; cardIndex < cardGamePlayerNumber * CARD_NUMBER_OF_PLAYER; cardIndex++) {
			sum += card[cardIndex].getCardNumber();
			cardData.add(card[cardIndex]);

			if ((cardIndex + 1) % CARD_NUMBER_OF_PLAYER == 0) {
				CardPlayer cardPlayer = new CardPlayer();
				cardPlayer.setCardSet(cardData);
				cardPlayer.setCardSum(sum);
				cardPlayerMap.put(++person, cardPlayer);
				sum = 0;
				cardData = new HashSet<Card>(CARD_NUMBER_OF_PLAYER);
			}
		}
	}

	@Override
	public void printWinner() {
		int min = MAX_SUM_SIZE;
		int winnder = 1;

		for (int key : cardPlayerMap.keySet()) {
			System.out.print("Player" + key + " : ");
			int cardSum = cardPlayerMap.get(key).getCardSum();

			if (min > cardSum) {
				min = cardSum;
				winnder = key;
			}
			System.out.print(cardPlayerMap.get(key).getCardSet());
			System.out.println(" : sum = " + cardPlayerMap.get(key).getCardSum());
		}

		if (isSameWinnerExist(min)) {
			System.out.println("More than one winner person exists. New Play Games start!");
			cardGamePlay();
		} else {
			System.out.println("Winner : Player" + winnder);
		}
	}

	private boolean isSameWinnerExist(int min) {
		int sameWinnerCnt = 0;

		for (int key : cardPlayerMap.keySet()) {
			int cardSum = cardPlayerMap.get(key).getCardSum();

			if (min == cardSum) {
				sameWinnerCnt++;
			}

			if (sameWinnerCnt > FIX_WINNER_CNT) {
				return true;
			}
		}
		return false;
	}

	public Set<Card> getCardSet() {
		return cardSet;
	}

	public void setCardSet(Set<Card> cardSet) {
		this.cardSet = cardSet;
	}

	public int getCardGamePlayer() {
		return cardGamePlayerNumber;
	}

	public void setCardGamePlayer(int cardGamePlayer) {
		this.cardGamePlayerNumber = cardGamePlayer;
	}
}
