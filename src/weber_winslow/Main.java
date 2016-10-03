package weber_winslow;

import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Boolean check = false;
		
		int intRowMatrix1, intRowMatrix2, intColMatrix1, intColMatrix2;
		
		do {
			System.out.println("Please enter the number of rows for the first Matrix: ");
			String stringRowMatrix1 = in.nextLine();
			intRowMatrix1 = Integer.parseInt(stringRowMatrix1);
			
			System.out.println("Please enter the number of columns for the first Matrix: ");
			String stringColMatrix1 = in.nextLine();
			intColMatrix1 = Integer.parseInt(stringColMatrix1);
			
			System.out.println("Please enter the number of rows for the second Matrix: ");
			String stringRowMatrix2 = in.nextLine();
			intRowMatrix2 = Integer.parseInt(stringRowMatrix2);
			
			System.out.println("Please enter the number of columns for the second Matrix: ");
			String stringColMatrix2 = in.nextLine();
			intColMatrix2 = Integer.parseInt(stringColMatrix2);
			
			if (intRowMatrix1 != intColMatrix2){
				System.out.println("Not the correct parameters; Please try again!");
			} else {
				check = true;
			}
			
		} while(check == false);
		
		
		
		int A [][] = new int [intRowMatrix1][intColMatrix1];
		int B [][] = new int [intRowMatrix2][intColMatrix2];
		int C [][] = new int [intRowMatrix1][intColMatrix2];
		
		for (int indexRow = 0; indexRow < intRowMatrix1; indexRow++){
			for (int indexCol = 0; indexCol < intColMatrix1; indexCol++){
				System.out.println("Please enter the cordinate for the first matrix at [" + indexRow + "] [" + indexCol + "] :" );
				A[indexRow][indexCol] = Integer.parseInt(in.nextLine());
			}
		}
		
		for (int indexRow = 0; indexRow < intRowMatrix2; indexRow++){
			for (int indexCol = 0; indexCol < intColMatrix2; indexCol++){
				System.out.println("Please enter the cordinate for the second matrix at [" + indexRow + "] [" + indexCol + "] :" );
				B[indexRow][indexCol] = Integer.parseInt(in.nextLine());
			}
		}
		
		System.out.println("Matrix 1:");

		for (int indexRow = 0; indexRow < intRowMatrix1; indexRow++){
			for (int indexCol = 0; indexCol < intColMatrix1; indexCol++){
				if (indexCol != 0){
					System.out.print("-");
				}
				System.out.print(A[indexRow][indexCol]);
			}
			System.out.println("");
		}
		
		System.out.println("Matrix 2:");

		for (int indexRow = 0; indexRow < intRowMatrix2; indexRow++){
			for (int indexCol = 0; indexCol < intColMatrix2; indexCol++){
				if (indexCol != 0){
					System.out.print("-");
				}
				System.out.print(B[indexRow][indexCol]);
			}
			System.out.println("");
		}
		
		Thread[] thd = new Thread[intRowMatrix1 * intColMatrix2];
		
		int count = 0;

		for (int i = 0; i <intColMatrix2  ; i++){
			for (int j = 0; j < intRowMatrix1; j++){				
				thd[count] = new Thread(new WorkerThread (i,j, A, B, C));	
				thd[count].start();
				count++;
			}
		}
		
		for (int index = 0; index < intRowMatrix1 * intColMatrix2; index++){
			try {
				thd[index].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Product Matrix:");
		
		for (int indexRow = 0; indexRow < intRowMatrix1; indexRow++){
			for (int indexCol = 0; indexCol < intColMatrix2; indexCol++){
				if (indexCol != 0){
					System.out.print("-");
				}
				System.out.print(C[indexRow][indexCol]);
			}
			System.out.println("");
		}
		
		System.out.println("End of Program");


	}
}
