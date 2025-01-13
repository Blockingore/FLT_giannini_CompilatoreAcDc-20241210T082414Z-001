package ast;

public class NodePrint extends NodeStm {
	private NodeId id;
	
	public NodePrint(NodeId id) {
		this.id = id;
	}

	public NodeId getId() {
		return id;
	}

	@Override
	public String toString() {
		return "NodePrint -> [id=" + id.toString() + "];\t";
	}

	@Override
	public TypeDescriptor calcResType() {
		return new TypeDescriptor(TipoTD.OK);
	}

	@Override
	public String calcCodice() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'calcCodice'");
	}


}
