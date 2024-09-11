package lldPractice;

class Car{

    void run(){System.out.println("running");}

}

class Audi extends Car {
    @Override
    void run() {
        System.out.println("running swiftly with 100km");
    }

    public static void main(String args[]) {

        Car b = new Audi();//upcasting

        b.run();

    }
}

