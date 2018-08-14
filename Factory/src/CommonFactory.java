/**
 * Created by lenovo on 2018/8/14.
 */
abstract class Product{
    public String name;
}
interface Factory{
    public Product produce();
}

class TV extends Product{
    public TV(){
        this.name = "TV";
    }
}
class Watch extends Product{
    public Watch(){
        this.name = "Watch";
    }
}

class TVfactory implements Factory{

    @Override
    public Product produce() {
        return new TV();
    }
}

class Watchfactory implements Factory{

    @Override
    public Product produce() {
        return new Watch();
    }
}



