import vega.demo.Filter


def screen(Boolean... filter) {
  filter.each {
    if ($it) {
      currentBuild.result = 'ABORT'
      error()
      return
    }
  }
}


def call(String jenkinsfile) {
  def filter = new Filter(this, jenkinsfile)
  this.screen([filter.security(), filter.profanity()])
}
