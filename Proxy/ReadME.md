静态代理模式的角色

    抽象的客户类
    具体的客户类
    抽象的代理类  动态代理java有实现
    具体的代理类
   
静态代理的缺点

    每一个代理类都必须实现一遍委托类（也就是realsubject）的接口，如果接口增加方法，则代理类也必须跟着修改。
    其次，代理类每一个接口对象对应一个委托对象，如果委托对象非常多，则静态代理类就非常臃肿，难以胜任。
  
动态代理的角色

    抽象的代理类  java中有实现InvocationHandler接口    
    具体的代理类
  动态代理不需要具体的客户类，可以代理不同类型的对象
  不过，在使用时，最好有客户类，这样可以提高代码的可读性，易理解性。
 
  

 动态代理， 它是在运行时生成的class，在生成它时你必须提供一组interface给它， 然后该class就宣称它实现了这些interface。
 你当然可以把该class的实例当作这些interface中的任何一个来用。 当然啦，这个Dynamic
 Proxy其实就是一个Proxy，它不会替你作实质性的工作， 在生成它的实例时你必须提供一个handler，由它接管实际的工作。

 
 
 创建动态代理的对象，需要借助Proxy.newProxyInstance。该方法的三个参数分别是：
 
    ClassLoader loader表示当前使用到的appClassloader。
    Class<?>[] interfaces表示目标对象实现的一组接口。
    InvocationHandler h表示当前的InvocationHandler实现实例对象。