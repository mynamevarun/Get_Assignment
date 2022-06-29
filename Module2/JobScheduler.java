package p2;

import java.util.Arrays;

class FcFs{
	
	public int[] completionTime(int at[],int bt[], int n) {
		
		int ct[] = new int[n];
		for(int  i = 0 ; i < n; i++)
		{
			if( i == 0){
				ct[i] = at[i] + bt[i];
			}
			else{
				if( at[i] > ct[i-1]){
					ct[i] = at[i] + bt[i];
				}
				else {
					ct[i] = ct[i-1] + bt[i];
				}
					
		}
	}
		return ct;
	
}
public int[] turnAroundTime(int at[],int bt[], int n) {
		
		int tat[] = new int[n];
		
		int ct[] = completionTime(at,bt,n);
		for(int i=0;i<n;i++) {
			tat[i] = ct[i] - at[i];
			
		}
		
	return tat;
}
public int[] waitingTime(int at[],int bt[], int n) {
		
		
		int wt[] = new int[n];
		int ct[] = completionTime(at,bt,n);
		int tat[] = turnAroundTime(at,bt,n);
		for(int i=0;i<n;i++) {
			
			wt[i] = tat[i]-bt[i];
		}
		
	return wt;
}

public float averageWaitingTime(int wt[],int n) {
	

	float avgWt=0;
	for(int i=0;i<n;i++) {
		avgWt += wt[i];
	}
	
	return avgWt/n;
}
	
public int maxWaitingTime(int wt[],int n) {
	int max=0;
	for(int i=0;i<n;i++) {
		if(wt[i] > max) {
			max=wt[i];
		}
	}
	return max;
}
}




public  class JobScheduler {
		public static void main(String[] args) {
			int[][] process = {{0,10}, {6,20}, {60,10}, {110,5}};
			int len = process.length;
			int at [] = new int[len];
			int bt[] = new int[len];
			for(int i=0;i<process.length;i++) {
				at[i] = process[i][0];
			}
			for(int i=0;i<process.length;i++) {
				bt[i] = process[i][1];
			}
			FcFs fc = new FcFs();
			System.out.println("The Completion Time is: ");
			System.out.println(Arrays.toString(fc.completionTime(at,bt,len)));
			
			System.out.println("The Turn Around Time is: ");
			System.out.println(Arrays.toString(fc.turnAroundTime(at,bt,len)));
			
			System.out.println("The Waiting Time is: ");
			System.out.println(Arrays.toString(fc.waitingTime(at,bt,len)));
			int wt[] = fc.waitingTime(at, bt, len);
			
			System.out.println("The Average Waiting Time is: ");
			System.out.println(fc.averageWaitingTime(wt,len));
			
			System.out.println("The Maximum Waiting Time is: ");
			System.out.println(fc.maxWaitingTime(wt,len));
			
			
			
		}
}
