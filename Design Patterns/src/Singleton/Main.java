package Singleton;

class Singleton_1 {
	// static���� ������ "�� �ϳ��� �ν��Ͻ�"�� ���� ������ ����
	private static Singleton_1 instance;
	
	// �����ڰ� private�� ����Ǿ� ������ new Ű����� �ν��Ͻ� ���� �Ұ�
	private Singleton_1() {}
	
	// new�� �ƴ�, getInstance()��� �޼ҵ带 �̿��Ͽ� ��ü ���� (�ܺο��� ������ �����ؾ� �ϱ� ������ public)
	public static Singleton_1 getInstance() {
		/*
		 * if���� �̿��Ͽ� �޷θ� ���� ���� 
		 * static�� �����Ͻ� �޸𸮸� �Ҵ������� static�̾ ��ü�� �����ϴ� �κ��� ���� ��� ��ü�� ó�� ������ �� �޸� �Ҵ�
		 */
		
		// instance�� null�� ��쿡�� ��ü�� ����
		if(instance == null) {
			instance = new Singleton_1();
		}
		return instance;	// �ܺο��� get �Լ��� ȣ���ϸ� ������ �ν��Ͻ��� ��ȯ
	}
}

// Thread safe Lazy initalization
class Singleton_2 {
	private static Singleton_2 instance;
	private Singleton_2() {}	
	
	// synchronized�� �̿��Ͽ� ����ȭ _ but �ڹ� ���������� �޼��峪 ������ ����ȭ�� ���� block�� unblock�� ó���ϸ鼭 ���� ����
	public static synchronized Singleton_2 getInstance() {
		if(instance == null) {
			instance = new Singleton_2();
		}
		return instance;
	}
}

// Thread safe Lazy initalization + Double-checked locking
class Singleton_3 {
	private static Singleton_3 instance;
	private Singleton_3() {}	
	
	// �ν��Ͻ��� ���� ��쿡�� synchronized ���
	// �������ϴ� ��ȭ��ų �� ������ �ٺ����� �ذ�å�� ����
	public static Singleton_3 getInstance() {
		synchronized (Singleton_3.class) {
			if (instance == null) {
				instance = new Singleton_3();
			}
		}
		return instance;
	}
}
// Holder�� ���� �ʱ�ȭ
class Singleton_4 {
	private static class LazyHolder {
		// instance�� static�̱� ������ Ŭ���� �ε������� �ѹ��� ȣ��
		// final�� ����Ͽ� ���� �ٽ� �Ҵ���� �ʵ��� ����
		static final Singleton_4 instance = new Singleton_4();
	}
	
	// getInstance() �Լ��� ȣ��Ǵ� ���� �� �ڵ� �ߵ�(������ �ν��Ͻ� ����)
	public static Singleton_4 getInstance() {
		return LazyHolder.instance;
	}
}

public class Main {
	public static void main(String[] args) {
		/*
		Singleton_1 s1 = Singleton_1.getInstance();
		Singleton_1 s2 = Singleton_1.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		*/
	}
}