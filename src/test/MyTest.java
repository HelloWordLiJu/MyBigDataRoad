package test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/**
 * 
 * @author lidaj
 *
 */
public class MyTest {
	static  long add(long n,long num)
    {
        if(n==1 )
        {
            return 1;
        }
        else
        {
            return add(n-1,num)+n+num;
        }

    }
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();//�����̳߳أ�Ƶ������
		System.out.println("һ������");
		FutureTask<Long> mytask = null;
		mytask = (FutureTask<Long>) service.submit(()->add(10,0));
	}
	public static void main1(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Long> mytask = new FutureTask<Long>(()->{add(10,0);return 0l;});
		System.out.println("һ������");
		new Thread(mytask).start();
	
		while(!mytask.isDone()){
			System.out.println("û����");
		}
		System.out.println(mytask.get());
	}
}
