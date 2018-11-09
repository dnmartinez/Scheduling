public class Process {
	int pid; // Process ID 
	int bt;  // Burst Time
	int at; // Arrival Time
	int priority;
	
	public Process() {
		this.pid = pid;
		this.bt = bt;
		this.priority = priority; 
	}
	
	public Process(int pid, int bt, int priority, int at) {
		this.pid = pid;
		this.bt = bt;
		this.priority = priority;
		this.at = at;
	}
	
	public static Process createSJF(int pid, int bt, int at) {
		return new Process(pid, bt, 0, at);
	}
	
	public static Process createPriority(int pid, int bt, int priority) {
		return new Process(pid, bt, priority, 0);
	}
	
	public int getPID() {
		return this.pid;
	}
	
	// Get execution time
	public int getBurstTime() {
		return this.bt;
	}
	
	public int getPriorityNumber() {
		return this.priority;
	}
	
	public int getArrivalTime() {
		return this.at;
	}
	
	public void setPID(int pid) {
		this.pid = pid;
	}
	
	public String toString() {
		return pid + " " + bt + " " + priority+ " " + at;
	}
	
}