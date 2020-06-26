public class Edge implements Cloneable {

	public int source, destination;
	public double cost;
	
	public Edge(int source, int destination, double cost) {
		this.source = source;
		this.destination = destination;
		this.cost = cost;
	}
	
	@Override
	protected Object clone() {
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
			return null;	
		}
	}
	
}
