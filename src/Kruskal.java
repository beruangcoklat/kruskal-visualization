import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

public class Kruskal {

	private final int ballSize = 10;
	private int jumlah_node;
	private Vector<Point> points = new Vector<>();
	private Vector<Edge> edgeList = new Vector<>();
	private int[] parent;
	private Vector<Pair<Point, Point>> ret = new Vector<>();

	private void reset() {
		for (int i = 0; i < jumlah_node; i++) {
			parent[i] = -1;
		}
	}

	private double euclideanDistance(Point a, Point b) {
		int x = a.x - b.x;
		int y = a.y - b.y;
		x *= x;
		y *= y;
		return Math.sqrt(x + y);
	}

	private void constructGraph() {
		if (ret.size() != 0)
			return;
		for (int i = 0; i < jumlah_node; i++) {
			for (int j = 0; j < jumlah_node; j++) {
				if (i == j)
					continue;
				edgeList.add(new Edge(i, j, euclideanDistance(points.get(i), points.get(j))));
			}
		}
	}

	private int findParent(int x) {
		int curr = x;
		while (parent[curr] != -1)
			curr = parent[curr];
		return curr;
	}

	private boolean connect(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		if (px == py)
			return false;
		parent[px] = py;
		return true;
	}

	public void doMST() {
		reset();
		constructGraph();
		Collections.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge e1, Edge e2) {
				return (int) (e1.cost - e2.cost);
			}

		});

		for (int i = 0; i < edgeList.size(); i++) {
			int source = edgeList.get(i).source;
			int destination = edgeList.get(i).destination;
			if (connect(source, destination)) {
				ret.add(new Pair<Point, Point>(points.get(source), points.get(destination)));
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		for (Point p : points) {
			g.fillOval(p.x, p.y, ballSize, ballSize);
		}

		g.setColor(Color.BLUE);
		for (Pair<Point, Point> edge : ret) {
			int x1 = edge.getKey().x + (ballSize / 2);
			int y1 = edge.getKey().y + (ballSize / 2);
			int x2 = edge.getValue().x + (ballSize / 2);
			int y2 = edge.getValue().y + (ballSize / 2);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	public void generateNode(int jumlah_node) {
		this.jumlah_node = jumlah_node;
		parent = new int[jumlah_node];

		edgeList.clear();
		points.clear();
		ret.clear();
		Random rand = new Random();
		for (int i = 0; i < jumlah_node; i++) {
			int x = rand.nextInt(MainPanel.WIDTH - 20) + 10;
			int y = rand.nextInt(MainPanel.HEIGHT - 20) + 10;
			points.add(new Point(x, y));
		}
	}

}
