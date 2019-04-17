package vega.demo


class Filter implements Serializable {
    private def cmd, jenkinsfile

        
    Filter(Object cmd, String jenkinsfile) {
        this.cmd = cmd
        this.jenkinsfile = jenkinsfile
    }


    def securityRegexp() {
        security()
    }


    def profanityRegexp() {
        profanity()
    }

    
    def private scrub(String alert) {
        cmd.echo "*** ${alert} filter alert! ***"
        return 'FAILURE'
    }


    def private security() {
        if ( jenkinsfile ==~ /(?s).*credentials.*/) {
            scrub("security")
        }
    }

    
    def private profanity() {
        if ( jenkinsfile ==~ /(?s).*fightclub.*/) {
            scrub("profanity")
        }
    }
}

