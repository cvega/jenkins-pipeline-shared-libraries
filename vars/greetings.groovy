import vega.demo.Greetings


def call(String lang, String name) {
  def greetings = new Greetings(this, lang, name);
  
  greetings.sayHello()
  greetings.sayGoodbye()
}
