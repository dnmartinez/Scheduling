import java.util.Arrays;
import java.util.Scanner;

import javax.swing.Box.Filler;

import org.omg.CORBA.INTERNAL;

public class ShortestJobScheduler {
	public static void main(String[] args) {
		
		/*int arr[] = new int[5];
		for(int i = 0; i < arr.length; i++) {
			Process process = new Process(i, i+1);
			arr[i] = process;
		}*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("SJF Scheduling"); // Planificación del Trabajo más Corto
		System.out.print("Enter the tolal number of processes: "); // Ingrese el total de procesos
		int numProcess = scanner.nextInt();
		Process processes[]=new Process[numProcess];  //array to store 5 Process objects
		
		fillArray(processes, scanner);
		
		boolean hasDuplicateIndex = true;
		int duplicateIndex = 0;
		while(hasDuplicateIndex) {
			duplicateIndex = checkDuplicates(processes);
			if(duplicateIndex == 0) {
				hasDuplicateIndex = false;
			} else {
				changeProcessID(duplicateIndex, scanner, processes);
			}
		}
		
		Sort sort = new Sort();
		sort.arrivalTimeSort(processes);
		System.out.println("By AT: " +Arrays.toString(processes));
		sort.sjfSort(processes);
		
		//12 23 31 44
	    System.out.println("The processess will be executed as follows:"); // Los procesos se ejecutaron de la siguiente forma
	    System.out.println(Arrays.toString(processes));
		
			
	}
	
	public static void fillArray(Process processes[], Scanner scanner) {
		for(int i = 0; i < processes.length; i++) {
			System.out.print("Enter the PID, burst time, and arrival time: "); // Ingrese el ID del proceso, el tiempo de ejecucion y el tiempo de llegada
			int pid = scanner.nextInt();
			int bt = scanner.nextInt();
			int at = scanner.nextInt();
			processes[i] = Process.createSJF(pid, bt, at);
		}
	}
	
	public static int checkDuplicates(Process processes[]) {
		int index = 0;
		for (int i = 0; i < processes.length; i++) { 
			for (int j = i + 1 ; j < processes.length; j++) { 
				if (processes[i].getPID() == processes[j].getPID()) { // got the duplicate element 
					index = j;
				}
			}
		}
		return index;
	}
	
	public static void changeProcessID(int index, Scanner scanner, Process processes[]) {
		System.out.println("There is a duplicate PID. Please change the process: " + processes[index].toString());
		System.out.print("Enter the new ID: ");
		int newID = scanner.nextInt();
		processes[index].setPID(newID);
	}
}
