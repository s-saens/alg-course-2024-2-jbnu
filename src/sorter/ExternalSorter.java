package sorter;
import java.util.*;

public class ExternalSorter<T extends Comparable<T>> {

    int memorySize;

    /* '_'로 시작하는 필드는 disk에 있다고 가정 */
    List<T> _data;
    List<List<T>> _chunks = new ArrayList<>();

    public ExternalSorter(List<T> _data, int memorySize) {
        this._data = _data;
        this.memorySize = memorySize;
    }

    public void sort() {
        divide();
        merge();
    }

    void divide() {

        int size = _data.size();

        for(int i = 0; i< size ; i+=memorySize) {
            List<T> chunk = new ArrayList<>(); // 메모리 사용

            for (int j = i; j < Math.min(i + memorySize, size); j++) {
                chunk.add(_data.get(j));
            }

            Collections.sort(chunk);
            _chunks.add(chunk); // 디스크에 저장.
        }
    }

    void merge()
    {
        // 메모리 사용: (T의 크기) + (int 2개) + (클래스 메모리 오버헤드)
        PriorityQueue<Node<T>> minHeap = new PriorityQueue<>();
        int dataSize = _data.size();
        int chunkSize = _chunks.size();

        for(int ci=0 ; ci < chunkSize ; ++ci) {
            minHeap.add(new Node<>(_chunks.get(ci).getFirst(), ci, 0));
        }

        for(int i = 0 ; i < dataSize && !minHeap.isEmpty() ; ++i) {

            Node<T> min = minHeap.poll();

            T v = min.value;
            int ci = min.chunkIndex;
            int ici = min.innerChunkIndex + 1; // chunk 내에서의 다음 인덱스

            _data.set(i, v); // 디스크에 덮어 쓰기

            if(ici < _chunks.get(ci).size()) { // minHeap에 해당 chunk의 다음 데이터 추가
                minHeap.add(new Node<>(_chunks.get(ci).get(ici), ci, ici));
            }
        }
    }

    static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

        public T value;
        public int chunkIndex; // 몇 번 chunk인지
        public int innerChunkIndex; // 해당 chunk 내에서의 인덱스

        public Node(T value, int chunkIndex, int innerChunkIndex) {
            this.value = value;
            this.chunkIndex = chunkIndex;
            this.innerChunkIndex = innerChunkIndex;
        }

        @Override
        public int compareTo(Node<T> o) {
            return this.value.compareTo(o.value);
        }
    }
}
