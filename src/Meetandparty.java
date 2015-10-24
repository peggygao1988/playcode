import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Meetandparty {

    public static class Point {
	int x;
	int y;

	public Point(int x, int y) {
	    this.x = x;
	    this.y = y;
	}

    }

    public static class XCompatarot implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {

	    return o1.x - o2.x;
	}

    }

    public static class YCompatarot implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
	    return o1.y - o2.y;
	}

    }

    public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new FileReader(
		"B-small-attempt0.in"));

	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
		"B-small-attempt0.out")));

	int T = Integer.parseInt(in.readLine());

	for (int i = 0; i < T; i++) {

	    int B = Integer.parseInt(in.readLine());

	    ArrayList<Point> list = new ArrayList<Point>();

	    for (int j = 0; j < B; j++) {
		String[] line = in.readLine().split(" ");
		for (int s = Integer.valueOf(line[0]); s <= Integer
			.valueOf(line[2]); s++) {
		    for (int e = Integer.valueOf(line[1]); e <= Integer
			    .valueOf(line[3]); e++) {
			list.add(new Point(s, e));
		    }
		}
	    }

	    Collections.sort(list, new XCompatarot());
	    int size = list.size();

	    int min = Integer.MAX_VALUE;
	    int d = 0;
	    int x = list.get(0).x;
	    int y = list.get(0).y;

	    if ((size & 1) == 1) {
		int index = size / 2;
		Point center = list.get(index);
		for (int w = index; w >= 0; w--) {
		    Point p = list.get(w);
		    if (p.x != center.x) {
			break;
		    }

		    d = 0;
		    for (Point k : list) {
			d += Math.abs(p.x - k.x);
			d += Math.abs(p.y - k.y);
		    }

		    if (d < min) {
			min = d;
			x = p.x;
			y = p.y;
		    }
		}

		for (int w = index + 1; w < size; w++) {
		    Point p = list.get(w);
		    if (p.x != center.x) {
			break;
		    }

		    d = 0;
		    for (Point k : list) {
			d += Math.abs(p.x - k.x);
			d += Math.abs(p.y - k.y);
		    }

		    if (d < min) {
			min = d;
			x = p.x;
			y = p.y;
		    }
		}
	    } else {
		Point[] centers = { list.get(size / 2), list.get(size / 2 + 1) };

		for (int j = 0; j < 2; j++) {
		    Point center = centers[j];
		    int index = size / 2 + j;
		    for (int w = index; w >= 0; w--) {
			Point p = list.get(w);
			if (p.x != center.x) {
			    break;
			}

			d = 0;
			for (Point k : list) {
			    d += Math.abs(p.x - k.x);
			    d += Math.abs(p.y - k.y);
			}

			if (d < min) {
			    min = d;
			    x = p.x;
			    y = p.y;
			}
		    }

		    for (int w = index + 1; w < size; w++) {
			Point p = list.get(w);
			if (p.x != center.x) {
			    break;
			}

			d = 0;
			for (Point k : list) {
			    d += Math.abs(p.x - k.x);
			    d += Math.abs(p.y - k.y);
			}

			if (d < min) {
			    min = d;
			    x = p.x;
			    y = p.y;
			}
		    }

		}
	    }

	    Collections.sort(list, new YCompatarot());
	    if ((size & 1) == 1) {
		int index = size / 2;
		Point center = list.get(index);
		for (int w = index; w >= 0; w--) {
		    Point p = list.get(w);
		    if (p.y != center.y) {
			break;
		    }

		    d = 0;
		    for (Point k : list) {
			d += Math.abs(p.x - k.x);
			d += Math.abs(p.y - k.y);
		    }

		    if (d < min) {
			min = d;
			x = p.x;
			y = p.y;
		    }
		}

		for (int w = index + 1; w < size; w++) {
		    Point p = list.get(w);
		    if (p.y != center.y) {
			break;
		    }

		    d = 0;
		    for (Point k : list) {
			d += Math.abs(p.x - k.x);
			d += Math.abs(p.y - k.y);
		    }

		    if (d < min) {
			min = d;
			x = p.x;
			y = p.y;
		    }
		}
	    } else {
		Point[] centers = { list.get(size / 2), list.get(size / 2 + 1) };

		for (int j = 0; j < 2; j++) {
		    Point center = centers[j];
		    int index = size / 2 + j;
		    for (int w = index; w >= 0; w--) {
			Point p = list.get(w);
			if (p.y != center.y) {
			    break;
			}

			d = 0;
			for (Point k : list) {
			    d += Math.abs(p.x - k.x);
			    d += Math.abs(p.y - k.y);
			}

			if (d < min) {
			    min = d;
			    x = p.x;
			    y = p.y;
			}
		    }

		    for (int w = index + 1; w < size; w++) {
			Point p = list.get(w);
			if (p.y != center.y) {
			    break;
			}

			d = 0;
			for (Point k : list) {
			    d += Math.abs(p.x - k.x);
			    d += Math.abs(p.y - k.y);
			}

			if (d < min) {
			    min = d;
			    x = p.x;
			    y = p.y;
			}
		    }

		}
	    }

	    out.println(String.format("Case #%d: %d %d %d", i + 1, x, y, min));

	}
	out.close();

    }
}
