package vega.demo


class Filter implements Serializable {
    private def cmd, jenkinsfile

    Filter(Object cmd, String jenkinsfile) {
        this.cmd  = cmd
        this.jenkinsfile = jenkinsfile
    }


    def securityRegexp() {
        security()
    }


    def profanityRegex() {
        profanity()
    }


    def private scrub(String alert) {
        this.cmd.echo "${alert} alert!"
        this.cmd.currentBuild.result = 'FAILURE'
        return
    }


    def private security() {
        if ( this.jenkinsfile ==~ /(?s).*credentials.*/) {
            scrub("secruity")
            return
        }
    }

    def private profanity(String jenkinsfile) {
        if ( this.jenkinsfile ==~ /(?s).*fightclub.*/) {
            scrub("profanity")
            return
        }
    }
}

