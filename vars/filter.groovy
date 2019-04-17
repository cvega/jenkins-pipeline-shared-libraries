import vega.demo.Filter


def call(String jenkinsfile) {
  def filter = new Filter(this, jenkinsfile);
  
  if (filter.securityRegexp == 'FAILURE') {
      currentBuild.result = "${filter.securityRegexp()}"
      error('Stopping early…')
  }
  else if (filter.profanityRegexp == 'FAILURE') {
      currentBuild.result = "${filter.profanityRegexp()}"
      error('Stopping early…')
  }
  else {
    echo "*** INVALID FILTER NAME ***"
  }
  return
}
