import vega.demo.Filter


def call(String jenkinsfile, String type) {
  def filter = new Filter(this, jenkinsfile);
  
  if (type == "security") {
    if (filter.securityRegexp()) {
      currentbuild.result = 'ABORT'
    }
  }
  else if (type == "profanity") {
    if (filter.profanityRegexp()) {
      currentbuild.result = 'ABORT'
    }
  }
  else {
    echo "*** INVALID FILTER NAME ***"
  }
}
