public class ClockWise {

    static final int RIGHT = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int UP = 3;

    static void simulate(int n, int[][] data) {
	int x, y;
	x = y = (n - 1) / 2;
	data[x][y] = 1;
	int len = 1;
	int count = 0;
	int num = 2;
	int dir = RIGHT;
	while (num <= n * n) {
	    for (int i = 0; i < len && num<=n*n; i++) {
		switch (dir) {
		case LEFT:
		    --y;
		    break;
		case RIGHT:
		    ++y;
		    break;
		case UP:
		    --x;
		    break;
		case DOWN:
		    ++x;
		    break;
		default:
		    break;
		}
		data[x][y] = num++;
	    }
	    count++;
	    if (count == 2) {
		count = 0;
		len++;
	    }
	    dir = ((dir + 1) % 4);
	}
	// output(data, n);
    }

    static void output(int[][] data, int n, StringBuffer sb) {
	int i, j;
	for (i = 0; i < n; i++) {
	    System.out.print(data[i][0]);
	    sb.append(data[i][0]);
	    for (j = 1; j < n; j++) {
		System.out.print("*" + data[i][j]);
		sb.append("*" + data[i][j]);
	    }
	    System.out.println();
	    sb.append("\n");
	}
    }

    static String clockwise(int size) {

	StringBuffer sb = new StringBuffer();

	int[][] data = new int[size ][size ];

	simulate(size, data);
	output(data, size, sb);

	return sb.toString();
    }

    
    
    static int num ;
    static int[][] clock(int size){
	int[][] data = new int[size][size];
	
	for(int i = 0;i <=size/2; i++){
	    
	    
	    circle(data,i,size);
	    
	}
	
	return data;
    }
    
    
    static void circle(int[][] data,int start,int size ){
	
	int endX = start;
	int endY = size-start-1;
	
	for(int i =size-start-1 ; i>=endX ; i--){
	    data[start][i] = num--;
	}
	
	for(int i = start+1; i<=endY;i++){
	    data[i][start] = num--;
	}
	
	for(int i = start+1; i<=size-start-1;i++){
	    data[size-start-1][i] = num--;
	}
	
	for(int i = size-start-1-1;i>=start+1;i--){
	    data[i][size-start-1] = num--;
	}
	
	
	
    }
    
    static void print(int[][] data ,int n){
	for(int i = 0 ; i< n ; i++){
	    System.out.print(data[i][0]);
	    for(int j = 1; j< n ; j++){
		System.out.print("*"+data[i][j]);
	    }
	    System.out.println();
	}
    }
    public static void main(String[] args) {

//	System.out.println(clockwise(5));
	num = 25;
	print(clock(5), 5);
	
    }

}
