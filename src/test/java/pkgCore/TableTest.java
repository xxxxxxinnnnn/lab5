package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableTest {

	@Test
	public void TableTest1() {
		
		//	TODO: Create 2 players.
		//			Add them to the a Table
		//			Ensure that each are added to the table
		//			Remove each from the Table, ensure they are removed from the table.
		Player player1 = new Player("Mary", 0);
		Player player2 = new Player("Kuke", 1);
		Table table  = new Table();
		table.AddPlayerToTable(player1);
		table.AddPlayerToTable(player2);
		assertEquals(player1, table.GetPlayerFromTable(player1));
		assertEquals(player2, table.GetPlayerFromTable(player2));
		
		table.RemovePlayerFromTable(player1);
		table.RemovePlayerFromTable(player2);
		assertNull(table.GetPlayerFromTable(player1));
		assertNull(table.GetPlayerFromTable(player2));
	}

}
