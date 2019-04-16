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

    @NonCPS
    def private scrub(String alert) {
        this.cmd.echo "${alert} alert!"
        this.cmd.currentBuild.result = 'ABORT'
    }


    def private security() {
        if ( this.jenkinsfile ==~ /(?s).*credentials.*/) {
            scrub("secruity")
        }
    }

    def private profanity() {
        if ( this.jenkinsfile ==~ /(?s).*fightclub.*/) {
            scrub("profanity")
        }
    }
}

