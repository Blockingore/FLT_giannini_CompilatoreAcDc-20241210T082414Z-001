package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;
import parser.*;
import scanner.Scanner;
import ast.NodeProgramm;
import exception.SyntacticException;
import visitor.*;

/**
 * Test per il CodeGenerator
 * 
 * @author Luca Iacobucci, 20035727
 * @author Andrija Jovic, 20034244
 */
public class TestCodeGenerator {
    
    String path = "src/test/data/testCodeGenerator/";
    
    @Test
    public void test_3_Generale() throws FileNotFoundException, SyntacticException {

        NodeProgramm nP = new Parser(new Scanner(path + "3_generale.txt")).parse();

		var tcVisit = new TypeCheckinVisitor();
		nP.accept(tcVisit);
		var cgVisit = new CodeGeneratorVisitor();
		nP.accept(cgVisit);
		
		assertEquals(cgVisit.getLog(), "");
		//assertEquals("5 3 + si li 0.5 + sf li p P lf 4 5 k / 0 k sf lf p P lf 1 - sflo lflo lf * sflo lflo p P", cgVisit.getCodiceGenerato());
		assertEquals("5 3 + sa la 0.5 + sb la p P lb 4 5 k / 0 k sb lb p P lb 1 - sc lc lb * sc lc p P", cgVisit.getCodiceGenerato());
    }
  
    @Test
	public void test_1_Assign1() throws FileNotFoundException, SyntacticException {

		NodeProgramm nP = new Parser(new Scanner(path + "1_assign.txt")).parse();
		var tcVisit = new TypeCheckinVisitor();
		nP.accept(tcVisit);
		var cgVisit = new CodeGeneratorVisitor();
		nP.accept(cgVisit);
		
		assertEquals(cgVisit.getLog(), "");
		//assertEquals(cgVisit.getCodiceGenerato(), "1 6 / stemp ltemp p P");
		assertEquals("1 6 / sa la p P", cgVisit.getCodiceGenerato());

    }
    
    @Test
    public void test_2_divisioni() throws FileNotFoundException, SyntacticException{
        
            NodeProgramm nP = new Parser(new Scanner(path + "2_divsioni.txt")).parse();
            var tcVisit = new TypeCheckinVisitor();
            nP.accept(tcVisit);
            var cgVisit = new CodeGeneratorVisitor();
            nP.accept(cgVisit);
            
            assertEquals(cgVisit.getLog(), "");
            //assertEquals("0 sa la 1 + sa 6 sb 1.0 6 5 k / 0 k la lb / + stemp la p P lb p P ltemp p P", 
            assertEquals("0 sa la 1 + sa 6 sb 1.0 6 5 k / 0 k la lb / + sc la p P lb p P lc p P", 
            cgVisit.getCodiceGenerato());

        }
     
    @Test
    public void testRegistriFiniti() throws FileNotFoundException, SyntacticException {

            NodeProgramm nP = new Parser(new Scanner(path + "4_registriFiniti.txt")).parse();
            var tcVisit = new TypeCheckinVisitor();
            nP.accept(tcVisit);
            var cgVisit = new CodeGeneratorVisitor();
            nP.accept(cgVisit);
        
            assertEquals(cgVisit.getLog(), "impossibile aggiungere altri registri");
            assertEquals("", cgVisit.getCodiceGenerato());
        }

}
    
	
