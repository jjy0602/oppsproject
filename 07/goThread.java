package opens;

import java.io.IOException;

public class goThread extends Thread{

	static boolean flag;
	goThread()
	{
		flag=true;
		start();
	}
	
	
	public void run()
	{
		while(flag)
		{
			try {
				new Naver();
				new Daum();
				Thread.sleep(5000); //5�ʸ��� ����
				System.out.println("renew"); //����Ȯ�θ޽���
			} catch(InterruptedException | IOException e)
			{
				e.printStackTrace(); //�����߻��� �޽��� ���
			}
		}
	}
}
