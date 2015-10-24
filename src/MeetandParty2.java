import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MeetandParty2 {

    public static class Point {
	int x;
	int y;

	public Point(int x, int y) {
	    this.x = x;
	    this.y = y;
	}

    }

    public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new FileReader(
		"B-small-attempt1.in"));

	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
		"B-small-attempt1.out")));

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

	    int min = Integer.MAX_VALUE;
	    int d = 0;
	    int x = 0;
	    int y = 0;

	    for (int j = 0; j < list.size(); j++) {
		Point center = list.get(j);
		d = 0;
		for (int k = 0; k < list.size(); k++) {
		    d += Math.abs(center.x - list.get(k).x);
		    d += Math.abs(center.y - list.get(k).y);
		}

		if (d < min) {
		    min = d;
		    x = center.x;
		    y = center.y;

		}

	    }

	    out.println(String.format("Case #%d: %d %d %d", i + 1, x, y, min));

	}
	out.close();

    }

}
