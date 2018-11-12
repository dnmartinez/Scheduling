import java.util.Arrays;
import java.util.Scanner;

public class FifoScheduler {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("FIFO Scheduling"); // Planificacón de FIFO
		System.out.print("Ingrese el total de procesos: "); //Ingrese el total de procesos
		int numProcess = scanner.nextInt();
		Process processes[]=new Process[numProcess];  //array to store 5 Process objects
		
		for(int i = 0; i < numProcess; i++) {
			// Ingrese el ID del proceso, el tiempo de ejecucion y la prioridad:
			System.out.print("Enter the PID, burst time, and priority: "); 
			int pid = scanner.nextInt(); // process id o id del proceso
			int bt = scanner.nextInt(); // burst time o tiempo
			int priority = scanner.nextInt();
			processes[i] = Process.createPriority(pid, bt, priority);	
		}
		
		
		
		//434 123 251 522 
	    System.out.println("The processess will be executed as follows:"); // Los procesos se ejecutaron de la siguiente forma
	    System.out.println(Arrays.toString(processes));
	}
}
