import vega.demo.Filter


def call(String jenkinsfile, String type) {
  def filter = new Filter(this, jenkinsfile);
  
  if (type == "security") {
    if (filter.securityRegexp() == 'FAILURE') {
      currentBuild.result = "${filter.securityRegexp()}"
    }
  }
  else if (type == "profanity") {
    if (filter.profanityRegexp() == 'FAILURE') {
      currentBuild.result = "${filter.profanityRegexp()}"
    }
  }
  else {
    echo "*** INVALID FILTER NAME ***"
  }
  return
}
