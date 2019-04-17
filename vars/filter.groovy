import vega.demo.Filter


def call(String jenkinsfile) {
  def filter = new Filter(this, jenkinsfile)
  
  [filter.security(), filter.profanity()].each {
    if (it) {
      currentBuild.result = 'ABORTED'
      error("*** build aborted by filter library ***")
      return
    }
  }
}
