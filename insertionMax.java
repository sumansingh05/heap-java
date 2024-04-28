import java.util.ArrayList;

//implementation of max heap

public class insertionMax {
    
    static class Heap{

        ArrayList<Integer> arr = new ArrayList<>();

        public boolean isEmpty(){
            return arr.size()==0;
        }

        public void add(int data){
            //add at last idx
            arr.add(data);

            int x = arr.size()-1;   // x is a child idx
            int par = (x-1)/2;  //parent idx

            while(arr.get(x) > arr.get(par)){
                // swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i +2;
            int maxIdx = i;

            if(left < arr.size() && arr.get(maxIdx) < arr.get(left)){
                maxIdx = left;
            }
            if(right < arr.size() && arr.get(maxIdx) < arr.get(right)){
                maxIdx = right;
            }
            if(maxIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i,arr.get(maxIdx));
                arr.set(maxIdx,temp);

                heapify(maxIdx);
            }

        }

        public int remove(){
            int data = arr.get(0);

            //Step 1 - swap first and last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //Step 2 - delete last
            arr.remove(arr.size()-1);

            //step 3 - call heapify
            heapify(0);
            return data;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(7);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
     
}

