中介者模式的优点:
    1:避免同事类之间的过度耦合
    2:将对象间一对多的关联转变为一对一的关联
    3:将对象的行为和协作进行抽象,能够比较灵活的处理对象间的相互作用
中介者模式要求
    各同事类不可以直接关联，通过中介者类来达到关联的目的
中介者模式
    1：同事类接口或是抽象类   AbstractColleague
    2：中介者类   Mediator
    3：协调的操作方法或是协调的对象域
中介者模式的组成
    抽象的客户类  或是一个接口  要有触发中介行为的抽象方法  
    抽象的中介类    维护一个抽象客户类链表  能实现添加客户  移除客户  抽象的中介行为
    具体的客户类    要有触发中介行为的方法  比如说约会某个对象，提出要求，或者改变房价
    具体的中介类