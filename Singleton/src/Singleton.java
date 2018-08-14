/**
 * Created by lenovo on 2018/8/14.
 */
class Singleton{

    private int a ;
    String b ;
    private Singleton(int a, String b){
        this.a = a;
        this.b = b;
    }
    private static class SingletonLoader{
        private static final Singleton singleton = new Singleton(4,"00");
    }
    public static Singleton getInstance(){
        return SingletonLoader.singleton;
    }

    /*
    private static Singleton t;
    static Singleton getinstance(){
        if(t==null){
            t = new Singleton(3,"5");
        }
        System.out.println(t);
        return t;
    }*/

}
