/*
 * @(#)CardPlayer.java $version 2016. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.study.card.game;

import java.util.Set;

/**
 * @author SuJi, Lee
 *
 */
public class CardPlayer {
	private Set<Card> cardSet;
	private int cardSum;

	public Set<Card> getCardSet() {
		return cardSet;
	}

	public void setCardSet(Set<Card> cardSet) {
		this.cardSet = cardSet;
	}

	public int getCardSum() {
		return cardSum;
	}

	public void setCardSum(int cardSum) {
		this.cardSum = cardSum;
	}
}
