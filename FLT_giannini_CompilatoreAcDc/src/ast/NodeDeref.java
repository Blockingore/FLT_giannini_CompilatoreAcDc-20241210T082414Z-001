package ast;

import visitor.IVisitor;

/** 
 * Implementa il nodo NodeDeref dell'AST.
 * 
 * @author Luca Iacobucci, 20035727
 * @author Andrija Jovic, 20034244
 */
public class NodeDeref extends NodeExpr{

	private NodeId id;
	
	/**
	 * Costruttore per NodeDeref.
	 * 
	 * @param id NodeId assegnato al nodo
	 */
	public NodeDeref(NodeId id) {
		this.id = id;
	}

	/**
	 * Restituisce il NodeId assegnato a un NodeDeref.
	 * 
	 * @return NodeId assegnato al nodo
	 */
	public NodeId getId() {
		return id;
	}

	@Override
	public String toString() {
		return "NodeDeref -> [id=" + id + "];\t";
	}
/*
	@Override
	public String calcCodice() {
		return "l" + id.calcCodice();
	}
*/
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}
