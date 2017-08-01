package Queue;

/**
 * Created by yinxin on 17-7-29.
 */
/*
    1,队空的判定条件，队空的条件是front=rear
    2，队满的判定条件 （rear+1）%QueueSize=front；
    queuesize时队列初始空间大小
 */
public class RingBuffer {
    public int array[];
    public int size;
    public int front;
    public int rear;
    public RingBuffer(int size){
        array = new int[size];
        this.size = size;
        front = 0;
        rear=0;
    }
    public void enqueue(int value){
        if ((rear+1)%size == front){    //   1 2 3 rear front
            throw new ArrayIndexOutOfBoundsException();
        }else {
            array[rear] = value;
            rear = (rear+1)%size;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int dequeue(){
        if (rear == front){
            return 0;//当rear==front说明空的
        }
        else {
            int temp = front;
            front = (front+1)%size;
            return array[temp];
        }
    }
}
