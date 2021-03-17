package reactorex01;

import java.util.Arrays;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

// <T>가 발행정보.
public class MyPublisher implements Publisher<Integer>{
	
	// 데이터베이스 - 정보를 가지고 있음.
	Iterable<Integer> its = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

   // 이 함수를 통해서 구독할 수 있음. 구독자가 호출해야함.
   public void subscribe(Subscriber<? super Integer> s) {
      System.out.println("1. MyPublisher - 구독");
      s.onSubscribe(new MySubscription((MySubscriber)s, its)); // 니가 이런걸 구독했다는 증명. 영수증. => 이걸 서브스크라이버를 돌려받으면 구독이 시작되는것임.
   }

}