package vega.demo


class Filter implements Serializable {
    private def cmd, jenkinsfile

        
    Filter(Object cmd, String jenkinsfile) {
        this.cmd = cmd
        this.jenkinsfile = jenkinsfile
    }


    def security() {
        securityRegexp()
    }


    def profanity() {
        profanityRegexp()
    }

    
    def private scrub(String alert) {
        cmd.echo "*** ${alert} filter alert! ***"
        return 'ABORT'
    }


    def private securityRegexp() {
        if ( jenkinsfile ==~ /(?s).*credentials.*/) {
            scrub("security")
        }
    }

    
    def private profanityRegexp() {
        if ( jenkinsfile ==~ /(?s).*fightclub.*/) {
            scrub("profanity")
        }
    }
}

