import java.util.ArrayList;

public class implemenattion {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public boolean isEmpty(){
            return arr.size()==0;
        }

        public void add(int data){
            //adding at last index
            arr.add(data);

            int idx = arr.size()-1;
            int parentIdx = (idx-1)/2;

            while(arr.get(idx) < arr.get(parentIdx)){
                //swap
                int temp = arr.get(idx);
                arr.set(idx,arr.get(parentIdx));
                arr.set(parentIdx,temp);

                idx = parentIdx;
                parentIdx = (idx-1)/2;

            }
        }
        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size()  &&  arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size()  &&  arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            if(minIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);
            }
        }
        public int remove(){
            int data = arr.get(0);

            //step 1 - swap first and last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2 - delete last
            arr.remove(arr.size()-1);

            //step 2 - call heapify
            heapify(0);
            return data;
        }

    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(5);
        h.add(8);
        h.add(2);
        h.add(6);
        h.add(75);

        while(!h.isEmpty()){
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}

