package reactorex01;

import java.util.Iterator;

import org.reactivestreams.Subscription;

public class MySubscription implements Subscription{

   private final MySubscriber subscriber;
   private final Iterator<Integer> it;
   
   public MySubscription(MySubscriber s, Iterable<Integer> its) {
      System.out.println("2. MySubscription 구독정보생성");
      this.subscriber = s;
      this.it = its.iterator();
   }

   public void request(long n) {
	   System.out.println("4. MySubscription - "+n+"개씩 구독 시작");
	   while(n > 0) {
		   if(it.hasNext()) {
			   subscriber.onNext(it.next());
		   }else {
			   subscriber.onComplete();
			   break;
		   }
		   n--;
	   }
   }

   public void cancel() {
      // TODO Auto-generated method stub
      
   }

}