package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import exception.LexicalException;
import scanner.Scanner;
import token.Token;
import token.TokenType;

class TestScanner {

	String path = "src/test/data/testScanner/";
	
	@Test
	void testNextToken() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "testGenerale.txt");
		
		Token tk;

		//riga 1
		 tk = scan.nextToken();
		 
		 assertEquals(  TokenType.TYINT  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 1  );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.ID  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 1  );
		 assertEquals( "temp", tk.getVal());
		
		 tk = scan.nextToken();
		 assertEquals(  TokenType.SEMI  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 1  ); 
		 
		 //riga 2
		 tk = scan.nextToken();
		 
		 assertEquals(  "temp"  , tk.getVal() );
		 assertEquals(  TokenType.ID  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 2  );
	
		 tk = scan.nextToken();
		 assertEquals(  TokenType.OP_ASSIGN  , tk.getTipo() );
		 assertEquals(  "+="  , tk.getVal() );
		 assertEquals( tk.getRiga(), 2  );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.FLOAT  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 2  );
		 assertEquals(  "5.0"  , tk.getVal() );
		
		 tk = scan.nextToken();
		 assertEquals(  TokenType.SEMI  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 2  );
		 
		 //riga 3
		 
		 //riga 4 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.TYFLOAT  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 4  );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.ID  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 4  );
		 assertEquals( tk.getVal(), "b"  );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.SEMI  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 4  );
		 
		 
		 // riga 5
		 tk = scan.nextToken();
		 assertEquals(  TokenType.ID  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 5  );
		 assertEquals( tk.getVal(), "b"  );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.ASSIGN  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 5  );
		 assertEquals( tk.getVal(), "="  );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.ID  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 5  );
		 assertEquals( tk.getVal(), "temp" );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.PLUS  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 5  );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.FLOAT  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 5  );
		 assertEquals( tk.getVal(), "3.2" );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.SEMI  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 5  );
		 
		 //riga 6
		 tk = scan.nextToken();
		 assertEquals(  TokenType.PRINT  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 6  );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.ID  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 6  );
		 assertEquals( tk.getVal(), "b" );
		 
		 tk = scan.nextToken();
		 assertEquals(  TokenType.SEMI  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 6  );
		 
		 //riga 7
		 tk = scan.nextToken();
		 assertEquals(  TokenType.EOF  , tk.getTipo() );
		 assertEquals( tk.getRiga(), 8  );
		 

	}

	@Test
	void testCaratteriNonCaratteri() throws IOException, LexicalException {
		
	    Scanner scan = new Scanner(path + "caratteriNonCaratteri.txt");
	    Token tk;
	    
	    	LexicalException e = assertThrows(LexicalException.class, () -> {scan.nextToken();});
	    	assertEquals("il carattere: '^' non e' un carattere ammesso", e.getMessage());
	  	    	
	    	 e = assertThrows(LexicalException.class, () -> {scan.nextToken();});
	    	assertEquals("il carattere: '&' non e' un carattere ammesso", e.getMessage());
	    	
	    	tk = scan.nextToken();
	    	assertEquals(  TokenType.SEMI  , tk.getTipo() );

	    	e = assertThrows(LexicalException.class, () -> {scan.nextToken();});
	    	assertEquals("il carattere: '|' non e' un carattere ammesso", e.getMessage());
	    	
	    	tk = scan.nextToken();
	    	assertEquals(  TokenType.PLUS  , tk.getTipo() );

	    	tk = scan.nextToken();
	    	assertEquals(  TokenType.EOF  , tk.getTipo() );
	}
	
	@Test
	void testCaratteriSkip() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "caratteriSkip");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.EOF  , tk.getTipo() );
		
	}
	
	@Test
	void testErroriNumbers() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "erroriNumbers.txt");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.INT  , tk.getTipo() );
		assertEquals(  1 , tk.getRiga() );
		assertEquals(  "0" , tk.getVal() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.INT  , tk.getTipo() );
		assertEquals(  1 , tk.getRiga() );
		assertEquals(  "33" , tk.getVal() );
		

    	LexicalException e = assertThrows(LexicalException.class, () -> {scan.nextToken();});
    	assertEquals("Numero non valido alla riga 3; ci sono più di 5 cifre dopo il '.'", e.getMessage());
  	

    	e = assertThrows(LexicalException.class, () -> {scan.nextToken();});
		assertEquals("Numero non valido (doppio punto) alla riga 5" , e.getMessage());
  	
	}
	
	@Test	
	void testEOF() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "testEOF.txt");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.EOF  , tk.getTipo() );
		
	}
	
	@Test
	void testFloat() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "testFloat.txt");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.FLOAT  , tk.getTipo() );
		assertEquals(  1  , tk.getRiga() );
		assertEquals(  "98.8095"  , tk.getVal() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.FLOAT  , tk.getTipo() );
		assertEquals(  2  , tk.getRiga() );
		assertEquals(  "0.0"  , tk.getVal() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.FLOAT  , tk.getTipo() );
		assertEquals(  3  , tk.getRiga() );
		assertEquals(  "98.0"  , tk.getVal() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.FLOAT  , tk.getTipo() );
		assertEquals(  5  , tk.getRiga() );
		assertEquals(  "89.99999"  , tk.getVal() );

	}
	
	@Test
	void testId() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "testId.txt");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.ID  , tk.getTipo() );
		assertEquals(  1  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.ID  , tk.getTipo() );
		assertEquals(  2  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.ID  , tk.getTipo() );
		assertEquals(  4  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.ID  , tk.getTipo() );
		assertEquals(  6  , tk.getRiga() );
	}
	
	@Test
	void testIdKeywords() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "testIdKeyWords.txt");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.TYINT  , tk.getTipo() );
		assertEquals(  1  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.ID  , tk.getTipo() );
		assertEquals(  1  , tk.getRiga() );

		tk = scan.nextToken();
		assertEquals(  TokenType.TYFLOAT  , tk.getTipo() );
		assertEquals(  2  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.PRINT  , tk.getTipo() );
		assertEquals(  3  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.ID  , tk.getTipo() );
		assertEquals(  4  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.ID  , tk.getTipo() );
		assertEquals(  5  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.TYINT  , tk.getTipo() );
		assertEquals(  6  , tk.getRiga() );
	}

	@Test
	void testInt() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "testInt.txt");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.INT  , tk.getTipo() );
		assertEquals(  1  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.INT  , tk.getTipo() );
		assertEquals(  2  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.INT  , tk.getTipo() );
		assertEquals(  4  , tk.getRiga() );

		tk = scan.nextToken();
		assertEquals(  TokenType.INT  , tk.getTipo() );
		assertEquals(  5  , tk.getRiga() );
		
		
	}

	@Test
	void testKeyWords() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "testKeywords.txt");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.PRINT  , tk.getTipo() );
		assertEquals(  2  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.TYFLOAT  , tk.getTipo() );
		assertEquals(  2  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.TYINT  , tk.getTipo() );
		assertEquals(  5  , tk.getRiga() );
		
	}
	
	@Test
	void testOpsDels() throws LexicalException, IOException {
		
		Scanner scan = new Scanner(path + "testOpsDels.txt");
		Token tk;
		
		tk = scan.nextToken();
		assertEquals(  TokenType.PLUS  , tk.getTipo() );
		assertEquals(  1  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.OP_ASSIGN  , tk.getTipo() );
		assertEquals(  1  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.MINUS  , tk.getTipo() );
		assertEquals(  2  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.TIMES  , tk.getTipo() );
		assertEquals(  2  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.DIV  , tk.getTipo() );
		assertEquals(  3  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.OP_ASSIGN  , tk.getTipo() );
		assertEquals(  5  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.ASSIGN  , tk.getTipo() );
		assertEquals(  6  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.OP_ASSIGN  , tk.getTipo() );
		assertEquals(  6  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.MINUS  , tk.getTipo() );
		assertEquals(  8  , tk.getRiga() );

		tk = scan.nextToken();
		assertEquals(  TokenType.ASSIGN  , tk.getTipo() );
		assertEquals(  8  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.OP_ASSIGN, tk.getTipo() );
		assertEquals(  8  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.SEMI, tk.getTipo() );
		assertEquals(  10  , tk.getRiga() );
		
		tk = scan.nextToken();
		assertEquals(  TokenType.EOF, tk.getTipo() );
		assertEquals(  10  , tk.getRiga() );
	}
	
	@Test
	void peekToken () throws LexicalException, IOException {

		Scanner s = new Scanner (path + "testGenerale.txt");

		assertEquals(s.peekToken().getTipo(), TokenType.TYINT );
		assertEquals(s.nextToken().getTipo(), TokenType.TYINT );
		assertEquals(s.peekToken().getTipo(), TokenType.ID );
		assertEquals(s.peekToken().getTipo(), TokenType.ID );
		
		Token t = s.nextToken();
		
		assertEquals(t.getTipo(), TokenType.ID);
		assertEquals(t.getRiga(), 1);
		assertEquals(t.getVal(), "temp");
	}

}
