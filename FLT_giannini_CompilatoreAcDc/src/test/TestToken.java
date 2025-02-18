package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import token.Token;
import token.TokenType;

/**
 * Test per la classe Token
 * 
 * @author Luca Iacobucci, 20035727
 * @author Andrija Jovic, 20034244
 */
class TestToken {

	@Test
	void testCostruttore() {
		Token tk1 = new Token(TokenType.SEMI, 1);
		Token tk2 = new Token(TokenType.PLUS, 5);
		
		assertEquals(tk1.getTipo(), TokenType.SEMI);
		assertEquals(tk1.getRiga(), 1);
		assertEquals(tk2.getTipo(), TokenType.PLUS);
		assertEquals(tk2.getRiga(), 5);
	}
	
	@Test
	void testCostruttoreValore() {
		Token tk1 = new Token(TokenType.INT, 4, "19");
		Token tk2 = new Token(TokenType.ID, 2, "b");
		
		assertEquals(tk1.getTipo(), TokenType.INT);
		assertEquals(tk1.getRiga(), 4);
		assertEquals(tk1.getVal(), "19");
		assertEquals(tk2.getTipo(), TokenType.ID);
		assertEquals(tk2.getRiga(), 2);
		assertEquals(tk2.getVal(), "b");
	}
	
	@Test
	void testToString() {
		Token tk1 = new Token(TokenType.SEMI, 1);
		Token tk2 = new Token(TokenType.ID, 2, "b");
		
		assertEquals(tk1.toString(), "SEMI, riga: 1");
		assertEquals(tk2.toString(), "ID, riga: 2, b");
	}
}
