package weber_winslow;

public class Main {

	public static int M = 3;
	public static int K = 2;
	public static int N = 3;
	public static int NUM = M*N;
	
	public static int A [][] = {{1,2}, {3,4}, {5,6}};
	public static int B [][] = {{7,8,9},{10,11,12}};
	public static int C [][] = new int [M][N];
	
	public static WorkerThread[][] thd = new WorkerThread[M][N];
		
	public static void main(String[] args) {

		for (int i = 0; i < M ; i++){
			for (int j = 0; j < N; j++){
				thd[i][j] = new WorkerThread(i,j,A,B,C);
				thd[i][j].run();
				try {
					thd[i][j].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}
}
