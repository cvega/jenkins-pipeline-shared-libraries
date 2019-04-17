import vega.demo.Filter


def call(String jenkinsfile) {
  def filter = new Filter(this, jenkinsfile)
  def screen = [filter.security(), filter.profanity()]
  
  screen.each {
    println "here i am"
    println "$it"
    if (it) {
      println "here to"
      currentBuild.result = 'ABORT'
      error()
    }
  }
  
  return
}
