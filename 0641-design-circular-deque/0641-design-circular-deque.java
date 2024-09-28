class MyCircularDeque {
    int K;
    int[] deque;
    int front;
    int rear;
    int count;
    public MyCircularDeque(int k) {
        deque = new int[k];
        K = k;
        front = 0;
        rear = K-1;
        count = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        
        front = (front-1+K) %K;
        deque[front] = value;
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        
        rear = (rear+1)%K;
        deque[rear] = value;
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        
        front = (front+1) % K;
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        
        rear = (rear-1+K)%K;
        count--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return deque[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return deque[rear];
    }
    
    public boolean isEmpty() {
        if(count == 0)return true;
        return false;
    }
    
    public boolean isFull() {
        if(count == K)return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */