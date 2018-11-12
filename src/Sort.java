import java.util.Collection;

public class Sort extends Process{
	
	public void prioritySort(Process processes[]) {
		Process temp = new Process();
		for(int j = 0; j < processes.length-1; j++) {
			for(int i = 0; i < processes.length-1; i++) {
				int pnum1 = processes[i].getPriorityNumber(); // priority number 1
				int pnum2 = processes[i+1].getPriorityNumber();
				if(pnum1 > pnum2) {
					temp = processes[i];
					processes[i] = processes[i+1];
					processes[i+1] = temp;
				}
				if(pnum1 == pnum2) {
					continue;
				}
			}
		}
	}
	
	//works
	
	public void sjfSort(Process myProcess[]) {
		Process temp = new Process();
		for(int i = 0; i < myProcess.length - 1; i++) {
			if(myProcess[i].getBurstTime() > myProcess[i+1].getBurstTime()) {
				temp = myProcess[i];
				myProcess[i] = myProcess[i+1];
				myProcess[i+1] = temp;
			}
		}
		
			
		
		// CHECAR SI [0]BT Y [1]AT SON IGUALES Y ORDENAR LOS RESTANTES. Si no, ordenar igual
		
	}
	
	public void arrivalTimeSort(Process myProcess[]) {
		Process temp = new Process();
		for(int j = 0; j < myProcess.length-1; j++) {
			for(int i = 0; i < myProcess.length-1; i++) {
				int at1 = myProcess[i].getArrivalTime(); // priority number 1
				int at2 = myProcess[i+1].getArrivalTime();
				if(at1 > at2) {
					temp = myProcess[i];
					myProcess[i] = myProcess[i+1];
					myProcess[i+1] = temp;
				}
				if(at1 == at2) {
					continue;
				}
			}
		}
	}

	public void noAccumulatedProcesses(Process myProcess[], int completionTime, int i) {
		completionTime += myProcess[i].getBurstTime();
	}
	
	public void hasAccumulatedProcesses(Process myProcess[], Process temp, int completionTime, int i) {
		if(myProcess[i].getBurstTime() >= myProcess[i+1].getBurstTime() && 
				myProcess[i+1].getArrivalTime() < completionTime) {
			temp = myProcess[i];
			myProcess[i] = myProcess[i+1];
			myProcess[i+1] = temp;
			completionTime += myProcess[i].getBurstTime();
			System.out.println("completion time if: " + completionTime);
		} 
	}
	public void checkCorrectBT(Process processes[]) {
		System.out.println("here");
		for(int i = 2; i < processes.length - 1; i++) {
			if(processes[i].getBurstTime() > processes[i+1].getBurstTime() ) {
				System.out.println("true");
				sjfSort(processes);
			}
		}
	}
}

