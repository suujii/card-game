/*
 * @(#)Card.java $version 2016. 11. 15.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.study.card.game;

/**
 * @author SuJi, Lee
 *
 */
public class Card {
	private String cardValue;
	private int cardNumber;

	public String getCardValue() {
		return cardValue;
	}

	public void setCardValue(String cardValue) {
		this.cardValue = cardValue;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public int hashCode() {
		return cardValue.hashCode() + Integer.toString(cardNumber).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			Card card = (Card)obj;
			return cardValue.equals(card.cardValue) && cardNumber == card.cardNumber;
		}
		return false;
	}

	@Override
	public String toString() {
		return cardValue;
	}
}
