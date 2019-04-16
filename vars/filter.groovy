import vega.demo.Filter


def call(String jenkinsfile, String type) {
    def filter = new Filter(this, jenkinsfile);
  
  if (type == "security") {
    filter.securityRegexp()
  }
  else if (type == "profanity") {
    filter.profanityRegexp()
  }
  else {
    echo "*** INVALID FILTER NAME ***"
  }
}
