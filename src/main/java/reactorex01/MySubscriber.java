package reactorex01;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// <T> 구독할 데이터 => 퍼블리셔의 T와 서브스크라이버의 <T>는 같아야함. 구독할정보와 발행할정보이기 떄문에
public class MySubscriber implements Subscriber<Integer> {

   private Integer size = 1000000000; // nobounded
   private Subscription s;
   
   public void onSubscribe(Subscription s) {
	   this.s = s;
      System.out.println("3. MySubscriber - 구독 정보를 돌려받음.");
      // 구독했으니깐 이제 신문 주세요
      s.request(size); // 내가 하루에 읽을 수 있는 글자수의 한계가 있기 때문에 갯수를 정해둔건데. (백프레셔 = BackPressure)
   }

   public void onNext(Integer t) {
      System.out.println("onNext - 신문 " + t);
      size--;
      if(size == 0) {
    	  size = 3;
    	  s.request(size);
      }

   }

   public void onError(Throwable t) {
      // TODO Auto-generated method stub

   }

   public void onComplete() {
	   System.out.println("신문 다 받음.");
   }

}
