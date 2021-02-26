import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class IM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());

			PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<N; i++)
				q.offer(Integer.parseInt(st.nextToken()));
			
			int min = 0, floor=1;
			while(!q.isEmpty()) {
				if(floor <= m1) {
					
					min += q.poll() * floor;
				}
				if(floor <= m2) {
					min += q.poll() * floor;
				}
				floor++;
			}
			System.out.printf("#%d %d\n",tc,min);
			
		}

	}

}
