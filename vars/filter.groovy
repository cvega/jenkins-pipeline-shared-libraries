import vega.demo.Filter


def clean(boolean filter) {
  if (!filter) {
    currentBuild.result = 'ABORT'
    error()
    return
  }
}


def call(String jenkinsfile) {
  def filter = new Filter(this, jenkinsfile);
  
  this.clean(filter.security())
  this.clean(filter.profanity())
}
