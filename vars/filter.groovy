import vega.demo.Filter


def abort() {
  return currentbuild.result = 'ABORT'
}


def call(String jenkinsfile, String type) {
  def filter = new Filter(this, jenkinsfile);
  
  if (type == "security") {
    if (filter.securityRegexp()) {
      abort()
    }
  }
  else if (type == "profanity") {
    if (filter.profanityRegexp()) {
      abort()
    }
  }
  else {
    echo "*** INVALID FILTER NAME ***"
  }
}
