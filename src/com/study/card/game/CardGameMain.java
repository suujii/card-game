/*
 * @(#)CardGameMain.java $version 2016. 11. 15.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.study.card.game;

/**
 * @author SuJi, Lee
 * 
 */
public class CardGameMain {
	private static final int CARD_GAME_PLAYER_NUMBER = 4;

	public static void main(String[] args) {
		CardGame cardGame = new CardGameImpl(CARD_GAME_PLAYER_NUMBER);
		cardGame.cardGamePlay();
	}
}