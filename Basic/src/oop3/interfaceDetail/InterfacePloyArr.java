package oop3.interfaceDetail;

public class InterfacePloyArr {
    public static void main(String[] args) {
        USB[] arr = new USB[2];
        arr[0] = new Phone();
        arr[1] = new Camera();
        for(int i = 0; i < arr.length; i ++ ){
            arr[i].work();
            if(arr[i] instanceof Phone){
                ((Phone) arr[i]).cal();
            }
        }
    }
}

interface USB{
    public void work();
}

class Phone implements USB{
    public void cal(){
        System.out.println("Phone的cal被调用了");
    }

    @Override
    public void work() {
        System.out.println("Phone在工作");
    }
}

class Camera implements USB{
    @Override
    public void work() {
        System.out.println("Camera在工作");
    }
}