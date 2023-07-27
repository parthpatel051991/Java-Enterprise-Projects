package in.ineuron;

public class MutliThreads {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 == 0) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 != 0) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		System.out.println("First thread started :: Printing even number between 1 to 10");
		t1.start();

		t1.join();

		System.out.println("Second thread started :: :: Printing odd number between 1 to 10");
		t2.start();

	}
}
