import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class RationalNumberTree {

    public static class Rational {
	double up;
	double down;

	public Rational(double up, double down) {
	    this.up = up;
	    this.down = down;
	}

	@Override
	public boolean equals(Object obj) {
	    Rational r = (Rational) obj;
	    return this.up == r.up && this.down == r.down;
	}

    }

    public static void main(String[] args) throws Exception {

	BufferedReader in = new BufferedReader(new FileReader("B-large.in"));

	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
		"B-large.out")));

	int N = Integer.valueOf(in.readLine());

	for (int i = 0; i < N; i++) {

	    String line = in.readLine();
	    String[] s = line.split(" ");
	    int type = Integer.valueOf(s[0]);
	    if (type == 1) {

		double n = Double.valueOf(s[1]);

		Rational[] a = new Rational[(int) (n + 1)];

		a[1] = new Rational(1, 1);
		for (int j = 2; j <= n; j += 2) {
		    Rational parent = a[j / 2];

		    a[j] = new Rational(parent.up, parent.down + parent.up);
		   if(j+1<a.length){
		    a[j + 1] = new Rational(parent.down + parent.up,
			    parent.down);
		    }

		}

		out.println("Case #" + (i + 1) + ": " + " "
			+ a[(int) n].up + " " + a[(int) n].down);
	    } else if (type == 2) {
		double up = Double.valueOf(s[1]);
		double down = Double.valueOf(s[2]);

		int index = find(up, down);

		out.println("Case #" + (i + 1) + ": "  + " "
			+ index);
	    }

	}

	out.close();
    }

    public static int find(double up, double down) {
	if (up == 1.0 && down == 1.0) {
	    return 1;
	}

	int add = 0;
	if (up > down) {
	    add = 1;
	}
	
	if(add == 0){
	    return find(up, down-up)*2;
	}else{
	return find(up - down, down) * 2 + add;
	}

    }

}
