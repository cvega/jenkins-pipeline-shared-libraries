import vega.demo.Filter


def call(String jenkinsfile, String type) {
    def filter = new Filter(this, jenkinsfile);
  
  if (type == "security") {
    filter.security()
  }
  elif (type == "profanity") {
    filter.profanity()
  }
  else {
    echo "*** INVALID FILTER NAME ***"
  }
}
