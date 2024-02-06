import java.time.*;



public class Contador extends Thread {

	private int time = 0;
	private int limit = -1;
	private boolean running = true;


	public Contador(int limit) {
		this.limit = limit;

		if(this.limit <= 0) {
			this.limit = 0;
		}
	}

	public Contador() {
		this.limit = -1;
	}

	@Override
	public void run() {
		while(running) {
			time += 1;

			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
				running = false;
			}

			if(limit != -1 && time == limit) {
				running = false;
			}
		}
	}


	public int getTime() {
		return time;
	}


	public String getTimeFormatted() {
		LocalTime t = LocalTime.ofSecondOfDay(time);
		return t.toString();
	}


	public void stopCounter() {
		running = false;
	}


	public boolean isRunning() {
		return running;
	}
}