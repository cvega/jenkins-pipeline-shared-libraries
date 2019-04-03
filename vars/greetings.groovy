import vega.demo.Greetings


def call(String lang, String name) {
  def greetings = new Greetings(lang, name);
  
  greetings.sayHello
  greetings.sayGoodbye
  return 0
}
