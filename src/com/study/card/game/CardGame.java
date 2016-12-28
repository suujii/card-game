/*
 * @(#)CardGame.java $version 2016. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.study.card.game;

/**
 * @author SuJi, Lee
 *
 */
public interface CardGame {
	public void cardGamePlay();

	public void suffleCard();

	public void divideCard();

	public void printWinner();
}
