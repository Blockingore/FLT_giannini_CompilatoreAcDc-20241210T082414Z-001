package ast;

import visitor.IVisitor;

/** 
 * Implementa il nodo NodeId dell'AST.
 * 
 * @author Luca Iacobucci, 20035727
 * @author Andrija Jovic, 20034244
 */
public class NodeId extends NodeAST {
	
	private String name;
	
	/**
	 * Costruttore per NodeId.
	 * 
	 * @param name il nome assegnato al nodo
	 */
	public NodeId(String name) {
		this.name = name;
	}
	
	/**
	 * Restituisce il nome dell'id assegnato a un NodeId.
	 * 
	 * @return il nome dell'id assegnato al nodo
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "NodeId -> [names=" + name + "]; \t";
	}

/*
	@Override
    public String calcCodice(){
		return name;
		}
*/
		@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}