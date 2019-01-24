package java1016_collection;

import java.util.LinkedList;

/*
 * Queue (큐)
 * 
 * 1. FIFO: 제일 먼저 저장한 요소를 제일 먼저 꺼내옴
 * 2. 최근 사용문서, 인쇄작업대기목록, 버퍼
 */
public class Java193_LinkedList {

	public static void main(String[] args) {
		LinkedList<String> nQueue = new LinkedList<String>();
		
		//추가 - offer
		nQueue.offer(new String("java"));
		nQueue.offer(new String("jsp"));
		nQueue.offer(new String("spring"));
		
		System.out.println(nQueue.get(1)); // get도 지원하지만 큐에서의 get은 복사해서 가져오는 것
		
		while(!nQueue.isEmpty())
			//추출 - poll
			System.out.println(nQueue.poll());
		//이 다음에 get을 사용하면 인덱스예외처리 실행됨 (큐에 남은 데이터가 없으므로)
		
	}

}
