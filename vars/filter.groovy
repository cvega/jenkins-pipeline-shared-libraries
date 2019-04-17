import vega.demo.Filter


def call(String jenkinsfile) {
  def filter = new Filter(this, jenkinsfile)
  def screen = [filter.security(), filter.profanity()]
  
  screen.each {
    if ($it) {
      currentBuild.result = 'ABORT'
      error()
      return
    }
  }
}
