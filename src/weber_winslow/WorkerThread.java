package weber_winslow;

public class WorkerThread extends Thread implements Runnable  {

	private int row;
	private int col;
	private int[][] A;
	private int[][] B;
	private int[][] C;
	
	public WorkerThread(int row, int col, int[][] A, int[][] B, int[][] C){
		this.row = row;
		this.col = col;
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	@Override
	public void run() {
		int number = 0;
    	for (int i = 0; i < 2; i++){    		
			number += A[row][i] * B[i][col];
		}
    	System.out.println(number);	
        C[row][col] = number;
	}

}
