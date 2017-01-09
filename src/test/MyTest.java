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
		ExecutorService service = Executors.newCachedThreadPool();//创建线程池，频繁炒作
		System.out.println("一会来拿");
		FutureTask<Long> mytask = null;
		mytask = (FutureTask<Long>) service.submit(()->add(10,0));
	}
	public static void main1(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Long> mytask = new FutureTask<Long>(()->{add(10,0);return 0l;});
		System.out.println("一会来搞");
		new Thread(mytask).start();
	
		while(!mytask.isDone()){
			System.out.println("没好呢");
		}
		System.out.println(mytask.get());
	}
}
