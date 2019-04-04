import vega.demo.Greeting


def call(String lang, String name) {
    def greeting = new Greeting(this, lang, name);
  
    greeting.sayHello()
    greeting.sayGoodbye()
}
