package pkgCore;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.UUID;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.HandException;

public class GamePlayBlackJackTest {

	@Test
	public void TestPlayerWinning() {
		Player player = new Player("Mary", 0);
		HashMap<UUID, Player> hmTablePlayers = new HashMap<>();
		hmTablePlayers.put(player.getPlayerID(),player );
		
		Deck deck = new Deck();
		GamePlayBlackJack game = new GamePlayBlackJack(hmTablePlayers, deck);
		Hand hand = new HandBlackJack();
		hand.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hand.AddCard(new Card(eSuit.SPADES, eRank.FOUR));
		hand.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		GamePlayerHand gamePlayerHand=new GamePlayerHand(game.getGameID(), player.getPlayerID(), hand.getHandID());
		game.putHandToGame(gamePlayerHand, hand);
		
		Player dealer = game.getpDealer();
		Hand hand2 = new HandBlackJack();
		hand2.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hand2.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hand2.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		GamePlayerHand gamePlayerHand2=new GamePlayerHand(game.getGameID(), dealer.getPlayerID(), hand2.getHandID());
		game.putHandToGame(gamePlayerHand2, hand2);
		
		game.ScoreGame(gamePlayerHand);
		
		assertTrue(hand.isbWinner());
	}

	@Test
	public void TestPlayerLosing() {
		Player player = new Player("Mary", 0);
		HashMap<UUID, Player> hmTablePlayers = new HashMap<>();
		hmTablePlayers.put(player.getPlayerID(),player );
		
		Deck deck = new Deck();
		GamePlayBlackJack game = new GamePlayBlackJack(hmTablePlayers, deck);
		Hand hand = new HandBlackJack();
		hand.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hand.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		hand.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		GamePlayerHand gamePlayerHand=new GamePlayerHand(game.getGameID(), player.getPlayerID(), hand.getHandID());
		game.putHandToGame(gamePlayerHand, hand);
		
		Player dealer = game.getpDealer();
		Hand hand2 = new HandBlackJack();
		hand2.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hand2.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hand2.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		GamePlayerHand gamePlayerHand2=new GamePlayerHand(game.getGameID(), dealer.getPlayerID(), hand2.getHandID());
		game.putHandToGame(gamePlayerHand2, hand2);
		
		game.ScoreGame(gamePlayerHand);
		
		assertFalse(hand.isbWinner());
	}
	
	@Test
	public void TestPlayerPush() {
		Player player = new Player("Mary", 0);
		HashMap<UUID, Player> hmTablePlayers = new HashMap<>();
		hmTablePlayers.put(player.getPlayerID(),player );
		
		Deck deck = new Deck();
		GamePlayBlackJack game = new GamePlayBlackJack(hmTablePlayers, deck);
		Hand hand = new HandBlackJack();
		hand.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hand.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		hand.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		GamePlayerHand gamePlayerHand=new GamePlayerHand(game.getGameID(), player.getPlayerID(), hand.getHandID());
		game.putHandToGame(gamePlayerHand, hand);
		
		try {
			assertTrue(game.bDoesDealerHaveToDraw());
		} catch (HandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestTwoPlayersWinning()
	{
		Player player = new Player("Mary", 0);
		Player player2 = new Player("Lucy", 1);
		HashMap<UUID, Player> hmTablePlayers = new HashMap<>();
		hmTablePlayers.put(player.getPlayerID(),player );
		hmTablePlayers.put(player2.getPlayerID(), player2);
		
		Deck deck = new Deck();
		GamePlayBlackJack game = new GamePlayBlackJack(hmTablePlayers, deck);
		Hand hand = new HandBlackJack();
		hand.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hand.AddCard(new Card(eSuit.SPADES, eRank.FOUR));
		hand.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		GamePlayerHand gamePlayerHand=new GamePlayerHand(game.getGameID(), player.getPlayerID(), hand.getHandID());
		game.putHandToGame(gamePlayerHand, hand);
		
		Hand hand3 = new HandBlackJack();
		hand3.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hand3.AddCard(new Card(eSuit.SPADES, eRank.FOUR));
		hand3.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		GamePlayerHand gamePlayerHand3=new GamePlayerHand(game.getGameID(), player2.getPlayerID(), hand3.getHandID());
		game.putHandToGame(gamePlayerHand3, hand3);
		
		Player dealer = game.getpDealer();
		Hand hand2 = new HandBlackJack();
		hand2.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hand2.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hand2.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		GamePlayerHand gamePlayerHand2=new GamePlayerHand(game.getGameID(), dealer.getPlayerID(), hand2.getHandID());
		game.putHandToGame(gamePlayerHand2, hand2);
		
		game.ScoreGame(gamePlayerHand);
		
		game.ScoreGame(gamePlayerHand3);
		
		assertTrue(hand.isbWinner());
		
		assertTrue(hand3.isbWinner());
	}
}
