package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Games.Game;

public abstract class CardGame implements Game {

    public abstract Deck dealCards();
}
